package com.emrtnm.jwt.service;

import com.emrtnm.jwt.dto.CredentialsDto;
import com.emrtnm.jwt.dto.SignUpDto;
import com.emrtnm.jwt.dto.UserDto;
import com.emrtnm.jwt.entity.User;
import com.emrtnm.jwt.exception.AppException;
import com.emrtnm.jwt.mapper.UserMapper;
import com.emrtnm.jwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        if (credentialsDto.username().length() < 5) {
            throw new AppException("Username can be minimum 5 characters", HttpStatus.BAD_REQUEST);
        }

        if (credentialsDto.password().length < 6) {
            throw new AppException("Password can be minimum 6 characters", HttpStatus.BAD_REQUEST);
        }

        User user = userRepository.findByUsername(credentialsDto.username())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        if (userDto.username().length() < 5) {
            throw new AppException("Username can be minimum 5 characters", HttpStatus.BAD_REQUEST);
        }

        if (userDto.password().length < 6) {
            throw new AppException("Password can be minimum 6 characters", HttpStatus.BAD_REQUEST);
        }

        Optional<User> optionalUser = userRepository.findByUsername(userDto.username());

        if (optionalUser.isPresent()) {
            throw new AppException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        Optional<User> optionalEmail = userRepository.findByEmail(userDto.email());

        if (optionalEmail.isPresent()) {
            throw new AppException("E-mail already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.password())));

        return userMapper.toUserDto(userRepository.save(user));
    }

    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
}

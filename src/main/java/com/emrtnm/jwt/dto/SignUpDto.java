package com.emrtnm.jwt.dto;

public record SignUpDto (String firstName, String lastName, String email, String username, char[] password) { }

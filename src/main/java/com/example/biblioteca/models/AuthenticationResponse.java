package com.example.biblioteca.models;

public class AuthenticationResponse {
    private String token;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }
}

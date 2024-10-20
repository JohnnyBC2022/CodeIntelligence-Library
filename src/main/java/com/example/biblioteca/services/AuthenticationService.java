package com.example.biblioteca.services;

import com.example.biblioteca.models.AuthenticationResponse;
import com.example.biblioteca.models.UserEntity;

public interface AuthenticationService {
    public AuthenticationResponse register(UserEntity request);

    public AuthenticationResponse authenticate(UserEntity request);

    public void revokeAllTokensByUser(UserEntity user);

    public void saveUserToken(String jwt, UserEntity user);

    public AuthenticationResponse signOut(UserEntity signoutRequest);
}

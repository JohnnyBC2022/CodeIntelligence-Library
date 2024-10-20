package com.example.biblioteca.serviceImpl;

import com.example.biblioteca.models.AuthenticationResponse;
import com.example.biblioteca.models.Token;
import com.example.biblioteca.models.UserEntity;
import com.example.biblioteca.repository.TokenRepository;
import com.example.biblioteca.repository.UserRepository;
import com.example.biblioteca.services.AuthenticationService;
import com.example.biblioteca.services.JwtService;
import com.example.biblioteca.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final TokenRepository tokenRepository;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    public AuthenticationServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService, TokenRepository tokenRepository, AuthenticationManager authenticationManager) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.tokenRepository = tokenRepository;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse register(UserEntity request) {
        if(repository.findByUsername(request.getUsername()).isPresent()) {
            return new AuthenticationResponse(null, "User already exist");
        }

        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setMail(request.getMail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());

        user = repository.save(user);

        String jwt = jwtService.generateToken(user);

        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User registration successfully");
    }

    public AuthenticationResponse authenticate(UserEntity request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        UserEntity user = repository.findByUsername(request.getUsername()).orElseThrow();
        String jwt = jwtService.generateToken(user);

        revokeAllTokensByUser(user);
        saveUserToken(jwt, user);

        return new AuthenticationResponse(jwt, "User login successfully");
    }

    public void revokeAllTokensByUser(UserEntity user) {
        List<Token> validTokens = tokenRepository.findAllTokensByUser(user.getId());

        if(validTokens.isEmpty()){
            return;
        }

        validTokens.forEach(t -> {
            t.setLoggedOut(true);
        });

        tokenRepository.saveAll(validTokens);
    }

    public void saveUserToken(String jwt, UserEntity user) {
        Token token = new Token();
        token.setToken(jwt);
        token.setLoggedOut(false);
        token.setUser(user);
        tokenRepository.save(token);
    }

    public AuthenticationResponse signOut(UserEntity signoutRequest) {
        AuthenticationResponse response;
        UserEntity userLeaving = this.userService.getCurrentUser();

        try {
            this.revokeAllTokensByUser(userLeaving);
            response = new AuthenticationResponse(null, "Signed Out Successfully");
        } catch (Exception e) {
            response = new AuthenticationResponse(null, e.getMessage());
        }
        return response;
    }
}

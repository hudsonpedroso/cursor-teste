package com.werewolfvampire.game.controller;

import com.werewolfvampire.game.dto.JwtResponse;
import com.werewolfvampire.game.dto.LoginRequest;
import com.werewolfvampire.game.dto.SignupRequest;
import com.werewolfvampire.game.entity.Player;
import com.werewolfvampire.game.entity.Role;
import com.werewolfvampire.game.entity.User;
import com.werewolfvampire.game.repository.PlayerRepository;
import com.werewolfvampire.game.repository.UserRepository;
import com.werewolfvampire.game.security.JwtUtils;
import com.werewolfvampire.game.security.UserPrincipal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        
        // Buscar informações do player
        Player player = playerRepository.findByUserId(userPrincipal.getId()).orElse(null);
        
        if (player != null) {
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userPrincipal.getId(),
                    userPrincipal.getUsername(),
                    userPrincipal.getEmail(),
                    userPrincipal.getAuthorities().stream()
                            .map(item -> Role.valueOf(item.getAuthority()))
                            .collect(java.util.stream.Collectors.toSet()),
                    player.getFaction(),
                    player.getLevel(),
                    player.getPower()));
        } else {
            return ResponseEntity.ok(new JwtResponse(jwt,
                    userPrincipal.getId(),
                    userPrincipal.getUsername(),
                    userPrincipal.getEmail(),
                    userPrincipal.getAuthorities().stream()
                            .map(item -> Role.valueOf(item.getAuthority()))
                            .collect(java.util.stream.Collectors.toSet())));
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Email is already in use!");
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_USER);
        user.setRoles(roles);

        User savedUser = userRepository.save(user);

        // Create player profile
        if (signUpRequest.getFaction() != null) {
            Player player = new Player(savedUser, signUpRequest.getFaction());
            playerRepository.save(player);
        }

        return ResponseEntity.ok("User registered successfully!");
    }
}
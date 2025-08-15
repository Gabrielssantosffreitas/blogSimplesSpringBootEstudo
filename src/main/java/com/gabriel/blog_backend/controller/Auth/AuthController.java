package com.gabriel.blog_backend.controller.Auth;

import com.gabriel.blog_backend.Entity.Usuario.Usuario.UsuarioEntity;
import com.gabriel.blog_backend.service.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsuarioEntity usuario) {
        if (usuario.getUsername() == null || usuario.getPassword() == null || usuario.getRole() == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }
        try {
            UsuarioEntity created = usuarioService.registerUser(usuario);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(409).body(e.getMessage()); // 409 Conflict for duplicate username
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");
        Optional<String> tokenOpt = usuarioService.authenticateUser(username, password);
        if (tokenOpt.isPresent()) {
            return ResponseEntity.ok(Map.of("token", tokenOpt.get()));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}

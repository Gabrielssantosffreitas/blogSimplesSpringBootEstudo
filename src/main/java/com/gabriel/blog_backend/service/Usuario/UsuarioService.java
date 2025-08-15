package com.gabriel.blog_backend.service.Usuario;

import com.gabriel.blog_backend.Entity.Usuario.Usuario.UsuarioEntity;
import com.gabriel.blog_backend.repository.Usuario.UsuarioRepository;
import com.gabriel.blog_backend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public UsuarioEntity registerUser(UsuarioEntity usuario) {
        Optional<UsuarioEntity> existing = usuarioRepository.findByUsername(usuario.getUsername());
        if (existing.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public Optional<String> authenticateUser(String username, String password) {
        Optional<UsuarioEntity> userOpt = usuarioRepository.findByUsername(username);
        if (userOpt.isPresent()) {
            UsuarioEntity user = userOpt.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                String token = jwtUtil.generateToken(user.getUsername(), user.getRole());
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }

    public Optional<UsuarioEntity> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}

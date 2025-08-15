package com.gabriel.blog_backend.repository.Usuario;

import com.gabriel.blog_backend.Entity.Usuario.Usuario.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByUsername(String username);
}


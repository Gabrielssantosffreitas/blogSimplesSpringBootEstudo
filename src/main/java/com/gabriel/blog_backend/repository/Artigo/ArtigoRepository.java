package com.gabriel.blog_backend.repository.Artigo;

import com.gabriel.blog_backend.Entity.Artigo.ArtigoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtigoRepository extends JpaRepository<ArtigoEntity, Long> {
}

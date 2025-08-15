package com.gabriel.blog_backend.service.Artigo;

import com.gabriel.blog_backend.Entity.Artigo.ArtigoEntity;
import com.gabriel.blog_backend.repository.Artigo.ArtigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;


@Service
public class ArtigoService {


    @Autowired
    ArtigoRepository artigoRepository;

    public ResponseEntity<List<ArtigoEntity>> getTodosArtigos() {
        return ResponseEntity.ok()
                .body(artigoRepository.findAll());
    }

    public ResponseEntity<ArtigoEntity> setArtigo(ArtigoEntity artigoEntity) {
        if (artigoEntity.getData() == null && artigoEntity.getConteudo() != null && artigoEntity.getResumo() != null && artigoEntity.getTitulo() != null) {
            LocalDateTime dateTime = LocalDateTime.now();
            artigoEntity.setData(dateTime);
        } else if (artigoEntity.getConteudo() == null || artigoEntity.getResumo() == null || artigoEntity.getTitulo() == null) {
            return ResponseEntity.badRequest().body(artigoEntity);
        }

        artigoRepository.save(artigoEntity);

        return ResponseEntity.accepted().body(artigoEntity);
    }

    public ResponseEntity<ArtigoEntity> putArtigo(Long id, ArtigoEntity artigoEntity) {
        List<ArtigoEntity> artigoEntities = artigoRepository.findAll();
        Iterator<ArtigoEntity> iterator = artigoEntities.iterator();
        ArtigoEntity artigoEntityEditado;

        while (iterator.hasNext()) {
            ArtigoEntity artigoEntityAtual = iterator.next();
            if (artigoEntityAtual.getId().equals(id)) {
                artigoEntityAtual.setTitulo(artigoEntity.getTitulo());
                artigoEntityAtual.setConteudo(artigoEntity.getConteudo());
                artigoEntityAtual.setResumo(artigoEntity.getResumo());
                return ResponseEntity.accepted().body(artigoEntityAtual);
            }
        }

        return ResponseEntity.badRequest().body(artigoEntity);
    }

    public ResponseEntity<String> deleteArtigo(Long id) {
        artigoRepository.deleteById(id);
        return ResponseEntity.accepted().body(" requisicao aceita");
    }
}

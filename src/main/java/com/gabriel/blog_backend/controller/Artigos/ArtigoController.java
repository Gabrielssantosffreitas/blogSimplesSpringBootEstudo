package com.gabriel.blog_backend.controller.Artigos;

import com.gabriel.blog_backend.Entity.Artigo.ArtigoEntity;
import com.gabriel.blog_backend.repository.Artigo.ArtigoRepository;
import com.gabriel.blog_backend.service.Artigo.ArtigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/artigo")
public class ArtigoController {
    @Autowired
    ArtigoService artigoService;

    @GetMapping("/todos_artigos")
    public ResponseEntity<List<ArtigoEntity>> getTodosArtigos(){


        return artigoService.getTodosArtigos();
    }
    @PostMapping("/post_artigo")
    public ResponseEntity<ArtigoEntity> setArtigo (@RequestBody ArtigoEntity artigoEntity){
        return artigoService.setArtigo(artigoEntity);
    }
    @PutMapping("/editar_artigo/{id}")
    public  ResponseEntity<ArtigoEntity> putArtigo (@PathVariable Long id , @RequestBody ArtigoEntity artigoEntity){
        return artigoService.putArtigo(id,artigoEntity);
    }
    @DeleteMapping("/deletar_artigo/{id}")
    public  ResponseEntity<String> deleteArtigo(@PathVariable Long id){
        return artigoService.deleteArtigo(id);
    }
}

package com.gabriel.blog_backend.Entity.Artigo;

import jakarta.persistence.*;

import java.time.LocalDateTime;


@Entity
@Table(name = "artigos")
public class ArtigoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private String resumo;
    @Lob
    @Column(nullable = false , columnDefinition = "LONGTEXT")
    private String conteudo;
    @Column(nullable = false)
    private LocalDateTime data;


    public ArtigoEntity() {
    }

    public ArtigoEntity(String titulo, String resumo, String texto, LocalDateTime data) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.conteudo = texto;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        ArtigoEntity that = (ArtigoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "ArtigoEntity{" +
                "titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", Texto='" + conteudo + '\'' +
                ", data=" + data +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}

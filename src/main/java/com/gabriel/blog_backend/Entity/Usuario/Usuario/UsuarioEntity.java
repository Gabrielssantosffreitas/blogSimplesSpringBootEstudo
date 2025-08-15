package com.gabriel.blog_backend.Entity.Usuario.Usuario;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class UsuarioEntity implements Comparable<UsuarioEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column(nullable = false)
    protected String nome;

    public UsuarioEntity() {
    }

    public UsuarioEntity(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public int compareTo(UsuarioEntity o) {

        return Long.compare(this.id, o.id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

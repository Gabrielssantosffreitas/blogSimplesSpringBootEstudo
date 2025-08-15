package com.gabriel.blog_backend.Entity.Usuario.Usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class UsuarioEntity implements Comparable<UsuarioEntity> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role; // ADMINISTRADOR or ANONIMO

    public UsuarioEntity() {}

    public UsuarioEntity(long id, String nome, String username, String password, String role) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UsuarioEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public int compareTo(UsuarioEntity o) {
        return Long.compare(this.id, o.id);
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}

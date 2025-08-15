package com.gabriel.blog_backend.Entity.Usuario.Adiministrador;

import com.gabriel.blog_backend.Entity.Usuario.Usuario.UsuarioEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario_adiministrador")
public class AdiministradorEntity extends UsuarioEntity {

    public AdiministradorEntity() {
        super();
    }
    public AdiministradorEntity(long id, String nome) {
        super(id, nome);
    }
}

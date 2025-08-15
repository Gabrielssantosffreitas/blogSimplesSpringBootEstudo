package com.gabriel.blog_backend.Entity.Usuario.Anonimo;

import com.gabriel.blog_backend.Entity.Usuario.Usuario.UsuarioEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "usuario_anonimo")
public class AnonimoEntity extends UsuarioEntity {
    public AnonimoEntity() {
    }

    public AnonimoEntity(long id, String nome) {
        super(id, nome);
    }


}

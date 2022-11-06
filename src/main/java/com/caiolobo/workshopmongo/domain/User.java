package com.caiolobo.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "user")// para dizer que é uma coleção do MongoDB  colelction opcional ele mapeia pelo nome da classe
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;
    private String email;
    //Usa DBRef para dizer que eles vãos er referenciados em outra entidade(Document)
    @DBRef(lazy = true)     //lazy porque nao quer carregar automaticamente os posts assim que carregar o usuário do banco de dados
    // só serão carregados se explicitamente acessá-los
    private List<Post> posts = new ArrayList<>();

    public User() {
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Post> getPosts() {
        return posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getId().equals(user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

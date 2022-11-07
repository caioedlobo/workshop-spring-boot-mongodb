package com.caiolobo.workshopmongo.repository;

import com.caiolobo.workshopmongo.domain.Post;
import com.caiolobo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // com isso, um objeto UserRepository vai poder fazer várias operações básicas, salvar, deletar, atualizar. Já está embutido no MongoRepository

    //IgnoreCase para não diferenciar se a letra for maiúsucla ou minúscula
    List<Post> findByTitleContainingIgnoreCase(String text);      //isso já faz com que o Spring Data monte a consulta. Usa query methods
}

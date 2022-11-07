package com.caiolobo.workshopmongo.repository;

import com.caiolobo.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    // com isso, um objeto UserRepository vai poder fazer várias operações básicas, salvar, deletar, atualizar. Já está embutido no MongoRepository

    //IgnoreCase para não diferenciar se a letra for maiúsucla ou minúscula
    List<Post> findByTitleContainingIgnoreCase(String text);      //isso já faz com que o Spring Data monte a consulta. Usa query methods

    // NÃO ESTÁ FUNCIONANDO ABAIXO

   // @Query("{ 'title': { $regex ?0, $options: 'i' } }")        // ?0 primeiro parâmetro do método, nesse caso é o text / i no options para ignorar minúsculas e maiúsculas
    //List<Post> searchTitle(String text);
}

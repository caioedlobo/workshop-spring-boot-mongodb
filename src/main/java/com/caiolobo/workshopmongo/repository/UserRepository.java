package com.caiolobo.workshopmongo.repository;

import com.caiolobo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // com issso, um objeto UserRepository vai poder fazer várias operações básicas, salvar, deletar, atualizar. Já está embutio no MongoRepository
}

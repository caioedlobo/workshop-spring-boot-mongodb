package com.caiolobo.workshopmongo.services;

import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.repository.UserRepository;
import com.caiolobo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired      // para instanciar automaticamente um objeto no Service
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(String id){
        Optional<User> user = repository.findById(id);     // se não achar retorna nulo;
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

}

package com.caiolobo.workshopmongo.services;

import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired      // para instanciar automaticamente um objeto no Service
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

}

package com.caiolobo.workshopmongo.services;

import com.caiolobo.workshopmongo.domain.Post;
import com.caiolobo.workshopmongo.repository.PostRepository;
import com.caiolobo.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired      // para instanciar automaticamente um objeto no Service
    private PostRepository repository;

    public List<Post> findAll(){
        return repository.findAll();
    }

    public Post findById(String id){
        Optional<Post> post = repository.findById(id);     // se não achar retorna nulo;
        return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }



}

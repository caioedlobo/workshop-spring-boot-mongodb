package com.caiolobo.workshopmongo.resources;

import com.caiolobo.workshopmongo.domain.Post;
import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.dto.UserDTO;
import com.caiolobo.workshopmongo.resources.util.URL;
import com.caiolobo.workshopmongo.services.PostService;
import com.caiolobo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = service.findById(id);

        return ResponseEntity.ok().body(post);
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){       // se o parametro text não for informado vai ter uma string vazia
        text = URL.decodeParam(text);       // criado no util para decodificar parâmetro da URL
        List<Post> list = service.findByTitle(text);

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(@RequestParam(value = "text", defaultValue = "") String text,
                                                 @RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                 @RequestParam(value = "maxDate", defaultValue = "") String maxDate){       // se o parametro text não for informado vai ter uma string vazia
        text = URL.decodeParam(text);       // criado no util para decodificar parâmetro da URL
        Date min = URL.convertDate(minDate, new Date(0L));      // gera uma data antiga
        Date max = URL.convertDate(maxDate, new Date());            // gera a data atual
        List<Post> list = service.fullSearch(text, min, max);

        return ResponseEntity.ok().body(list);
    }







}

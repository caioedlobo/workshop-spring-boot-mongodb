package com.caiolobo.workshopmongo.resources;

import com.caiolobo.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET) // ou  @GetMapping
    public ResponseEntity<List<User>> findAll(){      //ResponseEntity encapsula toda a estrutura necessária para retornar respsotas http com cabeçalhos, erros...
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }

}

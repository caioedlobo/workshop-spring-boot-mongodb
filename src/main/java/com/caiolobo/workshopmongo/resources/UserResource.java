package com.caiolobo.workshopmongo.resources;

import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) // ou  @GetMapping
    public ResponseEntity<List<User>> findAll(){      //ResponseEntity encapsula toda a estrutura necessária para retornar respsotas http com cabeçalhos, erros...
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}

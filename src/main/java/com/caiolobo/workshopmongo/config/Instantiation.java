package com.caiolobo.workshopmongo.config;

import com.caiolobo.workshopmongo.domain.Post;
import com.caiolobo.workshopmongo.domain.User;
import com.caiolobo.workshopmongo.dto.AuthorDTO;
import com.caiolobo.workshopmongo.dto.CommentDTO;
import com.caiolobo.workshopmongo.repository.PostRepository;
import com.caiolobo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob)); // salva os usuários para depois associá-los a um post, senão o id dá null

        Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu viagem", "Vou viajar para Sao Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2022"), "Bom dia", "Dormi bem hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem, mano!", sdf.parse("21/03/2022"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2022"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2022"), new AuthorDTO(alex));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.getPosts().addAll(Arrays.asList(post1, post2));       // ele ja adiciona a referência
        userRepository.save(maria);
    }
}

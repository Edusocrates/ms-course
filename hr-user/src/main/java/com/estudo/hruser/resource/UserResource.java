package com.estudo.hruser.resource;

import com.estudo.hruser.entities.User;
import com.estudo.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private static Logger log = LoggerFactory.getLogger(UserResource.class);

    @Autowired
    private UserRepository repository;

//    @GetMapping
//    public ResponseEntity<List<User>> findAll() {
//        List<User> list = repository.findAll();
//        return ResponseEntity.ok(list);
//    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = repository.findById(id).get();//ou lança exception
        return ResponseEntity.ok(obj);
    }
    @GetMapping(value = "/search")
    public ResponseEntity<User> findbyEmail(@RequestParam String email) {
        User obj = repository.findByEmail(email);//ou lança exception
        return ResponseEntity.ok(obj);
    }

}

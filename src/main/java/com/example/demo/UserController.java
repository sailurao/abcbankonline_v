package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000", maxAge=3600)
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Integer id)
    {
        return userRepository.findById(id);
    }

    @PostMapping("/user")
    public @Valid User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }

    @PutMapping("/user/{id}")
    public @Valid User updateUser(@PathVariable(value="id") Integer id, @Valid @RequestBody User user)
            throws UserNotFoundException {
        User usr = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
        usr.setFirst_name(user.getFirst_name());
        usr.setMiddle_name(user.getMiddle_name());
        usr.setLast_name(user.getLast_name());
        usr.setAddress(user.getAddress());
        usr.setEmailId(user.getEmailId());
        usr.setMobile_number(user.getMobile_number());
        usr.setPassword(user.getPassword());
        User updUser = userRepository.save(usr);
        return updUser;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable ("id") Integer id) throws UserNotFoundException {
        User usr1=userRepository.findById(id).orElseThrow(()->new UserNotFoundException(id));
        userRepository.delete(usr1);
        return ResponseEntity.ok().build();
    }

}

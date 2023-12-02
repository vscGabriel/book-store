package com.chatgv.user.api.controller;

import com.chatgv.user.api.service.UserService;
import com.chatgv.user.domain.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "*")
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> createUser(@RequestBody UserEntity user){
        log.info("***** User Creating *****");
        String resp = userService.saveUser(user);
        log.info("***** User Created *****");
        return ResponseEntity.ok().body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String[]> getByIdCategory(@PathVariable Long id){
        log.info("**** Getting User ****");
        String[] getUser = userService.findUserById(id);
        return ResponseEntity.ok().body(getUser);
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@RequestBody UserEntity user){
        log.info("**** Updating User ****");
        String resp = userService.updateUser(user);
        return ResponseEntity.ok().body(resp);
    }

    @DeleteMapping
    public ResponseEntity<String> disableUser(@RequestBody UserEntity user){
        log.info("**** Updating User ****");
       String resp =  userService.deleteUser(user);
        return ResponseEntity.ok().body(resp);
    }
}

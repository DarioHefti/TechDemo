/*
 * Controller.java
 *
 * Creator:
 * 16.09.2019 11:34 heftid
 *
 * Maintainer:
 * 16.09.2019 11:34 heftid
 *
 * Last Modification:
 * controller: $
 *
 * Copyright (c) 2019 ABACUS Research AG, All Rights Reserved
 */
package com.example.demo;

import com.example.demo.beans.User;
import com.example.demo.repo.UserRepository;
import org.apache.tomcat.jni.Error;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

  @Autowired
  UserRepository userRepository;

  @GetMapping(value = "/start")
  public List<User> start() {
    final User user = new User();
    user.setUsername("dariohefti");
    user.setSurname("Dario");
    user.setName("Hefti");
    user.setAge(25);
    userRepository.save(user);

    final User user1 = new User();
    user1.setUsername("mariusgermann");
    user1.setSurname("Marius");
    user1.setName("Germann");
    user1.setAge(27);
    userRepository.save(user1);

    final User user2 = new User();
    user2.setUsername("nicohefti");
    user2.setSurname("Nico");
    user2.setName("Hefti");
    user2.setAge(23);
    userRepository.save(user2);

    return userRepository.findAll();
  }

  @GetMapping(value = "/users")
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @PostMapping(value = "/users")
  public User addUser(@RequestBody User user) {
    return userRepository.save(user);
  }

  @GetMapping(value = "/search/byName/{name}")
  public List<User> findByName(@PathVariable final String name) {
    return userRepository.findByName(name);
  }

  @GetMapping(value = "/search/byUsername/{username}")
  public User findByUsername(@PathVariable String username) {
    return userRepository.findByUsername(username);
  }

  @GetMapping(value = "/search/olderThan/{age}")
  public List<User> getUserOlderThan(@PathVariable int age) {
    return userRepository.findOlderThan(age);
  }

  @GetMapping(value = "/users/{id}")
  public User getUser(@PathVariable Long id){
    return userRepository.findById(id).orElse(null);
  }

  @DeleteMapping(value = "/users/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }

  @DeleteMapping(value="/users/all")
  public void deleteAll(){
    userRepository.deleteAll();
  }

}

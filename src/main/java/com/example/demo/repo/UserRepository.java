package com.example.demo.repo;/*
 * UserRepository.java
 *
 * Creator:
 * 16.09.2019 11:34 heftid
 *
 * Maintainer:
 * 16.09.2019 11:34 heftid
 *
 * Last Modification:
 * userrepository: $
 *
 * Copyright (c) 2019 ABACUS Research AG, All Rights Reserved
 */

import com.example.demo.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
public interface UserRepository extends JpaRepository<User,Long> {

  List<User> findByName(String name);

  User findByUsername(String username);

  @Query(value = "SELECT * FROM User u where u.age > ?1 ", nativeQuery = true)
  List<User> findOlderThan(int age);
}

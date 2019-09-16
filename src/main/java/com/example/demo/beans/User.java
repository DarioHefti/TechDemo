/*
 * User.java
 *
 * Creator:
 * 16.09.2019 11:29 heftid
 *
 * Maintainer:
 * 16.09.2019 11:29 heftid
 *
 * Last Modification:
 * user: $
 *
 * Copyright (c) 2019 ABACUS Research AG, All Rights Reserved
 */
package com.example.demo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

  @Id
  @GeneratedValue
  private long id;
  @Column(unique = true)
  private String username;
  private String name;
  private String surname;
  private int age;

  public User() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}





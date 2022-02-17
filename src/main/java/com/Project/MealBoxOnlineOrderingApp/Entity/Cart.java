package com.Project.MealBoxOnlineOrderingApp.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    @JsonIgnore
    @ManyToOne
    private User user;
    @JsonIgnore
    @ManyToOne
    private Food food;

    public Cart(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }
}

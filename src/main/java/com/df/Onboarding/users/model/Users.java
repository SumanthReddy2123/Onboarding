package com.df.Onboarding.users.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Users {

    @Id
    int id;
    public String firstName,lastName;

    public int getId() {
        return id;
    }

    public Users(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    public Users() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String  toString(){
        return "FirstName : "+this.firstName+" LastName : "+this.lastName;
    }


}
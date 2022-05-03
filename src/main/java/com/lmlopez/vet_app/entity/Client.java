package com.lmlopez.vet_app.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Client")
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    private String cellphone;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Pet> pets = new ArrayList<>();

    public Client addPet(Pet pet){
        this.pets.add(pet);

        return this;
    }
}

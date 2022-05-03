package com.lmlopez.vet_app.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Pet")
@Table(name = "pet")
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;

    private String type;

    private Character sex;

    private Integer age;

    private Long fkClientId;
}

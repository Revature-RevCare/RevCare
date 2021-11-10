package com.revature.Spring.models;

import javax.persistence.*;

/**
 * Entity entity model class annotated to match the DB table "roles"
 */
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column
    private ERole name;

    // Constructors

    public Role() {
    }

    /**
     * Role constructor
     * @param name ERole instance
     */
    public Role(ERole name) {
        this.name = name;
    }

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }


    // toString Method here


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}

package com.example.php_course2.model;

import javax.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "deputies")
@Data
public class Deputy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String party;

    private int votes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deputy", fetch=FetchType.LAZY)
    private List<User> users;

    public Deputy() {
    }

    public Deputy(String address, String date) {
        this.name = address;
        this.party = date;
        this.votes = 0;
    }
}

package com.ma.xproce.dao.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Creator {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    @OneToMany(mappedBy = "creator")
    private Collection<Video> videos;

}

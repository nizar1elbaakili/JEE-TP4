package com.ma.xproce.dao.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Video {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String url;
    private String Description ;
    private Date datePublication;
    @ManyToOne
    private Creator creator;
}

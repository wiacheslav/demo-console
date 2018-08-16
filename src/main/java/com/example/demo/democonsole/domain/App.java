package com.example.demo.democonsole.domain;

import com.example.demo.democonsole.domain.types.AppType;
import com.example.demo.democonsole.domain.types.ContentType;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "apps")
@Data
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private AppType type;
    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ContentType.class)
    private Set<ContentType> contentTypes;
    @OneToOne
    private User user;
}

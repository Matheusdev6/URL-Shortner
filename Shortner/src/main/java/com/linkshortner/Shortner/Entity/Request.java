package com.linkshortner.Shortner.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Entity
@Table(name = "Links")
@Getter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private final String link;
    private final String email;
    private final String code;
    public Request(String link, String email) {
        this.link = link;
        this.email = email;
        this.code = UUID.randomUUID().toString().substring(0,6);
    }
}

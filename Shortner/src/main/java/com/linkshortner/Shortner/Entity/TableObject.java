package com.linkshortner.Shortner.Entity;


import com.linkshortner.Shortner.DTOs.CreateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Links")
@Getter
@NoArgsConstructor
public class TableObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String link;
    private  String email;
    private  String code;
    public TableObject(CreateDTO dto) {
        this.link = dto.getLink();
        this.email = dto.getEmail();
        this.code = UUID.randomUUID().toString().substring(0,6);
    }
}

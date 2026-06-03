package com.linkshortner.Shortner.DTOs;

import lombok.Getter;

@Getter
public class CreateDTO {
    private final String link;
    private final String email;

    public CreateDTO(String link, String email)
    {
        this.link = link;
        this.email = email;
    }
}

package com.linkshortner.Shortner.DTOs;


import lombok.Getter;

@Getter
public class GetLinkDTO {

    private final String code;

    public GetLinkDTO(String code){
        this.code = code;
    }
}

package com.linkshortner.Shortner.Controller;

import com.linkshortner.Shortner.DTOs.GetLinkDTO;
import com.linkshortner.Shortner.Entity.TableObject;
import com.linkshortner.Shortner.Service.LinkFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class LinkController {
    LinkFunctions service;
    @Autowired
    public LinkController(LinkFunctions service){
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<String> link(@RequestBody TableObject tao) {
        String created = service.ShortLink(tao);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/object/{code}")
    public ResponseEntity<Optional<TableObject>> getObject(@RequestParam String code){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCode(code));
    }

    @GetMapping("/link/{code}")
    public ResponseEntity<String> getLink(@RequestParam GetLinkDTO getLinkDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.getLink(getLinkDTO));
    }
}

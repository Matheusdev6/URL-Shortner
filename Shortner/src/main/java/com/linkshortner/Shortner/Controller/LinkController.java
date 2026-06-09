package com.linkshortner.Shortner.Controller;

import com.linkshortner.Shortner.DTOs.CreateDTO;
import com.linkshortner.Shortner.DTOs.GetLinkDTO;
import com.linkshortner.Shortner.Entity.TableObject;
import com.linkshortner.Shortner.Service.LinkFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class LinkController {
    LinkFunctions service;
    @Autowired
    public LinkController(LinkFunctions service){
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<String> link(@RequestBody CreateDTO dto) {
        String created = service.ShortLink(dto);
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

package com.linkshortner.Shortner.Controller;

import com.linkshortner.Shortner.DTOs.CreateDTO;
import com.linkshortner.Shortner.DTOs.GetLinkDTO;
import com.linkshortner.Shortner.Entity.TableObject;
import com.linkshortner.Shortner.Service.LinkFunctions;
import io.swagger.v3.oas.annotations.Parameter;
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
    public ResponseEntity<Optional<TableObject>> getObject(
            @Parameter(description = "link code",  required = true)
            @RequestParam String code){
        return ResponseEntity.status(HttpStatus.OK).body(service.findByCode(code));
    }

    @GetMapping("/link/{code}")
    public ResponseEntity<String> getLink(
            @Parameter(description = "getLinkDTO", required = true)
            @RequestBody GetLinkDTO getLinkDTO){
        return ResponseEntity.status(HttpStatus.OK).body(service.getLink(getLinkDTO));
    }

    @GetMapping("/link/redirect/{code}")
    public ResponseEntity<Void> redirect(
            @Parameter(description = "code", required = true)
            @PathVariable String code
    ){
        String url = service.getLink(new GetLinkDTO(code));
        return ResponseEntity.status(HttpStatus.MOVED_PERMANENTLY).header("Location", url).build();
    }
}

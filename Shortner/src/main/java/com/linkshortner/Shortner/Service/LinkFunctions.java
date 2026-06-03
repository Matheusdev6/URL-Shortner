package com.linkshortner.Shortner.Service;


import com.linkshortner.Shortner.DTOs.GetLinkDTO;
import com.linkshortner.Shortner.Entity.TableObject;
import com.linkshortner.Shortner.Exceptions.LinkNotFound;
import com.linkshortner.Shortner.Exceptions.NullObject;
import com.linkshortner.Shortner.Repository.TableObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkFunctions {
    @Autowired
    private final TableObjectRepository tableObjectRepository;

    public LinkFunctions(TableObjectRepository tableObjectRepository){
        this.tableObjectRepository = tableObjectRepository;
    }
    // Funções dos Endpoints

    public String ShortLink(TableObject tableObject){
        if(tableObject != null){
            tableObjectRepository.save(tableObject);
            MailService mailService = new MailService();
            mailService.sendMail(tableObject.getCode(), "Encurtador de links", String.format("Olá, seu link foi encurtado. Aqui está ele: localhost:8080/%s", tableObject.getCode()));
            return "Link foi encurtado.";
        } else{
            NullObject nullObject = new NullObject("The request is null or not completed.");
            System.out.println(nullObject.getMessage());
            return "Link não foi encurtado.";
        }
    }
    public Optional<TableObject> findByCode(String code){
        return tableObjectRepository.findByCode(code);
    }
    public String getLink(GetLinkDTO getLinkDTO){
        if(getLinkDTO != null){
            Optional<TableObject> requestForLink = tableObjectRepository.findByCode(getLinkDTO.getCode());
            if(requestForLink.isPresent()){
               return requestForLink.get().getLink();
            }
            else {
                LinkNotFound linkNotFound = new LinkNotFound("Link not found. Or the code is wrong");
                return linkNotFound.getMessage();
            }
        } else{
            LinkNotFound linkNotFound = new LinkNotFound("Link not found. Or the code is wrong");
            return linkNotFound.getMessage();
        }
    }
}

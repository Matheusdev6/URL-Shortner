package com.linkshortner.Shortner.Service;


import com.linkshortner.Shortner.Entity.Request;
import com.linkshortner.Shortner.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkFunctions {
    @Autowired
    private final Repository repository;

    public LinkFunctions(Repository repository){
        this.repository = repository;
    }
}

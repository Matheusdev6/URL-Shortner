package com.linkshortner.Shortner.Repository;

import com.linkshortner.Shortner.Entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repository extends JpaRepository<Request, Long> {
    Optional<Request> findByCode(String code);
}

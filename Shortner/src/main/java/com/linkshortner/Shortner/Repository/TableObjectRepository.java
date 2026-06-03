package com.linkshortner.Shortner.Repository;

import com.linkshortner.Shortner.Entity.TableObject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TableObjectRepository extends JpaRepository<TableObject, Long> {
    Optional<TableObject> findByCode(String code);
}

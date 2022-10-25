package com.example.cameit.domain.bread.domain.repository;

import com.example.cameit.domain.bread.domain.Bread;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BreadRepository extends CrudRepository<Bread, Long> {
    Optional<Bread> findByName(String name);
    List<Bread> findAllByNameContains(String name);

    List<Bread> findAllByOrderById();
}

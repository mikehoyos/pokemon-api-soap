package com.pokemon.soap.repository;

import com.pokemon.soap.entity.AccesUsr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccesUserRepository extends JpaRepository<AccesUsr, Long> {
}

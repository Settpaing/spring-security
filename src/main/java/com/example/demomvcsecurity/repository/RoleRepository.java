package com.example.demomvcsecurity.repository;

import com.example.demomvcsecurity.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Integer> {
}

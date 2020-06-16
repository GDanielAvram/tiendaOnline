package com.tiendaOnline.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.tiendaOnline.model.RolEntity;

@Repository
@Component("rolRepository")
public interface RolRepository extends JpaRepository<RolEntity, Integer> {
}
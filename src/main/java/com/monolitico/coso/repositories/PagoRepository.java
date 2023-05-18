package com.monolitico.coso.repositories;

import com.monolitico.coso.entities.PagoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PagoRepository extends JpaRepository<PagoEntity, Long>{
}

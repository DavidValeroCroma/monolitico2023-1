package com.monolitico.coso.repositories;

import com.monolitico.coso.entities.AcopioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AcopioRepository extends JpaRepository<AcopioEntity, Long>{
    ArrayList<AcopioEntity> findByIdProveedor(Long idProveedor);
}

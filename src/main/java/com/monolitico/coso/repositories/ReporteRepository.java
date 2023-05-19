package com.monolitico.coso.repositories;


import com.monolitico.coso.entities.ReporteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ReporteRepository extends JpaRepository<ReporteEntity, Long>{
    ArrayList<ReporteEntity> findByIdProveedor(Long idProveedor);
}

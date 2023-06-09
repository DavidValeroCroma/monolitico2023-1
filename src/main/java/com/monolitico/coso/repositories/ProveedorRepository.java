package com.monolitico.coso.repositories;

import com.monolitico.coso.entities.ProveedorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Long>{
}

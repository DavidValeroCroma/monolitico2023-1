package com.monolitico.coso.services;

import com.monolitico.coso.entities.AcopioEntity;
import com.monolitico.coso.repositories.AcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class AcopioService {
    @Autowired
    AcopioRepository acopioRepository;

    public ArrayList<AcopioEntity> obtenerAcopios(){
        return (ArrayList<AcopioEntity>) acopioRepository.findAll();
    }

    public ArrayList<AcopioEntity> obtenerAcopiosPorProveedor(Long id){
        return (ArrayList<AcopioEntity>) acopioRepository.findByIdProveedor(id);
    }

    public ArrayList<AcopioEntity> obtenerAcopiosPorQuincena(Integer quincena, Integer mes, Integer año, Long idProveedor){
        ArrayList<AcopioEntity> acopiosQuincena = new ArrayList<>();
        ArrayList<AcopioEntity> totalAcopios = obtenerAcopiosPorProveedor(idProveedor);
        for (int i = 0 ; i< totalAcopios.size()  ; i++){
            if (quincena == 1 && totalAcopios.get(i).getFecha().getDay() < 15  && totalAcopios.get(i).getFecha().getDay() > 0 && totalAcopios.get(i).getFecha().getMonth() == mes && totalAcopios.get(i).getFecha().getYear()== año){
                acopiosQuincena.add(totalAcopios.get(i));
            }
            if (quincena == 2 && totalAcopios.get(i).getFecha().getDay() <= 31  && totalAcopios.get(i).getFecha().getDay() >= 15  && totalAcopios.get(i).getFecha().getMonth() == mes && totalAcopios.get(i).getFecha().getYear()== año){
                acopiosQuincena.add(totalAcopios.get(i));
            }
        }
        return acopiosQuincena;
    }
    
}

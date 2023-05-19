package com.monolitico.coso.services;

import com.monolitico.coso.entities.AcopioEntity;
import com.monolitico.coso.repositories.AcopioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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

    public void crearAcopio(Long idProveedor, Date fecha, Character turno, Double leche){
        AcopioEntity acopioAux = new AcopioEntity();
        acopioAux.setIdProveedor(idProveedor);
        acopioAux.setFecha(fecha);
        acopioAux.setLeche(leche);
        if (turno == 'M' || turno == 'T'){
            acopioAux.setTurno(turno);
        }else{
            turno = 'M';
            acopioAux.setTurno(turno);
        }
        acopioRepository.save(acopioAux);
    }

    public ArrayList<AcopioEntity> obtenerAcopiosPorQuincena(Integer quincena, Integer mes, Integer año, Long idProveedor){
        ArrayList<AcopioEntity> acopiosQuincena = new ArrayList<>();
        ArrayList<AcopioEntity> totalAcopios = obtenerAcopiosPorProveedor(idProveedor);

        for (AcopioEntity acopio: totalAcopios){
            if (quincena == 1 && acopio.getFecha().getDay() < 15  && acopio.getFecha().getDay() > 0 && acopio.getFecha().getMonth() == mes && acopio.getFecha().getYear()== año){
                acopiosQuincena.add(acopio);
            }
            if (quincena == 2 && acopio.getFecha().getDay() <= 31  && acopio.getFecha().getDay() >= 15  && acopio.getFecha().getMonth() == mes && acopio.getFecha().getYear()== año){
                acopiosQuincena.add(acopio);
            }
        }

        return acopiosQuincena;
    }

    public double totalLecheQuincena(Integer quincena, Integer mes, Integer año, Long idProveedor){
        ArrayList<AcopioEntity> acopiosQuincena = obtenerAcopiosPorQuincena(quincena, mes, año, idProveedor);
        double acum = 0 ;

        for (AcopioEntity acopio:acopiosQuincena){
            acum = acum + acopio.getLeche();
        }

        return acum;
    }

}

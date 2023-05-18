package com.monolitico.coso.services;

import com.monolitico.coso.entities.PagoEntity;
import com.monolitico.coso.repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class PagoService {
    @Autowired
    PagoRepository pagoRepository;

    public ArrayList<PagoEntity> obtenerPagos(){
        return (ArrayList<PagoEntity>) pagoRepository.findAll();
    }

    public PagoEntity obtenerPagoPorId(Long id){
        return pagoRepository.getById(id);
    }

    public void guardarPago(Long idProveedor, Long idReporte, Integer quincena){
        PagoEntity pagoAux = new PagoEntity();
        pagoAux.setIdReporte(idReporte);
        pagoAux.setIdProveedor(idProveedor);
        if (quincena == 1  || quincena == 2){
            pagoAux.setQuincena(quincena);
        }


    }



}

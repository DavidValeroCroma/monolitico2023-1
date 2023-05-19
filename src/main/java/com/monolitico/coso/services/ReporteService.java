package com.monolitico.coso.services;

import com.monolitico.coso.entities.ReporteEntity;
import com.monolitico.coso.repositories.ReporteRepository;
import org.springframework.stereotype.Service;
import com.monolitico.coso.entities.AcopioEntity;
import com.monolitico.coso.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

@Service
public class ReporteService {
    @Autowired
    ReporteRepository reporteRepository;
    @Autowired
    AcopioService acopioService;
    public ArrayList<ReporteEntity> obtenerQuincenas(){
        return (ArrayList<ReporteEntity>) reporteRepository.findAll();
    }

    public ArrayList<ReporteEntity> obtenerQuincenasPorProveedor(Long id){
        return (ArrayList<ReporteEntity>) reporteRepository.findByIdProveedor(id);
    }

    public Float obtenerVariacionGrasa(Long idProveedor, Integer quincena, Integer mes, Integer año, Float grasa){

    }
    public Float obtenerVariacionSolido(Long idProveedor, Integer quincena, Integer mes, Integer año, Float solidos){

    }
    public void crearReporte(Long idProveedor, Integer quincena, Integer mes, Integer año, Float solidos, Float grasa ){
        Date fecha = new Date();
        ReporteEntity reporteAux = new ReporteEntity();
        reporteAux.setFecha(fecha);
        reporteAux.setIdProveedor(idProveedor);
        reporteAux.setQuincena(quincena);
        reporteAux.setMes(mes);
        reporteAux.setAño(año);
        reporteAux.setSolidos(solidos);
        reporteAux.setGrasa(grasa);

        Double leche = acopioService.totalLecheQuincena(quincena, mes, año, idProveedor);

        Float varGrasa = obtenerVariacionGrasa(idProveedor, quincena, mes, año, grasa);
        Float varSolidos = obtenerVariacionSolido(idProveedor, quincena, mes, año, solidos);


    }

}
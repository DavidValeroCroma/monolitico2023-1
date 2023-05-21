package com.monolitico.coso.services;

import com.monolitico.coso.entities.ReporteEntity;
import com.monolitico.coso.repositories.ReporteRepository;
import org.springframework.stereotype.Service;
import com.monolitico.coso.entities.AcopioEntity;
import com.monolitico.coso.services.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
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

    /*
    public Double obtenerVariacionGrasa(Long idProveedor, Integer quincena, Integer mes, Integer año, Double grasa){

        // calculamos los parametros de la anterior entrega de reporte de los porcentajes

        Integer quincenaAux = quincena;
        Integer mesAux = mes;
        Integer añoAux = año;

        if(quincena == 2){
            quincenaAux = 1;
        }
        if (quincena == 1){
            quincenaAux = 2;
            if (mes == 1){
                mesAux = 12;
                añoAux = año - 1;
            }else{
                mesAux = mes - 1;
            }
        }

        ReporteEntity reporteAux = reporteRepository.findByIdProveedorAndQuincenaAndMesAndAño(idProveedor,quincenaAux,mesAux,añoAux);
        
        //generamos los casos posibles de variacion
        Double variacion = 0.0;
        //no existe reporte anterior
        if (reporteAux != null){
            return variacion
        } else if (reporteAux.getGrasa()<grasa) {
            return variacion;
        }else{
            variacion = (grasa - reporteAux.getGrasa());

        }

    }

    public Double obtenerVariacionSolido(Long idProveedor, Integer quincena, Integer mes, Integer año, Double solidos){}

    public void crearReporte(Long idProveedor, Integer quincena, Integer mes, Integer año, Double solidos, Double grasa ){
        ReporteEntity reporteAux = new ReporteEntity();
        reporteAux.setIdProveedor(idProveedor);
        reporteAux.setSolidos(solidos);
        reporteAux.setGrasa(grasa);
        if(quincena== 1 || quincena== 2 ){
            reporteAux.setQuincena(quincena);
        }else{
            reporteAux.setQuincena(1);
        }
        if(mes < 13 && mes > 0){
            reporteAux.setMes(mes);
            reporteAux.setAño(año);
        }

        Double leche = acopioService.totalLecheQuincena(quincena, mes, año, idProveedor);
        if(quincena == 1) {

        }
        Double varGrasa = obtenerVariacionGrasa(idProveedor, quincena, mes, año, grasa);
        Double varSolidos = obtenerVariacionSolido(idProveedor, quincena, mes, año, solidos);


    }
    */

}
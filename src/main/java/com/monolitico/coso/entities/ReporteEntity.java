package com.monolitico.coso.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reporte")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ReporteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false, unique = true)
    private Long id;
    private Long idProveedor;
    private Double leche;
    private Date fecha;
    private Integer quincena;
    private Integer mes;
    private Integer año;
    private Float solidos;
    private Float grasa;
    private Float varSolidos;
    private Float varGrasa;
    private Float varCantLeche;
}

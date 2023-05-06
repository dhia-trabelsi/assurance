package com.pfe.Bareme;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
@AllArgsConstructor
@Entity
@Table(name = "BAREME")
public class Bareme {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long Cod_Assur;
    private String abrv;
    private String indice;
    private float mtt;
    private Date date;
    private float taux;
    private String plafonne;
    private float plafond;
    private String piece;
    private String vign;
    private String dureeAct;
    private String plafondPrest;
    private String prortat;
    private int ageMin;
    private int ageMax;
    private String femmeEnc;
    private float dureeEnc;

}

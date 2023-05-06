package com.pfe.Societe;

import com.pfe.Assurance.Assurance;

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
@Table(name = "SOCIETE")
public class Societe {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private int Cod;
    private String Lib;
    private String LibA;
    private String Adresse;
    private String AdresseA;
    private String Tel;
    private String Fax;
    private String CodeTva;
    private String CodeRetr;
    private String NumRetr;
    private String RepWeb;
    private String Regime;
    private String NumPolice;
    private String AdrElectronique;
    private String CodPay;
    private int AgeMin;
    private int AgeMax;
    private long assurance;

}

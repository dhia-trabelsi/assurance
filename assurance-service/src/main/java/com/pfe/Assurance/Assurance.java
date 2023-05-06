package com.pfe.Assurance;

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
@Table(name = "ASSURANCE")
public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Cod_Assur;

    private String Lib_Assur;
    private String Lib_Assur_A;
    private String Num_Police;
    private String Typ_Plafond;
    private String Tel_Assur;
    private String Fax_Assur;
    private String Prefixe;
    private double Duree_Bult_Mut;
    private double Taux_Mut;
    private double Plaf_Mut;
    private Date Dat_Contrat;
    private int Delai_Cvisite;
    private int Age_Between_Enf;
    private float mntAdher;
    private float mntEnf;
    private float mntConj;
    private float mntPere;
    private float mntMere;
    private String ProratPec;

    



    // MNT_ADHER NUMBER(10, 3),
    // MNT_ENF NUMBER(10, 3),
    // MNT_CONJ NUMBER(10, 3),
    // MNT_PERE NUMBER(10, 3),
    // MNT_MERE NUMBER(10, 3),
    // PRORAT_PEC VARCHAR2(1),

}

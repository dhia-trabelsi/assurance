package com.pfe.Bds;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pfe.Act.Act;
import com.pfe.Borderau.Borderau;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "BUllTIN")
public class Bulltin {
    
    @Id @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer Id;

    
    private int userID;
    private long assur;
    private String prestataire;
    private Date dateSoin;
    private int mois;
    private int ans;
    private Date dateSaisie;

    



    @ManyToOne
    @JoinColumn(name = "code")
    private  Borderau borderau;

    @JsonIgnore
    @OneToMany(mappedBy = "Id")
    private List<Act> acts;

}

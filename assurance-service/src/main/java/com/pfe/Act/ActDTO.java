package com.pfe.Act;

import java.util.Date;

import com.pfe.TypeAct.TypeAct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActDTO {
    

    private String abrv;
    private String lib;
    
    private Date date;
    private String plafonne;
    private String ctr;
    private String sexe;
    private String parent;
    private  TypeAct typeAct;
    
}

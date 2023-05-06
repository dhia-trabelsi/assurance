package com.pfe.TypeAct;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pfe.Act.Act;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "typeact")
public class TypeAct {
    
    @Id
    private int typeAct;

    private String lib;

    
    
    @JsonIgnore
    @OneToMany(mappedBy = "typeAct")
    private List<Act> act;

    public TypeAct(int typeAct) {
        this.typeAct = typeAct;
    }
}

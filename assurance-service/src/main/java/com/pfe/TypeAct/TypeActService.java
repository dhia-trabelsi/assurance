package com.pfe.TypeAct;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pfe.util.NotifSender;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TypeActService {
    
    private final TypeActRepository typeActRepository;
    private final NotifSender notifSender;



    

    public TypeAct save(TypeAct typeAct) {
        TypeAct newTypeAct = TypeAct.builder()
                .typeAct(typeAct.getTypeAct())
                .lib(typeAct.getLib())
                .build();

         String message = "nouveau type des actes médicaux : "+ typeAct.getLib() + " est ajouté";
         
        notifSender.sendNotif(message, "NEW_TYPEACT");

        return typeActRepository.save(newTypeAct);

    }

    public List<TypeAct> getAll(){
        return typeActRepository.findAll();
    }

    public TypeAct getById(int id) {
        return typeActRepository.findById(id).orElseThrow();
    }

    public void delete(int id) {
        typeActRepository.deleteById(id);
    }

    public TypeAct updateTypeAct(int id, TypeAct typeAct) {
        TypeAct typeActToUpdate = typeActRepository.findById(id).orElseThrow();
        typeActToUpdate =  typeActToUpdate.builder()
                .lib(typeAct.getLib())
                .build();
        return typeActRepository.save(typeActToUpdate);
    }
}

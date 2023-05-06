package com.pfe.Act;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.TypeAct.TypeAct;
import com.pfe.TypeAct.TypeActRepository;
import com.pfe.util.NotifSender;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActService {

    private final ActRepository actRepository;
    private final TypeActRepository typeActRepository;
    private final NotifSender notifSender;

    public Act save(ActDTO act) {

        TypeAct existingTypeAct = typeActRepository.findById(act.getTypeAct().getTypeAct())
                .orElseThrow(() -> new RuntimeException("TypeAct instance not found in the database"));
        Act newAct = Act.builder()
                .abrv(act.getAbrv())
                .lib(act.getLib())
                .date(act.getDate())
                .plafonne(act.getPlafonne())
                .ctr(act.getCtr())
                .sexe(act.getSexe())
                .parent(act.getParent())
                .typeAct(act.getTypeAct())
                .build();

        // String message = "nouveau acte médical : " + act.getLib() + " est ajouté au type : " + existingTypeAct.getLib();
        // notifSender.sendNotif(message, "NEW_ACT");

        return actRepository.save(newAct);

    }

    public Act getById(int id) {
        return actRepository.findById(id).orElseThrow();
    }

    public List<Act> getAll() {
        return actRepository.findAll();
    }

    public void delete(int id) {
        actRepository.deleteById(id);
    }

    public Act update(int id, Act act) {

        Act actToUpdate = actRepository.findById(id).orElseThrow();
    actToUpdate.setAbrv(act.getAbrv());
    actToUpdate.setLib(act.getLib());
    actToUpdate.setDate(act.getDate());
    actToUpdate.setPlafonne(act.getPlafonne());
    actToUpdate.setCtr(act.getCtr());
    actToUpdate.setParent(act.getParent());
    actToUpdate.setTypeAct(act.getTypeAct());
    actToUpdate.setSexe(act.getSexe());
    actToUpdate.setDuree(act.getDuree());
    actToUpdate.setIndice(act.getIndice());
    actToUpdate.setMtt(act.getMtt());
    actToUpdate.setPlafond(act.getPlafond());
    actToUpdate.setPiece(act.getPiece());
    actToUpdate.setVign(act.getVign());
    actToUpdate.setTaux(act.getTaux());

    return actRepository.save(actToUpdate);
    }

    public Act getByAbrv(String abrv) {
        return actRepository.findByAbrv(abrv);
    }
}

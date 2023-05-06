package com.pfe.Bareme;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Act.Act;
import com.pfe.Act.ActService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BaremeService {
    
    private final BaremeRepository baremeRepository;
    private final ActService actService;

    public Bareme save(Bareme bareme) {
        Bareme newBareme = Bareme.builder()
                .Cod_Assur(bareme.getCod_Assur())
                .abrv(bareme.getAbrv())
                .indice(bareme.getIndice())
                .mtt(bareme.getMtt())
                .date(bareme.getDate())
                .taux(bareme.getTaux())
                .plafonne(bareme.getPlafonne())
                .plafond(bareme.getPlafond())
                .piece(bareme.getPiece())
                .vign(bareme.getVign())
                .dureeAct(bareme.getDureeAct())
                .plafondPrest(bareme.getPlafondPrest())
                .prortat(bareme.getPrortat())
                .ageMin(bareme.getAgeMin())
                .ageMax(bareme.getAgeMax())
                .femmeEnc(bareme.getFemmeEnc())
                .dureeEnc(bareme.getDureeEnc())
                .build();

                Act act = actService.getByAbrv(newBareme.getAbrv());
                act.setDuree(newBareme.getDureeAct());
                act.setIndice(newBareme.getIndice());
                act.setMtt(newBareme.getMtt());
                act.setPlafond(newBareme.getPlafond());
                act.setPiece(newBareme.getPiece());
                act.setVign(newBareme.getVign());
                actService.update(act.getId(), act);
 

            return baremeRepository.save(newBareme);
    }

    public Bareme getById(Long id) {
        return baremeRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        baremeRepository.deleteById(id);
    }

    public Bareme update(Long id, Bareme bareme) {
        Bareme newBareme = baremeRepository.findById(id).orElseThrow();
        newBareme.builder()
                .Cod_Assur(bareme.getCod_Assur())
                .abrv(bareme.getAbrv())
                .indice(bareme.getIndice())
                .mtt(bareme.getMtt())
                .date(bareme.getDate())
                .taux(bareme.getTaux())
                .plafonne(bareme.getPlafonne())
                .plafond(bareme.getPlafond())
                .piece(bareme.getPiece())
                .vign(bareme.getVign())
                .dureeAct(bareme.getDureeAct())
                .plafondPrest(bareme.getPlafondPrest())
                .prortat(bareme.getPrortat())
                .ageMin(bareme.getAgeMin())
                .ageMax(bareme.getAgeMax())
                .femmeEnc(bareme.getFemmeEnc())
                .dureeEnc(bareme.getDureeEnc())
                .build();
            return baremeRepository.save(newBareme);
            
    }

    public List<Bareme> getAll() {
        return baremeRepository.findAll();
    }
}

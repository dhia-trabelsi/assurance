package com.pfe.Assurance;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pfe.Societe.Societe;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssuranceService {

    private final AssuranceRepository assuranceRepository;

    public Assurance save(Assurance assurance) {
        var assuranceToSave = Assurance.builder()
                .Cod_Assur(assurance.getCod_Assur())
                .Lib_Assur(assurance.getLib_Assur())
                .Lib_Assur_A(assurance.getLib_Assur_A())
                .Num_Police(assurance.getNum_Police())
                .Typ_Plafond(assurance.getTyp_Plafond())
                .Dat_Contrat(assurance.getDat_Contrat())
                .Age_Between_Enf(assurance.getAge_Between_Enf())
                .Delai_Cvisite(assurance.getDelai_Cvisite())
                .Duree_Bult_Mut(assurance.getDuree_Bult_Mut())
                .Tel_Assur(assurance.getTel_Assur())
                .Fax_Assur(assurance.getFax_Assur())
                .Prefixe(assurance.getPrefixe())
                .Plaf_Mut(assurance.getPlaf_Mut())
                .Taux_Mut(assurance.getTaux_Mut())
                .mntAdher(assurance.getMntAdher())
                .mntEnf(assurance.getMntEnf())
                .mntConj(assurance.getMntConj())
                .mntPere(assurance.getMntPere())
                .mntMere(assurance.getMntMere())
                .ProratPec(assurance.getProratPec())
                .build(); 

        return assuranceRepository.save(assuranceToSave);
    }

    public List<Assurance> getAll() {
        return assuranceRepository.findAll();
    }

    public Assurance getById(Long id) {
        return assuranceRepository.findById(id).orElseThrow();
    }

    public void delete(Long id) {
        assuranceRepository.deleteById(id);
    }

    public Assurance updateAssurance(Assurance assurance, Long id) {
        Assurance assuranceToUpdate = assuranceRepository.findById(id).orElseThrow();
        assuranceToUpdate.builder()
                .Cod_Assur(assurance.getCod_Assur())
                .Lib_Assur(assurance.getLib_Assur())
                .Lib_Assur_A(assurance.getLib_Assur_A())
                .Num_Police(assurance.getNum_Police())
                .Typ_Plafond(assurance.getTyp_Plafond())
                .Dat_Contrat(assurance.getDat_Contrat())
                .Delai_Cvisite(assurance.getDelai_Cvisite())
                .Age_Between_Enf(assurance.getAge_Between_Enf())
                .Duree_Bult_Mut(assurance.getDuree_Bult_Mut())
                .Tel_Assur(assurance.getTel_Assur())
                .Fax_Assur(assurance.getFax_Assur())
                .Prefixe(assurance.getPrefixe())
                .Plaf_Mut(assurance.getPlaf_Mut())
                .Taux_Mut(assurance.getTaux_Mut())
                .mntAdher(assurance.getMntAdher())
                .mntEnf(assurance.getMntEnf())
                .mntConj(assurance.getMntConj())
                .mntPere(assurance.getMntPere())
                .mntMere(assurance.getMntMere())
                .ProratPec(assurance.getProratPec())
                .build();
        assuranceRepository.save(assuranceToUpdate);
        return assuranceToUpdate;
    }

}

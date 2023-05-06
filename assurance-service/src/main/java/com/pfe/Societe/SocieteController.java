package com.pfe.Societe;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/societe")
public class SocieteController {

    private final SocieteService societeService;

    @PostMapping
    public Societe save(@RequestBody Societe societe) {
        return societeService.CreateSociete(societe);
    }

    @GetMapping("/{id}")
    public Societe getById(@PathVariable int id) {
        return societeService.getById(id);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(societeService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Societe> updateSociete(@PathVariable int id, @RequestBody Societe societe) {
        return ResponseEntity.ok(societeService.updateSociete(id, societe));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSociete(@PathVariable int id) {
        societeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getbyassurance/{id}")
    public ResponseEntity<?> getByAssurance(@PathVariable long id) {
        return ResponseEntity.ok(societeService.getByAssurance(id));
    }
}

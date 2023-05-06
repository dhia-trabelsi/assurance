package com.pfe.Assurance;

import java.util.List;

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
@RequestMapping("/api/v1/assurance")
public class AssuranceController {

    private final AssuranceService assuranceService;

    @PostMapping()
    public ResponseEntity<Assurance> save(@RequestBody Assurance assurance) {

        return ResponseEntity.ok(assuranceService.save(assurance));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Assurance>> getAll() {

        if (assuranceService.getAll() == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(assuranceService.getAll());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Assurance> getById(@PathVariable Long id) {

        if (assuranceService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(assuranceService.getById(id));
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        if (assuranceService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            assuranceService.delete(id);
            return ResponseEntity.ok().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Assurance> update(@RequestBody Assurance assurance, @PathVariable Long id) {

        if (assuranceService.getById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(assuranceService.updateAssurance(assurance, id));
        }

    }


}

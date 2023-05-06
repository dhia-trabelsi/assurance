package com.pfe.Bareme;

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
@RequestMapping("/api/bareme")
@RequiredArgsConstructor 
public class BaremController {
    

    private final BaremeService baremeService;


    @PostMapping
    public ResponseEntity<?> save(@RequestBody Bareme bareme){

        return ResponseEntity.ok(baremeService.save(bareme));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){

        return ResponseEntity.ok(baremeService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        baremeService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Bareme bareme){

        return ResponseEntity.ok(baremeService.update(id, bareme));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){

        return ResponseEntity.ok(baremeService.getAll());
    }
}

package com.pfe.TypeAct;

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
@RequestMapping("/api/typeact")
@RequiredArgsConstructor
public class TypeActController {

    private final TypeActService typeActService;

    @PostMapping
    public ResponseEntity<?> createActe(@RequestBody TypeAct typeAct) {
        return ResponseEntity.ok(typeActService.save(typeAct));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(typeActService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        return ResponseEntity.ok(typeActService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        typeActService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTypeAct(@PathVariable int id, @RequestBody TypeAct typeAct) {
        return ResponseEntity.ok(typeActService.updateTypeAct(id, typeAct));
    }

}

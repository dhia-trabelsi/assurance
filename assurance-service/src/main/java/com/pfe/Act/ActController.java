package com.pfe.Act;

import java.util.List;

import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/act")
public class ActController {

    private final ActService actService;

    @PostMapping
    public ResponseEntity<Act> save(@RequestBody ActDTO act) {
        return new ResponseEntity<>(actService.save(act), HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Act> getById(@PathVariable int id) {
        return new ResponseEntity<>(actService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Act>> getAll() {
        return new ResponseEntity<>(actService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        actService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Act> update(@PathVariable int id, @RequestBody Act act) {
        return new ResponseEntity<>(actService.update(id, act), HttpStatus.OK);

    }
}
package com.pfe.Borderau;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/borderau")
public class BorderauController {
    

    private final BorderauService borderauService;

    @PostMapping
    public ResponseEntity<Borderau> prepareBorderau(@RequestBody Borderau borderau) {
    
        return ResponseEntity.ok(borderauService.prepareBorderau(borderau));
    }
}

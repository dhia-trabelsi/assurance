package com.pfe.Bds;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bulltin")
public class BulltinController {
    
    private final bulltinService bulltinService;


    
}

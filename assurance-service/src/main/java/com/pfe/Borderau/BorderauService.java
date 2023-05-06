package com.pfe.Borderau;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorderauService {
    
    private final BorderauRepository borderauRepository;

    public Borderau prepareBorderau(Borderau borderau) {
    
        return borderauRepository.save(borderau);
    }


    


}

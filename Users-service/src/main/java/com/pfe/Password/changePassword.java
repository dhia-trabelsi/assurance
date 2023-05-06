package com.pfe.Password;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class changePassword {

    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
    
}

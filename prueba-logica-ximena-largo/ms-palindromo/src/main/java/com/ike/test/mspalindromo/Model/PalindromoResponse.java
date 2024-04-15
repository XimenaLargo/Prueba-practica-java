package com.ike.test.mspalindromo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PalindromoResponse {

    private int lengthCadena;
    private int isPalindromo;
    private int lengthCaracteresEspeciales;

}

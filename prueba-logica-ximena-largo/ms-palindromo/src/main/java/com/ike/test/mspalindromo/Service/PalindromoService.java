package com.ike.test.mspalindromo.Service;

import com.ike.test.mspalindromo.Model.PalindromoResponse;
import org.springframework.stereotype.Service;

@Service
public class PalindromoService {


public PalindromoResponse leerPalindromo (String palindromo){
    int lengthCadena = palindromo.length();
    int isPalindromo = isPalindromoFunc(palindromo);
    int lengthCaracteresEspeciales = lengthCaracteresEspecialesFunc(palindromo);

    return new PalindromoResponse(lengthCadena,isPalindromo,lengthCaracteresEspeciales);
}


public int isPalindromoFunc(String palindromo){
    palindromo = palindromo.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    int longitud = palindromo.length();
    for (int i = 0; i < longitud / 2; i++) {
        if (palindromo.charAt(i) != palindromo.charAt(longitud - i - 1)) {
            return 0;
        }
    }
    return 1;
}

    public int lengthCaracteresEspecialesFunc(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                result++;
            }
        }
        return result;
    }

}

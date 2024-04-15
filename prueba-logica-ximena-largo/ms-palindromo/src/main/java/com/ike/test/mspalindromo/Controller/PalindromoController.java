package com.ike.test.mspalindromo.Controller;

import com.ike.test.mspalindromo.Model.PalindromoRequest;
import com.ike.test.mspalindromo.Model.PalindromoResponse;
import com.ike.test.mspalindromo.Service.PalindromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/palindromo")
@RequiredArgsConstructor
public class PalindromoController {


    private final PalindromoService palindromoService;


    @PostMapping
    public ResponseEntity<PalindromoResponse> testPalindromo(@RequestBody PalindromoRequest palindromoRequest){
        String palindromo = palindromoRequest.getPalindromo();
        return ResponseEntity.ok(palindromoService.leerPalindromo(palindromo));
    }

}

package br.com.dobackaofront.javahospitalar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enfermeiro")
public class EnfermeiroController {
    @GetMapping
    public String enfermeiroAccess() {
        return "Área do Enfermeiro";
    }
}

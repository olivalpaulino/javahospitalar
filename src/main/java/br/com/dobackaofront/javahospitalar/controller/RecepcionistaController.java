package br.com.dobackaofront.javahospitalar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recepcionista")
public class RecepcionistaController {
    @GetMapping
    public String recepcionistaAccess() {
        return "Área da Recepcionista";
    }
}

package br.com.dobackaofront.javahospitalar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medico")
public class MedicoController {
    @GetMapping
    public String medicoAccess() {
        return "Área do Médico";
    }
}

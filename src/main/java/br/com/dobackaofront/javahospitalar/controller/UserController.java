package br.com.dobackaofront.javahospitalar.controller;

import br.com.dobackaofront.javahospitalar.entity.User;
import br.com.dobackaofront.javahospitalar.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register-admin")
    public ResponseEntity<String> registerAdmin(@RequestParam String username, @RequestParam String password) {
        User user = userService.cadastrarAdministrador(username, password);
        return ResponseEntity.ok("Administrador cadastrado com sucesso! Username: " + user.getUsername());
    }
}

package br.com.dobackaofront.javahospitalar.service;

import br.com.dobackaofront.javahospitalar.entity.Role;
import br.com.dobackaofront.javahospitalar.entity.User;
import br.com.dobackaofront.javahospitalar.repository.RoleRepository;
import br.com.dobackaofront.javahospitalar.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Collections;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User cadastrarAdministrador(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new RuntimeException("Usuário já existe!");
        }

        // Busca a role ADMIN no banco ou cria uma nova caso não exista
        Role adminRole = roleRepository.findByName("ADMIN");
        if (adminRole == null) {
            adminRole = new Role();
            adminRole.setName("ADMIN");
            roleRepository.save(adminRole);
        }

        // Cria o usuário com a role de ADMIN
        User admin = new User();
        admin.setUsername(username);
        admin.setPassword(passwordEncoder.encode(password));
        admin.setRoles(Collections.singleton(adminRole));

        return userRepository.save(admin);
    }
}

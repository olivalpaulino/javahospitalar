package br.com.dobackaofront.javahospitalar.repository;

import br.com.dobackaofront.javahospitalar.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

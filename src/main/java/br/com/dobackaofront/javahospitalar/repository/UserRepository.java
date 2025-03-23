package br.com.dobackaofront.javahospitalar.repository;

import br.com.dobackaofront.javahospitalar.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

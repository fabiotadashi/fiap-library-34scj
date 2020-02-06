package br.com.fiap.library.repository;

import br.com.fiap.library.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findFirstByUsername(String username);

}

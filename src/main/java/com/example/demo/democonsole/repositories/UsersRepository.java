package com.example.demo.democonsole.repositories;

import com.example.demo.democonsole.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(@NotNull String email);
}

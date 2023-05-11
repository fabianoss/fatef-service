package br.com.fatef.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.fatef.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {

}

package br.com.fatef.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatef.dto.UserDTO;
import br.com.fatef.entity.User;
import br.com.fatef.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
	return repository.findAll().stream().map(UserDTO::mapper).collect(Collectors.toList());
    }

    public Optional<UserDTO> findByIdUser(Long idUser) {
	return repository.findById(idUser).map(UserDTO::mapper);
    }

    public UserDTO mapper(UserDTO dto) {
	User userSaved = repository.save(User.mapper(dto));
	return UserDTO.mapper(userSaved);
    }

}

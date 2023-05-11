package br.com.fatef.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fatef.domain.User;
import br.com.fatef.dto.UserDTO;
import br.com.fatef.repository.UserRepository;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
	return repository.findAll().stream().map(UserDTO::mapper).collect(Collectors.toList());
    }

    public UserDTO findByIdUser(Long idUser) {
	Optional<UserDTO> opt = repository.findById(idUser).map(UserDTO::mapper);
	if (opt.isPresent()) {
	    return opt.get();
	} else {
	    return null;
	}
    }

    public UserDTO update(Long idUser, UserDTO userDTO) {
	Optional<User> userOpt = repository.findById(idUser);
	if (userOpt.isEmpty()) {
	    return null;
	}
	return this.save(userDTO.mapper(userOpt.get()));
    }

    public UserDTO save(UserDTO userDTO) {
	User userSaved = repository.save(User.mapper(userDTO));
	return UserDTO.mapper(userSaved);
    }

    public void delete(Long idUser) {
	repository.deleteById(idUser);
    }

    public UserDTO mapper(UserDTO dto) {
	User userSaved = repository.save(User.mapper(dto));
	return UserDTO.mapper(userSaved);
    }

}

package br.com.fatef.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatef.dto.UserDTO;
import br.com.fatef.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<UserDTO>> findAll() {
	return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(value = "/{idUser}")
    public ResponseEntity<UserDTO> findById(@PathVariable(name = "idUser") Long idUser) {
	return ResponseEntity.ok(userService.findByIdUser(idUser));
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<UserDTO> save(@RequestBody UserDTO userDTO) {
	return ResponseEntity.ok(userService.save(userDTO));
    }

    @PutMapping(value = "/{idUser}")
    @ResponseBody
    public ResponseEntity<UserDTO> update(@PathVariable(name = "idUser") Long idUser, @RequestBody UserDTO userDTO) {
	return ResponseEntity.ok(userService.update(idUser, userDTO));
    }

    @DeleteMapping(value = "/{idUser}")
    @ResponseBody
    public ResponseEntity<Void> delete(@PathVariable(name = "idUser") Long idUser) {
	userService.delete(idUser);
	return ResponseEntity.ok().build();
    }

}

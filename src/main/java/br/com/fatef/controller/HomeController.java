package br.com.fatef.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/v1/home")
public class HomeController {
    
    @GetMapping
    public ResponseEntity<String> home() {
	return ResponseEntity.ok("Olá mundo exemplo serviço rest");
    }
}

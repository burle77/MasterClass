package br.com.masterclass.superpecas.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/carro")
public class CarroController {
    @GetMapping("/")
    public String buscaCarro() {
        return "teste";
    }
}

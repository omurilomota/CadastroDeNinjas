package dev.java10x.CadastroDeNinjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping({"/", "/home"})
    public String home() {
        return "Bem vindo ao Cadastro de Ninjas! Rotas : /ninjas, /missoes";
    }
}

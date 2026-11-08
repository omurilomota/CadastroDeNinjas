package dev.java10x.CadastroDeNinjas.Missoes.controller;

import dev.java10x.CadastroDeNinjas.Missoes.MissoesModel;
import dev.java10x.CadastroDeNinjas.Missoes.repository.MissoesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    private final MissoesRepository repository;
    public MissoesController(MissoesRepository repository) { this.repository = repository; }

    @GetMapping
    public List<MissoesModel> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public MissoesModel buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public MissoesModel criar(@RequestBody MissoesModel missao) {
        return repository.save(missao);
    }

    @PutMapping("/{id}")
    public MissoesModel atualizar(@PathVariable Long id, @RequestBody MissoesModel missao) {
        missao.setId(id);
        return repository.save(missao);

    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }


}

package dev.java10x.CadastroDeNinjas.Ninjas.controller;

import dev.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import dev.java10x.CadastroDeNinjas.Ninjas.repository.NinjaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaRepository repository;
    public NinjaController(NinjaRepository repository) { this.repository = repository; }

    @GetMapping
    public List<NinjaModel> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public NinjaModel buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public NinjaModel criar(@RequestBody NinjaModel ninja) { return repository.save(ninja); }

    @PutMapping("/{id}")
    public NinjaModel atualizar(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        ninja.setId(id);
        return repository.save(ninja);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

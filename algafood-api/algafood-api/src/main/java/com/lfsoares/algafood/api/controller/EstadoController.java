package com.lfsoares.algafood.api.controller;

import com.lfsoares.algafood.domain.exception.EntidadeEmUsoException;
import com.lfsoares.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.lfsoares.algafood.domain.model.Estado;
import com.lfsoares.algafood.domain.repository.EstadoRepository;
import com.lfsoares.algafood.domain.service.CadastroEstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CadastroEstadoService cadastroEstado;

    @GetMapping
    public List<Estado> listar() {
        return estadoRepository.findAll();
    }

    // Method listar por ID
    @GetMapping("/{estadoId}")
    public ResponseEntity<Estado> buscar(@PathVariable Long estadoId) {
        Optional<Estado> estado = estadoRepository.findById(estadoId);

        if (estado.isPresent()) {
            return ResponseEntity.ok(estado.get());
        }

        return ResponseEntity.notFound().build();
    }

    // Method Atualizar
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estado adicionar(@RequestBody Estado estado) {
        return cadastroEstado.salvar(estado);
    }

    // Method Atualizar
    @PutMapping("/{estadoId}")
    public ResponseEntity<Estado> atualizar(@PathVariable Long estadoId, @RequestBody Estado estado) {
       Estado estadoAtual = estadoRepository.findById(estadoId).orElse(null);

       if (estadoAtual != null) {
           BeanUtils.copyProperties(estado, estadoAtual, "id");

           estadoAtual = cadastroEstado.salvar(estadoAtual);
           return ResponseEntity.ok(estadoAtual);
       }
        return ResponseEntity.notFound().build();
    }

    //Method Deletar
    @DeleteMapping("/{estadoId}")
    public ResponseEntity<Estado> remover(@PathVariable Long estadoId) {
        try {
            cadastroEstado.excluir(estadoId);
            return ResponseEntity.noContent().build();

        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();

        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

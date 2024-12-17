package com.lfsoares.algafood.api.controller;

import com.lfsoares.algafood.domain.exception.EntidadeEmUsoException;
import com.lfsoares.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.lfsoares.algafood.domain.model.Cidade;
import com.lfsoares.algafood.domain.repository.CidadeRepository;
import com.lfsoares.algafood.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.listar();
    }

    @GetMapping("/{cidadeId}")
    public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
        Cidade cidade = cidadeRepository.buscar(cidadeId);

        if (cidade == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cidade);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody Cidade cidade) {
        return cadastroCidade.salvar(cidade);
    }

    @PutMapping("/{cidadeId}")
    public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
        Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);

        if (cidadeAtual != null) {
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");

            cidadeAtual = cadastroCidade.salvar(cidadeAtual);

            return ResponseEntity.ok(cidadeAtual);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cidadeId}")
    public ResponseEntity<Cidade> remover(@PathVariable Long cidadeId) {
        try {
            cadastroCidade.excluir(cidadeId);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}

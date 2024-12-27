package com.lfsoares.algafood.api.controller;

import com.lfsoares.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    //@GetMapping("/cozinhas/por-nome")
    //public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome) {
    //    return cozinhaRepository.consultarPorNome(nome);
    //}
}

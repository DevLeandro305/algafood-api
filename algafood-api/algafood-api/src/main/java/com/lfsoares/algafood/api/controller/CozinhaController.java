package com.lfsoares.algafood.api.controller;

import com.lfsoares.algafood.api.model.CozinhasXmlWrapper;
import com.lfsoares.algafood.domain.model.Cozinha;
import com.lfsoares.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cozinha> listar() {
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml() {
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
        Cozinha cozinha =  cozinhaRepository.buscar(id);

      //return ResponseEntity.status(HttpStatus.OK).body(cozinha);
      //return ResponseEntity.ok(cozinha);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.LOCATION, "http://localhost:8080/cozinhas");

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .headers(headers)
                .build();
    }
}

package com.lfsoares.algafood.domain.repository;

import com.lfsoares.algafood.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long cidadeId);
}

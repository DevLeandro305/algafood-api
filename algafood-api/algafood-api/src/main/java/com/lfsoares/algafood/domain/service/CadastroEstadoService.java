package com.lfsoares.algafood.domain.service;

import com.lfsoares.algafood.domain.exception.EntidadeEmUsoException;
import com.lfsoares.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.lfsoares.algafood.domain.model.Estado;
import com.lfsoares.algafood.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void excluir(Long estadoId) {
        try {
            estadoRepository.deleteById(estadoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Estado de código %d não pode ser removida, pois está em uso", estadoId));

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                String.format("Não existe um cadastro de estado com código %d", estadoId));
        }
    }

}

package com.lfsoares.algafood.di.service;

import com.lfsoares.algafood.di.modelo.Cliente;
import com.lfsoares.algafood.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    private NotificadorEmail notificadorEmail;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}

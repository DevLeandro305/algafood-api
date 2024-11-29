package com.lfsoares.algafood.di.service;

import com.lfsoares.algafood.di.modelo.Cliente;
import com.lfsoares.algafood.di.notificacao.NivelUrgencia;
import com.lfsoares.algafood.di.notificacao.Notificador;
import com.lfsoares.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {

    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo");
    }


}

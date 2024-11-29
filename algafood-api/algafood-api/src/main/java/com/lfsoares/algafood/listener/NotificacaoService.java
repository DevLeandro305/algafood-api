package com.lfsoares.algafood.listener;

import com.lfsoares.algafood.di.notificacao.NivelUrgencia;
import com.lfsoares.algafood.di.notificacao.Notificador;
import com.lfsoares.algafood.di.notificacao.TipoDoNotificador;
import com.lfsoares.algafood.di.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacaoService {

    @TipoDoNotificador(NivelUrgencia.URGENTE)
    @Autowired
    private Notificador notificador;

    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }
}

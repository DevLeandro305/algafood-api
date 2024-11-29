package com.lfsoares.algafood.di.notificacao;

import com.lfsoares.algafood.di.modelo.Cliente;
import org.springframework.stereotype.Component;

@Component
public class NotificadorSMS implements Notificador{

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s por SMS através do telefone %s: %s",
                cliente.getNome(), cliente.getTelefone(), mensagem);
    }

}

package com.lfsoares.algafood.di.notificacao;

import com.lfsoares.algafood.di.modelo.Cliente;

public interface Notificador {

    void notificar(Cliente cliente, String mensagem);
}

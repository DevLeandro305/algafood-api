package com.lfsoares.algafood.jpa;

import com.lfsoares.algafood.AlgafoodApiApplication;
import com.lfsoares.algafood.domain.model.Cozinha;
import com.lfsoares.algafood.domain.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class BuscaCozinhaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha =  cozinhaRepository.buscar(1L);

        System.out.println(cozinha.getNome());


    }
}

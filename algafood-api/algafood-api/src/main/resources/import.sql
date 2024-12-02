insert into tb_cozinha (nome) values ('Tailandesa');
insert into tb_cozinha (nome) values ('Indiana');

insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Thai Gourmet', 10, 1);
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Thai Delivery', 9.50, 1);
insert into tb_restaurante (nome, taxa_frete, cozinha_id) values ('Tuk Tuk Comida Indiana', 15, 2);

insert into tb_forma_pagamento (descricao) values ('Dinheiro');
insert into tb_forma_pagamento (descricao) values ('Pix');
insert into tb_forma_pagamento (descricao) values ('Débito');
insert into tb_forma_pagamento (descricao) values ('Crédito');

insert into tb_estado (nome) values ('Distrito Federal');
insert into tb_estado (nome) values ('Minas Gerais');
insert into tb_estado (nome) values ('Goiás');
insert into tb_estado (nome) values ('Tocantins');

insert into tb_cidade (nome, estado_id) values ('Brasília', 1);
insert into tb_cidade (nome, estado_id) values ('Belo Horizonte', 2);
insert into tb_cidade (nome, estado_id) values ('Goiânia', 3);
insert into tb_cidade (nome, estado_id) values ('Palmas', 4);

insert into tb_permissao (nome, descricao) values ('CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
insert into tb_permissao (nome, descricao) values ('EDITAR_COZINHAS', 'Permite editar cozinhas');


=== Loja Virtual Vivelis — Sistema em Java ===
Este projeto é um sistema de loja virtual desenvolvido em Java, que simula o processo de compra em um ambiente de terminal (console). O programa permite ao usuário visualizar produtos, adicionar ao carrinho, aplicar filtros por categoria, finalizar a compra com diferentes métodos de pagamento e acessar o suporte da loja.

O sistema é ideal para fins didáticos, aprendizado de lógica de programação, uso de estruturas de dados e boas práticas com entrada/saída em Java.

==Funcionalidades
==Cadastro de Clientes por CPF

= Visualização e Filtro de Produtos por Categoria

= Carrinho com controle de quantidades e subtotal

= Frete grátis em compras acima de R$199,90

= Pagamento via Débito, Crédito ou PIX (com 10% de desconto)

= Sistema de fidelidade: brinde a cada 10 compras

= Informações de Suporte ao Cliente

= Tecnologias Utilizadas
Java (puro)

Scanner (entrada de dados via console)

ArrayList e HashMap (estrutura de dados)

= Estrutura do Projeto
Main.java — Arquivo principal com toda a lógica de funcionamento da loja.

Produto.java — Classe que representa os produtos da loja.

Cliente.java — Classe que representa os clientes cadastrados.

ItemCarrinho.java — Classe que representa os itens no carrinho de compras.

= O sistema não possui persistência de dados (nenhum banco de dados ou arquivo externo).

= Como executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/loja-vivelis-java.git
Compile o programa:

bash
Copiar
Editar
javac Main.java Produto.java Cliente.java ItemCarrinho.java
Execute:

bash
Copiar
Editar
java Main

= Observações
Este projeto é voltado para fins educacionais e demonstração de lógica de programação. Caso deseje evoluir o sistema, algumas sugestões são:

Adicionar persistência com arquivos ou banco de dados.

Criar uma interface gráfica (GUI) ou uma API web.

Modularizar mais o código para facilitar testes e manutenção.


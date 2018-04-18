# Dextra Challenge

Repositório com o projeto do ambiente para o desafio Dextra.

Projeto desenvolvido com Spring Boot e Java 8 utilizando Maven para gerenciar as dependências no Back End, e no Front End utilizando HTML/CSS com jQuery para consumir os serviços criados.

### Métodos
GET - http://localhost:8080/lanches/cardapio
GET - http://localhost:8080/lanches/{id}
POST - http://localhost:8080/lanches/personalizado

Para executar o projeto, siga os seguintes passos:

- Realize o clone do repositório e dentro do Eclipse acesse Arquivo/Importar, selecione a opção Maven/Existing Maven Projects, na próxima tela aponte para o diretório para onde foi feito o clone do projeto do git, e no final clique em Finalizar. 

- Caso o projeto apresente erro de compilação, basta clicar com o botão direto sobre o projeto e teclar alt+F5, na tela que aparece, clique em OK. Isso fará com que o projeto Maven realize novamente o build do projeto, baixando as dependências que faltarem.

- Abra o package br.com.dextra.app; 

- Clique na classe LanchoneteApp.java 

- Execute o programa como se fosse um aplicativo Java, não é necessário instalar o Tomcat pois o Spring Boot já possui ele embutido. 

- Clique com o botão direito do mouse  e navegue para Run As > Java Application $ No console, Aguarde o servidor subir, enquanto isso acesse a pasta com os arquivos do front-end, que se localiza no caminho {caminho_projeto_baixado\src\main\webapp}, e clique duas vezes no arquivo index.html para abrir o arquivo no navegador.

Para testar o projeto, pelos testes unitários ou pelo front end, siga os passos a seguir:

Testes unitários - JUnit
- No eclipse, dentro de src/test/java, acesso o arquivo ProductTests.java, que fica no pacote br.com.dextra.tests
- É possivel executar todos os testes de uma vez, clicando com o botão direto sobre o arquivo ProductTests.java, navegar até a opção Run As, e selecionar a opção JUnit Test. Nesse momento será aberta a aba com o resultado da execução dos testes.
- Também é possivel executar um teste específico que existe dentro da classe, para isso basta seleciona o nome do teste (sem os parênteses), clicar com o botão direto, navegar até a opção Run As, e selecionar a opção JUnit Test. Também será exibida a aba com o resultado da execução do teste.

Teste utilizando a interface do Front End
- Com o arquivo index.html aberto no navegador, é possível selecionar um lanche do cardápio utilizando o combo box, e com isso ao selecionar o lanche, o preço será exibido abaixo automáticamente no campo Valor Total. Isso porque, ao selecionar um lanche, o front end realiza a chamada do serviço correspondente no back, passando o código do lanche no cardápio como parâmetro.
- Também é possível customizar um lanche, sleecionando através dos checkboxes os ingredientes desejados. Ao selecionar um ingrediente, um combo box é  exibido ao lado, para que seja possível selecionar a quantidade desejada. Para calcular o valor total do anche personalizado, após selecionar os ingredientes, basta clicar no botão logo abaixo, "Calcular o Valor".

## Descrição

Somos uma startup do ramo de alimentos e precisamos de uma aplicação web para gerir nosso negócio. Nossa especialidade é a venda de lanches, de modo que alguns lanches são opções de cardápio e outros podem conter ingredientes personalizados.

A seguir, apresentamos a lista de ingredientes disponíveis:


INGREDIENTE           |   VALOR
:---------            | --------:
Alface                | R$ 0.40
Bacon                 | R$ 2,00
Hambúrguer de carne   | R$ 3,00
Ovo                   | R$ 0,80
Queijo                | R$ 1,50

Segue as opções de cardápio e seus respectivos ingredientes:


LANCHE        |   INGREDIENTES
:---------    | :--------------------------------------:
X-Bacon       | Bacon, hambúrguer de carne e queijo
X-Burger      | Hambúrguer de carne e queijo
X-Egg         | Ovo, hambúrguer de carne e queijo
X-Egg Bacon   | Ovo, bacon, hambúrguer de carne e queijo

O valor de cada opção do cardápio é dado pela soma dos ingredientes que compõe o lanche. Além destas opções, o cliente pode personalizar seu lanche e escolher os ingredientes que desejar. Nesse caso, o preço do lanche também será calculado pela soma dos ingredientes.

Existe uma <b>exceção</b> à regra para o cálculo de preço, quando o lanche pertencer à uma promoção. A seguir, apresentamos a lista de promoções e suas respectivas regras de negócio:

PROMOÇÃO        |  REGRA DE NEGÓCIO
:---------      | :--------------------------------------:
Light           | Se o lanche tem alface e não tem bacon, ganha 10% de desconto.
Muita carne     | A cada 3 porções de carne o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
Muito queijo    | A cada 3 porções de queijo o cliente só paga 2. Se o lanche tiver 6 porções, ocliente pagará 4. Assim por diante...
Inflação        | Os valores dos ingredientes são alterados com frequência e não gostaríamos que isso influenciasse nos testes automatizados.

## CRITÉRIOS DE COMPLETUDE

### O projeto deve ser entregue atendendo aos seguintes critérios:

- O server-side deve ser desenvolvido em Java, utilizando Maven para gerenciar as dependências.
- O client-side deve ser desenvolvido em HTML, CSS e JavaScript (apenas com jQuery, ou com algum framework se desejar)
- Deve possuir cobertura de testes automatizados para os seguintes pontos: Valor dos lanches de cardápio, regra para cálculo de preço e promoções.
- Não é necessário se preocupar com a autenticação dos usuários.
- Não é necessário persistir os dados em um banco, pode fazer armazenamento em memória.


## ENTREGÁVEIS

Você deve entregar um conjunto de artefatos, de acordo com o nível de complexidade que achar melhor. A seguir, os níveis de complexidade e seus respectivos entregáveis:

<b>Fácil:</b>
- [ ] Implementação dos requisitos;
- [ ] Instruções para executar.

<b>Médio:</b>
- [X] Implementação dos requisitos;
- [X] Relatório simples de justificativas para escolha do design de código;
- [X] Instruções para executar;

<b>Difícil:</b>
- [ ] Implementação dos requisitos;
- [ ] Relatório simples de justificativas para escolha do design de código;
- [ ] Os testes automatizados devem ser executados por algum modelo de integração contínua;
- [ ] O ambiente de execução da aplicação deve possuir um HTTP Proxying com nginx, redirecimendo as requisições da porta 80 para o server-side.
- [ ] Ambiente virtualizado em Docker com scripts para execução do projeto.

# Projeto Spring Boot API REST

## 1) Objetivos do projeto:

* Criar um serviço capaz de gerar uma venda. A venda deve conter: `id`, `data da venda`, `valor`, `id do vendedor` e ` nome do vendedor`.
* O banco de dados usado é o H2 (funciona em memória).

### O serviço também deve conter a seguinte requisição REST:
- Gerar uma nova venda;
- Retornar a lista de vendedores com os campos: `nome`, `total de vendas do vendedor` e `média de vendas diária`, conforme o período informado por um `parâmetro`.

## 2) Resultado:

## 3) Estrutura do projeto

![image](https://user-images.githubusercontent.com/78989152/187933214-626bc12b-7a77-4b32-a4d7-1e319138b3c6.png)


## 4) Principais dificuldades

Meu principais entraves nesse projeto foram:

- Descobrir como fazer o Spring conversar com o banco de dados através de queries. Consegui graças a biblioteca `JPA Query`.
- Descobrir como criar um método de receber os dados das queries e exibi-los. Consegui graças as `JPA Projections`.

## 5) O que aprendi? Conclusões

Cheguei a ver conteúdo de API com o Spring na faculdade, mas foi muito corrido e teórico e aqui pude ver mais na prática como é construir desde o início. Outro grande aprendizado foi relativo ao banco de dados, pois tive que estudar sobre queries, tipos de dados e como fazer as tabelas conversarem com as classes/entidades criadas no projeto Spring Boot.

De todos projetos que já fiz esse foi o mais desafiador, pois eu tinha um conhecimento muito baixo sobre o Spring. Aqui pude dar um objetivo bem claro um projeto back-end que geralmente é mais difícil de ser visualizado o resultado na prática.

😀

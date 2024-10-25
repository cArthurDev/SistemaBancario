# Sistema de Banco em Java

Este é um projeto de sistema bancário em Java que permite a criação de contas, operações de depósito e saque, visualização de extratos e informações do cliente. O projeto utiliza Java básico para gerenciamento de contas de clientes com um menu interativo para facilitar a navegação.

## Funcionalidades

- **Cadastrar Cliente**: Permite registrar um novo cliente com informações como nome, CPF, email, telefone, número de conta, senha e saldo inicial.
- **Acessar Conta**: Autentica o usuário pelo número da conta e senha, permitindo o acesso às funcionalidades da conta.
- **Sacar**: Realiza a retirada de um valor da conta, se houver saldo suficiente.
- **Depositar**: Permite adicionar um valor à conta.
- **Ver Extrato**: Exibe um extrato com as transações realizadas, incluindo data e hora de cada saque e depósito.
- **Informações do Cliente**: Mostra dados básicos do cliente, incluindo nome, CPF, telefone e saldo atual.

## Estrutura do Projeto

O projeto é composto por duas classes principais:

- `Cliente`: Responsável pelos atributos e métodos relacionados ao cliente, como saque, depósito e visualização do extrato.
- `Main`: Classe principal que contém o menu do sistema e a lógica para cadastrar usuários, autenticar e acessar contas.

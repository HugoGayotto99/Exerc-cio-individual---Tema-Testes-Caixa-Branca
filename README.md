# Sistema de Login com Java e MySQL

## Descrição do Projeto

Este projeto é uma implementação simples de um sistema de login usando Java e MySQL. Ele fornece a funcionalidade de conectar-se a um banco de dados e verificar se o nome de usuário e a senha fornecidos correspondem a registros existentes no banco.

## Funcionalidades

- **Conexão com o Banco de Dados**: O projeto utiliza a API JDBC para conectar-se a um banco de dados MySQL.
- **Verificação de Login**: Um método permite verificar se as credenciais do usuário (login e senha) são válidas.
- **Recuperação do Nome do Usuário**: Quando as credenciais são válidas, o sistema retorna o nome do usuário correspondente.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Banco de Dados**: MySQL
- **Bibliotecas**: JDBC (Java Database Connectivity)

## Como Usar

1. Certifique-se de ter o MySQL instalado e configurado.
2. Crie um banco de dados com a seguinte estrutura:

   ```sql
   CREATE DATABASE test;

   USE test;

   CREATE TABLE usuarios (
       id INT AUTO_INCREMENT PRIMARY KEY,
       nome VARCHAR(100),
       login VARCHAR(50),
       senha VARCHAR(50)
   );

   INSERT INTO usuarios (nome, login, senha) VALUES ('Admin', 'admin', '1234');

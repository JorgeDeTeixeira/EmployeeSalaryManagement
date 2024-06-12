# Gestão de Salários de Funcionários

Uma aplicação Java simples para gerenciar os salários dos funcionários. A aplicação permite registrar funcionários, garantindo IDs únicos, e aumentar os salários com base em uma porcentagem fornecida.

## Estrutura do Projeto

- **application/Main.java**: A classe principal que lida com a entrada do usuário e operações.
- **entities/Employee.java**: A classe Employee que representa a entidade funcionário com ID, nome e salário.

## Funcionalidades

- Registro de funcionários com ID, nome e salário.
- Garantia de IDs únicos para cada funcionário.
- Aumento de salário baseado em uma porcentagem fornecida.
- Listagem atualizada dos funcionários.

## Como Executar

1. Compile os arquivos Java:
   ```sh
   javac src/application/Main.java src/entities/Employee.java

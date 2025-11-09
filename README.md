# Sistema Escolar

Um sistema desktop de gerenciamento escolar desenvolvido em Java
(Swing + NetBeans) com integração ao MySQL.
O sistema permite cadastrar, editar, listar e inativar alunos, cursos e
matrículas, oferecendo uma interface simples e intuitiva.

## Sumário

- [Descrição Geral](#-descrição-geral)
- [Funcionalidades](#-funcionalidades)
- [Conceitos Utilizados](#-conceitos-utilizados)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Banco de Dados](#-banco-de-dados)
- [Como Executar o Projeto](#-como-executar-o-projeto)
- [Autor](#-autor) 

## Funcionalidades

#### Alunos

-   Cadastro de aluno
-   Edição de informações
-   Exclusão lógica (marcar como inativo)
-   Listagem em tabela
-   Validações de dados (nome, e-mail, data, etc.)

#### Cursos

-   Cadastro de novos cursos
-   Alteração de dados
-   Exclusão lógica
-   Visualização em tabela

#### Matrículas

-   Matrícula de alunos em cursos
-   Edição e cancelamento
-   Consulta geral de matrículas

#### Utilidades

-   Conversão e manipulação de datas
-   Conexão com banco MySQL
-   Estrutura DAO completa (Aluno, Curso, Matrícula) 
 
 ## Conceitos Utilizados 
- Programação Orientada a Objetos (POO)
- Arquitetura e Organização do Projeto (MVC & DAO)
- Integração com Banco de Dados (JDBC)
  
 ## Estrutura do Projeto

    SistemaEscolar/
    │
    ├── src/
    │   ├── DAO/              # Classes de acesso ao banco (DAOAluno, DAOCurso, etc.)
    │   ├── model/            # Modelos: Aluno, Curso, Matricula
    │   ├── view/             # Telas Swing (NetBeans GUI Builder)
    │   ├── util/             # Funções auxiliares, DataUtils
    │   └── sistemaescolar/   # Classe Main
    │
    ├── dist/
    │   ├── SistemaEscolar.jar   # Arquivo executável
    │   └── lib/                 # Bibliotecas necessárias
    │
    └── nbproject/            # Configurações do NetBeans

## Tecnologias Utilizadas

-   Java 21
-   Swing (NetBeans GUI Builder)
-   MySQL 8+
-   JDBC
-   NetBeans 23

## Banco de Dados

O projeto utiliza MySQL via mysql-connector-j-9.1.0.jar.

Exemplo de criação do Banco:

    CREATE DATABASE sistema_escolar;

    USE sistema_escolar;

    CREATE TABLE aluno (
        id_aluno INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100),
        email VARCHAR(100),
        data_nascimento DATE,
        ativo BOOLEAN DEFAULT TRUE
    );

    CREATE TABLE curso (
        id_curso INT PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100),
        carga_horaria INT,
        ativo BOOLEAN DEFAULT TRUE
    );

    CREATE TABLE matricula (
        id_matricula INT PRIMARY KEY AUTO_INCREMENT,
        id_aluno INT,
        id_curso INT,
        data_matricula DATE,
        ativo BOOLEAN DEFAULT TRUE,
        FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
        FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
    );

## Como Executar o Projeto

#### 1. Faça o clone do repositório 
```
 git clone https://github.com/paulo-czr/SistemaEscolar.git
```
Depois: 
```
 cd SistemaEscolar
```
#### 2. Abra no NetBeans 

Abra o NetBeans → File → Open Project → selecione a pasta clonada. 

#### 3. Configure o Banco de Dados

Edite o arquivo:
```
 src/DAO/Conexao.java
```
e coloque seu usuário, senha e nome do banco MySQL. 

#### 4. Execute o projeto 

Clique no botão Run do NetBeans. 

## Bibliotecas Inclusas

-   mysql-connector-j-9.1.0.jar
-   jcalendar-1.4.jar
--- 
 
## Autor

Desenvolvido por **Paulo Cesar**  
📧 [PauloCesarCoder@gmail.com](mailto:PauloCesarCoder@gmail.com)  
🌐 [GitHub](https://github.com/paulo-czr)  
💼 [Meu LinkedIn](https://www.linkedin.com/in/paulo-czr)

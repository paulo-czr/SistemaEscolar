# Sistema Escolar

Um sistema desktop de gerenciamento escolar desenvolvido em Java
(Swing + NetBeans) com integração ao MySQL.
O sistema permite cadastrar, editar, listar e inativar alunos, cursos e
matrículas, oferecendo uma interface simples e intuitiva.  
 [Vídeo do Projeto](https://www.linkedin.com/posts/paulo-czr_java-netbeans-mysql-activity-7393314364277268481-s8UG?utm_source=share&utm_medium=member_desktop&rcm=ACoAAE0sl04BDVl7biGrslHdTRAzdOpkGUGJtWo) 

 --- 
 
## Sumário

- [Descrição Geral](#sistema-escolar)
- [Funcionalidades](#funcionalidades)
- [Conceitos Utilizados](#conceitos-utilizados)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Banco de Dados](#banco-de-dados)
- [Como Executar o Projeto](#como-executar-o-projeto)
- [Autor](#autor) 

 --- 
 
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
 
 --- 
 
 ## Conceitos Utilizados 
- Programação Orientada a Objetos (POO)
- Arquitetura e Organização do Projeto (MVC & DAO)
- Integração com Banco de Dados (JDBC)
  
 --- 
 
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

 --- 
 
## Tecnologias Utilizadas

-   Java 21
-   Swing (NetBeans GUI Builder)
-   MySQL 8+
-   JDBC
-   NetBeans 23

 --- 
 
## Banco de Dados

O projeto utiliza MySQL via mysql-connector-j-9.1.0.jar.

Exemplo de criação do Banco:
```sql
    CREATE DATABASE Sistema_Escolar;

    USE Sistema_Escolar;

    CREATE TABLE Aluno (
        id_aluno INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
        nome VARCHAR(100) NOT NULL,
        email VARCHAR(100) NOT NULL,
        telefone VARCHAR(20),
        data_nasc DATE NOT NULL,
        ativo BOOLEAN DEFAULT TRUE
    );

    CREATE TABLE Curso (
        id_curso INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
        nome_curso VARCHAR(100) NOT NULL,
        carga_horaria INT NOT NULL,
        ativo BOOLEAN DEFAULT TRUE
    );

    CREATE TABLE Matricula (
        id_matricula INT UNIQUE PRIMARY KEY AUTO_INCREMENT,
        id_aluno INT NOT NULL,
        id_curso INT NOT NULL,
        data_matricula DATE NOT NULL,
        ativo BOOLEAN DEFAULT TRUE,
        CONSTRAINT UC_Matricula UNIQUE (id_aluno, id_curso),
        FOREIGN KEY (id_aluno) REFERENCES aluno(id_aluno),
        FOREIGN KEY (id_curso) REFERENCES curso(id_curso)
    );
```
 
 --- 
 
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

 --- 
 
## Bibliotecas Inclusas

-   mysql-connector-j-9.1.0.jar
 
 --- 
 
## Autor

Desenvolvido por **Paulo Cesar**  
📧 [PauloCesarCoder@gmail.com](mailto:PauloCesarCoder@gmail.com)  
🌐 [GitHub](https://github.com/paulo-czr)  
💼 [Meu LinkedIn](https://www.linkedin.com/in/paulo-czr)

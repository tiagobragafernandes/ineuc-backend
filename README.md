
# Ineuc API

Este repositório contém a documentação da API para a aplicação Ineuc. A API fornece endpoints para gerenciamento de usuários, tipos de atividades e atividades.

# Instalação
Para configurar a API Ineuc em sua máquina local, siga estes passos:

1. Clone este repositório:

```git clone https://github.com/your-username/ineuc-api.git```

2. Navegue até o diretório do projeto:

```cd ineuc-api```

3. Configure as variáveis de ambiente:
Crie um arquivo .env no diretório raiz do projeto e forneça os valores de configuração necessários. Exemplo:

```
PORT=8080
DATABASE_URL=mongodb://localhost:27017/ineuc
JWT_SECRET=sua-chave-secreta
```

## Ao iniciar o sevidor, a API estará acessível em http://localhost:8080.

# Endpoints da API
Os seguintes endpoints estão disponíveis na API Ineuc:

# Usuário
Criar Usuário

Método: POST
Endpoint: /user/create
Descrição: Cria um novo usuário com as informações fornecidas.
Corpo da Requisição:

```
{
    "email": "tiago@gmail.com",
    "password": "123",
    "isActive": 1,
    "createUserPersonalData": {
        "firstName": "Tiago",
        "lastName": "Fernandes",
        "dob": "1998-07-27"
    }
}
```
# Autenticação

Método: GET
Endpoint: /auth
Descrição: Recupera informações de autenticação para o usuário.
Detalhes do Usuário

Método: GET
Endpoint: /user/{id}
Descrição: Recupera informações detalhadas sobre um usuário específico.
Parâmetros de Caminho:
id - O ID do usuário a ser recuperado.
Tipo de Atividade
Criar Tipo de Atividade

Método: POST
Endpoint: /activityType
Descrição: Cria um novo tipo de atividade com o nome fornecido.
Corpo da Requisição:

```
{
    "name": "Estudos"
}

```
# Atividade
Criar Atividade

Método: POST
Endpoint: /activityType
Descrição: Cria uma nova atividade com o nome fornecido.
Corpo da Requisição:

```
{
    "name": "Estudos"
}
```
# Listar Atividades

Método: GET
Endpoint: /activity/{id}
Descrição: Recupera uma lista de atividades para um usuário específico.
Parâmetros de Caminho:
id - O ID do usuário para recuperar as atividades.
Observe que, para endpoints autenticados, o cabeçalho token deve ser incluído na requisição. O token deverá obter autenticação.




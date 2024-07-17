# Descrição do Arquivo

### AppModule, ReminderApp, MainActivity e demais files do app

- **Arquivo AppModule.kt**:
  _Koin como DI (Dependency Injection)_:
  Escolha do Koin para gerenciar as dependências do projeto.

  Configura o banco de dados Room, fornece o **Dao**, o **Repository** e o **ViewModel**.

- **Arquivo ReminderApp:**
  Inicializa o Koin para injeção de dependência.

- **Arquivo MainActivity:**
  Atividade principal do aplicativo, que contém a tela do aplicativo.

- **Demais packages do app:** database package, model package, repositories package, view package e
  viewmodel package.

  - **database package:**
    Define a estrutura do banco de dados e os métodos de acesso aos dados.

  - **model package:**
    Define a estrutura dos dados do aplicativo.

  - **repositories package:**
    Fornece uma camada entre o **DAO** e o **ViewModel**, facilitando a separação de responsabilidades.

  - **view package:**
    Contém as classes de interface do usuário, como a atividade principal e os adaptadores de exibição.

  - **viewmodel package:**
    Gerencia o ciclo de vida dos dados relacionados à interface do usuário de maneira mais robusta.
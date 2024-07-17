# Descrição do Arquivo
## AppModule, ReminderApp, MainActivity

#### Decisões Tomadas:

- Arquivo AppModule.kt:
  Koin como DI (Dependency Injection): Escolha do Koin para gerenciar as dependências do projeto.
  Configura o banco de dados Room, fornece o Dao, o Repository e o ViewModel.

- Arquivo ReminderApp:
  Inicializa o Koin para injeção de dependência.

- Arquivo MainActivity:
    Atividade principal do aplicativo, que contém a tela do aplicativo.
# Descrição do Arquivo

### ReminderDao, ReminderDb

Define métodos de acesso aos dados do banco de dados. Neste
caso, os métodos de inserção, atualização e exclusão de lembretes.

- **Arquivo ReminderDao:**
  _Interface DAO (Data Access Object):_ Define métodos de acesso aos dados do banco de dados.
  Neste caso, os métodos de inserção, atualização e exclusão de lembretes.
- **Arquivo ReminderDb:**
  Classe abstrata que estende RoomDatabase e anota a classe com `@Database`, indicando que é um banco
  de dados `Room`. Define os métodos abstratos que retornam instâncias de DAOs.
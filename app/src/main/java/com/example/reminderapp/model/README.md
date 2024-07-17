# Descrição do Arquivo

### ReminderModel (Reminder.kt)

- Entidade do Banco de Dados: Define a estrutura dos dados de um lembrete.
- Anotação `@Entity`: Define a tabela reminders no banco de dados.
- Chave Primária: Campo id gerado automaticamente.
- **Class Converters**:
  Converte Date para Long e vice-versa, pois o Room não lida diretamente com tipos complexos.
PADRÃO FACTORY METHOD E SOLID - TSI 5 Periodo IFGOIANO
🎯 OBJETIVO DA AULA
Implementar um sistema flexível de notificações utilizando o Padrão Factory Method, demonstrando na prática os princípios do SOLID, especialmente o Open/Closed Principle (OCP).

📌 1. PROBLEMA APRESENTADO
Empresa precisa enviar notificações por múltiplos canais:

E-mail

SMS

Push Notification

Necessidade de flexibilidade para adicionar novos canais

Evitar modificações no código existente ao adicionar novos canais

📌 2. SOLUÇÃO PROPOSTA
Implementação do Padrão Factory Method com estrutura:

2.1 Produto Abstrato (Notification)
Interface que define o contrato para todas as notificações

Métodos: send(message) e getType()

2.2 Produtos Concretos
EmailNotification

SMSNotification

PushNotification

WhatsAppNotification (adicionado posteriormente)

2.3 Criador Abstrato (NotificationFactory)
Classe abstrata com o Factory Method: createNotification()

Método concreto: sendNotification() que utiliza o factory method

2.4 Criadores Concretos
EmailFactory

SMSFactory

PushFactory

WhatsAppFactory (adicionado sem modificar existentes)

2.5 Cliente (Main)
Gerencia interface com usuário

Seleciona a fábrica adequada baseado na escolha

Envia notificações

📌 3. PRINCÍPIOS SOLID DEMONSTRADOS
Princípio	Como foi aplicado
Single Responsibility	Cada classe tem uma única responsabilidade:
- Notificações: apenas enviam mensagens
- Fábricas: apenas criam objetos
- Main: apenas gerencia interface
Open/Closed	✅ Sistema aberto para extensão
✅ Fechado para modificação
➜ WhatsApp adicionado sem alterar classes existentes
Liskov Substitution	Todas as fábricas concretas podem substituir a fábrica abstrata
Todas as notificações podem substituir a interface Notification
Interface Segregation	Interface Notification é específica e coesa
Apenas métodos necessários: send() e getType()
Dependency Inversion	Main depende da abstração NotificationFactory
Não depende das fábricas concretas
📌 4. DEMONSTRAÇÃO DO OPEN/CLOSED PRINCIPLE
O que NÃO foi modificado (Fechado):
✅ Notification.java

✅ EmailNotification.java

✅ SMSNotification.java

✅ PushNotification.java

✅ NotificationFactory.java

✅ EmailFactory.java

✅ SMSFactory.java

✅ PushFactory.java

O que foi ADICIONADO (Aberto):
➕ WhatsAppNotification.java

➕ WhatsAppFactory.java

Única modificação necessária:
⚠️ Main.java - apenas para incluir a opção 4 no menu (interface com usuário)

📌 5. BENEFÍCIOS DO PADRÃO FACTORY METHOD
Benefício	Explicação
Desacoplamento	Cliente não conhece as classes concretas de notificação
Extensibilidade	Novos canais adicionados sem impacto no código existente
Manutenibilidade	Código organizado por responsabilidades
Testabilidade	Fácil criar mocks e testes unitários
Reusabilidade	Fábricas podem ser reutilizadas em diferentes contextos
📌 6. ESTRUTURA FINAL DO PROJETO
text
notificacoes/
├── Notification.java          (interface - NÃO MODIFICADA)
├── EmailNotification.java     (NÃO MODIFICADO)
├── SMSNotification.java       (NÃO MODIFICADO)
├── PushNotification.java      (NÃO MODIFICADO)
├── WhatsAppNotification.java  (NOVO - ADICIONADO)
├── NotificationFactory.java   (abstrata - NÃO MODIFICADA)
├── EmailFactory.java          (NÃO MODIFICADO)
├── SMSFactory.java            (NÃO MODIFICADO)
├── PushFactory.java           (NÃO MODIFICADO)
├── WhatsAppFactory.java       (NOVO - ADICIONADO)
└── Main.java                  (MODIFICADO - apenas menu)
📌 7. APRENDIZADOS PRÁTICOS
Factory Method → Delega a criação de objetos para subclasses

OCP → Como estender sistemas sem modificar código existente

Baixo Acoplamento → Depender de abstrações, não de implementações

Coesão → Cada classe tem uma responsabilidade única

Arquitetura Flexível → Sistemas preparados para mudanças futuras

📌 8. UML - VISÃO GERAL DA ARQUITETURA
text
┌─────────────────────────────────────────────────────────┐
│                    <<interface>>                        │
│                    Notification                         │
│              + send() + getType()                       │
└─────────────────────────┬───────────────────────────────┘
                          △
        ┌─────────────────┼─────────────────┬─────────────┐
        │                 │                 │             │
┌───────┴───────┐ ┌───────┴───────┐ ┌───────┴───────┐ ┌───┴──────────┐
│ EmailNotif    │ │ SMSNotif      │ │ PushNotif     │ │ WhatsAppNotif│
└───────────────┘ └───────────────┘ └───────────────┘ └──────────────┘
        △                 △                 △                 △
        │                 │                 │                 │
        └─────────────────┼─────────────────┼─────────────────┘
                          │
              ┌───────────┴───────────┐
              │   <<abstract>>        │
              │ NotificationFactory   │
              │ + createNotification()│
              │ + sendNotification()  │
              └───────────┬───────────┘
        ┌─────────────────┼─────────────────┬─────────────┐
        │                 │                 │             │
┌───────┴───────┐ ┌───────┴───────┐ ┌───────┴───────┐ ┌───┴──────────┐
│ EmailFactory  │ │ SMSFactory    │ │ PushFactory   │ │ WhatsAppFact-│
│               │ │               │ │               │ │ ory          │
└───────────────┘ └───────────────┘ └───────────────┘ └──────────────┘
📌 9. CONCLUSÕES FINAIS
✅ Factory Method é ideal para sistemas que precisam ser extensíveis

✅ OCP permite adicionar novas funcionalidades sem risco de quebrar código existente

✅ O padrão promove baixo acoplamento e alta coesão

✅ Código se torna mais limpo, testável e manutenível

✅ A adição do WhatsApp demonstrou na prática como o sistema pode evoluir sem modificações nas classes já existentes

Obs:
No GlitHub ja está presente tanto a primeira quanto a segunda versão desse código

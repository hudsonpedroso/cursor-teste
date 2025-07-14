# Lobisomem vs Vampiro - Jogo de Click

Um jogo de click moderno inspirado nos antigos jogos de browser, com temática de batalha épica entre lobisomens e vampiros.

## 🎮 Sobre o Jogo

Este é um jogo incremental (idle/clicker) onde os jogadores escolhem entre duas facções rivais:
- **Lobisomens** 🐺 - Criaturas da floresta com força brutal
- **Vampiros** 🧛 - Seres da noite com poderes místicos

## 🏗️ Arquitetura

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.2.0
- **Banco de Dados**: H2 (em memória para desenvolvimento)
- **Autenticação**: JWT (JSON Web Tokens)
- **API**: RESTful com Spring Security

### Frontend (Angular)
- **Framework**: Angular 18.2
- **Estilização**: SCSS com design moderno e gótico
- **HTTP Client**: Angular HttpClient
- **Roteamento**: Angular Router

## 🚀 Como Executar

### Pré-requisitos
- Java 17 ou superior
- Node.js 18 ou superior
- Maven 3.8 ou superior

### Backend (Spring Boot)
```bash
cd backend
mvn spring-boot:run
```
O backend estará disponível em: `http://localhost:8080`

### Frontend (Angular)
```bash
cd frontend/werewolf-vampire-frontend
npm install
npm start
```
O frontend estará disponível em: `http://localhost:4200`

## 📋 Funcionalidades Implementadas

### ✅ Página de Login
- Interface moderna com tema gótico
- Validação de formulários
- Integração com API de autenticação
- Design responsivo

### 🔄 Em Desenvolvimento
- Página de registro com seleção de facção
- Dashboard principal do jogo
- Sistema de clicks e progressão
- Batalhas entre facções
- Sistema de rankings
- Loja de upgrades

## 🎨 Design

O jogo possui um design dark/gótico com:
- Paleta de cores escuras (preto, roxo, dourado)
- Animações suaves
- Efeitos visuais temáticos (lua, névoa)
- Interface moderna e intuitiva

## 🔧 Tecnologias Utilizadas

### Backend
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT
- H2 Database
- Maven

### Frontend
- Angular 18
- TypeScript
- SCSS
- RxJS
- Angular Reactive Forms

## 📁 Estrutura do Projeto

```
/
├── backend/                    # Spring Boot API
│   ├── src/main/java/com/werewolfvampire/game/
│   │   ├── controller/        # Controllers REST
│   │   ├── entity/           # Entidades JPA
│   │   ├── repository/       # Repositórios
│   │   ├── service/          # Lógica de negócio
│   │   ├── security/         # Configurações JWT
│   │   └── dto/              # Data Transfer Objects
│   └── pom.xml
└── frontend/werewolf-vampire-frontend/  # Angular App
    ├── src/app/
    │   ├── components/       # Componentes UI
    │   ├── services/         # Serviços Angular
    │   ├── interceptors/     # Interceptors HTTP
    │   └── guards/           # Route Guards
    └── package.json
```

## 🔐 Autenticação

O sistema utiliza JWT para autenticação:
1. Login com username/password
2. Recebe token JWT
3. Token incluído automaticamente em requisições autenticadas
4. Renovação automática de token

## 🎯 Próximos Passos

1. **Página de Registro** - Seleção de facção e criação de conta
2. **Dashboard Principal** - Interface principal do jogo
3. **Sistema de Clicks** - Mecânica básica de progressão
4. **Batalhas** - Sistema de combate entre facções
5. **Rankings** - Leaderboards globais e por facção
6. **Loja** - Sistema de upgrades e melhorias

## 🤝 Contribuindo

Este projeto está em desenvolvimento ativo. Contribuições são bem-vindas!

## 📄 Licença

Este projeto é open source e está disponível sob a licença MIT.
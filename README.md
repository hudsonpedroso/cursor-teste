# Lobisomem vs Vampiro - Jogo de Click

Um jogo de click moderno inspirado nos antigos jogos de browser, com temática de batalha épica entre lobisomens e vampiros.

## 🎮 Sobre o Jogo

Este é um jogo incremental (idle/clicker) onde os jogadores escolhem entre duas facções rivais:
- **Lobisomens** 🐺 - Criaturas da floresta com força brutal
- **Vampiros** 🧛 - Seres da noite com poderes místicos

## 🏗️ Arquitetura

### Backend (Spring Boot)
- **Framework**: Spring Boot 3.2.0
- **Banco de Dados**: PostgreSQL 14+
- **Autenticação**: JWT (JSON Web Tokens)
- **API**: RESTful com Spring Security

### Frontend (Angular)
- **Framework**: Angular 18.2
- **Estilização**: SCSS com design moderno e gótico
- **HTTP Client**: Angular HttpClient
- **Roteamento**: Angular Router

## 🚀 Como Executar no Windows

### 📋 Pré-requisitos

#### 1. Java Development Kit (JDK) 17+
**Opção 1: Oracle JDK**
1. Baixe o [Oracle JDK 17+](https://www.oracle.com/java/technologies/downloads/)
2. Execute o instalador e siga as instruções
3. Verifique a instalação:
```cmd
java -version
javac -version
```

**Opção 2: OpenJDK (Recomendado)**
1. Baixe o [Adoptium OpenJDK 17+](https://adoptium.net/)
2. Execute o instalador e marque a opção "Set JAVA_HOME variable"
3. Verifique a instalação no Command Prompt ou PowerShell:
```powershell
java -version
```

#### 2. Apache Maven 3.8+
**Opção 1: Download Manual**
1. Baixe o [Apache Maven](https://maven.apache.org/download.cgi)
2. Extraia para `C:\apache-maven`
3. Adicione `C:\apache-maven\bin` ao PATH do sistema:
   - Windows + R → `sysdm.cpl` → Avançado → Variáveis de Ambiente
   - Em "Variáveis do sistema", edite PATH e adicione o caminho
4. Verifique a instalação:
```cmd
mvn -version
```

**Opção 2: Chocolatey (Se instalado)**
```powershell
choco install maven
```

**Opção 3: Scoop (Se instalado)**
```powershell
scoop install maven
```

#### 3. Node.js 18+
1. Baixe o [Node.js](https://nodejs.org/) (versão LTS recomendada)
2. Execute o instalador (automaticamente adiciona ao PATH)
3. Verifique a instalação:
```cmd
node --version
npm --version
```

#### 4. PostgreSQL 14+
**Opção 1: Instalador Oficial (Recomendado)**
1. Baixe o [PostgreSQL para Windows](https://www.postgresql.org/download/windows/)
2. Execute o instalador como administrador
3. Durante a instalação:
   - Senha do superusuário: `postgres` (anote esta senha)
   - Porta: `5432` (padrão)
   - Locale: `Portuguese, Brazil` ou `C`
4. Após instalação, abra o pgAdmin ou SQL Shell
5. Crie o banco de dados do projeto:
```sql
CREATE DATABASE werewolf_vampire_db;
```

**Opção 2: Chocolatey**
```powershell
choco install postgresql
```

**Opção 3: Docker (Para desenvolvedores experientes)**
```cmd
docker run --name postgres-werewolf -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:14
docker exec -it postgres-werewolf psql -U postgres -c "CREATE DATABASE werewolf_vampire_db;"
```

#### 5. Git (Opcional, mas recomendado)
1. Baixe o [Git for Windows](https://git-scm.com/download/win)
2. Execute o instalador com configurações padrão

### ⚙️ Configuração do Banco de Dados

Antes de executar o projeto, certifique-se de que o PostgreSQL está rodando e configurado:

#### Verificar se o PostgreSQL está rodando:
```cmd
# Verificar se o serviço está ativo
sc query postgresql-x64-14

# Iniciar o serviço se necessário
net start postgresql-x64-14
```

#### Configurar senha e banco (se necessário):
1. Abra o **SQL Shell (psql)** ou **pgAdmin**
2. Conecte com o usuário `postgres`
3. Execute os comandos:
```sql
-- Criar banco se não existir
CREATE DATABASE werewolf_vampire_db;

-- Verificar se foi criado
\l
```

#### Configurações personalizadas:

**Para Desenvolvimento (application-dev.yml):**
Edite o arquivo `backend/src/main/resources/application-dev.yml`:
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/SEU_BANCO
    username: SEU_USUARIO
    password: SUA_SENHA
```

**Para Produção (Variáveis de Ambiente):**
Configure as seguintes variáveis de ambiente:
```cmd
# No Windows (Command Prompt)
set DATABASE_URL=jdbc:postgresql://localhost:5432/werewolf_vampire_db
set DATABASE_USERNAME=postgres
set DATABASE_PASSWORD=sua_senha_segura

# No PowerShell
$env:DATABASE_URL="jdbc:postgresql://localhost:5432/werewolf_vampire_db"
$env:DATABASE_USERNAME="postgres"
$env:DATABASE_PASSWORD="sua_senha_segura"
```

### 🖥️ Executando o Projeto

#### 🚀 Opção 1: Execução Automática (Recomendado)
Execute o script que inicializa tudo automaticamente:
```cmd
start-project.bat
```
Este script irá:
1. Verificar se o PostgreSQL está rodando
2. Criar o banco de dados se não existir
3. Iniciar o backend automaticamente
4. Iniciar o frontend automaticamente

#### 🔧 Opção 2: Execução Manual

##### Backend (Spring Boot)

**No Command Prompt (Desenvolvimento):**
```cmd
cd backend
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

**No PowerShell (Desenvolvimento):**
```powershell
Set-Location backend
mvn spring-boot:run -D"spring-boot.run.profiles=dev"
```

**Para Produção:**
```cmd
cd backend
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```

O backend estará disponível em: `http://localhost:8080`

##### Frontend (Angular)

**No Command Prompt:**
```cmd
cd frontend\werewolf-vampire-frontend
npm install
npm start
```

**No PowerShell:**
```powershell
Set-Location frontend/werewolf-vampire-frontend
npm install
npm start
```

O frontend estará disponível em: `http://localhost:4200`

### 🔧 Comandos Úteis para Windows

#### Verificar se as portas estão em uso:
```cmd
netstat -ano | findstr :8080
netstat -ano | findstr :4200
```

#### Matar processo na porta (se necessário):
```cmd
taskkill /PID <PID> /F
```

#### Limpar cache do Maven:
```cmd
cd backend
mvn clean
```

#### Limpar cache do npm:
```cmd
cd frontend\werewolf-vampire-frontend
npm cache clean --force
rmdir /S node_modules
npm install
```

### 🛠️ IDEs Recomendadas para Windows

#### Para Java/Spring Boot:
- **IntelliJ IDEA Community** (Gratuito): https://www.jetbrains.com/idea/
- **Eclipse IDE**: https://www.eclipse.org/downloads/
- **Visual Studio Code** com extensões Java

#### Para Angular/TypeScript:
- **Visual Studio Code**: https://code.visualstudio.com/
- **WebStorm** (Pago): https://www.jetbrains.com/webstorm/

### 🔧 Configurações Específicas do Windows

#### Configurar JAVA_HOME (se necessário):
1. Windows + R → `sysdm.cpl` → Avançado → Variáveis de Ambiente
2. Criar nova variável do sistema:
   - Nome: `JAVA_HOME`
   - Valor: Caminho da instalação do Java (ex: `C:\Program Files\Java\jdk-17`)

#### Firewall do Windows:
O Windows pode bloquear as portas 8080 e 4200. Se houver problemas:
1. Windows Defender Firewall → Permitir um aplicativo
2. Adicione Java e Node.js à lista de exceções

#### Executar como Administrador (se necessário):
Se houver problemas de permissão, execute o Command Prompt ou PowerShell como administrador.

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
- Spring Boot 3.2.0
- Spring Security
- Spring Data JPA
- JWT (JSON Web Tokens)
- PostgreSQL 14+
- Maven 3.8+

### Frontend
- Angular 18.2
- TypeScript
- SCSS
- RxJS
- Angular Reactive Forms
- Bootstrap 5.3

## 📁 Estrutura do Projeto

```
\
├── backend\                    # Spring Boot API
│   ├── src\main\java\com\werewolfvampire\game\
│   │   ├── controller\        # Controllers REST
│   │   ├── entity\           # Entidades JPA
│   │   ├── repository\       # Repositórios
│   │   ├── service\          # Lógica de negócio
│   │   ├── security\         # Configurações JWT
│   │   └── dto\              # Data Transfer Objects
│   └── pom.xml
└── frontend\werewolf-vampire-frontend\  # Angular App
    ├── src\app\
    │   ├── components\       # Componentes UI
    │   ├── services\         # Serviços Angular
    │   ├── interceptors\     # Interceptors HTTP
    │   └── guards\           # Route Guards
    └── package.json
```

## 🔐 Autenticação

O sistema utiliza JWT para autenticação:
1. Login com username/password
2. Recebe token JWT
3. Token incluído automaticamente em requisições autenticadas
4. Renovação automática de token

## 🚨 Solução de Problemas Comuns no Windows

### Erro: "java não é reconhecido como comando interno"
- Verifique se o Java está instalado e no PATH
- Reinstale o Java marcando a opção para adicionar ao PATH

### Erro: "mvn não é reconhecido como comando interno"
- Adicione o Maven ao PATH do sistema
- Reinicie o terminal após adicionar ao PATH

### Erro: "npm não é reconhecido como comando interno"
- Reinstale o Node.js
- Verifique se foi adicionado automaticamente ao PATH

### Erro de permissão ao instalar dependências:
- Execute o terminal como administrador
- Use `npm install --no-optional` se houver problemas com dependências opcionais

### Erro de porta já em uso:
```cmd
# Verificar processos na porta 8080
netstat -ano | findstr :8080
# Matar processo (substitua <PID> pelo ID do processo)
taskkill /PID <PID> /F
```

### Problemas com PostgreSQL:

#### Erro: "Connection refused" ou "FATAL: password authentication failed"
- Verifique se o PostgreSQL está rodando:
```cmd
sc query postgresql-x64-14
```
- Verifique as credenciais no `application.yml`
- Reinicie o serviço PostgreSQL:
```cmd
net stop postgresql-x64-14
net start postgresql-x64-14
```

#### Erro: "database does not exist"
- Crie o banco manualmente:
```sql
psql -U postgres
CREATE DATABASE werewolf_vampire_db;
\q
```

#### Erro: "Port 5432 is already in use"
- Verifique se há outra instância do PostgreSQL rodando
- Ou altere a porta no `application.yml` e na configuração do PostgreSQL

#### Problemas de conexão:
1. Verifique o arquivo `pg_hba.conf` (geralmente em `C:\Program Files\PostgreSQL\14\data\`)
2. Certifique-se de que a linha para localhost está configurada como `trust` ou `md5`:
```
# TYPE  DATABASE        USER            ADDRESS                 METHOD
host    all             all             127.0.0.1/32            md5
```

## 🎯 Próximos Passos

1. **Página de Registro** - Seleção de facção e criação de conta
2. **Dashboard Principal** - Interface principal do jogo
3. **Sistema de Clicks** - Mecânica básica de progressão
4. **Batalhas** - Sistema de combate entre facções
5. **Rankings** - Leaderboards globais e por facção
6. **Loja** - Sistema de upgrades e melhorias

## 🤝 Contribuindo

Este projeto está em desenvolvimento ativo. Contribuições são bem-vindas!

### Para contribuir no Windows:
1. Fork o repositório
2. Clone localmente:
   ```cmd
   git clone https://github.com/seu-usuario/lobisomem-vampiro.git
   ```
3. Crie uma branch para sua feature:
   ```cmd
   git checkout -b nova-feature
   ```
4. Faça suas alterações e commit:
   ```cmd
   git add .
   git commit -m "Adiciona nova feature"
   ```
5. Push para seu fork e crie um Pull Request

## 📄 Licença

Este projeto é open source e está disponível sob a licença MIT.
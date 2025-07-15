@echo off
echo =====================================
echo   Lobisomem vs Vampiro - Iniciador
echo =====================================
echo.

REM Verificar se o PostgreSQL está rodando
echo [1/4] Verificando PostgreSQL...
sc query postgresql-x64-14 >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo PostgreSQL não está rodando. Tentando iniciar...
    net start postgresql-x64-14
    if %ERRORLEVEL% NEQ 0 (
        echo ERRO: Não foi possível iniciar o PostgreSQL.
        echo Verifique se está instalado corretamente.
        pause
        exit /b 1
    )
)
echo PostgreSQL está rodando!

REM Verificar se o banco existe
echo [2/4] Verificando banco de dados...
psql -U postgres -lqt | cut -d ^| -f 1 | findstr /C:"werewolf_vampire_db" >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Criando banco de dados...
    psql -U postgres -c "CREATE DATABASE werewolf_vampire_db;"
    if %ERRORLEVEL% NEQ 0 (
        echo ERRO: Não foi possível criar o banco de dados.
        pause
        exit /b 1
    )
)
echo Banco de dados OK!

REM Iniciar Backend
echo [3/4] Iniciando Backend...
cd backend
start "Backend - Spring Boot" cmd /k "mvn spring-boot:run -Dspring-boot.run.profiles=dev"
cd ..

REM Aguardar um pouco antes de iniciar o frontend
echo Aguardando backend inicializar...
timeout /t 15 /nobreak >nul

REM Iniciar Frontend
echo [4/4] Iniciando Frontend...
cd frontend\werewolf-vampire-frontend
start "Frontend - Angular" cmd /k "npm start"
cd ..\..

echo.
echo =====================================
echo   Projeto iniciado com sucesso!
echo =====================================
echo.
echo Backend: http://localhost:8080
echo Frontend: http://localhost:4200
echo.
echo Pressione qualquer tecla para fechar este script.
echo (Os serviços continuarão rodando nas outras janelas)
pause >nul
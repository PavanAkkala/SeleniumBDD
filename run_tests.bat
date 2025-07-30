@echo off

REM Check for argument (ci or local)
set MODE=%1

IF "%MODE%"=="" (
    echo No environment specified. Defaulting to local.
    set MODE=local
)

REM Navigate to the Docker Compose directory
cd /d "D:\New folder (3)\BDDCucumberHybrid\BDDCucumberHybrid"

REM Start Docker containers with 2 Chrome nodes
docker compose up -d --scale chrome=2

REM Wait for grid to stabilize
timeout /t 15

REM Run tests with the selected environment
echo Running tests with environment: %MODE%
mvn clean test -Denv=%MODE%

REM Shut down Docker containers
docker compose down
pause

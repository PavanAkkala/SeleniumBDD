@echo off
REM Change to project directory
cd "D:\New folder (3)\BDDCucumberHybrid\BDDCucumberHybrid"

REM Start Docker containers with 3 Chrome nodes
REM docker compose up -d --scale chrome=2

REM Optional: Wait a few seconds to let containers start
timeout /t 10

REM Run Maven tests
mvn clean test

REM Optional: Stop Docker containers after test
docker compose down

pause
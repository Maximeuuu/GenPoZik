@echo off
setlocal enabledelayedexpansion

REM Racine du projet
cd /d "%~dp0"

java -Dfile.encoding=UTF-8 -cp bin;lib/* genpozik.Controleur

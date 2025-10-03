@echo off
echo Compiling JavaFX project...
javac --module-path "E:\Java project(2-1)\javafx-sdk-25\lib" --add-modules javafx.controls,javafx.fxml -d "E:\Java project(2-1)\MY_Project\bin" "E:\Java project(2-1)\MY_Project\src\application\Main.java"

if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b
)

echo Running JavaFX project...
java --module-path "E:\Java project(2-1)\javafx-sdk-25\lib" --add-modules javafx.controls,javafx.fxml -cp "E:\Java project(2-1)\MY_Project\bin" application.Main

pause

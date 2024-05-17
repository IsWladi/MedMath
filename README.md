# Instrucciones para levantar entorno local en Linux Ubuntu WSL2
## Descargar, Descomprimir e Instalar
- Ejecutar script (revisarlo antes y modificarlo si es necesario): `sudo ./setup.sh`

## Agregar variables de entorno
- Abrir el archivo ~/.bashrc o ~/.zshrc según el caso
- Agregar lo siguiente al final del archivo:
    ``` bash
    # JDK
    export JAVA_HOME='/opt/jdk/jdk-17.0.11'
    PATH="$JAVA_HOME/bin:$PATH"
    export PATH

    # Maven
    export MAVEN_HOME='/opt/maven/apache-maven-3.9.6'
    PATH="$MAVEN_HOME/bin:$PATH"
    export PATH

    # Spring CLI
    export SPRING_HOME='/opt/spring-boot-cli/spring-3.2.5'
    PATH="$SPRING_HOME/bin:$PATH"
    export PATH
    ```
## Probar que todo este instalado
- java --version
- mvn --version
- spring --version

## Levantar API REST
- Ejecutar "./mvnw clean install compile spring-boot:run"

# Instrucciones para levantar entorno local con Docker

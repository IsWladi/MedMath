# Instrucciones para levantar entorno

<details>
<summary>Desarrollo - Ubuntu</summary>
</br>

### Requerimientos
- Java 17.0.11
- Maven 3.9.6
- Spring Boot CLI 3.2.5 ( opcional, solamente para crear una aplicación de Spring Boot desde 0 )
- Docker

### Descargar, Descomprimir e Instalar
- Ejecutar script (revisarlo antes y modificarlo si es necesario o hacer instalación manual): `sudo ./setup.sh`

### Agregar variables de entorno
- Abrir el archivo `~/.bashrc` o `~/.zshrc` según el caso
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
### Probar que todo este instalado
- `java --version`
- `mvn --version`
- ( opcional ) `spring --version`

### Crear archivo de variables de entorno
- En el directorio `./api/` crear el archivo `.env`
- En el archivo `.env` pegar el contenido de `.env.template` y modificar los valores de `USERNAME` y `PASSWORD`

### Levantar base de datos con Docker
Nota: Si no se desea utilizar Docker, se puede instalar PostgreSQL de manera local usando las variables de entorno del archivo `.env`
- Ejecutar `docker compose -f bdd-compose.yml up -d`

### Instalación de dependencias y compilación
- En el directorio `./api/` ejecutar `./mvnw clean install compile`

### Levantar API REST
- En el directorio `./api/` ejecutar `./mvnw spring-boot:run`

</details>

<details>
<summary>Probar aplicación - Docker</summary>
</br>

### Requerimientos
- Docker

### Crear archivo de variables de entorno
- En el directorio `./api/` crear el archivo `.env`
- En el archivo `.env` pegar el contenido de `.env.template` y modificar los valores de `USERNAME` y `PASSWORD`

### Levantar API REST y Base de Datos con Docker
- En el directorio `./api/` ejecutar `docker compose up -d`
</details>

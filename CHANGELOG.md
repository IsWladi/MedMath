# Changelog

Todos los cambios importantes de este proyecto serán documentados en este archivo.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased] - 2024-06-14

### Added
- Añade archivo `./api/bdd-compose.yml` para levantar la base de datos con Docker para usar en desarrollo

### Changed
- Actualiza archivo compose.yml para levantar la aplicación con Docker (no apta para desarrollo, solo para probar la aplicación ya que no permite hot reload)
- Mejora la documentación del README.md, ahora incluye intrucciones para levantar la aplicación
- Valor por defecto en el archivo `.env.template` para la variable `SPRING_DATASOURCE_DB`

### Removed

## [Unreleased] - 2024-05-25

### Added
- Readme con instrucciones para levantar entorno local con binarios en Ubuntu
- Script para decargar, descomprimir e instalar JDK, Maven y Spring
- Se crea proyecto con spring init
- Se crea conexión a la base de datos PostgreSQL (por ahora, no se guarda nada en base de datos)
- Se crea un endpoint para obtener sugerencias de horarios para toma de remedios: "/obtener/sugerencia/horarios"

### Changed


### Removed

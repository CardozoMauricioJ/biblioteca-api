# Biblioteca API REST

## Descripción

Este proyecto es una API REST desarrollada con Spring Boot para gestionar una biblioteca de libros. Permite crear, listar, actualizar y eliminar libros.

## Tecnologías Utilizadas

* Spring Boot
* Spring Data JPA
* Springdoc OpenAPI (Swagger)
* Maven

## Instrucciones de Ejecución

Instrucciones paso a paso para ejecutar el proyecto en un entorno local.

1.  Clonar el repositorio: `git clone https://github.com/CardozoMauricioJ/biblioteca-api.git`
2.  Navegar al directorio del proyecto: `cd biblioteca-api`
3.  Ejecutar la aplicación con Maven: `mvn spring-boot:run`
4.  Acceder a la documentación de Swagger UI: `http://localhost:8080/swagger-ui.html`

## Endpoints de la API

Lista de los endpoints principales de la API con ejemplos de solicitudes y respuestas.

Ejemplo:
* **GET biblioteca/libros:** Obtiene la lista de todos los libros.
* **GET biblioteca/libros/{id}:** Obtiene un libro por su ID.
* **POST biblioteca/libros:** Crea un nuevo libro.
* **PUT biblioteca/libros/{id}:** Actualiza un libro existente.
* **DELETE biblioteca/libros/{id}:** Elimina un libro.

## Autor

Desarrollado por [Mauricio Javier Cardozo] - [mau.webapp@gmail.com] - [LinkedIn (https://www.linkedin.com/in/MauricioCardozo1)]
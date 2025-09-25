Descripción
Este proyecto es parte del ejercicio de la semana 1 del programa Desarrollador Full Stack. Consiste en una API REST desarrollada con Spring Boot 3.x, que gestiona dos entidades relacionadas: Usuario (entidad principal) y Comentario (entidad secundaria). La base de datos utilizada es MySQL.

Requisitos:
Java 17+
Maven
MySQL Server
Postman (para pruebas)

Instalación y ejecución:

git clone https://github.com/NameYohell/udemy-apirest-prod.git
cd udemy-apirest-prod

Configura la base de datos en src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/nombre_de_tu_bd
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jackson.time-zone=America/Santiago

Ejecuta el proyecto:
mvn spring-boot:run

Endpoints disponibles:
Usuario:
POST/usuarios	            Crear nuevo usuario
GET/usuarios	            Listar todos los usuarios
GET/usuarios/{id}	        Buscar usuario por ID
PUT/usuarios/{id}	        Actualizar usuario por ID
DELETE	/usuarios/{id}	    Eliminar usuario por ID

Comentario:
POST/comentarios	        Crear nuevo comentario vinculado a un usuario
GET/comentarios	            Listar todos los comentarios
DELETE/comentarios/{id}	    Eliminar comentario por ID


Ejemplos para Postman
Crear usuario
json
{
  "nombreUsuario": "yohel_dev",
  "emailUsuario": "yohel@example.com",
  "nombre": "Yohel",
  "apellidos": "González",
  "idioma": "Español",
  "zonaHoraria": "America/Santiago"
}

Crear comentario vinculado a usuario
json
{
  "textoComentario": "Este es un comentario de prueba",
  "fechaComentario": "2025-09-25T18:30:00",
  "candidatosId": 101,
  "usuario": {
    "id": 1
  }
}

Estructura del proyecto
Código
src/
└── main/
    └── java/
        └── com.example.udemy_apirest_prod/
            ├── controller/
            ├── entity/
            ├── repository/
            ├── service/
            └── UdemyApirestProdApplication.java

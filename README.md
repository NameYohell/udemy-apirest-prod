Proyecto Semana 1
markdown
# udemy-apirest-prod

Proyecto backend desarrollado con Spring Boot como parte del curso de Udemy. Esta entrega corresponde a la **semana 1**, donde se implementa una API REST básica con entidades relacionadas, conexión a base de datos, y despliegue con Docker.

## 🚀 Tecnologías utilizadas

- Java 21
- Spring Boot
- JPA / Hibernate
- MySQL 8
- Docker & Docker Compose
- Maven Wrapper (`./mvnw`)
- Postman (para pruebas)

## 📦 Estructura del proyecto

- `entity/`: Modelos `Usuario` y `Comentario`
- `repository/`: Interfaces JPA
- `service/`: Lógica de negocio
- `controller/`: Endpoints REST
- `dto/`: `ComentarioUsuarioDTO` para respuestas personalizadas

## 🐳 Cómo levantar el entorno

1. Compilar el proyecto:
   ```bash
   ./mvnw clean package
Levantar contenedores:

bash
docker-compose up --build
Ejecutar la app (si no está dockerizada):

bash
java -jar target/udemy-apirest-prod-0.0.1-SNAPSHOT.jar

🧪 Endpoints disponibles
Usuarios
GET /usuarios: Listar todos los usuarios

POST /usuarios: Crear nuevo usuario

Comentarios
GET /comentarios: Listar todos los comentarios

POST /comentarios: Crear nuevo comentario

GET /comentarios/dto: Listar comentarios con datos del usuario (DTO)

Ejemplo de respuesta DTO
json
[
  {
    "nombreUsuario": "NameYohel",
    "emailUsuario": "yohel@email.com",
    "textoComentario": "Este es un comentario de prueba",
    "fechaComentario": "2025-09-25T18:30:00"
  }
]
🧠 Notas
La base de datos se levanta en Docker, puerto 3307.

phpMyAdmin disponible en http://localhost:8080

Usuario DB: root, contraseña: mipasswordsegura

## 🧪 Pruebas con Postman

Se incluye una colección de Postman para probar todos los endpoints del proyecto.

📁 Ruta: `postman-udemy-apirest-prod.postman_collection.json`

Importa el archivo en Postman y ejecuta las peticiones directamente. Incluye pruebas para:

- Usuarios (`GET`, `POST`)
- Comentarios (`GET`, `POST`)
- Comentarios con DTO (`GET /comentarios/dto`)


📌 Entrega semana 1
✅ Proyecto funcional ✅ DTO implementado ✅ Docker operativo ✅ Código versionado en GitHub ✅ Documentación clara
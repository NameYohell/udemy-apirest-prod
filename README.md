Udemy API REST Prod
Proyecto backend desarrollado con Spring Boot como parte del curso de Udemy. API REST completa con entidades relacionadas, conexión a base de datos MySQL, y despliegue con Docker.

🚀 Tecnologías utilizadas
  Java 21
  Spring Boot 3.5.6
  Spring Data JPA / Hibernate
  MySQL 8.0
  Docker & Docker Compose
  Maven Wrapper (./mvnw)
  Lombok
Postman (para pruebas)
📦 Estructura del proyecto
  entity/: Modelos Usuario y Comentario
  repository/: Interfaces JPA para acceso a datos
  service/: Lógica de negocio
  controller/: Endpoints REST
  dto/: ComentarioUsuarioDTO para respuestas personalizadas
🐳 Despliegue con Docker (Recomendado)
  Prerequisitos
  Docker
  Docker Compose
1. Levantar todo el entorno:
docker-compose up --build
Esto creará y ejecutará:
MySQL en puerto 3307
API REST en puerto 8081
phpMyAdmin en puerto 8080

2. Acceder a los servicios:
API REST: http://localhost:8081
phpMyAdmin: http://localhost:8080
Servidor: mysql
Usuario: root
Contraseña: mipasswordsegura
Comandos útiles:
# Levantar en segundo plano
  docker-compose up -d

# Ver logs de la aplicación
  docker-compose logs app -f

# Parar todos los servicios
  docker-compose down

# Limpiar volúmenes (elimina datos de BD)
  docker-compose down -v
  🛠️ Desarrollo Local (Sin Docker)
  Prerequisitos
  Java 21
  Maven 3.9+
  MySQL 8.0
  Pasos:
  Crear base de datos:
  CREATE DATABASE `bdd-apirest-prod`;
  Configurar application.properties:
  spring.datasource.url=jdbc:mysql://localhost:3306/bdd-apirest-prod
  spring.datasource.username=root
  spring.datasource.password=tu_password
Ejecutar aplicación:
./mvnw spring-boot:run
🧪 Endpoints disponibles
    
      Usuarios
      GET /usuarios - Listar todos los usuarios
      GET /usuarios/{id} - Obtener usuario por ID
      POST /usuarios - Crear nuevo usuario
      PUT /usuarios/{id} - Actualizar usuario
      DELETE /usuarios/{id} - Eliminar usuario
      
      Comentarios
      GET /comentarios - Listar todos los comentarios
      GET /comentarios/{id} - Obtener comentario por ID
      POST /comentarios - Crear nuevo comentario (JSON)
      POST /comentarios/crear?texto=...&usuarioId=... - Crear comentario con usuario (recomendado)
      PUT /comentarios/{id} - Actualizar comentario
      DELETE /comentarios/{id} - Eliminar comentario
      GET /comentarios/dto - Listar comentarios con datos del usuario (DTO)
Ejemplo de respuesta DTO:
      [
        {
          "nombreUsuario": "NameYohel",
          "emailUsuario": "yohel@email.com",
          "textoComentario": "Este es un comentario de prueba",
          "fechaComentario": "2025-09-25T18:30:00"
        }
      ]
🧪 Pruebas con Postman
Se incluye una colección de Postman para probar todos los endpoints:

📁 Archivo: postman-udemy-apirest-prod.postman_collection.json

Para usar:

Importa el archivo en Postman
Ejecuta las peticiones directamente
Incluye pruebas para:

Usuarios (GET, POST, PUT, DELETE)
Comentarios (GET, POST, PUT, DELETE)
Comentarios con DTO (GET /comentarios/dto)
🐳 Estructura Docker
├── Dockerfile                          # Imagen de la aplicación
├── docker-compose.yml                 # Orquestación completa
├── .dockerignore                       # Archivos excluidos
└── src/main/resources/
    ├── application.properties          # Config desarrollo
    └── application-docker.properties   # Config Docker
📝 Notas importantes
La base de datos se ejecuta en puerto 3307 para evitar conflictos
Se incluye healthcheck para MySQL para asegurar inicialización correcta
La aplicación espera a que MySQL esté listo antes de iniciarse
Se usa multi-stage build para optimizar el tamaño de la imagen Docker
📌 Entrega semana 1 ✅ Proyecto funcional ✅ DTO implementado ✅ Docker operativo ✅ Código versionado en GitHub ✅ Documentación clara

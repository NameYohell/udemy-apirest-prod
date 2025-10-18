#!/bin/bash

echo "🚀 Script de prueba para API REST Udemy"
echo "======================================"

# URL base de la API
BASE_URL="http://localhost:8081"

# Función para verificar si la API está disponible
check_api() {
    echo "🔍 Verificando disponibilidad de la API..."
    for i in {1..30}; do
        if curl -s "$BASE_URL" > /dev/null 2>&1; then
            echo "✅ API disponible!"
            return 0
        fi
        echo "⏳ Esperando... ($i/30)"
        sleep 2
    done
    echo "❌ API no disponible después de 60 segundos"
    exit 1
}

# Función para crear un usuario de prueba
create_user() {
    echo "👤 Creando usuario de prueba..."
    curl -X POST "$BASE_URL/usuarios" \
        -H "Content-Type: application/json" \
        -d '{
            "nombre": "Usuario Test",
            "email": "test@example.com",
            "edad": 25
        }' | jq '.'
}

# Función para obtener usuarios
get_users() {
    echo "📋 Obteniendo lista de usuarios..."
    curl -s "$BASE_URL/usuarios" | jq '.'
}

# Función para crear un comentario de prueba
create_comment() {
    echo "💬 Creando comentario de prueba..."
    curl -X POST "$BASE_URL/comentarios" \
        -H "Content-Type: application/json" \
        -d '{
            "texto": "Este es un comentario de prueba desde script",
            "usuarioId": 1
        }' | jq '.'
}

# Función para obtener comentarios
get_comments() {
    echo "📋 Obteniendo lista de comentarios..."
    curl -s "$BASE_URL/comentarios" | jq '.'
}

# Función para obtener comentarios con DTO
get_comments_dto() {
    echo "📋 Obteniendo comentarios con DTO..."
    curl -s "$BASE_URL/comentarios/dto" | jq '.'
}

# Ejecutar pruebas
main() {
    check_api
    echo ""
    create_user
    echo ""
    get_users
    echo ""
    create_comment
    echo ""
    get_comments
    echo ""
    get_comments_dto
    echo ""
    echo "🎉 Pruebas completadas!"
}

# Verificar si jq está instalado
if ! command -v jq &> /dev/null; then
    echo "⚠️  jq no está instalado. Instalando..."
    # Para sistemas basados en Debian/Ubuntu
    # sudo apt-get update && sudo apt-get install -y jq
    echo "Por favor instala jq para una mejor visualización de JSON"
fi

# Ejecutar main
main
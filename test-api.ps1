# Script de prueba para API REST Udemy (PowerShell)
# ========================================================

Write-Host "🚀 Script de prueba para API REST Udemy" -ForegroundColor Green
Write-Host "======================================" -ForegroundColor Green

# URL base de la API
$BaseUrl = "http://localhost:8081"

# Función para verificar si la API está disponible
function Test-ApiAvailability {
    Write-Host "🔍 Verificando disponibilidad de la API..." -ForegroundColor Yellow
    
    for ($i = 1; $i -le 30; $i++) {
        try {
            $response = Invoke-WebRequest -Uri $BaseUrl -Method GET -TimeoutSec 5
            if ($response.StatusCode -eq 200) {
                Write-Host "✅ API disponible!" -ForegroundColor Green
                return $true
            }
        } catch {
            Write-Host "⏳ Esperando... ($i/30)" -ForegroundColor Yellow
            Start-Sleep -Seconds 2
        }
    }
    
    Write-Host "❌ API no disponible después de 60 segundos" -ForegroundColor Red
    exit 1
}

# Función para crear un usuario de prueba
function New-TestUser {
    Write-Host "👤 Creando usuario de prueba..." -ForegroundColor Cyan
    
    $userBody = @{
        nombre = "Usuario Test"
        email = "test@example.com"
        edad = 25
    } | ConvertTo-Json
    
    try {
        $response = Invoke-RestMethod -Uri "$BaseUrl/usuarios" -Method POST -Body $userBody -ContentType "application/json"
        $response | ConvertTo-Json -Depth 10
    } catch {
        Write-Host "Error creando usuario: $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Función para obtener usuarios
function Get-AllUsers {
    Write-Host "📋 Obteniendo lista de usuarios..." -ForegroundColor Cyan
    
    try {
        $response = Invoke-RestMethod -Uri "$BaseUrl/usuarios" -Method GET
        $response | ConvertTo-Json -Depth 10
    } catch {
        Write-Host "Error obteniendo usuarios: $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Función para crear un comentario de prueba
function New-TestComment {
    Write-Host "💬 Creando comentario de prueba..." -ForegroundColor Cyan
    
    $commentBody = @{
        texto = "Este es un comentario de prueba desde PowerShell"
        usuarioId = 1
    } | ConvertTo-Json
    
    try {
        $response = Invoke-RestMethod -Uri "$BaseUrl/comentarios" -Method POST -Body $commentBody -ContentType "application/json"
        $response | ConvertTo-Json -Depth 10
    } catch {
        Write-Host "Error creando comentario: $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Función para obtener comentarios
function Get-AllComments {
    Write-Host "📋 Obteniendo lista de comentarios..." -ForegroundColor Cyan
    
    try {
        $response = Invoke-RestMethod -Uri "$BaseUrl/comentarios" -Method GET
        $response | ConvertTo-Json -Depth 10
    } catch {
        Write-Host "Error obteniendo comentarios: $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Función para obtener comentarios con DTO
function Get-CommentsWithDTO {
    Write-Host "📋 Obteniendo comentarios con DTO..." -ForegroundColor Cyan
    
    try {
        $response = Invoke-RestMethod -Uri "$BaseUrl/comentarios/dto" -Method GET
        $response | ConvertTo-Json -Depth 10
    } catch {
        Write-Host "Error obteniendo comentarios DTO: $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Ejecutar pruebas principales
function Start-ApiTests {
    Test-ApiAvailability
    Write-Host ""
    
    New-TestUser
    Write-Host ""
    
    Get-AllUsers
    Write-Host ""
    
    New-TestComment
    Write-Host ""
    
    Get-AllComments
    Write-Host ""
    
    Get-CommentsWithDTO
    Write-Host ""
    
    Write-Host "🎉 Pruebas completadas!" -ForegroundColor Green
}

# Ejecutar el script principal
Start-ApiTests
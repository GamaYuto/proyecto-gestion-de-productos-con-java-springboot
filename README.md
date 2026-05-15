# Proyecto de Gestión de Productos - Spring Boot

Este es un proyecto de ejemplo para la gestión de productos desarrollado con **Java 17** y **Spring Boot 3**. Implementa una API REST completa siguiendo una arquitectura de capas (Controlador, Servicio, Repositorio y Modelo).

## 🚀 Tecnologías Utilizadas

*   **Java 17**
*   **Spring Boot 3.2.5**
*   **Spring Data JPA** (Persistencia de datos)
*   **H2 Database** (Base de datos en memoria para desarrollo)
*   **Lombok** (Reducción de código boilerplate)
*   **Maven** (Gestión de dependencias)

## 📋 Requisitos Previos

Para ejecutar este proyecto, asegúrate de tener instalado:

*   **JDK 17** o superior.
*   **Maven** 3.6+.

## 🛠️ Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/GamaYuto/proyecto-gestion-de-productos-con-java-springboot.git
    cd proyecto-gestion-de-productos-con-java-springboot
    ```

2.  **Compilar y ejecutar el proyecto:**
    Puedes usar el comando de Maven para arrancar la aplicación directamente:
    ```bash
    mvn spring-boot:run
    ```

3.  **Acceso a la aplicación:**
    La aplicación estará disponible en: `http://localhost:8080`

## 📡 Endpoints de la API (REST)

| Acción | Método | Endpoint | Descripción |
| :--- | :--- | :--- | :--- |
| **Listar** | `GET` | `/api/productos` | Obtiene todos los productos |
| **Obtener** | `GET` | `/api/productos/{id}` | Obtiene un producto por su ID |
| **Crear** | `POST` | `/api/productos` | Crea un nuevo producto |
| **Actualizar** | `PUT` | `/api/productos/{id}` | Actualiza un producto existente |
| **Eliminar** | `DELETE` | `/api/productos/{id}` | Elimina un producto por ID |

### Ejemplo de JSON para POST/PUT:
```json
{
    "nombre": "Laptop Pro",
    "descripcion": "16GB RAM, 512GB SSD",
    "precio": 1200.50,
    "cantidad": 10
}
```

## 📊 Base de Datos

El proyecto utiliza una base de datos **H2** en memoria. Puedes acceder a la consola de administración mientras la aplicación está corriendo en:

*   **URL:** `http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:mem:productosdb`
*   **Usuario:** `sa`
*   **Contraseña:** (vacío)

---
Proyecto desarrollado para la entrega de gestión de productos.

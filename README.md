# Proyecto de Gestión de Productos - Spring Boot (Taller Práctico)

Este proyecto es una API RESTful desarrollada con **Java 17** y **Spring Boot 3** para administrar un catálogo de productos de un e-commerce. Implementa una arquitectura por capas, validaciones de datos, manejo global de excepciones y documentación automática con Swagger.

## 🚀 Tecnologías y Requisitos

*   **Java 17**
*   **Spring Boot 3.2.5**
*   **Maven** (Gestión de dependencias)
*   **H2 Database** (Base de datos en memoria)
*   **Springdoc-OpenAPI** (Swagger UI)
*   **Bean Validation** (Validaciones de entrada)
*   **Lombok**

## 📋 Requisitos del Taller Cumplidos

- [x] **Arquitectura:** controller, service, repository, entity, exception, dto.
- [x] **Entidad Product:** id, name, description, price, stock, category, createdAt.
- [x] **Validaciones:** @NotBlank, @Positive, @Min(0).
- [x] **Excepciones:** ProductNotFoundException personalizada y GlobalExceptionHandler.
- [x] **Paginación:** Parámetros `page` y `size` en el listado.
- [x] **Swagger/OpenAPI:** Documentación integrada y accesible.
- [x] **Puntos Extra:** Implementación de **DTOs** para separar la lógica de persistencia de la de transferencia.

## 🛠️ Instalación y Ejecución

1.  **Clonar el repositorio:**
    ```bash
    git clone https://github.com/GamaYuto/proyecto-gestion-de-productos-con-java-springboot.git
    cd proyecto-gestion-de-productos-con-java-springboot
    ```

2.  **Ejecutar la aplicación:**
    ```bash
    mvn spring-boot:run
    ```

3.  **Acceso a la Documentación (Swagger):**
    Una vez iniciada la aplicación, accede a:
    [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## 📡 Endpoints de la API

| Acción | Método | Endpoint | Parámetros |
| :--- | :--- | :--- | :--- |
| **Listar** | `GET` | `/products` | `page`, `size` (Opcionales) |
| **Obtener** | `GET` | `/products/{id}` | - |
| **Crear** | `POST` | `/products` | Body (JSON) |
| **Actualizar** | `PUT` | `/products/{id}` | Body (JSON) |
| **Eliminar** | `DELETE` | `/products/{id}` | - |

### Ejemplo de JSON para POST/PUT:
```json
{
    "name": "Laptop Gamer",
    "description": "RTX 4060, 16GB RAM",
    "price": 4500.0,
    "stock": 10,
    "category": "Tecnología"
}
```

## 📊 Base de Datos H2

Acceso a la consola de administración (con la aplicación corriendo):
*   **URL:** `http://localhost:8080/h2-console`
*   **JDBC URL:** `jdbc:h2:mem:productosdb`
*   **Usuario:** `sa`
*   **Contraseña:** (vacío)

---
Proyecto desarrollado para el Taller Práctico de Programación Backend.

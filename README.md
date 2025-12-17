# 📦 Pedidos API

[![Build Status](https://img.shields.io/badge/Status-WIP-orange)](https://github.com/tu_usuario/tu_repo)
[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)

<br>

## 🌟 Visión General

`Pedidos API` es una interfaz RESTful dedicada a la gestión del inventario (stock) de productos de un cliente.
Proporciona un conjunto de *endpoints* estándar (CRUD) para **Crear**, **Leer**, **Actualizar** y **Eliminar** productos
de la base de datos.

Este proyecto sirve como un **campo de pruebas personal** para profundizar en el desarrollo *backend* utilizando Spring
Boot y aplicar las mejores prácticas en el diseño de APIS REST.

---

## 🛠 Tecnologías Utilizadas

Este proyecto está construido con herramientas robustas y populares en el ecosistema Java:

* **Lenguaje:** Java 17+
* **Framework:** Spring Boot 3
* **Web:** Spring Web (Desarrollo REST)
* **Gestión de Dependencias:** Maven
* **Base de Datos (Desarrollo):** H2 Database (En memoria)
* **Base de Datos (Producción/Planificado):** PostgreSQL

---

## ⚙️ Estructura de la Entidad `Product`

La API gestiona la entidad principal **`Product`**, la cual se representa con los siguientes atributos:

| Campo             | Tipo de Dato  | Requerido     | Descripción                                                         | Ejemplo                              |
|:------------------|:--------------|:--------------|:--------------------------------------------------------------------|:-------------------------------------|
| `id`              | `Long`        | No (Generado) | Identificador único del producto.                                   | `101`                                |
| `name`            | `String`      | Sí            | Nombre legible del producto.                                        | `"Laptop Gamer X1"`                  |
| `originalPrice`   | `BigDecimal`  | Sí            | Precio sin descuentos (precio base).                                | `1200.00`                            |
| `offerPrice`      | `BigDecimal`  | No            | Precio con descuento, si aplica.                                    | `1099.50`                            |
| `imageUrl`        | `String`      | No            | URL a la imagen principal del producto.                             | `https://api.domain.com/img/101.jpg` |
| **`hasDiscount`** | **`Boolean`** | **Sí**        | **Indica si el producto tiene un precio de oferta (`offerPrice`).** | `true`                               |
| `description`     | `String`      | No            | Producto descripción detallada del producto.                        | `"Potente laptop para juegos..."`    |

> **Nota sobre `BigDecimal`:** Se utiliza este tipo de dato para evitar problemas de precisión con la representación de
> números decimales y moneda.

---

## 🚀 Endpoints de la API

A continuación, se listan los *endpoints* principales de la API disponibles bajo la ruta base `/api/products`.

| HTTP Método | Ruta                 | Descripción                                                                  | Request Body (JSON) | Response (Status)                  |
|:------------|:---------------------|:-----------------------------------------------------------------------------|:--------------------|:-----------------------------------|
| **POST**    | `/api/products`      | Crea un nuevo producto.                                                      | Objeto `Product`    | `201 Created`                      |
| **GET**     | `/api/products`      | Obtiene una lista de todos los productos (con paginación/filtrado opcional). | N/A                 | `200 OK`                           |
| **GET**     | `/api/products/{id}` | Obtiene un producto específico por su ID.                                    | N/A                 | `200 OK` / `404 Not Found`         |
| **PUT**     | `/api/products/{id}` | Actualiza completamente un producto existente.                               | Objeto `Product`    | `200 OK` / `404 Not Found`         |
| **DELETE**  | `/api/products/{id}` | Elimina un producto por su ID.                                               | N/A                 | `204 No Content` / `404 Not Found` |

### Ejemplo de Uso (POST)

Para crear un nuevo producto, puedes usar la siguiente solicitud `cURL`:

```bash
curl -X POST http://localhost:8080/api/products \
-H "Content-Type: application/json" \
-d '{
    "name": "Teclado Mecánico RGB",
    "originalPrice": 85.99,
    "offerPrice": 75.00,
    "imageUrl": "[https://img.com/teclado.jpg](https://img.com/teclado.jpg)",
    "hasDescription": true,
    "description": "Teclado con switches silenciosos y retroiluminación configurable."
}'
```

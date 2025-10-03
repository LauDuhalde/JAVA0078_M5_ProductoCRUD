# JAVA0078_M5_ProductoCRUD

## Descripción
Proyecto en Java que implementa un CRUD de productos utilizando **Servlets**, **JSP**, **DAO**, **PostgreSQL** y el patrón **Singleton** para la conexión a la base de datos.

La aplicación permite:
- Crear productos.
- Listar productos.
- Eliminar productos.

---

## Estructura del Proyecto

```
JAVA0078_M5_ProductoCRUD/
│
├── src/main/java/cl/web/
│   ├── CrearProducto.java
│   ├── EliminarProducto.java
│   ├── ListarProductos.java
│   │
│   ├── DAO/
│   │   ├── ProductoDAO.java
│   │   └── ProductoDAOImpl.java
│   │
│   ├── DTO/
│   │   └── Producto.java
│   │
│   └── util/
│       └── ConexionDB.java
│
├── src/main/webapp/
│   ├── index.jsp
│   ├── listaProductos.jsp
│   └── META-INF / WEB-INF
│
├── tabla.sql
└── README.md
```
---

## Requisitos

- **Java 21** o superior
- **Apache Tomcat 10+**
- **Eclipse/STS** o cualquier IDE compatible con proyectos Dynamic Web
- JSTL (Jakarta Standard Tag Library)
- Postgres y su JDBC

---

## Base de datos

Archivo `tabla.sql`:

```sql
CREATE TABLE producto(
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    precio INT NOT NULL,
    descripcion VARCHAR(300) NOT NULL
);
```
---

## Ejecución

1. Crear la base de datos en PostgreSQL y ejecutar el script `tabla.sql`.
2. Importa el proyecto en **Spring Tool Suite (STS)** o **Eclipse** como *Dynamic Web Project*.
3. Configurar las credenciales en `ConexionDB.java`.
4. Configura Apache Tomcat como servidor.
5. Despliega la aplicación en Tomcat.
6. Acceder a:
   - `http://localhost:8080/JAVA0078_M5_ProductoCRUD/index.jsp` para crear productos.
   - `http://localhost:8080/JAVA0078_M5_ProductoCRUD/listarProductos` para listar y eliminar productos.

---

## Autor
- Laura Duhalde

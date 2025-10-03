<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, cl.web.DTO.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de productos</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <h2 class="mb-4 text-center">Listado de Productos</h2>

        <%
            List<Producto> productos = (List<Producto>) request.getAttribute("productos");
        %>

        <table class="table table-bordered table-hover table-striped">
            <thead class="table-dark">
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Precio</th>
                    <th>Descripción</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <% if (productos != null && !productos.isEmpty()) { 
                       for (Producto p : productos) { %>
                    <tr>
                        <td><%= p.getId() %></td>
                        <td><%= p.getNombre() %></td>
                        <td><%= p.getPrecio() %></td>
                        <td><%= p.getDescripcion() %></td>
                        <td>
		                    <form action="eliminarProducto" method="post" style="display:inline;">
		                        <input type="hidden" name="id" value="<%= p.getId() %>">
		                        <button type="submit" class="btn btn-danger btn-sm"
		                                onclick="return confirm('¿Seguro que deseas eliminar este usuario?');">
		                            Eliminar
		                        </button>
		                    </form>
		                </td>
                    </tr>
                <%   } 
                   } else { %>
                    <tr>
                        <td colspan="5" class="text-center text-muted">No hay productos registrados</td>
                    </tr>
                <% } %>
            </tbody>
        </table>
        <a href="index.jsp" class="btn btn-primary m-2">Crear Producto</a>
    </div>

<!-- Bootstrap JS (opcional si usas componentes interactivos) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

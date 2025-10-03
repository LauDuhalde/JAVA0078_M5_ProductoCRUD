<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Producto</title>
<!-- Bootstrap CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<div class="container mt-5">
		<h2>Crear Producto</h2>
		
		<c:if test="${not empty error}">
        	<div class="alert alert-danger" role="alert"><c:out value="${error}" /></div>
    	</c:if>
    	
		<form action="crearProducto" method="post">
			<div class="mb-3">
		    	<label for="nombre" class="form-label">Nombre</label>
		    	<input type="text" class="form-control" id="nombre" name="nombre">
		  	</div>
		  	<div class="mb-3">
		    	<label for="precio" class="form-label">Precio</label>
		    	<input type="number" class="form-control" id="precio" name="precio">
		  	</div>
		  	<div class="mb-3">
		    	<label for="descripcion" class="form-label">Descripción</label>
		    	<textarea class="form-control" id="descripcion" name="descripcion" rows="4" cols="50" ></textarea>
		  	</div>
		  	<button type="submit" class="btn btn-primary">Crear Producto</button> 
		  	<a href="listarProductos" class="btn btn-success m-2">Ver Productos</a>
		</form>
	</div>
	
	<!-- Bootstrap JS (opcional si necesitas componentes interactivos) -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
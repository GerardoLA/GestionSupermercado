<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container shadow">
				<h1>Alta Producto</h1>

		<form method ="post"action="AltaProducto" class="w-50 mx-auto" >
			<label>Id :</label>	
			<input type="text" name="id" class="form-control" placeholder = "id"/><br>
			<br>
			<label>codigo:</label>
			<input type = "text" name ="codigo" class="form-control" placeholder = "codigo"/><br>
			<br>
			<label>Nombre: </label>
			<input type = "text" name ="nombre"  class="form-control" placeholder = "Nombre"/> <br>
			<br>
			<label>Cantidad: </label>
			<input type = "text" name ="cantidad"  class="form-control" placeholder = "Cantidad"/> <br>
			<br>
			<label>Precio: </label>
			<input type = "text" name ="precio"  class="form-control" placeholder = "Precio"/> <br>
			<br>
			<label>Caducidad: </label>
			<input type = "date" name ="caducidad"  class="form-control" placeholder = "caducidad"/> <br>
			<br>
			<div class="form-group">
		<h1>seccion</h1>
			<select class = "form-control id ="seccion" name="id_seccion" required>
			<option value = "">--Selecciona una seccion</option>
			<c:forEach items="${secciones }" var = "seccion">
			<option value="${seccion.id}">${seccion.nombre} <option>
			</c:forEach>
			</select>
			
	</div>
		
			<input type ="submit" value="Crear">
		</form>
	
		<a href="VerProductos" class="btn btn-dark">Volver</a>
	</div>
	


</body>
</html>
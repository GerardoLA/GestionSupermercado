<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<table class="table table-striped">
                      <thead style="background-color: #002d72; color: white ">
                <tr>
		  			<th colspan=11 style="text-align:center"><h2>VER PRODUCTOS</h2></th>
		  		</tr>
    			<tr>
      				<th scope="col">ID</th>
      				<th scope="col">CODIGO</th>
      				<th scope="col">NOMBRE</th>
      				<th scope="col">CANTIDAD</th>
      				<th scope="col">PRECIO</th>
     				<th scope="col">CADUCIDAD</th>
     				<th scope="col">SECCION</th>
     				<th scope="row">ELIMINAR</th>
     				
    			</tr>
    			</thead>

  				<c:forEach items="${productos}" var="producto"> 
  				<tr>
      				<td scope="row">${producto.id}</td>
      				<td scope="row">${producto.codigo}</td>
      				<td scope="row">${producto.nombre}</td>
      				<td scope="row">${producto.cantidad}</td>
      				<td scope="row">${producto.precio}</td>
      				<td scope="row">${producto.caducidad}</td>
      				<td scope="row">${producto.seccion.nombre }</td>
      				<td><a href="EliminarProducto?id=${producto.id}" class="btn btn-primary">Eliminar</a></td>
      				
    			</tr>
    			
    				
  
 				</c:forEach>  				
				</table>
	<a href="AltaProducto">altaProducto</a>

</body>
</html>
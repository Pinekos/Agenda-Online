<!-- insertar.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Insertar Datos</title>
</head>
<body>
    <h2>Insertar Datos en la Agenda</h2>
    <form action="AgendaServlet?action=insert" method="post">		
	<br>
    <table>
  	<tr>
    	<th><label for="name">Nombre: </label></th>
    	<th><input type="text" id="name" name="name"></th>
    </tr>
    <tr>
    	<th><label for="surname">Apellidos: </label></th>
    	<th><input type="text" id="surname" name="surname"></th>
    </tr>
    <tr>
    	<th><label for="phone">Teléfono: </label></th>
    	<th><input type="tel" id="phone" name="phone"></th>
    </tr>
    </table>
    <br>
        <input type="submit" value="Enviar">
    </form>
    <br>
    <form action="AgendaServlet?action=show" method="post">		
    	<input type="submit" value="Mostrar">
    </form>
    <br>
    <form action="AgendaServlet?action=search" method="post">	
    	<label for="nombre_buscado">Buscar por nombre: </label>
    	<input type="text" id="nombre_buscado" name="nombre_buscado">	
    	<input type="submit" value="Buscar">
    </form>
</body>
</html>

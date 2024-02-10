<%@ page import="java.util.List" %>
<%@ page import="paqueteagenda.Contacto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar Contactos</title>
    <style>
        table {
            border-collapse: collapse;
            width: 50%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #dddddd;
            padding: 8px;
        }
    </style>
</head>
<body>

    <h2>Lista de Contactos</h2>
    
    <table>
        <tr>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Teléfono</th>
            <th>Acción</th>
        </tr>
        <% List<Contacto> contacts = (List<Contacto>) request.getAttribute("contacts");
           for (Contacto contact : contacts) { %>
               <tr>
                   <td><%= contact.getName() %></td>
                   <td><%= contact.getSurname() %></td>
                   <td><%= contact.getPhone() %></td>
                   <td>
                       <form action="AgendaServlet?action=delete" method="post">
                           <input type="hidden" id ="phone" name="phone" value="<%= contact.getPhone() %>">
                           <button type="submit">Eliminar</button>
                       </form>
                   </td>
               </tr>
        <% } %>
    </table>

</body>
</html>





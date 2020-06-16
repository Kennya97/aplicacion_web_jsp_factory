
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@page import="Model.Categoria" %><!--Importar el modelo-->

<!--El id debe ser el mismo que se le coloco de nombre a la seccion en el controlador-->

<jsp:useBean id="lista" scope="session" class="java.util.List" />

<html>

<head>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Control de Inventario</title>

 <!---INCLUIMOS LAS VISTA PARCIAL LA CUAL CONTIENE LAS URL 
DE LAS LIBRERIAS CORRESPONDIENTES A ESTILO Y JS-->
 
<%@include file="../WEB-INF/Vistas_Parciales/css-js.jspf"%>

</head>
<body>
    
<!--VISTA PARCIAL DE LA PARTE SUPERIOR DE LA APLICACION-->
<%@include file="../WEB-INF/Vistas_Parciales/encabezado.jspf"%>


<div style="width: 600px;">
<a href="<%=request.getContextPath()%>/categorias?opcion=crear" class="btn btn-success btn-sm glyphicon glyphicon " role="button">Nueva Categoria</a>
<h3>Listado de categoria registradas</h3>

<table class="table table-striped">
<tr>
<th>ID</th>
<th>NOMBRE</th>      
<th>ESTADO</th>    
<th>ACCION</th>      
</tr>

<%

for(int i= 0; i < lista.size(); i++) {
Categoria categoria = new Categoria();
categoria =(Categoria)lista.get(i);
%>

<tr>
<td><%= categoria.getId_categoria() %></td> 
<td><%= categoria.getNom_categoria() %></td>
<td><%= categoria.getEstado_categoria() %></td> 
<td>
<a href="#" class="btn btn-info  btn-sm  glyphicon-edit" role="button">Editar</a>
<a href="#" class="btn btn-danger  btn-sm  glyphicon-remove" role="button">Delete</a>    
</td> 
    
</tr>
<% } %>

</table>

</div>

<!--VISTA PARCIAL DE LA PARTE  INFERIOR DE LA APLICACION-->
<%@include  file="../WEB-INF/Vistas_Parciales/pie.jspf"%>

</body>
</html>

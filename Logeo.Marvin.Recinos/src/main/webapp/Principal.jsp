<html>
<head>
<meta charset="ISO-8859-1">
</head>
<%
HttpSession sesion = (HttpSession) request.getSession();
String usuariovariable = (String)sesion.getAttribute("usuario");
if(usuariovariable==null){
	
	response.sendRedirect("index.jsp");
	
}
%>

<body>
<form action="ServeletUse" method="post">
<input type="submit" value="CERRAR" name="btncerrar" >
</form>
<h1>Estas en la pagina principal</h1>
</body>
</html>
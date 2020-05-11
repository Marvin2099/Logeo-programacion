<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js">	
</script>
<script type="text/javascript">
	$(document).ready(function (){
		
			$.post('ServeletHistorial',{

			}, function(respose){

			let datos = JSON.parse(respose);
			//console.log(datos);

			var tabladatos = document.getElementById('tablaDatos'); 
			for(let item of datos){

				tabladatos.innerHTML +=`
				<tr>
				<td>${item.id}</td>
				<td>${item.nombre}</td>
				<td>${item.apellido}</td>
				<td>${item.edad}</td>
				<td>${item.direccion}</td>
				<td>${item.dui}</td>
				<td>${item.nit}</td>
				<td>${item.grupoDeClaseProgramacion3Alquepertenece}</td>
				<td>${item.utimaNotaObtenidaEnProgramacion2}</td>
				</tr>
				`
			}
        });
		
	});

</script>
<body>
<h2 align="center" class="text-secondary">DATOS DE LOS ESTUDIANTES</h2>

<table align="center">
	<thead>
	</thead>

	
</table>
<input type="submit" name="btn" value="AGREGAR" class="btn btn-warning">
<input type="submit" name="btn" value="ELIMINAR" class="btn btn-success">
<input type="submit" name="btn" value="MODIFICAR" class="btn btn-secondary">
<input type="submit" name="btn" value="CARGAR" id="envio" class="btn btn-primary"	>
<table class="table table-dark" id="tablaDatos">
	
	<thead>
	    <th>ID</th>
	    <th>Nombre</th>
	    <th>Apellido</th>
	    <th>Edad</th>
	    <th>Direccion</th>
	    <th>Dui</th>
	    <th>Nit</th>
	    <th>grupoDeClaseProgramacion3Alquepertenece</th>
	    <th>ultimaNotaObtenidaEnProgramacion2</th>	
	</thead>

	<tbody>
		
	</tbody>

</table>

</body>
</html>

$(document).ready(function(){
	function listausuario(){
		alert("usuario");
		$.ajax({
			type:"post",
			url:"ServletReporte",
			dataType:'json',
			data:{dato:"usu"},
			success: function( result ){
				console.log(result);
			}
		});
	}
	
	function listacliente(){
		alert("cliente");
		$.ajax({
			type:"post",
			url:"ServletReporte",
			dataType:'json',
			data:{dato:"cli"},
			success: function( result ){
				console.log(result);
				let datos=document.querySelector("#tablac");
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>Cedula</th>
								<th>Nombre</th>
								<th>Direccion</th>
								<th>Telefono</th>
								<th>Correo</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.cedula}</td>
									<td>${i.nombre}</td>
									<td>${i.direccion}</td>
									<td>${i.tel}</td>
									<td>${i.email}</td></tr>`;
				}
			}
		});
	}
	
	function listaventa(){
		alert("venta");
		$.ajax({
			type:"post",
			url:"ServletReporte",
			dataType:'json',
			data:{dato:"ven"},
			success: function( result){
				console.log(result);
			}
		});
	}
	
	
	$('.usu').on('click', function(){
		listausuario();
	});
	
	$('.cli').on('click', function(){
		listacliente();
	});
	
	$('.ven').on('click', function(){
		listaventa();
	});
});
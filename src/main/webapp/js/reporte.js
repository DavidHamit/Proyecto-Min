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
        let datos=document.querySelector('#tablau');
        console.log(datos);
        datos.innerHTML='';
        datos.innerHTML+= `<tr>
           <th>Documento</th>
           <th>Nombre</th>
           <th>Correo</th>
           <th>Usuario</th>
           <th>Clave</th>

           </tr>`;
        for (let i of result){
        	datos.innerHTML+=`<tr> <td>${i.cedula}</td>
                                   <td>${i.nombre}</td> 
                                   <td>${i.correo}</td> 
                                   <td>${i.usuario}</td> 
                                   <td>${i.password}</td> 

            </tr>`;
			}
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
				let datos=document.querySelector("#tablav");
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>Cedula</th>
								<th>Nombre</th>
								<th>Valor Total Ventas</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.cedcli}</td>
									<td>${i.nombre}</td>
									<td>${i.total}</td></tr>`;
				}
			}
		});
	}
	
	
	function nombventa(){
		alert("nombres");
		$.ajax({
			type:"get",
			url:"ServletReporte",
			dataType:'json',
			data:{dat:"nom"},
			success: function( result){
				console.log(result);
				let datos=document.querySelector("#tablan");
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>Nombre</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.nombre}</td></tr>`;
				}
			}
		});
	}
	
	function listaproveedores(){
		alert("en proovedor");
		$.ajax({
			type:"post",
			url:"ServletReporte",
			dataType:'json',
			data:{dato:"prov"},
			success: function( result ){
				console.log(result);
				let datos=document.querySelector('#tablap');
				//console.log(datos);
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>NIT</th>
				<th>Nombre</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Ciudad</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.nit}</td>
					<td>${i.nom}</td>
					<td>${i.dir}</td>
					<td>${i.tel}</td>
					<td>${i.ciudad}</td></tr>`;
				}
			}
		});
	}	
	
	function listaproducto(){
		alert("producto");
		$.ajax({
			type:"post",
			url:"ServletReporte",
			dataType:'json',
			data:{dato:"prod"},
			success: function( result ){
				console.log(result);
				let datos=document.querySelector("#tablaprod");
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>Codigo</th>
								<th>Nombre</th>
								<th>NIT Proveedor</th>
								<th>Precio Venta</th>
								<th>IVA</th>
								<th>Precio Compra</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.codigo}</td>
									<td>${i.nomprod}</td>
									<td>${i.nit}</td>
									<td>${i.precompra}</td>
									<td>${i.iva}</td>
									<td>${i.precventa}</td></tr>`;
									
				}
			}
		});
	}
	
	$('.usu').on('click', function(){
		listausuario();
	});
	
	$('.cli').on('click', function(){
		listacliente();
	});
	
	$('.vent').on('click', function(){
		listaventa();
		nombventa();
	});
	
	$('.prov').on('click',function(){
		listaproveedores();
	});
	
	$('.prod').on('click', function(){
		listaproducto();
	});
});
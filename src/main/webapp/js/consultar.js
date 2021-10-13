$(document).ready(function(){
	
	//alert("hola");
	
	
	
	function consultarusuarios(){
		alert("en la funcion");
		
    $.ajax({
	  type:"post",
      url: "ServletGestion",
      dataType:'json',
      data:{dat:"consultar"
         
       },
      success: function( result ) {
        console.log(result);
        let datos=document.querySelector('#tabla');
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
	
	function consultacliente(){
		alert("en cliente");
		$.ajax({
			type:"post",
			url:"ServletCliente",
			dataType:'json',
			data:{dat:"cliente"},
			success: function( result ){
				let datos=document.querySelector('#tablac');
				console.log(datos);
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
 /*function consultadocumento(){
		
		$.ajax({
	  type:"post",
      url: "ServletGestion",
      dataType:'json',
      data:{
	   x:"documento"
      },
      success: function( result ) {
	    console.log("success");
        console.log(result);
        let datos=document.querySelector('#lista');
        //console.log(datos);
        datos.innerHTML='';
        
        for (let i of result){
        	datos.innerHTML+=`<option>${i.cedula}</option>`;
        }
      }
    });
		
	}
	
	consultadocumento();*/
	function consultaproveedor(){
		alert("en proovedor");
		$.ajax({
			type:"post",
			url:"ServletProveedor",
			dataType:'json',
			data:{dat:"proveedor"},
			success: function( result ){
				console.log(result);
				let datos=document.querySelector('#tablap');
				console.log(datos);
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>NIT</th>
				<th>Nombre</th>
				<th>Direccion</th>
				<th>Telefono</th>
				<th>Ciudad</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.nitpr}</td>
					<td>${i.nompr}</td>
					<td>${i.dirpr}</td>
					<td>${i.telpr}</td>
					<td>${i.ciupr}</td></tr>`;
				}
			}
		});
	}
	
	function consultaproducto(){
		alert("En producto");
		$.ajax({
			type:"get",
			url:"ServletProducto",
			dataType:'json',
			data:{dat:"prod"},
			success: function( result ){
				let datos=document.querySelector('#tablap');
				console.log(result);
				datos.innerHTML='';
				datos.innerHTML+=`<tr><th>Codigo</th>
								<th>Nombre</th>
								<th>NIT Proveedor</th>
								<th>Precio Compra</th>
								<th>IVA</th>
								<th>Precio Venta</th></tr>`;
				for(let i of result){
					datos.innerHTML+=`<tr><td>${i.codigo}</td>
									<td>${i.nomprod}</td>
									<td>${i.nit}<td>
									<td>${i.precventa}</td>
									<td>${i.iva}</td>
									<td>${i.precompra}</td></tr>`;
				}
			}
		});
	}
	
	$('.conpro').on('click',function(){
		consultaproveedor();
	});
	
	$('.con').on('click',function(){
		consultarusuarios();
	});
	
	$('.concli').on('click',function(){
		consultacliente();
	});
	
	$('.conprod').on('click',function(){
		consultaproducto();
	});
});
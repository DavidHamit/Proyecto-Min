$(document).ready(function(){
	
	alert("hola");
	
	
	
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
				alert("dentro");
				console.log("dentro");
				console.log(result);
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
	
	$('.con').on('click',function(){
		consultarusuarios();
	});
	
	$('.concli').on('click',function(){
		consultacliente();
	});
	
});
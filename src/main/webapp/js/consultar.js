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
	    console.log("success");
        console.log(result);
        let datos=document.querySelector('#tabla');
        //console.log(datos);
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
                                   <td>${i.correo_electronico}</td> 
                                   <td>${i.usuario}</td> 
                                   <td>${i.clave}</td> 

            </tr>`;
        }
      }
    });

	}
	
	
	function consultadocumento(){
		
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
	
	consultadocumento();
	
	$('.con').on('click',function(){
		consultarusuarios();
	});
	
	
	
});
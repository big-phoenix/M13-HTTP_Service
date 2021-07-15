/**
 * 
 */


$(document).ready(function(){
	
	$.ajax({
			type: 'GET',
			url: '/api/v1/all',
			success: function(result){
				
				console.log(result.length);
				
				
				for(i=0;i<result.length;i++){
						
						tr="<tr><td>"+result[i].id+"</td><td>"+result[i].nombre+
							"</td><td>"+result[i].faena+"</td><td>"+result[i].salario+"</td>"+
							"<td><a id='editar' class='btn btn-warning' href='/editar/"+result[i].id+"'>Editar</a></td>"+
							"<td><a id='editar' class='btn btn-danger'href='/borrar/"+result[i].id+"'>Borrar</a></td></tr>";
							
							$("#tabla").append(tr);
			
					}
					
					$('#id').val(result.length);
					
				
			}
	});
	
	$('#buscar').click(function(){
		var faena = $('#faena').val();
		$.ajax({
			type: 'GET',
			url: '/api/v1/faena/'+faena,
			success: function(result){
				
				$("#tabla").empty();
				
				for(i=0;i<result.length;i++){
						
						tr="<tr><td>"+result[i].id+"</td><td>"+result[i].nombre+
							"</td><td>"+result[i].faena+"</td><td>"+result[i].salario+"</td>"+
							"<td><a id='editar' class='btn btn-warning' href='/editar/"+result[i].id+"'>Editar</a></td>"+
							"<td><a id='editar' class='btn btn-danger'href='/borrar/"+result[i].id+"'>Borrar</a></td></tr>";
							
							$("#tabla").append(tr);
			
					}
			}
		});
	});
	
});

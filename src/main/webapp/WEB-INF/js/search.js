var productos = new Bloodhound({
	datumTokenizer : Bloodhound.tokenizers.obj.whitespace('name'),
	queryTokenizer : Bloodhound.tokenizers.whitespace,
	remote : {
		url : "http://localhost:8080/tiendaOnline/producto/search/%QUERY",
		wildcard : '%QUERY'
	}
});
$('.typeahead').typeahead({
	minLength : 1,
	highlight : true
}, {
	name : 'productos',
	display : 'nombreProducto',
	source : productos
}).on("typeahead:select", function(e, productoDto) {
	window.location.replace = "http://localhost:8080/tiendaOnline/producto/perfilAjax/"
								+ productoDto.idProducto;
});

/*
function perfilProducto(productoDto) {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});
	$
			.ajax({
				url : "http://localhost:8080/tiendaOnline/producto/perfilProducto/"
						+ productoDto.idProducto,
				contentType : "application/json; charset=utf-8",
				data : JSON.stringify(),
				type : "POST",
				success : function(response) {
					var dir = window.location.href;
					if (dir == 'http://localhost:8080/tiendaOnline/producto/inicio') {
						window.location.href = "" + productoDto.idProducto;
					} else {
						window.location.href = "http://localhost:8080/tiendaOnline/producto/perfilProducto/"
								+ productoDto.idProducto;
					}
				}
			});
}
*/
$(document).ready(function() {
	var boton = document.getElementsByClassName('borrar');
	for (var i = 0; i < boton.length; i++) {
		boton[i].addEventListener('click', desmatricularProfesor, false);
	}
});

// $('.borrar').click(
// function eliminarProfesor (){
//	
// var obj = $(this);
// var idProfesor = $(this).closest("tr") // Finds the closest row <tr>
// .find("#idTd") // Gets a descendent with class="nr"
// .text();
//
// var idModulo = document.getElementById('idModulo').value;
//
// var token = $("meta[name='_csrf']").attr("content");
// var header = $("meta[name='_csrf_header']").attr("content");
// $(document).ajaxSend(function(e, xhr, options) {
// xhr.setRequestHeader(header, token);
// });
// $.ajax({
// url:
// "http://localhost:8080/PruebaSpring-AuthenticationAuthoritation/modulo/eliminarprofesor/"+idModulo+"/"+idProfesor,
// contentType: "application/json; charset=utf-8",
// type: "GET",
// success: function (response) {
// removed=true;
//    	 
// $(obj).closest("tr").remove();
//
// },
// error: function(xhr, status, error) {
//			
// var aviso ="" +
// "<div class='alert alert-danger' role='alert'>"+
// "El profesor ya no imparte este módulo"+
// "</div>" +
// "";
//			
// $('#aviso').html(aviso);
// }
// });
// });


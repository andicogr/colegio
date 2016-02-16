var baseURL;
$(function(){

	baseURL = $("#baseURL").val();
	
	$("#menuUsuarios").click(function() {
		$("#contenidoPrincipal").html("Cargando . . .");
		$.get(baseURL + "seguridad/usuario/usuarioForm", function(respuesta) {
			//$("#cabeceraPrincipal").html("Mantenimiento de Usuario");
			$("#page-wrapper").html(respuesta);
		}).fail(function() {
			$("#page-wrapper").html("No se ha podido visualizar esta pagina");
		});
	});
	
	$("#menuPerfiles").click(function() {
		$("#contenidoPrincipal").html("Cargando . . .");
		$.get(baseURL + "seguridad/perfil/listaPerfil", function(respuesta) {
			$("#title-page").html("Mantenimiento de Perfil");
			$("#contenidoPrincipal").html(respuesta);
		}).fail(function() {
			$("#contenidoPrincipal").html("No se ha podido visualizar esta pagina");
		});
	});
	
	$("#menuNoticias").click(function() {
		$("#contenidoPrincipal").html("Cargando . . .");
		$.get(baseURL + "contenido/noticia/listaNoticia", function(respuesta) {
			$("#title-page").html("Mantenimiento de Noticia");
			$("#contenidoPrincipal").html(respuesta);
		}).fail(function() {
			$("#contenidoPrincipal").html("No se ha podido visualizar esta pagina");
		});
	});
});
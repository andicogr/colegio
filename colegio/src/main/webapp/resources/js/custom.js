

function alerta_form(tipo,mensaje){
	alerta_html = 	'<div class="alert alert-' + tipo + '" id="' + tipo + '-alert">' +
						'<button type="button" class="close" data-dismiss="alert" aria-hidden="true">' +
							'&times;' +
						'</button>' + mensaje +
					'</div>'

	$("#main-alerts").html(alerta_html)


	$("#" + tipo + "-alert").fadeTo(4000, 500).slideUp(500, function(){
    	$("#" + tipo + "-alert").alert('close');
	})

}

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"/>" rel="stylesheet">


<link href="<c:url value="/resources/bower_components/datatables-responsive/css/responsive.dataTables.css"/>" rel="stylesheet">


			<div class="row">
                <div class="col-lg-6 filtros-top">
                    algo
                </div>
                <div class="col-lg-6 filtros-top">
                    algo2
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <div class="row">
                <div class="col-lg-6">
                    algo3
                </div>
                <div class="col-lg-6">
                    algo4
                </div>
                <!-- /.col-lg-12 -->
            </div>
			<div class="row">
				<div class="col-lg-12">
				<!--  <input id="searchbox" class="form-control input-sm" type="text" placeholder="Buscar...">-->
					
					<table id="example" class="table table-striped table-bordered dt-responsive nowrap" cellspacing="0" width="100%">
					        <thead>
					            <tr>
					                <th>Usuario</th>
					                <th>Estado</th>
					            </tr>
					        </thead>
					        <tbody>
					            <tr>
					                <td>Tiger</td>
					                <td>Nixon</td>
					            </tr>
					        </tbody>
					    </table>
				</div>
			</div>




<script src="<c:url value="/resources/bower_components/datatables/media/js/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/resources/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js"/>"></script>

<script>
    $(document).ready(function() {
        $('#example').DataTable({
        	"sDom": '<"wrapper"flitp>',
        	"order": [],
	    	responsive: true,
	    	sSearch: false,
	    	"language": {
	    			"sEmptyTable":   	"No hay datos disponibles en la tabla",
	    			"sInfo":         	"_START_ al _END_ de _TOTAL_ Registros",
	    			"sInfoEmpty":    	"0 al 0 de 0 Registros",
	    			"sInfoFiltered": 	"(filtrado de _MAX_ Registros)",
	    			"sInfoPostFix":  	"",
	    			"sInfoThousands":  	".",
	    			"sLengthMenu":   	"Mostrar _MENU_ entradas",
	    			"sLoadingRecords": 	"Cargando ...",
	    			"sProcessing":   	"Por favor, espere ...",
	    			"sSearch":       	"Buscar",
	    			"sZeroRecords":  	"No hay entradas",
	    			"oPaginate": {
	    				"sFirst":    	"En primer lugar",
	    				"sPrevious": 	"Volver",
	    				"sNext":     	"más cercano",
	    				"sLast":     	"El pasado"
	    			},
	    			"oAria": {
	    				"sSortAscending":  ": Habilitar para ordenar la columna en orden ascendente",
	    				"sSortDescending": ": Habilitar para ordenar descendente columna"
	    			}
	        }
        });
        
        oTable = $('#example').DataTable();   //pay attention to capital D, which is mandatory to retrieve "api" datatables' object, as @Lionel said
        /*$('#searchbox').keyup(function(){
              oTable.search($(this).val()).draw() ;
        }) */
    });
    </script>
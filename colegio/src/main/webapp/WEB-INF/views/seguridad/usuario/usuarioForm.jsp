<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 <sec:authorize ifAnyGranted="ROLE_ADMIN,ROLE_SEGURIDAD">
<div class="col-lg-12">
    <div class="col-lg-6">
        <form class="form-horizontal" role="form">
            <div class="form-group">
                <label for="ejemplo_email_3" class="col-lg-3 control-label">Email</label>
                <div class="col-lg-9">
                    <input type="email" class="form-control" id="ejemplo_email_3" placeholder="Email">
                </div>
            </div>
            <div class="form-group">
                <label for="ejemplo_password_3" class="col-lg-3 control-label">Contraseña</label>
                <div class="col-lg-9">
                    <input type="password" class="form-control" id="ejemplo_password_3" placeholder="Contraseña">
                </div>
            </div>
           
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                <button type="submit" class="btn btn-default">Entrar</button>
            	</div>
        	</div>
        	
        </form>
    </div>
    <div class="col-lg-6">
    </div>
</div>
</sec:authorize>
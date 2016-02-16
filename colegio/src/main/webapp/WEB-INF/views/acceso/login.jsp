<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Systema School - Login</title>
<link rel="stylesheet" href="resources/bower_components/bootstrap/dist/css/bootstrap.min.css" type="text/css" />
<link rel="stylesheet" href="resources/bower_components/metisMenu/dist/metisMenu.min.css" type="text/css" />
<link rel="stylesheet" href="resources/dist/css/sb-admin-2.css" type="text/css" />
<link rel="stylesheet" href="resources/bower_components/font-awesome/css/font-awesome.min.css" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/bower_components/jquery/dist/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/bower_components/metisMenu/dist/metisMenu.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/dist/js/sb-admin-2.js"/>"></script>
</head>

<body>
	<div class="loginwrapper">
		<p class="message" style="color:red;">
	        <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
	        	<c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='User is disabled'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'User is disabled', 'Usuario/Clave son incorrectos')}
		        </c:if>
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='Bad credentials'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'Bad credentials', 'Usuario/Clave son incorrectos')}
		        </c:if>
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='Maximum sessions of 1 for this principal exceeded'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'Maximum sessions of 1 for this principal exceeded', 'Esta cuenta ya esta siendo usada por alguien.')}
		        </c:if>
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='User account has expired'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'User account has expired', 'La cuenta de usuario ha expirado.')}
		        </c:if>
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='User credentials have expired'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'User credentials have expired', 'Las credenciales de usuario han caducado.')}
		        </c:if>
		        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION.message=='User account is locked'}">
		            ${fn:replace(SPRING_SECURITY_LAST_EXCEPTION.message, 'User account is locked', 'La cuenta de usuario está bloqueada.')}
		        </c:if>
		        <c:remove scope="session" var="SPRING_SECURITY_LAST_EXCEPTION"/>
	        </c:if> 
		</p>
	    <div class="container">
	        <div class="row">
	            <div class="col-md-4 col-md-offset-4">
	                <div class="login-panel panel panel-default">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Please Sign In</h3>
	                    </div>
	                    <div class="panel-body">
	                        <form role="form" id="loginform" action="j_spring_security_check" method="post" target="_parent">
	                            <fieldset>
	                                <div class="form-group">
	                                    <input class="form-control" id="username" placeholder="<spring:message code="label.inicioSesion.nombreUsuario"/>" name="j_username" type="text" autofocus>
	                                </div>
	                                <div class="form-group">
	                                    <input class="form-control" id="password" placeholder="<spring:message code="label.inicioSesion.clave"/>" name="j_password" type="password" value="">
	                                </div>
	                                <div class="checkbox">
	                                    <label>
	                                        <input name="remember" type="checkbox" value="Remember Me">Remember Me
	                                    </label>
	                                </div>
	                                <!-- Change this to a button or input when using this as a form -->
	                                <button class="btn btn-lg btn-success btn-block"><spring:message code="label.inicioSesion.enviar"/></button>
	                            </fieldset>
	                        </form>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div><!--loginwrapper-->

<script type="text/javascript">
jQuery(document).ready(function(){
	
	var anievent = (jQuery.browser.webkit)? 'webkitAnimationEnd' : 'animationend';
	jQuery('.loginwrap').bind(anievent,function(){
		jQuery(this).removeClass('animate2 bounceInDown');
	});
	
	jQuery('#username,#password').focus(function(){
		if(jQuery(this).hasClass('error')) jQuery(this).removeClass('error');
	});
	
	jQuery('#loginform button').click(function(){
		if(!jQuery.browser.msie) {
			if(jQuery('#username').val() == '' || jQuery('#password').val() == '') {
				if(jQuery('#username').val() == '') jQuery('#username').addClass('error'); else jQuery('#username').removeClass('error');
				if(jQuery('#password').val() == '') jQuery('#password').addClass('error'); else jQuery('#password').removeClass('error');
				jQuery('.loginwrap').addClass('animate0 wobble').bind(anievent,function(){
					jQuery(this).removeClass('animate0 wobble');
				});
			} else {
				jQuery('.loginwrapper').addClass('animate0 fadeOutUp').bind(anievent,function(){
					jQuery('#loginform').submit();
				});
			}
			return false;
		}
	});
});
</script>

</body>
</html>



<?xml version="1.0" encoding="iso-8859-1" ?>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt' %>

<html>
  <head>
    <title>Acesso ao Sistema</title>
	<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
	<link href="styles/padrao.css" rel="stylesheet" type="text/css" />
	<link href="styles/skin-default.css" rel="stylesheet" type="text/css" />  
	<style type="text/css">
		.yui-skin-sam .yui-layout-top {
		        background-color:#000000;
		}
		.yui-skin-sam .yui-layout-menu {
		        background-color:#FFFFFF;
		}    
		.ui-dock-container-top
		{
		   background-image: none;
		   background-color: #000000;
		   border-color: #000000;
		}  
	</style>	
  </head>
 
  <body class="yui-skin-sam">
 
	<table border="0" align="center" width="100%" style="height: 100px;" bgcolor="#000000">
	<tr>
		<td align="center" valign="top">
			<div align="center">
			</div>
		</td>
		<td align="right" width="150">
			<form>
				<a href="http://www.elaw.com.br" title="Clique Aqui para Visualizar o Site da Elaw" alt="Clique Aqui para Visualizar o Site da Elaw">
					<img src="img/logo/elaw.png" />
				</a>
							
			</form>
		</td>
	</tr>
	</table>
	
    <div id="login" align="center">
	 	<br/>
	 	
	 	<c:if test="${not empty param.login_error}">
	      <font color="red">
		      Usuario ou senha invalidos.<br/><br/>
		      Retorno: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
	      </font>
	    </c:if>
	    
	    <form name="f" action="<c:url value='j_spring_security_check'/>" method="post">
	    <input type="hidden" name="domain" value="${param.domain}"/>
	      <table>
	        <tr><td>Usuario:</td><td><input type='text' name='j_username' value=''/></td></tr>
	        <tr><td>Senha:</td><td><input type='password' name='j_password'></td></tr>
	        
	        <tr><td colspan='2'><input name="submit" type="submit" value="Acessar"></td></tr>
	        <tr><td colspan='2'><input name="reset" type="reset" value="Limpar"></td></tr>
	      </table>
	    </form>
    </div>
  </body>
</html>
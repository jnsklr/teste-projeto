<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teste Pessoa</title>
</head>
<body>
	<f:view>

		<h:form>
		<h:commandLink value="Lista pessoas" action="pessoa/lista" />
		<br />
		<h:commandLink value="Lista telefones" action="telefone/lista" />
		</h:form>

	</f:view>
</body>
</html>
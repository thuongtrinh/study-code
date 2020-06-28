<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts_Tag_Example</title>
</head>
<body>F
	<hr>
	<html:form action="/htmlTag1">
		<p>WriteTag</p>
		<bean:write name="html_Tag_1Form" property="muaHienTai"/>
		<hr>
		
		<p>DefineTag</p>
		<bean:define id="x" name="html_Tag_1Form" property="muaHienTai"></bean:define>
		<bean:write name="x"/>
		<bean:define id="y" name="html_Tag_1Form" property="pair2"></bean:define>
		<bean:write name="y" property="id"/> + <bean:write name="y" property="name"/>
		<hr>
		
	</html:form>
	<hr>
</body>
</html>
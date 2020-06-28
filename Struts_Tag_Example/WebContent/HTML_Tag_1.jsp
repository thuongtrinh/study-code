<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<body>
	<hr>
	<html:form action="/htmlTag1">
		<p>html:form</p>
	</html:form>
	<hr>
	<html:form action="/htmlTag1">
		<p>TextTag</p>
		<html:text property="textTag" maxlength="10"></html:text>
		<hr>

		<p>TextareaTag</p>
		<html:textarea property="textTag" cols="50" rows="4"></html:textarea>
		<hr>

		<p>PasswordTag</p>
		<html:password property="textTag"></html:password>
		<hr>

		<p>HiddenTag</p>
		<html:hidden property="textTag"></html:hidden>
		<hr>

		<p>ButtonTag</p>
		<html:button property="textTag" value="ButtonTag"></html:button>
		<hr>

		<p>ResetTag</p>
		<html:reset property="textTag" value="ResetTag"></html:reset>
		<hr>

		<p>SubmitTag</p>
		<html:reset property="textTag" value="SubmitTag"></html:reset>
		<hr>

		<p>FileTag</p>
		<html:file property="textTag" value="FileTag"></html:file>
		<hr>

		<p>ImageTag</p>
		<html:image property="textTag" src="1.jpg"></html:image>
		<hr>

		<p>ImgTag</p>
		<html:img src="1.jpg" height="100px" width="100px" imageName="textTag"></html:img>

	</html:form>
	<hr>
</body>
</html>
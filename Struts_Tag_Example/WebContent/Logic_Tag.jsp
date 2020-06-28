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
<body>
	<hr>
	<html:form action="/htmlTag1">
		<p>IterateTag</p>
		<logic:iterate id="x" name="html_Tag_1Form" property="mua">
			<bean:write name="x"/>
		</logic:iterate>
		<logic:iterate id="x" name="html_Tag_1Form" property="pair">
			<bean:write name="x" property="id"/> + <bean:write name="x" property="name"/>
		</logic:iterate>
		<hr>
		
		<p>EmptyTag + NotEmptyTag</p>
		<logic:empty name="html_Tag_1Form" property="muaHienTai">
			Empty
		</logic:empty>
		<logic:notEmpty name="html_Tag_1Form" property="muaHienTai">
			Not Empty
		</logic:notEmpty>
		<hr>
		
		<p>EqualTag + NotEqualTag</p>
		<logic:equal name="html_Tag_1Form" property="muaHienTai" value="Dong">
			Equal
		</logic:equal>
		<logic:notEqual name="html_Tag_1Form" property="muaHienTai" value="Dong">
			Not Equal
		</logic:notEqual>
		<hr>
		
		<p>GreaterEqualTag</p>
		<logic:greaterEqual name="html_Tag_1Form" property="muaHienTai" value="Dong">
			GreaterEqual
		</logic:greaterEqual>
		<hr>
		
		<p>GreaterThanTag</p>
		<logic:greaterThan name="html_Tag_1Form" property="muaHienTai" value="Dong">
			GreaterThan
		</logic:greaterThan>
		<hr>
		
		<p>MatchTag + NotMatchTag</p>
		<logic:match name="html_Tag_1Form" property="muaHienTai" value="ng">
			Match
		</logic:match>
		<logic:notMatch name="html_Tag_1Form" property="muaHienTai" value="ng">
			Not Match
		</logic:notMatch>
		<hr>
		
		<p>PresentTag + NotPresentTag</p>
		<logic:present name="html_Tag_1Form" property="muaHienTai1">
			Present
		</logic:present>
		<logic:notPresent name="html_Tag_1Form" property="muaHienTai1">
			Not Present
		</logic:notPresent>
		<hr>
		
	</html:form>
</body>
</html>
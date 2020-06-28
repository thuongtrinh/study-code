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
		<p>CheckboxTag</p>
			<html:checkbox property="textTag" value="1">Nam</html:checkbox>
			<html:checkbox property="textTag" value="0">Nữ</html:checkbox>
		<hr>
		
		<p>MultiboxTag</p>
		<logic:iterate id="x" name="html_Tag_1Form" property="mua">
			<html:multibox property="muaHienTai">
				<bean:write name="x"/>
			</html:multibox>
			<bean:write name="x"/>
		</logic:iterate>
		<hr>
		
		<p>RadioTag</p>
			<html:radio property="textTag" value="1">Nam</html:radio>
			<html:radio property="textTag" value="0">Nữ</html:radio>
		<hr>
		
		<p>LinkTag</p>
		<html:link linkName="textTag" action="/htmlTag1" target="blank">Link 1</html:link>
		<html:link linkName="textTag" href="/htmlTag1">Link 2</html:link>
		<hr>
		
		<p>SelectTag</p>
			<html:select property="textTag" value="ButtonTag">
				<html:option value="1">1</html:option>
				<html:option value="2">2</html:option>
			</html:select>
			
			<html:select property="textTag" value="ButtonTag">
				<html:options name="html_Tag_1Form" property="mua"/>
			</html:select>
			
			<html:select property="textTag" value="ButtonTag">
				<html:optionsCollection name="html_Tag_1Form" property="pair" label="name" value="id"/>
			</html:select>
		
	</html:form>
	<hr>
</body>
</html>
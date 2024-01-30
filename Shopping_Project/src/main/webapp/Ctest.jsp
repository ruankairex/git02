<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL Core Tags Test</title>
</head>
<body>

<h2>JSTL Core Tags Test</h2>

<c:set var="message" value="Hello, JSTL!"/>

<p>Original Message: ${message}</p>

<c:out value="${message}" escapeXml="false"/>

</body>
</html>
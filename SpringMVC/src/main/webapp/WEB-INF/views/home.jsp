<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<script>
	$(document).ready(function() {
		console.log(1);
	});
</script>

<P>  The time on the server is ${pName}. </P>
<%
	
%>
</body>
</html>

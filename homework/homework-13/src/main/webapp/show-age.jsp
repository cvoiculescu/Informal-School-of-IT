<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Calculated age</title>
</head>
<body>
Calculated age in years: <%=request.getAttribute("years")%><br/>
Calculated age in days: <%=request.getAttribute("days")%><br/>
</body>
</html>

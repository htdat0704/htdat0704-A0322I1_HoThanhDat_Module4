<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<form action="/calculator" method="get">
    <input type="number" name="so1"/>
    <input type="number" name="so2"/>
    <select name="dau">
        <option value="+">+</option>
        <option value="-">-</option>
        <option value="*">*</option>
        <option value="/">/</option>
    </select>
    <input type="submit" value="tính">
</form>
<c:if test="${result != 0}">
    <p >Result: ${result}</p>
</c:if>
</body>
</html>
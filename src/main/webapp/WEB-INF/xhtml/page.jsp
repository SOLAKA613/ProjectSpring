<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
    <tr>
      <th>Département</th>
      <th>Nom</th>
      <th>Age</th>
    </tr>
    <c:forEach items="${Information}" var="testItem">
        <tr>
           <td><c:out value="${testItem.nom}"/></td>
           <td><c:out value="${testItem.employee.nom}"/></td>
           <td><c:out value="${testItem.employee.age}"/></td>
        </tr>
    </c:forEach>
 </table>

    <p>the list of employees working in the IT department are ${Informatique} </p>
</body>
</html>
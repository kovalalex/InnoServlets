<%--
  Created by IntelliJ IDEA.

  Date: 20.12.2019
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<table class="table table-dark">
    <tbody>
    <c:forEach var="m" items="${mobiles}">
        <tr id="mobile${m.id }">
            <th scope="row">${m.id }</th>
            <td> ${m.model}</td>
            <td><fmt:formatNumber value="${m.price }" type="currency" currencyCode="USD"/></td>
            <td>${m.manufacturer }</td>
            <td><a href="edit?id=${m.id }">Ред.</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

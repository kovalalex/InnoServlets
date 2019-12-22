<%--
  Created by IntelliJ IDEA.
  User: nastya
  Date: 20.12.2019
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:forEach var="m" items="${mobile }">
    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xlg-2">
        <div id="mobile${mobile.id }" class="panel panel-default product">
            <h2>${fn:toUpperCase(m.name) }</h2>
            <div class="model">Price:
                <fmt:formatNumber value="${m.price }" type="currency" currencyCode="USD" />
            </div>
            <div class="model">Model:
                ${m.model}
            </div>
            <div class="manufacture">manufacture: ${m.manufacture }
            </div>
        </div>
    </div>
</c:forEach>

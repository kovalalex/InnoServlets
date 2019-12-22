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

<form method="post" action="edit">
    <div class="form-group">
        <label for="model">Модель</label>
        <input type="text" id="model" class="form-control" name="model" value="${mobile.model}">

    </div>
    <div class="form-group">
        <label for="price">Цена</label>
        <input type="text" id="price" class="form-control" name="price" value="${mobile.price}">

    </div>
    <div class="form-group">
        <label for="manufacturer">Производитель</label>
        <input type="text" class="form-control" id="manufacturer" name="manufacturer" value="${mobile.manufacturer}">
    </div>
    <input type="hidden" id="id" name="id" value="${mobile.id}">
    <button type="submit" class="btn btn-primary">Изменить</button>
</form>

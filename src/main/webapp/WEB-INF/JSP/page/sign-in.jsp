<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form method="post" action="sign-in">
    <div class="form-group">
        <label for="name">Имя</label>
        <input type="text" id="name" class="form-control" name="name" value="${mobile.model}">
        <small id="nameHelp" class="form-text text-muted">по умолчанию: user</small>
    </div>
    <div class="form-group">
        <label for="pass">Пароль</label>
        <input type="password" id="pass" class="form-control" name="password" value="${mobile.price}">
        <small id="passHelp" class="form-text text-muted">по умолчанию: user</small>

    </div>

    <button type="submit" class="btn btn-primary">Войти</button>
</form>

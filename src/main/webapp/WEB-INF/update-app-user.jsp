<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Update app user</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 id="update_user_title">Modifier un utilisateur</h1>

<form id="add_user_form" method="post" action="/app-users/update">

  <input type="hidden" name="appUserId" value="${appUser.appUserId}">

  <label for="nickname">Pseudo</label>
  <input id="nickname" type="text" name="nickname" placeholder="Pseudo" value="${appUser.nickname}" required>

  <label for="firstName">Prénom</label>
  <input id="firstName" type="text" name="firstName" placeholder="Prénom" value="${appUser.firstName}" required>

  <label for="lastName">Nom de famille</label>
  <input id="lastName" type="text" name="lastName" placeholder="Nom de famille" value="${appUser.lastName}" required>

  <label for="address">Adresse</label>
  <input id="address" type="text" name="address" placeholder="Adresse" value="${appUser.address}" required>

  <label for="postcode">Code postal</label>
  <input id="postcode" type="number" name="postcode" placeholder="Code postal" value="${appUser.postcode}" required>

  <label for="city">Ville</label>
  <input id="city" type="text" name="city" value="${appUser.city}" placeholder="ville" required>

  <label for="phoneNumber">Téléphone</label>
  <input id="phoneNumber" type="text" name="phoneNumber" placeholder="Téléphone" value="${appUser.phoneNumber}" required>

  <label for="email">Email</label>
  <input id="email" type="email" name="email" placeholder="Email" value="${appUser.email}" required>

  <label for="password">Mot de passe</label>
  <input id="password" type="text" name="password" placeholder="Mot de passe" value="${appUser.password}" required>

  <fieldset>
    <div>
      <input type="radio" id="admin" name="isAdmin" value="true" ${appUser.isAdmin ? "checked" : null}>
      <label for="admin">Admin</label>
    </div>
    <div>
      <input type="radio" id="user" name="isAdmin" value="false" ${!appUser.isAdmin ? "checked" : null}>
      <label for="user">Utilisateur</label>
    </div>
  </fieldset>

  <button id="add_user_form_button">Modifier</button>
</form>

<form id="delete_user_form" method="post" action="${pageContext.request.contextPath}/app-users/delete">
  <input type="hidden" value="${appUser.appUserId}" name="appUserId">
  <button id="delete_user_btn">Supprimer l'utilisateur</button>
</form>

</body>
</html>
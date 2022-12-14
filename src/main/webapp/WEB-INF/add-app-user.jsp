<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add form</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 id="add_user_title">Ajouter un utilisateur / admin</h1>

<form id="add_user_form" method="post" action="/app-users/add">
  <label for="nickname">Pseudo</label>
  <input id="nickname" type="text" name="nickname" placeholder="Pseudo" required>

  <label for="firstName">Prénom</label>
  <input id="firstName" type="text" name="firstName" placeholder="Prénom" required>

  <label for="lastName">Nom de famille</label>
  <input id="lastName" type="text" name="lastName" placeholder="Nom de famille" required>

  <label for="address">Adresse</label>
  <input id="address" type="text" name="address" placeholder="Adresse" required>

  <label for="postcode">Code postal</label>
  <input id="postcode" type="number" name="postcode" placeholder="Code postal" required>

  <label for="city">Ville</label>
  <input id="city" type="text" name="city" placeholder="ville" required>

  <label for="phoneNumber">Téléphone</label>
  <input id="phoneNumber" type="text" name="phoneNumber" placeholder="Téléphone" required>

  <label for="email">Email</label>
  <input id="email" type="email" name="email" placeholder="Email" required>

  <label for="password">Mot de passe</label>
  <input id="password" type="text" name="password" placeholder="Mot de passe" required>

  <fieldset>
    <div>
      <input type="radio" id="admin" name="isAdmin" value="true">
      <label for="admin">Admin</label>
    </div>
    <div>
      <input type="radio" id="user" name="isAdmin" value="false" checked>
      <label for="user">Utilisateur</label>
    </div>
  </fieldset>

  <button id="add_user_form_button">Ajouter un utilisateur / admin</button>
</form>

</body>
</html>

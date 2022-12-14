<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Users list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 id="user_list_title">Liste des utilisateurs</h1>

<div id="add_user">
    <a class="btn btn-success"
       href="${pageContext.request.contextPath}/app-users/add">Ajouter un utilisateur</a>
</div>

<c:forEach items="${appUserList}" var="appUser">
    <div class="user_card">
        <div class="user_details">
            <ul>
                <li>Pseudo : ${appUser.nickname}</li>
                <li>Prénom : ${appUser.firstName}</li>
                <li>Nom de famille : ${appUser.lastName}</li>
            </ul>
            <ul>
                <li>Adresse : ${appUser.address}</li>
                <li>Code postal : ${appUser.postcode}</li>
                <li>Ville : ${appUser.city}</li>
                <li>Tel. : ${appUser.phoneNumber}</li>
                <li>Email : ${appUser.email}</li>
                <li>User_Id : ${appUser.appUserId}</li>
            </ul>
        </div>
        <form id="update_user_form" method="get" action="${pageContext.request.contextPath}/app-users/update">
            <input type="hidden" value="${appUser.appUserId}" name="appUserId">
            <button class="update_user_btn">Modifier</button>
        </form>
    </div>
</c:forEach>

</body>
</html>


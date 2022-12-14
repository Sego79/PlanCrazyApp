<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admins list</title>
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<h1 id="user_list_title">Liste des admins</h1>

<div id="add_user">
    <a class="btn btn-success"
       href="${pageContext.request.contextPath}/app-users/add">Ajouter un admin</a>
</div>

<c:forEach items="${adminList}" var="admin">
    <div class="user_card admin_card">
        <div class="user_details">
            <ul>
                <li>Pseudo : ${admin.nickname}</li>
                <li>Prénom : ${admin.firstName}</li>
                <li>Nom de famille : ${admin.lastName}</li>
            </ul>
            <ul>
                <li>Adresse : ${admin.address}</li>
                <li>Code postal : ${admin.postcode}</li>
                <li>Ville : ${admin.city}</li>
                <li>Tel. : ${admin.phoneNumber}</li>
                <li>Email : ${admin.email}</li>
                <li>User_Id : ${admin.appUserId}</li>
            </ul>
        </div>
        <form id="update_user_form" method="get" action="${pageContext.request.contextPath}/app-users/update">
            <input type="hidden" value="${admin.appUserId}" name="appUserId">
            <button class="update_user_btn admin-btn">Modifier</button>
        </form>
    </div>
</c:forEach>

</body>
</html>


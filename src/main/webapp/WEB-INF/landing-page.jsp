<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Plan Crazy App</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<h1 id="landing_page_title">Menu principal</h1>

<div id="landing_page_container">
    <form id="link" method="get" action="${pageContext.request.contextPath}/app-users">
        <button id="link_btn">Liste des utilisateurs</button>
    </form>
    <form id="delete_user_form" method="get" action="${pageContext.request.contextPath}/admins">
        <button id="link_btn">Liste des admins</button>
    </form>

</div>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>${param.get("title")}</title>

<link rel="stylesheet" href = "../../resources/styles/styles.css">

<a href="index.jsp">Home</a>

<a href="<c:url value="/admin/user-list"/>">Users</a>|
<a href="<c:url value="/admin/category-list"/>">Categories</a>|
<a href="<c:url value="/profile/profile-view"/>">Profile</a><br>

<h1>${param.get("title")}</h1>

<div class="header">

</div>

<div class="content">


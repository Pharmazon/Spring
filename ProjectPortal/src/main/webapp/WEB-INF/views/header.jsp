<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<title>${param.get("title")}</title>

<link rel="stylesheet" href = "../../resources/styles/styles.css">

<h1>${param.get("title")}</h1>

<div class="header">
    <div class="headerChild">
        <a href="index.jsp">Home</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/admin/user-list"/>">User</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/admin/category-list"/>">Category</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/profile/profile-view"/>">Profile</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/profile/profile-view"/>">Log out</a>
    </div>
</div>

<div class="content">


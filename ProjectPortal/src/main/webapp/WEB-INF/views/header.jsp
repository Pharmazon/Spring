<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href = "../../resources/styles/styles.css">

<title>${param.get("title")}</title>

<div class="header">
    <div class="headerChild">
        <a href="/">Home</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/profile/ad-list"/>">Ads</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/admin/user-list"/>">User</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/admin/category-list"/>">Categories</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/profile/profile-view"/>">Profile</a>
    </div>
    <div class="headerChild">
        <a href="<c:url value="/logout"/>">Log out</a>
    </div>
</div>

<div class="content">
    <h1>${param.get("title")}</h1>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div class="header">

    <div class="headerChild">
        <a href="/">Home</a>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <div class="headerChild">
            <a href="<c:url value="/login"/>">Login</a>
        </div>
    </sec:authorize>

    <sec:authorize access="hasRole('ADMINISTRATOR')">
        <div class="headerChild">
            <a href="<c:url value="/admin/user-list"/>">Users</a>
        </div>
        <div class="headerChild">
            <a href="<c:url value="/admin/category-list"/>">Categories</a>
        </div>
    </sec:authorize>
    
    <sec:authorize access="isAuthenticated()">
        <div class="headerChild">
            <a href="<c:url value="/profile/ad-list"/>">Ads</a>
        </div>
        <div class="headerChild">
            <a href="<c:url value="/profile/profile-edit"/>">Profile</a>
        </div>
        <div class="headerChild">
            <a href="<c:url value="/logout"/>">Log out</a>
        </div>
    </sec:authorize>

</div>

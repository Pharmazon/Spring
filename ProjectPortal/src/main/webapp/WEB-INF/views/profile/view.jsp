<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../header.jsp" />

<title>User profile</title>

<h1>USER PROFILE</h1>

<table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="200" align="left" nowrap="nowrap">CAPTION</th>
        <th width="400" align="left" nowrap="nowrap">VALUE</th>
    </tr>

    <tr>
        <td>Login</td>
        <td>${userProfile.user.login}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${userProfile.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${userProfile.lastName}</td>
    </tr>
    <tr>
        <td>Date registered</td>
        <td>${userProfile.formattedDateTime}</td>
    </tr>
    <tr>
        <td>E-mail</td>
        <td>${userProfile.email}</td>
    </tr>
    <tr>
        <td>Phone</td>
        <td>${userProfile.phone}</td>
    </tr>
    <tr>
        <td>Company</td>
        <td>${userProfile.company.name}</td>
    </tr>
</table>
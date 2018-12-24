<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../views/header.jsp" />

<title>User view</title>

<h1>DETAILED USER VIEW</h1>

<table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="200" align="left" nowrap="nowrap">CAPTION</th>
        <th width="400" align="left" nowrap="nowrap">VALUE</th>
    </tr>
    <tr>
        <td>Id</td>
        <td>${user.user.id}</td>
    </tr>
    <tr>
        <td>Login</td>
        <td>${user.user.login}</td>
    </tr>
    <tr>
        <td>First Name</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Last Name</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>E-Mail</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Phone</td>
        <td>${user.phone}</td>
    </tr>
    <tr>
        <td>Date Registered</td>
        <td>${user.formattedDateTime}</td>
    </tr>
    <tr>
        <td>Role</td>
        <td>${user.role.name}</td>
    </tr>
    <tr>
        <td>Company Name</td>
        <td>${user.company.name}</td>
    </tr>
    <tr>
        <td>Company Address</td>
        <td>${user.company.address}</td>
    </tr>
    <tr>
        <td>Company Description</td>
        <td>${user.company.description}</td>
    </tr>
</table>
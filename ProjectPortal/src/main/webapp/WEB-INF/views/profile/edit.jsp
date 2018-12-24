<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp" />

<title>Edit user</title>

<h1>EDIT USER</h1>

<form:form method="post" action="/userprofile-save" modelAttribute="userProfile">
    <form:hidden path="id" />
    <form:hidden path="name" />
    <form:hidden path="user.id" />
    <form:hidden path="user.name" />
    <form:hidden path="user.login" />
    <form:hidden path="user.password" />
    <form:hidden path="email" />
    <form:hidden path="dateRegistered" />
    <form:hidden path="company.id" />
    <form:hidden path="company.name" />
    <form:hidden path="company.description" />
    <form:hidden path="role.id" />
    <form:hidden path="role.name" />

    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
        <tr>
            <th width="200" align="left" nowrap="nowrap">CAPTION</th>
            <th width="300" align="left" nowrap="nowrap">VALUE</th>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LOGIN</td>
            <td>${userProfile.user.login}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">FIRST NAME</td>
            <form:input path="firstName" />
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LAST NAME</td>
            <form:input path="lastName" />
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">E-MAIL</td>
            <td>${userProfile.email}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PHONE</td>
            <form:input path="phone" />
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">DATE REGISTRATION</td>
            <td>${userProfile.formattedDateTime}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY NAME</td>
            <td>${userProfile.company.name}</td>
        </tr>
    </table>

</form:form>
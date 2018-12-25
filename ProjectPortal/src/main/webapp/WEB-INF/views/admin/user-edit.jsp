<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="User edit" />
</jsp:include>

<form:form method="post" action="/user-save" modelAttribute="user">
    <form:hidden path="id" />
    <form:hidden path="name" />
    <form:hidden path="user.id" />
    <form:hidden path="user.name" />
    <form:hidden path="user.login" />
    <form:hidden path="user.password" />
    <form:hidden path="firstName" />
    <form:hidden path="lastName" />
    <form:hidden path="email" />
    <form:hidden path="phone" />
    <form:hidden path="dateRegistered" />
    <form:hidden path="company.id" />
    <form:hidden path="company.name" />
    <form:hidden path="company.description" />

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
            <td align="left" style="padding-right: 10px">ID</td>
            <td>${user.id}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">NAME</td>
            <td>${user.name}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LOGIN</td>
            <td>${user.user.login}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">FIRST NAME</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LAST NAME</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">E-MAIL</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PHONE</td>
            <td>${user.phone}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">DATE REGISTRATION</td>
            <td>${user.formattedDateTime}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY NAME</td>
            <td>${user.company.name}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY ADDRESS</td>
            <td>${user.company.address}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY DESCRIPTION</td>
            <td>${user.company.description}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">ROLE</td>
            <td>
                <form:select path="role.id" size="1">
                    <form:option value="---Select role:---" disabled="true" />
                    <form:options items="${roles}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">ENABLED</td>
            <td>${user.company.description}</td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />
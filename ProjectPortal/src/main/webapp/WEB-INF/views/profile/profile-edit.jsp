<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Profile" />
</jsp:include>

<form:form method="post" action="/profile/profile-save" modelAttribute="user">
    <sec:csrfInput/>

    <form:hidden path="id" />
    <form:hidden path="name" />
    <form:hidden path="dateRegistered" />
    <form:hidden path="email" />
    <form:hidden path="role.id" />
    <form:hidden path="user.id" />

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
            <td>${user.user.login}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">FIRST NAME</td>
            <td>
                <form:input path="firstName" />
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LAST NAME</td>
            <td>
                <form:input path="lastName" />
            </td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">E-MAIL</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PHONE</td>
            <td>
                <form:input path="phone" />
            </td>
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
            <td align="left" style="padding-right: 10px">COMPANY NAME</td>
            <td>${user.company.description}</td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />
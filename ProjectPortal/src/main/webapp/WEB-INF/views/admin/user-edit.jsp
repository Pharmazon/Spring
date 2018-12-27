<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="User edit" />
</jsp:include>

<form:form method="post" action="/admin/user-save" modelAttribute="userProfile">
    <form:hidden path="id" />
    <form:hidden path="user.id" />

    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="save" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
        <tr>
            <th width="200" align="left" nowrap="nowrap">CAPTION</th>
            <th width="300" align="left" nowrap="nowrap">VALUE</th>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">ID</td>
            <td>${userProfile.id}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">NAME</td>
            <td>${userProfile.name}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LOGIN</td>
            <td>${userProfile.user.login}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">FIRST NAME</td>
            <td>${userProfile.firstName}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">LAST NAME</td>
            <td>${userProfile.lastName}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">E-MAIL</td>
            <td>${userProfile.email}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PHONE</td>
            <td>${userProfile.phone}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">DATE REGISTRATION</td>
            <td>${userProfile.formattedDateTime}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY NAME</td>
            <td>${userProfile.company.name}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY ADDRESS</td>
            <td>${userProfile.company.address}</td>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">COMPANY DESCRIPTION</td>
            <td>${userProfile.company.description}</td>
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
            <td>
                <form:select path="user.enabled" size="1">
                    <form:option value="true" />
                    <form:option value="false" />
                </form:select>
            </td>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />
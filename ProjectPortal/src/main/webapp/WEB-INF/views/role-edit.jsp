<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp" />

<title>Role edit</title>

<h1>EDIT CATEGORY</h1>

<form:form method="post" action="/role-save" modelAttribute="role">
    <p>
        <button type="submit">
            <img src="../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>
    <table width="60%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:hidden path="id" />
                <form:input path="name" size="50" />
            </td>
        </tr>
    </table>
</form:form>
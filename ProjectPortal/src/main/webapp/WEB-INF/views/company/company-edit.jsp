<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/company-list">
    <button type="submit">
        <img src="../../../resources/images/icons/icon_back.png" alt="add" width="20"/>
    </button>
</form>

<h1>EDIT COMPANY</h1>

<form:form method="post" action="/company-save" modelAttribute="company">
    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>
    <table width="80%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:hidden path="id" />
                <form:input path="name" size="50"/>
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">DESCRIPTION</td>
            <td>
                <form:input path="description" size="50" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">ADDRESS</td>
            <td>
                <form:input path="address" size="50" />
            </td>
        </tr>
    </table>
</form:form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/company-list">
    <button type="submit">BACK</button>
</form>

<h1>ADD COMPANY</h1>

<form:form method="post" action="/company-create" modelAttribute="company" >
    <table width="80%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:input path="name" size="50" />
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
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>

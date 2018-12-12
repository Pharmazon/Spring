<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h1>EDIT AD</h1>

<form:form method="post" action="/ad-save" modelAttribute="ad">
    <table width="60%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:input path="name" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CONTENT</td>
            <td>
                <form:input path="content" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NUMBER</td>
            <td>
                <form:input path="number" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CATEGORY</td>
            <td>
                <form:input path="category.name" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">COMPANY</td>
            <td>
                <form:input path="company.name" />
            </td>
        </tr>
    </table>
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/ad-list">
    <button type="submit">BACK</button>
</form>

<h1>EDIT AD</h1>

<form:form method="post" action="/ad-save" modelAttribute="ad">
    <table width="80%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:hidden path="id" />
                <form:input path="name" size="50" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CONTENT</td>
            <td>
                <form:input path="content" size="50" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NUMBER</td>
            <td>
                <form:input path="number" size="50" />
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CATEGORY</td>
            <td>
                <form:select path="category.id" size="1">
                    <form:option value="---Select category:---" disabled="true" />
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">COMPANY</td>
            <td>
                <form:select path="company.id" size="1" >
                    <form:option value="---Select company:---" disabled="true" />
                    <form:options items="${companies}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
    </table>
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>
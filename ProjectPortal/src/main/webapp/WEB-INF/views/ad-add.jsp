<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/ad-list">
    <button type="submit">BACK</button>
</form>

<h1>ADD NEW AD</h1>

<form:form method="post" action="/ad-create" modelAttribute="newAd">
    <table width="80%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <input type="text" name="name" size="50">
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CONTENT</td>
            <td>
                <input type="text" name="content" size="50">
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NUMBER</td>
            <td>
                <input type="text" name="number" size="50">
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">CATEGORY</td>
            <td>
                <form:select path="category" size="1">
                    <form:option value="---Select category:---" disabled="true" hidden="true" />
                    <form:options items="${categories}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">COMPANY</td>
            <td>
                <form:select path="company" size="1">
                    <form:option value="---Select company:---" disabled="true" hidden="true" />
                    <form:options items="${companies}" itemValue="id" itemLabel="name" />
                </form:select>
            </td>
        </tr>
    </table>
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>

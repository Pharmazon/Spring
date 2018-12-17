<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/ad-list">
    <button type="submit">
        <img src="../../../resources/images/icons/icon_back.png" alt="add" width="20"/>
    </button>
</form>

<h1>DETAILED AD VIEW</h1>

<table width="60%" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="120" align="center" nowrap="nowrap">CAPTION</th>
        <th width="100%" align="center" nowrap="nowrap">VALUE</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${ad.id}</td>
    </tr>
    <tr>
        <td>DATE</td>
        <td>${ad.date}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${ad.name}</td>
    </tr>
    <tr>
        <td>CONTENT</td>
        <td>${ad.content}</td>
    </tr>
    <tr>
        <td>NUMBER</td>
        <td>${ad.number}</td>
    </tr>
    <tr>
        <td>CATEGORY</td>
        <td>${ad.category.name}</td>
    </tr>
    <tr>
        <td>COMPANY</td>
        <td>${ad.company.name}</td>
    </tr>
</table>
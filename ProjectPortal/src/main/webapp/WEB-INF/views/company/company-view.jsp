<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/company-list">
    <button type="submit">
        <img src="../../../resources/images/icons/icon_back.png" alt="add" width="20"/>
    </button>
</form>

<h1>DETAILED COMPANY VIEW</h1>

<table width="60%" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="120" align="center" nowrap="nowrap">CAPTION</th>
        <th width="100%" align="center" nowrap="nowrap">VALUE</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${company.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${company.name}</td>
    </tr>
    <tr>
        <td>DESCRIPTION</td>
        <td>${company.description}</td>
    </tr>
    <tr>
        <td>ADDRESS</td>
        <td>${company.address}</td>
    </tr>
</table>
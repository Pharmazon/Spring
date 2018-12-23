<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp" />

<title>Role view</title>

<h1>DETAILED ROLE VIEW</h1>

<table class="viewTable" width="60%" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
    <tr>
        <th width="120" align="left" nowrap="nowrap">CAPTION</th>
        <th width="100%" align="left" nowrap="nowrap">VALUE</th>
    </tr>
    <tr>
        <td>ID</td>
        <td>${role.id}</td>
    </tr>
    <tr>
        <td>NAME</td>
        <td>${role.name}</td>
    </tr>
</table>
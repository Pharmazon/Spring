<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form action="/category-list">
    <button type="submit">
        <img src="../../../resources/images/icons/icon_back.png" alt="add" width="20"/>
    </button>
</form>

<h1>ADD CATEGORY</h1>

<form:form method="post" action="/category-create" modelAttribute="category">
    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>
    <table width="80%" cellspacing="0" cellpadding="0" border="0" style="margin-bottom: 5px">
        <tr>
            <td width="10%" align="left" style="padding-right: 10px">NAME</td>
            <td>
                <form:input path="name" size="50" />
            </td>
        </tr>
    </table>
</form:form>

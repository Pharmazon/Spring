<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Edit category" />
</jsp:include>

<form:form method="post" action="/category-save" modelAttribute="category">
    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
        <tr>
            <th width="200" align="left" nowrap="nowrap">CAPTION</th>
            <th width="300" align="left" nowrap="nowrap">VALUE</th>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PARENT-CATEGORY</td>
            <form:select path="id" size="1">
                <form:option value="---Select parent:---" disabled="true" />
                <form:options items="${categories}" itemValue="id" itemLabel="name" />
            </form:select>
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">SUB-CATEGORY</td>
            <form:input path="name" />
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />
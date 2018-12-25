<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../header.jsp">
    <jsp:param name="title" value="Add category" />
</jsp:include>

<form:form method="post" action="/category-create" modelAttribute="category">
    <p>
        <button type="submit">
            <img src="../../../resources/images/icons/icon_save.png" alt="add" width="20"/>
        </button>
    </p>

    <table class="viewTable" cellspacing="0" cellpadding="0" border="1" style="margin-bottom: 5px">
        <tr>
            <td align="left" style="padding-right: 10px">CATEGORY</td>
            <form:input path="name" />
        </tr>
        <tr>
            <td align="left" style="padding-right: 10px">PARENT</td>
            <form:select path="id" size="1">
                <form:option value="---Select parent:---" disabled="true" />
                <form:options items="${categories}" itemValue="id" itemLabel="name" />
            </form:select>
        </tr>
    </table>
</form:form>

<jsp:include page="../footer.jsp" />
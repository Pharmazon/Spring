<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="EDIT AD" />
</jsp:include>

<h1>EDIT AD</h1>

<form:form method="post" action="/ad-save" modelAttribute="ad">
    <p>
        <div style="margin-bottom: 5px">NAME</div>
        <form:input path="name" />
    </p>
    <p>
        <div style="margin-bottom: 5px">DESCRIPTION</div>
        <form:input path="description" />
    </p>
    <p>
        <button type="submit">SAVE</button>
    </p>
</form:form>

<jsp:include page="footer.jsp" />
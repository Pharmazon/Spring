<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="Main" />
</jsp:include>

<sec:authorize access="isAnonymous()">
    <b>Hello, my ANONYMOUS friend! </b><br>
    <b>Please, authorize to let me know you!</b><br>
</sec:authorize>

<sec:authorize access="isAuthenticated()">
    <h2>Welcome, <c:out value="${username}"/>!</h2>
</sec:authorize>

<sec:authorize access="hasAuthority('USER')">
    <h3>You authorized as USER.</h3><br>
</sec:authorize>

<sec:authorize access="hasAuthority('ADMINISTRATOR')">
    <h3>You authorized as ADMINISTRATOR.</h3><br>
</sec:authorize>

<sec:authorize access="hasAuthority('MANAGER')">
    <h3>You authorized as MANAGER.</h3><br>
</sec:authorize>

<jsp:include page="footer.jsp" />
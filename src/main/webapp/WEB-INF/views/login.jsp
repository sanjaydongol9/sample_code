<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>Login | Cubic Report App</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous" />
<style type="text/css">
.loginform {
	width: 350px;
	margin: 150px auto;
	padding: 25px 30px;
	font-family: sans-serif;
	color: #333;
}

.loginform h1 {
	margin: 0px 0px 20px 0px;
	font-size: 27px;
}

.loginform .btn-primary, .loginform .btn-success {
	width: 100%;
	color: #fff;
	padding: 10px;
	margin:5px 0px;
}

.loginform .btn-primary {
	background: #D4001C;
	border: 1px solid #D4001C;
}

#logo {
	padding-bottom: 15px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 30px;
}

.loginform p {
	color: #666;
	margin-bottom: 15px;
}
</style>
</head>
<body>
	<div class="loginform">
		<div id="logo">
			<img src="${pageContext.request.contextPath}/resources/images/cubic-ipm.jpg" alt="Cubic App" />
		</div>
		<p>Login to Cubic App</p>
		<%-- <span class="text-danger" th:if="${param.error}">Invalid username
			and password.</span>
		<span class="text-danger" th:if="${param.logout}">You have been
			logged out.</span> --%>
			
		<c:if test="${not empty error}">
					<span class="text-danger">${error}</span>
		</c:if>

		<form action="<c:url value='/postLogin' />" method="post">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Email"
					id="username" name="username" />
			</div>
			<div class="form-group">
				<input type="password" name="password" class="form-control"
					placeholder="Password" id="password"/>
			</div>
			
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
			
			<button type="submit" class="btn btn-primary">Login</button>
			<!-- <a href="signup" class="btn btn-success">Sign Up</a> -->
		</form>
	</div>
</body>
</html>
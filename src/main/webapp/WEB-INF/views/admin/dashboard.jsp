<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	ng-app="cubicApp"
	>
<head>
<title>Cubic Report App</title>
<!-- CSS Files -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/js/bower_components/bootstrap/dist/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/list.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/angular-material.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/js/bower_components/components-font-awesome/css/font-awesome.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/angular.treeview.css" />

<!-- Library Files  -->
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular/angular.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular-route/angular-route.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular-bootstrap/ui-bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular-bootstrap/ui-bootstrap-tpls.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular-cookies/angular-cookies.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular-ui-mask/dist/mask.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/drag-and-drop/angular-drag-and-drop-lists.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular/angular-animate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular/angular-aria.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular/angular-messages.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/angular/angular-material.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bower_components/tree/angular.treeview.js"></script>

	<!-- Angular Material Library -->

<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/userService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/userCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/alertService.js"></script>
<script src ="${pageContext.request.contextPath}/resources/js/controller/manageCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/proxyCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/candidateController.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/candidateService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/alertService.js"></script>
<script src ="${pageContext.request.contextPath}/resources/js/controller/manageCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/proxyCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/adminService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/adminCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/bCheckerCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/bCheckerService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/showProxyCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/proxyService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/alertService.js"></script>
<script src ="${pageContext.request.contextPath}/resources/js/controller/manageCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/proxyCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/adminService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/adminCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/proxyService.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/showProxyCtrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/controller/treebrowser.ctrl.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/treebrowserService.js"></script>


<style type="text/css">

#logo {
    padding: 15px 0px;
}

.username {
	color: #D4001C;
}

</style>
</head>
<body>
	<header>
		<div class="container">
			<div id="logo">
				<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Cubic App" />
			</div>
			<nav>
				<ul>
					<li><a href="#dashboard">Dashboard</a></li>
					
					<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_MASTERADMIN')">
						<li><a href="#addUser">Add User</a></li>
						<li><a href="#manage">View User</a></li>
						<li><a href="#addProxy">Add Proxy</a></li>
						<li><a href="#showProxy">Show Proxy</a></li>
						<li><a href="#technologyManage">Technology</a></li>
						<li><a href="#manage-vc-cand">Manage Candidate</a></li>
						<li><a href="#manage-marketing-vc">Manage VC</a></li>
						<li><a href="#user-hierarchical">Tree View</a></li>
					</security:authorize>
					
					<security:authorize access="hasAnyRole('ROLE_BCHECKER')">
						<li><a href="#addCandidate">Add Candidate</a></li>
						<li><a href="#listCandidate">View Candidate</a></li> 
					</security:authorize>
					
					
					<li class="pull-right"><span class="username">Welcome, <strong>
							<security:authentication property="principal.username" /></strong> !</span> 
							<a href="#profile">Setting</a> | <a href="<spring:url value="/doLogout"/>">Logout</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section id="content">
		<div class="container">
			<div ng-view=""></div>
		</div>
	</section>
	<footer>
		<div class="container">
			<p>Copyright &copy; 2015. All rights reserved at Cubic
				Technologies, LLC.</p>
		</div>
	</footer>
</body>
</html>
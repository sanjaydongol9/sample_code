<head>
<style type="text/css">
.loginform {
	width: 350px;
	margin: 50px auto;
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
	margin: 5px 0px;
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

	<div class="loginform">
		<div id="logo">
			<img src="${pageContext.request.contextPath}/resources/images/logo.png" alt="Cubic App" />
		</div>
		<p>Sign Up</p>
		<form method="post" ng-controller="SignUpController" name="userForm">
			<!-- <uib-alert ng-show="success" type="success"
				close="closeSuccessAlert()">Account created successfully. Your account is under review and will be approved by Admin soon.</uib-alert>
			<uib-alert ng-show="error" type="danger"
				close="closeErrorAlert()">{{errorMessage}}</uib-alert> -->
				
			<div class="form-group" ng-class="{ 'has-error' : userForm.firstName.$error.required && !userForm.firstName.$pristine }">
				<label for="firstName">First Name</label>
				<input type="text" class="form-control"  name="firstName" ng-model="user.firstName" required/>
				<p ng-show="userForm.firstName.$error.required && !userForm.firstName.$pristine" class="help-block">First name is required</p>
			</div>
			
			<div class="form-group">
				<label for="middleName">Middle Name</label>
				<input type="text" class="form-control" ng-model="user.middleName" />
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' : userForm.lastName.$error.required && !userForm.lastName.$pristine }">
				<label for="lastName">Last Name</label>
				<input type="text" class="form-control"  name="lastName" ng-model="user.lastName" required/>
				<p ng-show="userForm.lastName.$error.required && !userForm.lastName.$pristine" class="help-block">Last name is required.</p>
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' : userForm.email.$error.required && !userForm.email.$pristine,  
							'has-error' :!userForm.email.$error.required && userForm.email.$error.email && !userForm.email.$pristine}">
				<label for="email">Email</label>
				<input type="email" class="form-control" name="email" ng-model="user.email" required />
				<!-- <p ng-show="userForm.email.$invalid && !userForm.email.$pristine" class="help-block">Enter a valid email</p> -->
				
				<p ng-show="userForm.email.$error.required && !userForm.email.$pristine" class="help-block">Email is required</p>
   				<p ng-show="!userForm.email.$error.required && userForm.email.$error.email && !userForm.email.$pristine" class="help-block">Enter a valid email</p>
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' :userForm.username.$error.required && userForm.username.$dirty, 
								!userForm.username.$error.required && (userForm.username.$error.minlength || userForm.username.$error.maxlength) && userForm.username.$dirty}">
				<label for="username">Username</label>
       			<input type="text" class="form-control" id="username" name="username" ng-model="user.username" ng-minlength="5" ng-maxlength="15" required  />
   				<p ng-show="userForm.username.$error.required && userForm.username.$dirty">Username is required</p>
   				<p ng-show="!userForm.username.$error.required && (userForm.username.$error.minlength || userForm.username.$error.maxlength) && userForm.username.$dirty">Username must be between 5 and 15</p>
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' : userForm.password.$error.required && !userForm.password.$pristine,
								'has-error' : !userForm.password.$error.required && (userForm.password.$error.minlength || userForm.password.$error.maxlength) && !userForm.password.$pristine,
								'has-error' : !userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine}">
				<label for="password">Password</label>
				<input type="password" ng-model="user.password" class="form-control" name="password" 
								ng-minlength="5" ng-maxlength="15" ng-pattern="/(?=.*[A-Z])(?=.*[^a-zA-Z])/" required/>
				<p ng-show="userForm.password.$error.required && !userForm.password.$pristine" class="help-block">Password is required</p>
				<p ng-show="!userForm.password.$error.required && (userForm.password.$error.minlength || userForm.password.$error.maxlength) && !userForm.password.$pristine" class="help-block">Passwords must be between 5 and 15.</p>
				<p ng-show="!userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine" class="help-block">Must contain uppercase and one non-alpha character (a number or a symbol.)</p>
			</div>
			
			<div class="form-group">
			
			 <!-- ng-class="{ 'has-error' : userForm.rePassword.$error.required && !userForm.rePassword.$pristine,
			'has-error': !userForm.rePassword.$error.required && userForm.rePassword.$error.noMatch && !userForm.password.$pristine}" -->
				<!-- http://localhost:8080/cubicipm/ -->
				<label for="rePassword">Confirm Password</label>
				<input type="password" ng-model="user.rePassword" name="rePassword" id="rePassword" class="form-control" required />
				<p ng-show="userForm.rePassword.$error.required && userForm.rePassword.$dirty" class="help-block">Confirm password is required</p>
				<!-- <p ng-show="!userForm.rePassword.$error.required && userForm.rePassword.$error.noMatch && userForm.password.$dirty" class="help-block">Passwords do not match</p> -->
			</div>
			 <!-- ng-disabled="!userForm.$valid" -->
			<button type="button" class="btn btn-primary" ng-disabled="!userForm.$valid"
				ng-click="adduser(user)" >Sign Up</button>
			<a href="/login" class="btn btn-success">Login</a>
		</form>
		</div>

<head>
<style type="text/css">
.addProxyform {
	width: 350px;
	margin: 50px auto;
	padding: 25px 30px;
	font-family: sans-serif;
	color: #333;
}

.addProxyform h1 {
	margin: 0px 0px 20px 0px;
	font-size: 27px;
}

.addProxyform .btn-primary, .addProxyform .btn-success {
	width: 100%;
	color: #fff;
	padding: 10px;
	margin: 5px 0px;
}

.addProxyform .btn-primary {
	background: #D4001C;
	border: 1px solid #D4001C;
}

#logo {
	padding-bottom: 15px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 30px;
}

.addProxyform p {
	color: #666;
	margin-bottom: 15px;
}
</style>
</head>

<div class="addProxyform">
	<p>Add Proxy</p>
	<form method="post" ng-controller="proxyController" name="proxyForm">


		<div class="form-group"><!--  ng-class="{ 'has-error' : proxyForm.firstName.$error.required && !proxyForm.firstName.$pristine }" --> 
			<label for="firstName">First Name</label> <input type="text"
				class="form-control" name="firstName" ng-model="proxy.firstName"
				required />
			
			<!-- <p ng-show="proxyForm.firstName.$error.required && !proxyForm.firstName.$pristine"
				class="help-block"> </p> -->
		</div>

	 <div class="form-group">
			<label for="middleName">Middle Name</label> <input type="text"
				class="form-control" ng-model="proxy.middleName" />
		</div>

		<div class="form-group"><!-- ng-class="{ 'has-error' : proxyForm.lastName.$error.required && !proxyForm.lastName.$pristine }" -->
			<label for="lastName">Last Name</label> <input type="text"
				class="form-control" name="lastName" ng-model="proxy.lastName"
				required />
			<!-- <p
				ng-show="proxyForm.lastName.$error.required && !proxyForm.lastName.$pristine"
				class="help-block">Last name is required.</p> -->
		</div>
		<div class="form-group"
			><!-- ng-class="{ 'has-error' : proxyForm.gender.$error.required && !proxyForm.gender.$pristine }" -->
			<label for="gender">Gender</label> <select class="form-control"
				ng-model="proxy.gender" required>
				<option value="" ng-selected="selected">Choose Gender</option>
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select>
		</div>
		<div class="form-group"
			><!-- ng-class="{ 'has-error' : proxyForm.email.$error.required && !proxyForm.email.$pristine,  
							'has-error' :!proxyForm.email.$error.required && proxyForm.email.$error.email && !proxyForm.email.$pristine}" -->
			<label for="email">Email</label> <input type="email"
				class="form-control" name="email" ng-model="proxy.email" required />

			<!-- <p
				ng-show="proxyForm.email.$error.required && !proxyForm.email.$pristine"
				class="help-block">Email is required</p>
			<p
				ng-show="!proxyForm.email.$error.required && proxyForm.email.$error.email && !proxyForm.email.$pristine"
				class="help-block">Enter a valid email</p> -->
		</div>


		<div class="form-group"
			><!-- ng-class="{ 'has-error' : proxyForm.phoneNumber.$error.required && !proxyForm.phoneNumber.$pristine }" -->
			<label for="phoneNumber">Phone Number</label>
			<div>
				<div class="col-sm-4">
					<input type="text" maxlength="3" class="form-control"
						ng-model="proxy.phone.areaCode" placeholder="">

				</div>
				<div class="col-sm-4">
					<input type="text" maxlength="3" class="form-control"
						ng-model="proxy.phone.prefixValue" placeholder="">
				</div>
				<div class="col-sm-4">
					<input type="text" maxlength="4" class="form-control"
						ng-model="proxy.phone.number" placeholder="">
				</div>
			</div>
			<!-- <p
				ng-show="proxyForm.phoneNumber.$error.required && !proxyForm.phoneNumber.$pristine"
				class="help-block">Phone Number is required.</p> -->
		</div>


		<div class="form-group"
			><!-- ng-class="{ 'has-error' : proxyForm.skypeId.$error.required && !proxyForm.skypeId.$pristine }" -->
			<label for="skypeId">Skype Id</label> <input type="text"
				class="form-control" name="skypeId" ng-model="proxy.skypeId"
				required />
			<!-- <p
				ng-show="proxyForm.skypeId.$error.required && !proxyForm.skypeId.$pristine"
				class="help-block">Skype Id name is required.</p> -->
		</div>
		
		<div class="form-group" ng-class="{ 'has-error' : addProxyform.technology.$error.required && !addProxyform.technology.$pristine }">
				<label for="role">Technology</label>
				<select class ="form-control" ng-model="proxy.technology.id" >
 					<option value="" ng-selected="selected">Choose  Technology</option>  
                    <option ng:repeat="tech in technology" value="{{tech.id}}">
                	{{tech.name}}
            		</option> 
 				</select> 
 				<p ng-show="addProxyform.technology.$error.required && !addProxyform.technology.$pristine" class="help-block">Technlogy is required.</p> 
 			</div>

		<!-- ng-disabled="!proxyForm.$valid" -->

		<button type="button" class="btn btn-primary"
			 ng-click="addproxy(proxy)">Add
			Proxy</button>
			<!-- ng-disabled="!proxyForm.$valid" -->
	</form>
</div>

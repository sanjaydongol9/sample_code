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
		<p>Add Candidate</p>
		<form method="post" ng-controller="candidateController" name="candidateForm" enctype="multipart/form-data">
<!-- 			 <uib-alert ng-show="success" type="success" -->
<!-- 				close="closeSuccessAlert()">Account created successfully. Your account is under review and will be approved by Admin soon.</uib-alert> -->

<!-- 			<uib-alert ng-show="error" type="danger" -->
<!-- 				close="closeErrorAlert()">{{errorMessage}}</uib-alert> -->
				
			<div class="form-group" ng-class="{ 'has-error' : candidateForm.firstName.$error.required && !candidateForm.firstName.$pristine }">
				<label for="firstName">First Name</label>
				<input type="text" class="form-control"  name="firstName" ng-model="candidate.firstName" required/>
				<p ng-show="candidateForm.firstName.$error.required && !candidateForm.firstName.$pristine" class="help-block">First name is required</p>
			</div>
			
			<div class="form-group">
				<label for="middleName">Middle Name</label>
				<input type="text" class="form-control" ng-model="candidate.middleName" />
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' : candidateForm.lastName.$error.required && !candidateForm.lastName.$pristine }">
				<label for="lastName">Last Name</label>
				<input type="text" class="form-control"  name="lastName" ng-model="candidate.lastName" required/>
				<p ng-show="candidateForm.lastName.$error.required && !candidateForm.lastName.$pristine" class="help-block">Last name is required.</p>
			</div>

			<div class="form-group" ng-class="{ 'has-error' : candidateForm.phoneNumber.$error.required && !candidateForm.phoneNumber.$pristine }">
				<label for="phoneNumber">Phone Number</label>
				<div>
				<div class="col-sm-4">
					<input type="text" maxlength="3" class="form-control"
						   ng-model="candidate.phone.areaCode" placeholder="">

				</div>
				<div class="col-sm-4">
					<input type="text" maxlength="3" class="form-control"
						   ng-model="candidate.phone.prefixValue" placeholder="">
				</div>
				<div class="col-sm-4">
					<input type="text" maxlength="4" class="form-control"
						   ng-model="candidate.phone.number" placeholder="">
				</div>
				</div>
				<p ng-show="candidateForm.phoneNumber.$error.required && !candidateForm.phoneNumber.$pristine" class="help-block">Phone Number is required.</p>
			</div>

			


			<div class="form-group" ng-class="{ 'has-error' : candidateForm.gender.$error.required && !candidateForm.gender.$pristine }">
				<label for="gender">Gender</label>
				<select class ="form-control" ng-model="candidate.gender" required>
					<option value="" ng-selected="selected">Choose Gender</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
			</div>
			
			<div class="form-group" ng-class="{ 'has-error' : candidateForm.skypeId.$error.required && !candidateForm.skypeId.$pristine }">
				<label for="lastName">skypeID</label>
				<input type="text" class="form-control"  name="skypeId" ng-model="candidate.skypeId" required/>
				<p ng-show="candidateForm.lastName.$error.required && !candidateForm.skypeId.$pristine" class="help-block">skypeId is required.</p>
			</div>
			
		
			
		<div class="form-group" ng-class="{ 'has-error' : candidateForm.technology.$error.required && !candidateForm.technology.$pristine }"> 
				<label for="role">Technology</label>
				<select class ="form-control" ng-model="candidate.technology.id" >
 					<option value="" ng-selected="selected">Choose  Technology</option>  
                    <option ng:repeat="tech1 in technology" value="{{tech1.id}}">     
                	{{tech1.name}}
            		</option> 
 				</select> 
 				<p ng-show="candidateForm.technology.$error.required && !candidateForm.technology.$pristine" class="help-block">Technlogy is required.</p> 
 			</div>

			<div class="form-group" ng-class="{ 'has-error' : candidateForm.email.$error.required && !candidateForm.email.$pristine,
							'has-error' :!candidateForm.email.$error.required && candidateForm.email.$error.email && !candidateForm.email.$pristine}">
				<label for="email">Email</label>
				<input type="email" class="form-control" name="email" ng-model="candidate.email" required />
				<p ng-show="candidateForm.email.$invalid && !candidateForm.email.$pristine" class="help-block">Enter a valid email</p>
				
				<p ng-show="candidateForm.email.$error.required && !candidateForm.email.$pristine" class="help-block">Email is required</p>
   				<p ng-show="!candidateForm.email.$error.required && candidateForm.email.$error.email && !candidateForm.email.$pristine" class="help-block">Enter a valid email</p>
			</div>
			
			<div class="form-group">
			<label for="fileUpload">Resume Upload</label>
			<input type="file" id="resumeFile" file-model="candidate.file">
			
			</div>
			
			
			 <!-- ng-disabled="!candidateForm.$valid" -->
			<button type="button" class="btn btn-primary" ng-disabled="!candidateForm.$valid"
				ng-click="addcandidate(candidate)" >Add Candidate</button>
				
		</form>
		</div>

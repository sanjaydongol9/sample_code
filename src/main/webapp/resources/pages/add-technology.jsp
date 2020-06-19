<head>
<style type="text/css">
.techform {
	width: 350px;
	margin: 50px auto;
	padding: 25px 30px;
	font-family: sans-serif;
	color: #333;
}

.techform h1 {
	margin: 0px 0px 20px 0px;
	font-size: 27px;
}

.techform .btn-primary, .loginform .btn-success {
	width: 100%;
	color: #fff;
	padding: 10px;
	margin: 5px 0px;
}

.techform .btn-primary {
	background: #D4001C;
	border: 1px solid #D4001C;
}

#logo {
	padding-bottom: 15px;
	border-bottom: 1px solid #ddd;
	margin-bottom: 30px;
}

.techform p {
	color: #666;
	margin-bottom: 15px;
}
</style>
</head>

	<div class="techform">
		<p>Add Technology</p>
		<form method="post"  name="technologyForm" >
 					
		<div class="form-group" ng-class="{ 'has-error' : technologyForm.techName.$error.required && !technlogyForm.techName.$pristine }">
				<label for="techName">Technology</label>
				<input type="text" class="form-control"  name="techName" ng-model="name" required/>
				<p ng-show="technologyForm.techName.$error.required && !technologyForm.techName.$pristine" class="help-block">Name is required</p>
			</div>
			
		
			<button type="button" class="btn btn-primary" ng-disabled="!technologyForm.$valid"
				ng-click="addtechnology(name)" >Add Technology</button>
				
		</form>
		</div>

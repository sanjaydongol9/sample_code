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
    <p>Sign Up</p>
    <form method="post" ng-controller="SignUpController" name="userForm">
        <%-- <uib-alert ng-show="success" type="success"
            close="closeSuccessAlert()">Account created successfully. Your account is under review and will be approved by Admin soon.</uib-alert>--%>

        <uib-alert ng-show="error" type="danger"
                   close="closeErrorAlert()">{{errorMessage}}
        </uib-alert>

        <div class="form-group"
             ng-class="{ 'has-error' : userForm.firstName.$error.required && !userForm.firstName.$pristine }">
            <label for="firstName">First Name</label>
            <input type="text" class="form-control" name="firstName" ng-model="user.firstName" required/>
            <p ng-show="userForm.firstName.$error.required && !userForm.firstName.$pristine" class="help-block">First
                name is required</p>
        </div>

        <div class="form-group">
            <label for="middleName">Middle Name</label>
            <input type="text" class="form-control" ng-model="user.middleName"/>
        </div>

        <div class="form-group"
             ng-class="{ 'has-error' : userForm.lastName.$error.required && !userForm.lastName.$pristine }">
            <label for="lastName">Last Name</label>
            <input type="text" class="form-control" name="lastName" ng-model="user.lastName" required/>
            <p ng-show="userForm.lastName.$error.required && !userForm.lastName.$pristine" class="help-block">Last name
                is required.</p>
        </div>

        <div class="form-group" ng-class="{ 'has-error': userForm.areaCode.$error.required && !userForm.areaCode.$pristine,
                                             'has-error' : !userForm.areaCode.$error.required && (userForm.areaCode.$error.minlength || userForm.areaCode.$error.maxlength) && userForm.areaCode.$dirty,
			 									'has-error':userForm.prefixValue.$error.required && !userForm.prefixValue.$pristine,
			 									'has-error' : !userForm.prefixValue.$error.required && (userForm.prefixValue.$error.minlength || userForm.prefixValue.$error.maxlength) && userForm.prefixValue.$dirty,
			 									'has-error':userForm.number.$error.required && !userForm.number.$pristine,
			 									'has-error' : !userForm.number.$error.required && (userForm.number.$error.minlength || userForm.number.$error.maxlength) && userForm.number.$dirty,}">

            <label for="phoneNumber">Phone Number</label>
            <div>
                <div class="col-sm-4">
                    <input type="text" ng-minlength ="3" maxlength="3" class="form-control" name="areaCode"
                           ng-model="user.phone.areaCode" placeholder="" required>

                </div>
                <div class="col-sm-4">
                    <input type="text" ng-minlength ="3" maxlength="3" class="form-control" name="prefixValue"
                           ng-model="user.phone.prefixValue" placeholder="" required>
                </div>
                <div class="col-sm-4">
                    <input type="text" ng-minlength ="4" maxlength="4" class="form-control" name="number"
                           ng-model="user.phone.number" placeholder="" required>
            </div>
            </div>
            <p ng-show="userForm.areaCode.$error.required && !userForm.areaCode.$pristine" class="help-block">Area Codes Required.</p>
            <p ng-show="!userForm.areaCode.$error.required && (userForm.areaCode.$error.minlength || userForm.areaCode.$error.maxlength) && userForm.areaCode.$dirty">Areacod Must be of 3 digit</p>

            <p ng-show="userForm.prefixValue.$error.required && !userForm.prefixValue.$pristine" class="help-block">Prefix value is Required.</p>
            <p ng-show="!userForm.prefixValue.$error.required && (userForm.prefixValue.$error.minlength || userForm.prefixValue.$error.maxlength) && userForm.prefixValue.$dirty">Prefix Must be of 3 digit</p>
            <p ng-show="userForm.number.$error.required && !userForm.number.$pristine" class="help-block">Last 4 digit is Required.</p>
            <p ng-show="!userForm.number.$error.required && (userForm.number.$error.minlength || userForm.number.$error.maxlength) && userForm.number.$dirty">Number Must be of 4 digit</p>
        </div>

        <div class="form-group" ng-class="{ 'has-error' : userForm.role.$error.required && !userForm.role.$pristine }">
            <label for="role">Role</label>
            <select class="form-control" ng-model="user.role" ng-options="role for role in roles" required>
                <option value="" ng-selected="selected">Choose Role</option>
                <option>{{ role }}</option>
            </select>
            <p ng-show="userForm.role.$error.required && !userForm.role.$pristine" class="help-block">Role is
                required.</p>
        </div>


        <div class="form-group"
             ng-class="{ 'has-error' : userForm.gender.$error.required && !userForm.gender.$pristine }">
            <label for="gender">Gender</label>
            <select class="form-control" ng-model="user.gender" required>
                <option value="" ng-selected="selected">Choose Gender</option>
                <option value="m">Male</option>
                <option value="f">Female</option>
                <option value="o">Other</option>
            </select>
        </div>

        <div class="form-group" ng-class="{ 'has-error' : userForm.email.$error.required && !userForm.email.$pristine,
							'has-error' :!userForm.email.$error.required && userForm.email.$error.email && !userForm.email.$pristine}">
            <label for="email">Email</label>
            <input type="email" class="form-control" name="email" ng-model="user.email" required/>

            <p ng-show="userForm.email.$error.required && !userForm.email.$pristine" class="help-block">Email is
                required</p>
            <p ng-show="!userForm.email.$error.required && userForm.email.$error.email && !userForm.email.$pristine"
               class="help-block">Enter a valid email</p>
        </div>

        <div class ="form-group" ng-class="{ 'has-error' :userForm.dob.$error.required }">
            <label for="dob">Date Of Birth</label>
            <input type="date" name="dob" class="form-control" id="dob" ng-model="user.dob" required />
            <p ng-show="userForm.dob.$error.required && userForm.dob.$dirty">DOB is required</p>
        </div>

        <div class="form-group" ng-class="{ 'has-error' :userForm.username.$error.required && userForm.username.$dirty,
								'has-error' : !userForm.username.$error.required && (userForm.username.$error.minlength || userForm.username.$error.maxlength) && userForm.username.$dirty}">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" ng-model="user.username"
                   ng-minlength="5" ng-maxlength="15" required/>
            <p ng-show="userForm.username.$error.required && userForm.username.$dirty">Username is required</p>
            <p ng-show="!userForm.username.$error.required && (userForm.username.$error.minlength || userForm.username.$error.maxlength) && userForm.username.$dirty">
                Username must be between 5 and 15</p>
        </div>
            <%--'has-error':!userForm.password.$valid,--%>
        <div class="form-group" ng-class="{  'has-error' :userForm.password.$error.required && userForm.password.$dirty,
                                             'has-error' : !userForm.password.$error.required && (userForm.password.$error.minlength || userForm.password.$error.maxlength) && !userForm.password.$pristine,
                                             'has-error' : !userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine}">
            <%--'has-error' : userForm.password.$error.required && !userForm.password.$pristine,--%>

            <%--'has-error' : !userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine}--%>
            <label for="password">Password</label>
            <input type="password" class="form-control" name="password" ng-minlength="5" ng-maxlength="15" ng-pattern="/(?=.*[A-Z])(?=.*[^a-zA-Z])/" required ng-model="user.password"/>
                <%--ng-minlength="5" ng-maxlength="15" ng-pattern="/(?=.*[A-Z])(?=.*[^a-zA-Z])/"--%>
            <%--<p class="help-block" ng-show="userForm.password.$error.required">Password is Required</p>--%>
                <p ng-show="userForm.password.$error.required && userForm.password.$dirty">Password is required</p>
                <p ng-show="!userForm.password.$error.required && (userForm.password.$error.minlength || userForm.password.$error.maxlength) && !userForm.password.$pristine" class="help-block">Passwords must be between 5 and 15.</p>
                <p ng-show="!userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine" class="help-block">Must contain uppercase and one non-alpha character (a number or a symbol.)</p>
                <%--<p ng-show="userForm.password.$error.required && !userForm.password.$pristine" class="help-block">Password is required</p>

            <p ng-show="!userForm.password.$error.required && !userForm.password.$error.minlength && !userForm.password.$error.maxlength && userForm.password.$error.pattern && !userForm.password.$pristine" class="help-block">Must contain uppercase and one non-alpha character (a number or a symbol.)</p>--%>
        </div>

            <%--'has-error':!userForm.rePassword.$valid--%>
        <div class="form-group" ng-class="{  'has-error' :userForm.rePassword.$error.required && userForm.rePassword.$dirty }">
            <!-- ng-class="{ 'has-error' : userForm.rePassword.$error.required && !userForm.rePassword.$pristine,
           'has-error': !userForm.rePassword.$error.required && userForm.rePassword.$error.noMatch && !userForm.password.$pristine}" -->
            <!-- http://localhost:8080/cubicipm/ -->
            <label for="rePassword">Confirm Password</label>
            <input type="password" name="rePassword" class="form-control" required ng-model="user.rePassword"
                   password-confirm match-target="user.password"/>
            <%--<p ng-show="userForm.rePassword.$error.required && userForm.rePassword.$dirty" class="help-block">Confirm password is required</p>
            <p class="help-block" ng-show="userForm.rePassword.$error.required">Required</p>
            <p class="help-block" ng-show="userForm.rePassword.$error.match">Passwords do not match.</p>--%>
            <p class="help-block" ng-show="userForm.rePassword.$error.required && userForm.rePassword.$dirty">Password is Required</p>
            <p class="help-block" ng-show="userForm.rePassword.$error.match">Passwords do not match.</p>
            <!-- <p ng-show="!userForm.rePassword.$error.required && userForm.rePassword.$error.noMatch && userForm.password.$dirty" class="help-block">Passwords do not match</p> -->
        </div>

        <!-- ng-disabled="!userForm.$valid" -->
        <button type="button" class="btn btn-primary" ng-disabled="!userForm.$valid"
                ng-click="adduser(user)">Sign Up
        </button>


    </form>
</div>

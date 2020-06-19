<div ng-controller="ManageController">

        <div class="modal-header">
            <h3 class="modal-title">Update User</h3>
        </div>
        <div class="modal-body">
            <form method="post" name="userForm">
                <uib-alert ng-show="success" type="success"
                           close="closeSuccessAlert()">Account created successfully. Your account is under review and will be approved by Admin soon.</uib-alert>

                <uib-alert ng-show="error" type="danger"
                           close="closeErrorAlert()">{{errorMessage}}</uib-alert>

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



        <div class="modal-footer">
            <button class="btn btn-success" type="button" ng-click="editUser(user); ok()">Update and Close</button>
            <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
        </div>

</div>
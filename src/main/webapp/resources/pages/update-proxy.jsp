
        <div class="modal-header">
            <h3 class="modal-title">Update Proxy</h3>
        </div>
        <div class="modal-body">
            <form method="post" name="proxyForm">
                <uib-alert ng-show="success" type="success"
                           close="closeSuccessAlert()">Account created successfully. Your account is under review and will be approved by Admin soon.</uib-alert>

                <uib-alert ng-show="error" type="danger"
                           close="closeErrorAlert()">{{errorMessage}}</uib-alert>

                <div class="form-group" ng-class="{ 'has-error' : proxyForm.firstName.$error.required && !proxyForm.firstName.$pristine }">
                    <label for="firstName">First Name</label>
                    <input type="text" class="form-control"  name="firstName" ng-model="proxy.firstName" required/>
                    <p ng-show="proxyForm.firstName.$error.required && !proxyForm.firstName.$pristine" class="help-block">First name is required</p>
                </div>

                <div class="form-group">
                    <label for="middleName">Middle Name</label>
                    <input type="text" class="form-control" ng-model="proxy.middleName" />
                </div>

                <div class="form-group" ng-class="{ 'has-error' : proxyForm.lastName.$error.required && !proxyForm.lastName.$pristine }">
                    <label for="lastName">Last Name</label>
                    <input type="text" class="form-control"  name="lastName" ng-model="proxy.lastName" required/>
                    <p ng-show="proxyForm.lastName.$error.required && !proxyForm.lastName.$pristine" class="help-block">Last name is required.</p>
                </div>

                <div class="form-group" ng-class="{ 'has-error' : proxyForm.phoneNumber.$error.required && !proxyForm.phoneNumber.$pristine }">
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
                    <p ng-show="proxyForm.phoneNumber.$error.required && !proxyForm.phoneNumber.$pristine" class="help-block">Phone Number is required.</p>
                </div>

                <div class="form-group" ng-class="{ 'has-error' : proxyForm.role.$error.required && !proxyForm.role.$pristine }">
                    <label for="role">Role</label>
                    <select class ="form-control" ng-model="proxy.role" ng-options ="role for role in roles" required>
                        <option value="" ng-selected="selected">Choose  Role</option>
                        <option>{{ role }}</option>
                    </select>
                    <p ng-show="proxyForm.role.$error.required && !proxyForm.role.$pristine" class="help-block">Role is required.</p>
                </div>


                <div class="form-group" ng-class="{ 'has-error' : proxyForm.gender.$error.required && !proxyForm.gender.$pristine }">
                    <label for="gender">Gender</label>
                    <select class ="form-control" ng-model="proxy.gender" required>
                        <option value="" ng-selected="selected">Choose Gender</option>
                        <option value="male">Male</option>
                        <option value="female">Female</option>
                    </select>
                </div>

                <div class="form-group" ng-class="{ 'has-error' : proxyForm.email.$error.required && !proxyForm.email.$pristine,
							'has-error' :!proxyForm.email.$error.required && proxyForm.email.$error.email && !proxyForm.email.$pristine}">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" ng-model="proxy.email" required />
                    <p ng-show="proxyForm.email.$invalid && !proxyForm.email.$pristine" class="help-block">Enter a valid email</p>

                    <p ng-show="proxyForm.email.$error.required && !proxyForm.email.$pristine" class="help-block">Email is required</p>
                    <p ng-show="!proxyForm.email.$error.required && proxyForm.email.$error.email && !proxyForm.email.$pristine" class="help-block">Enter a valid email</p>
                </div>

                <div class="form-group" ng-class="{ 'has-error' :proxyForm.proxyname.$error.required && proxyForm.proxyname.$dirty,
								'has-error' : !proxyForm.proxyname.$error.required && (proxyForm.proxyname.$error.minlength || proxyForm.proxyname.$error.maxlength) && proxyForm.proxyname.$dirty}">
                    <label for="proxyname">Username</label>
                    <input type="text" class="form-control" id="proxyname" name="proxyname" ng-model="proxy.proxyname" ng-minlength="5" ng-maxlength="15" required  />
                    <p ng-show="proxyForm.proxyname.$error.required && proxyForm.proxyname.$dirty">Username is required</p>
                    <p ng-show="!proxyForm.proxyname.$error.required && (proxyForm.proxyname.$error.minlength || proxyForm.proxyname.$error.maxlength) && proxyForm.proxyname.$dirty">Username must be between 5 and 15</p>
                </div>

        </div>
        <div class="modal-footer">
            <button class="btn btn-success" type="button" ng-click="editUser(proxy); ok()">Update and Close</button>
            <button class="btn btn-warning" type="button" ng-click="cancel()">Cancel</button>
        </div>

</div>
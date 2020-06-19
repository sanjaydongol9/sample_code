<div class="simpleList row" ng-init="getVendorWithCandidate()">

	<div class="col-md-12">
		<button type="button" class="btn btn-danger" ng-click="manageVendorWithCandidate(vcModelAsJson)">Apply Changes</button>
	</div>
	
    <div class="col-md-8" >
        <div class="row">
            <div ng-repeat="(listName, list) in vcModels.vendorCallTakers" class="col-md-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{listName.split("=")[1]}}</h3>
                    </div> 
                    <div class="panel-body" ng-include="'resources/pages/manage-vc-candidate-child.jsp'"></div>
                </div>
            </div>
        </div>

        <div view-source="simple"></div>
        
        

    </div>
    
    <div class="col-md-4">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Generated Model</h3>
            </div>
            <div class="panel-body">
                <pre class="code">{{vcModelAsJson}}</pre>
            </div>
        </div>
    </div>
    
 </div>
<div class="simpleList row" ng-init="getMarketerWithVc()">

	<div class="col-md-12">
		<button type="button" class="btn btn-danger" ng-click="manageMarketerWithVc(marketerModelAsJson)">Apply Changes</button>
	</div>
	
    <div class="col-md-8" >
        <div class="row">
           <div ng-repeat="(listName, list) in marketerModels.marketers" class="col-md-6">
                <div class="panel panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title">{{listName.split("=")[1]}}</h3>
                    </div> 
                    <div class="panel-body" ng-include="'resources/pages/manage-marketing-vc-child.jsp'"></div>
                </div>
            </div>
        </div>

        <div view-source="simple"></div>
        
        

    </div>
    
     <div class="col-md-2">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Generated Model</h3>
            </div>
            <div class="panel-body">
                <pre class="code">{{marketerModels}}</pre>
            </div>
        </div>
    </div> 
    
    <div class="col-md-2">
    <div class="trashcan box box-grey box-padding">
        <!-- If you use [] as referenced list, the dropped elements will be lost -->
        <h3>Duplicate VC</h3>
        <ul dnd-list="[]">
            <li><img src="resources/images/trashcan.jpg"></li>
        </ul>
    </div>
    </div>
    
 </div>
  <div ng-init="getAllUser()">

    <div style="margin:10px 0 30px 0; padding:10px; background-color:#EEEEEE; border-radius:5px; font:12px Tahoma;">
      <span><b>Selected Node</b> : {{mytree.currentNode.label}}</span>
    </div>

    <!--
      [TREE attribute]
      angular-treeview: the treeview directive
      tree-id : each tree's unique id.
      tree-model : the tree model on $scope.
      node-id : each node's id
      node-label : each node's label
      node-children: each node's children
    -->
  <div
    data-angular-treeview="true"
    data-tree-id="mytree"
    data-tree-model="treedata"
    data-node-id="id"
    data-node-label="label"
    data-node-children="children" >
 </div>

  </div>

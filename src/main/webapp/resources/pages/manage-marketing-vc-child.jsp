<!-- The dnd-list directive allows to drop elements into it.
     The dropped data will be added to the referenced list -->
<ul dnd-list="list">
    <!-- The dnd-draggable directive makes an element draggable and will
         transfer the object that was assigned to it. If an element was
         dragged away, you have to remove it from the original list
         yourself using the dnd-moved attribute -->
    <li ng-repeat="item in list"
        dnd-draggable="item"
        dnd-moved="list.splice($index, 1)"
        dnd-effect-allowed="copyMove"
        ng-class="{'selected': models.selected === item}"
        >
        <!-- dnd-selected="models.selected = item" -->
        {{item.firstName + ' ' + item.lastName }}
    </li>
</ul>
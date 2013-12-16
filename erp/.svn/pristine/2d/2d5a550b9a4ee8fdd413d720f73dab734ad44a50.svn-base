/**
 * 列表选择全部的checkbox
 */
function selectAllCheckbox(){
	var selectIds = document.getElementsByName("selectOne");
	var selectAllVal = document.getElementById("selectAll");
	
	if(selectAllVal.checked == true){
		for(var i=0; i<selectIds.length; i++){
			selectIds[i].checked = true;
		}
	}else{
		for(var i=0; i<selectIds.length; i++){
			selectIds[i].checked = false;
		}
	}
}

/**
 * 选中当前的checkbox
 */
function selectOneCheckbox(){
	var selectIds = document.getElementsByName("selectOne");
	var selectAll = true;
	
	for(var i=0; i<selectIds.length; i++){
		if(selectIds[i].checked == false){
			selectAll = false;
		}
	}
	
	if(selectAll){
		document.getElementById("selectAll").checked = true;
	}else{
		document.getElementById("selectAll").checked = false;
	}
}

/**
 * 得到选中的checkbox形成的字符串
 */
function getSelectOneStr(splitStr){
	var selectedItems = new Array();
	$("input[@name='selectOne[]']:checked").each(function() {
		selectedItems.push($(this).val());});
		
	var ids = selectedItems.join(splitStr);
	
	return ids;
}

/**
 * datagrid选中的行
 * @param datagridId
 * @param idName
 * @param splitStr
 * @returns
 */
function getDatagridSelectIds(datagridId,idName,splitStr){
    var ids = [];
    var rows = $('#'+datagridId).datagrid('getSelections');
    for(var i=0;i<rows.length;i++){
        ids.push(rows[i][idName]);
    }
	var strids = ids.join(splitStr);
	
	return strids;
}
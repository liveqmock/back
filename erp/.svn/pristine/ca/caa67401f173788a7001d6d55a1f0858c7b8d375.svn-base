/**
 * 恒大汇总查询中的js
 */

function companyToProject(companyId, projectId){
	$.ajax({
		type:"get",
		url: "./sale_hengda/search/compro.action",  
		data: "companyId=" + companyId,
		dataType: "html",
		success: function(data){
			$("#" + projectId).empty();
			$("#" + projectId).append(data);
		}
	});
}









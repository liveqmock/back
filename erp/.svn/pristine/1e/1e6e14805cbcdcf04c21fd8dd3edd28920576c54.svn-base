
/**
 * 创建编辑框，并初始化默认上传功能
 */
function createKindEditorIncludeUpload(textareaName){
	var options = {
			uploadJson : './ihk/common/upload.action',
			afterCreate : function() { 
	         	this.sync(); 
	        }, 
	        afterBlur:function(){ 
	            this.sync(); 
	        } 
		};
    var editor = KindEditor.create('textarea[name="'+textareaName+'"]', options);
}
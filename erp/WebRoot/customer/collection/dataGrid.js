$(function(){
	alert("测试");
            $('#test').datagrid({  
                title:'需要核对信息',//表格标题  
                iconCls:'icon-save',//表格图标  
                nowrap: false,//是否只显示一行，即文本过多是否省略部分。  
                striped: true,  
                url:'./customer/collection/search.action', //action地址  
                sortName: 'parentID',  
                sortOrder: 'desc',  
                idField:'nodeID', 
                loadMsg:'数据加载中...', 
                frozenColumns:[[  
                ]],  
                columns:[[  
                    {field:'adArea',title:'行政区域',width:150},  
                    {field:'areaSize',title:'套内面积',width:120},  
                    {field:'attribute',title:'属性',width:120,sortable:true},  
                    {field:'businesscircle',title:'商圈',width:120},  
                    {field:'constructtype',title:'结构',width:120},  
                    {field:'contactAddr',title:'联系地址',width:120},
                    {field:'opt',title:'操作',width:95,align:'center',
                        formatter:function(value,rec){
                           return "<a href='./customer/collection/search.action?orderId=" + rec.id + "'>查看</a>&nbsp;&nbsp;<a href='./customer/collection/search.action?orderId=" + rec.id + "'>删除</a>";
                         }
                   }  
                ]],  
                pagination:true, //包含分页  
                rownumbers:true,  
                singleSelect:true,  
                toolbar:[{  
                    text:'Add',  
                    iconCls:'icon-add',  
                    handler:function(){  
                        alert('add')  
                    }  
                },{  
                    text:'Cut',  
                    iconCls:'icon-cut',  
                    handler:function(){  
                        alert('cut')  
                    }  
                },'-',{  
                    text:'Save',  
                    iconCls:'icon-save',  
                    handler:function(){  
                        alert('save')  
                    }  
                }]  
            });  
            });
            
        function query(){
		        var queryParams = $('#test').datagrid('options').queryParams;
		        /* queryParams.queryWord = $('#qq').val();
		        queryParams.queryType = $('#ss').val(); */
		        $('#test').datagrid({
		            url:'./customer/collection/search.action'
		        });
    	}
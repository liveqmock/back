/* 打开一个标签 */
function OpenTab(title, url, icon){
    /**
     如果这个标题的标签存在，则选择该标签
     否则添加一个标签到标签组
     */

    if($("#tabs").tabs('exists', title)){
        $("#tabs").tabs('select', title);
    }else{
        $("#tabs").tabs('add',{
            title: title,
            content: createTabContent(url),
            closable: true,
            icon: icon
        });
    }

}

/* 生成标签内容 */
function createTabContent(url){
    return '<iframe style="width:100%;height:100%;" scrolling="auto" frameborder="0" src="' + url + '"></iframe>';
    //return '<div style="height:75%;"><object id="object" height="90%" width="100%" type="text/html" data="'+url+'"></object></div>';
}

function addTab(titleName,url,icon){
    parent.OpenTab(titleName,url,icon);
    return false;
}

//显示右边的报表
function showRightTable(actionName,titleName){

    var url = "./saleunit_new_report/report/guangzhou/"+actionName+".action?ts=<%=CacheUtils.getUrlTimeStamp()%>";
    parent.OpenTab(titleName,url,"");

    return false;
}


$(function(){

    //刷新
    $("#m-refresh").click(function(){

        var currTab = $('#tabs').tabs('getSelected');	//获取选中的标签项
        var url = $(currTab.panel('options').content).attr('src');	//获取该选项卡中内容标签（iframe）的 src 属性

        //currTab.panel("refresh",url);

        $("#tabs").tabs('update',{
            tab:currTab,
            options:{

                /*style:{padding:'1px'},*/

                content:createTabContent(url),
                closable: true,
                /*fit:true,*/
                selected:true
            }
        });


});


    //关闭所有
    $("#m-closeall").click(function(){
        $(".tabs li").each(function(i, n){
            if(i>0){
                var title = $(n).text();
                $('#tabs').tabs('close',title);
            }
        });
    });

    //除当前之外关闭所有
    $("#m-closeother").click(function(){
        var currTab = $('#tabs').tabs('getSelected');
        var currTitle = currTab.panel('options').title;

        $(".tabs li").each(function(i, n){
            if(i>0){
                var title = $(n).text();

                if(currTitle != title){
                    $('#tabs').tabs('close',title);
                }
            }
        });
    });

    //关闭当前
    $("#m-close").click(function(){
        var currTab = $('#tabs').tabs('getSelected');
        var currTitle = currTab.panel('options').title;
        //$('#tabs').tabs('close', currTitle);
        $(".tabs li").each(function(i, n){
            if(i>0){
                var title = $(n).text();

                if(currTitle == title){
                    $('#tabs').tabs('close',title);
                }
            }
        });
    });

    //关闭当前tabs,iframe 中使用
    $("#bnt-close").click(function(){
        var currTab = parent.$('#tabs').tabs('getSelected');
        var currTitle = currTab.panel('options').title;
        //$('#tabs').tabs('close', currTitle);
        parent.$(".tabs li").each(function(i, n){
            if(i>0){
                var title = $(n).text();

                if(currTitle == title){
                    parent.$('#tabs').tabs('close',title);
                }
            }
        });
    });


});


//$("#tabs").tabs("loaded");      隐藏
//$("#tabs").tabs("loading","");  显示
(function () {
    $.extend($.fn.tabs.methods, {
        //显示遮罩
        loading: function (jq, msg) {
            return jq.each(function () {
                var panel = $(this).tabs("getSelected");
                if (msg == undefined || msg.length==0) {
                    msg = "正在加载数据，请稍候...";
                }
                $("<div class=\"datagrid-mask\"></div>").css({ display: "block", width: panel.width(), height: panel.height() }).appendTo(panel);
                $("<div class=\"datagrid-mask-msg\"></div>").html(msg).appendTo(panel).css({ display: "block", left: (panel.width() - $("div.datagrid-mask-msg", panel).outerWidth()) / 2, top: (panel.height() - $("div.datagrid-mask-msg", panel).outerHeight()) / 2 });
            });
        }
        ,
        //隐藏遮罩
        loaded: function (jq) {
            return jq.each(function () {
                var panel = $(this).tabs("getSelected");
                panel.find("div.datagrid-mask-msg").remove();
                panel.find("div.datagrid-mask").remove();
            });
        }
    });
})(jQuery);

/** toScrollFrame: turns a iframe wrapper into a scrollable masking region on iOS webkits
*
*   @param  iFrame  String   A CSS/jQuery Selector identifying the iFrame to scroll
*   @param  mask    String   A CSS/jQuery Selector identifying the masking/wrapper object
*   @return         Boolean  true on success, false on failure.
*/
/*
var toScrollFrame = function(iFrame, mask){
    if(!navigator.userAgent.match(/iPad|iPhone/i)) return false; //do nothing if not iOS devie

    var mouseY = 0;
    var mouseX = 0;
    jQuery(iFrame).ready(function(){ //wait for iFrame to load
        //remeber initial drag motition
        jQuery(iFrame).contents()[0].body.addEventListener('touchstart', function(e){
            mouseY = e.targetTouches[0].pageY;
            mouseX = e.targetTouches[0].pageX;
        });

        //update scroll position based on initial drag position
        jQuery(iFrame).contents()[0].body.addEventListener('touchmove', function(e){
            e.preventDefault(); //prevent whole page dragging

            var box = jQuery(mask);
            box.scrollLeft(box.scrollLeft()+mouseX-e.targetTouches[0].pageX);
            box.scrollTop(box.scrollTop()+mouseY-e.targetTouches[0].pageY);
            //mouseX and mouseY don't need periodic updating, because the current position
            //of the mouse relative to th iFrame changes as the mask scrolls it.
        });
    });

    return true;
};


$().ready(function(){
    toScrollFrame('.myFrame','.myMask');
});*/

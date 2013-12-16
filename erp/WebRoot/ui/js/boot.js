__CreateJSPath = function (js) {
    var scripts = document.getElementsByTagName("script");
    var path = "";
    for (var i = 0, l = scripts.length; i < l; i++) {
        var src = scripts[i].src;
        if (src.indexOf(js) != -1) {
            var ss = src.split(js);
            path = ss[0];
            break;
        }
    }
    var href = location.href;
    href = href.split("#")[0];
    href = href.split("?")[0];
    var ss = href.split("/");
    ss.length = ss.length - 1;
    href = ss.join("/");
    if (path.indexOf("https:") == -1 && path.indexOf("http:") == -1 && path.indexOf("file:") == -1 && path.indexOf("\/") != 0) {
        path = href + "/" + path;
    }
    return path;
}



var bootPATH = __CreateJSPath("boot.js");

//miniui
document.write('<script src="' + bootPATH + 'jquery.min-1.7.1.js" type="text/javascript"></script>');
document.write('<script src="' + bootPATH + 'noContextMenu.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + 'jquery.easyui.min.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + 'easyui-lang-zh_CN.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + 'tabs.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + '../../js/ui_fix.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + 'highcharts.js" type="text/javascript" ></script>');
document.write('<script src="' + bootPATH + '../../js/easyui.utils.js" type="text/javascript" ></script>');

//skin
var skin = getCookie("default");
if (skin ==null || skin==""){
    skin = "default";
}
document.write('<link href="' + bootPATH + 'themes/' + skin + '/easyui.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + 'themes/icon.css" rel="stylesheet" type="text/css" />');
document.write('<link href="' + bootPATH + '../css/icon_custom.css" rel="stylesheet" type="text/css" />');




////////////////////////////////////////////////////////////////////////////////////////
function getCookie(sName) {
    var aCookie = document.cookie.split("; ");
    var lastMatch = null;
    for (var i = 0; i < aCookie.length; i++) {
        var aCrumb = aCookie[i].split("=");
        if (sName == aCrumb[0]) {
            lastMatch = aCrumb;
        }
    }
    if (lastMatch) {
        var v = lastMatch[1];
        if (v === undefined) return v;
        return unescape(v);
    }
    return null;
}
document.write(" <script language=\"javascript\" src=\"jquery-3.3.1.min.js\" > <\/script>");
src = "jquery-3.3.1.min.js";
document.write(" <script language=\"javascript\" src=\"default_config.js\" > <\/script>");
document.write(" <script src=\"http://pv.sohu.com/cityjson?ie=utf-8\" > <\/script>");

// var new_element=document.createElement("script");
// new_element.setAttribute("type","text/javascript");
// new_element.setAttribute("src","jquery-3.3.1.min.js");
// document.body.appendChild(new_element);

function PageView(ip,url,name,time){
    this.userIp = ip,
    this.pageUrl = url,
    this.userName = name,
    this.time = time
};
$(document).ready(function(){
    // $.post(DEFAULT_CONFIG.api_host + "/pageview",
    //     JSON.stringify(new PageView(returnCitySN["cip"],GetUrlRelativePath().toString(),
    //         "sxp",new Date())),"json")
    $.ajax({
        url :DEFAULT_CONFIG.api_host + "/pageview",
        contentType: "application/json; charset=utf-8",
        //data : JSON.stringify(new PageView("hh","hh","hh",new Date())),
        data : JSON.stringify(new PageView(returnCitySN["cip"],GetUrlRelativePath().toString(),"sxp",new Date())),
        dataType : 'json',
        method : "post"
    });
});

function GetUrlRelativePath()
{
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    return relUrl;
}
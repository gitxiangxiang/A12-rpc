//document.write(" <script src=\"http://pv.sohu.com/cityjson?ie=utf-8\" > <\/script>");

//默认配置
var DEFAULT_CONFIG = {
    'api_host': "http://localhost:8080/",
    //'app_host': HTTP_PROTOCOL + 'mixpanel.com',
    'autoTrace': true, // 是否打开全埋点监测
    //'cdn': HTTP_PROTOCOL + 'cdn.mxpnl.com',
    'detectComponent': ["button","href"],//监测的组件
    'detectId': [],//根据id选择器监测
    'cache' : 0,
    'cross_subdomain_cookie': true,
    'persistence': 'cookie',
    'persistence_name': '',
    'cookie_name': '',
    'loaded': function() {},
    'store_google': true,
    'save_referrer': true,
    'test': false,
    'verbose': false,
    'img': false,
    'track_pageview': true,
    'debug': false,
    'track_links_timeout': 300,
    'cookie_expiration': 365,
    'upgrade': false,
    'disable_persistence': false,
    'disable_cookie': false,
    'secure_cookie': false,
    'ip': true,
    'property_blacklist': []
};
//初始化
(function () {
    if(window.rpc){
        //检验客户是否获得了权限
        if(check(window.rpc)){
            throw new Error("no privilege !");
        }
        //初始化配置
        if(!window.rpc.config){
            window.rpc.config = DEFAULT_CONFIG;
            //加载自定义配置文件
            try {
                if(CUSTOM_CONFIG){
                    for(key in CUSTOM_CONFIG){
                        window.rpc.config[key] = CUSTOM_CONFIG[key];
                    }
                }
            }catch (e) {
                console.log(e.message);
            }
            //加载特定配置
            if(window.rpc[0] && window.rpc[0][0] === "init"){
                window.rpc.appKey = window.rpc[0][1];
                for(key in window.rpc[0][2]){
                    window.rpc.config[key] = window.rpc[0][2][key];
                }
                window.rpc.shift();
            }
            window.rpc.trace = trace;
            len = window.rpc.length;
            for (var i = 0; i < len; i++) {
                window.rpc.trace(window.rpc[0][1],window.rpc[0].slice(2))
                window.rpc.shift();
            }
        }
    }
})();

/*
 * 检查用户权限
 */
function check(o) {
    return o[0] && o[0] === "123456789";
}

/*
 * 记录pageview的实体
 */
function PageView(ip,url,name,time){
    this.userIp = ip,
    this.pageUrl = url,
    this.userName = name,
    this.time = time
};

/*
 * 自定义事件实体(事件名，{事件属性1：值1，...})
 */
function CustomEvent(eventName,eventInfo){
    this.eventName = eventName,
    this.eventInfo = eventInfo,
    this.time = new Date()
}

//引入获取IP的接口“http://pv.sohu.com/cityjson?ie=utf-8”
var returnCitySN = {"cip":null};
(function () {
    if (!document.getElementById("getIp-js")) {
        var a = document.createElement("script");
        a.type = "text/javascript";
        a.id = "getIp-js";
        a.async = !0;
        a.src = "http://pv.sohu.com/cityjson?ie=utf-8";
        var c = document.getElementsByTagName("script")[0];
        c.parentNode.insertBefore(a, c);
    }
})();

/*
 * 页面的访问信息（URL，userIp,username,time)
 */
$(window).load(function pv(){
    sent(new PageView((returnCitySN["cip"]!=null?returnCitySN["cip"]:"无法获取"),GetUrlRelativePath().toString(),getUserName(),new Date()),"/pageview");
});

/*
 * 触发自定义事件的记录
 */
function trace(eventName) {
    sent([new CustomEvent(eventName,arguments[1][0]),new CustomEvent(eventName,arguments[1][0])],"/customEvent");
}
$(window).bind('beforeunload', function() {

});
/*
 * 获取页面的URL
 */
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

/*
 * 获取用户名(暂时)
 */
function getUserName(){
    return "sxp";
}

/*
 * 向后端发送事件记录的接口
 * o:包含事件信息的实体
 * uri:请求路径
 */
function sent(o,uri){
    $.ajax({
        url :DEFAULT_CONFIG.api_host + uri,
        contentType: "application/json; charset=utf-8",
        data : JSON.stringify(o),
        async:true,
        dataType : 'json',
        method : "post"
    });
}
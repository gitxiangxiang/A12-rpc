//document.write(" <script src=\"http://pv.sohu.com/cityjson?ie=utf-8\" > <\/script>");

//默认配置
var DEFAULT_CONFIG = {
    'api_host': "http://localhost:8080/",
    //'app_host': HTTP_PROTOCOL + 'mixpanel.com',
    'autoTrace': true, // 是否打开全埋点监测
    //'cdn': HTTP_PROTOCOL + 'cdn.mxpnl.com',
    'detectComponent': ["a","button","input[type='button']"],//监测的组件
    'detectId': ["1"],//根据id选择器监测
    'cache' : 0
};
//初始化
(function () {
    if(window.rpc){
        //检验客户是否获得了权限
        if(!check(window.rpc)){
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
            window.rpc.getKey = getKey;
            window.rpc.trace = trace;
            window.rpc.identify = identify;
            len = window.rpc.length;
            for (var i = 0; i < len; i++) {
                var method = eval(window.rpc[0][0]);
                method(window.rpc[0].slice(1));
                window.rpc.shift();
            }
        }
    }else throw new Error("illegal");
})();

/**
 * 全埋点监测初始化
 */
if(window.rpc.config["autoTrace"] == true){
    for(var i in window.rpc.config["detectComponent"]){
        var component = window.rpc.config["detectComponent"][i];
        $(component).bind("click",detector(component,"click"));
    }
}

/**
 * 全埋点监测辅助函数
 * @param component
 * @param type
 * @returns {Function}
 */
function detector(component,type) {
    return function () {
        sent(new Component(GetUrlRelativePath().toString(),component,$(this).text(),type,new Date()),'/component');
    }
}
/**
 * 获取appKey
 * @returns {*}
 */
function getKey() {
    return window.rpc.appKey;
}
/*
 * 检查用户权限
 */
function check(o) {
    var result = $.ajax({
        url :DEFAULT_CONFIG.api_host + '/check',
        data : {'appKey':o[0][1]},
        async:false,
        dataType:"text",
        method : "post"
    });
    return result.responseText == 'true'?true:false;
}

function Component(loaction,componentType,componentName,event,time) {
    this.location = loaction;
    this.componentType = componentType;
    this.componentName = componentName;
    this.event = event;
    this.time = time;
}

/**
 * 初始化并标识用户(未完成)
 * @param id
 */
function identify(id) {
    window.rpc.userId = id;

}

/**
 * 网站用户
 */
function User(id,userInfo) {
    this.id = id;
    this.userInfo = userInfo;
}

/**
 * 获取用户id
 * @returns {*|number}
 */
function getUserId() {
    return window.rpc.userId || 0;
}
/*
 * 记录pageview的实体
 */
function PageView(ip,url,time){
    this.userId = getUserId(),
    this.userIp = ip,
    this.pageUrl = url,
    this.time = time
}

/**
 * 离开页面
 * @param url
 * @param time
 * @constructor
 */
function Leave(url,time) {
    this.userId = getUserId(),
    this.pageUrl = url,
    this.time = time
}

/*
 * 自定义事件实体(事件名，{事件属性1：值1，...})
 */
function CustomEvent(eventName,eventInfo){
    this.appKey = window.rpc.appKey,
    this.userId = getUserId(),
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
window.onload = function (){
    sent(new PageView((returnCitySN["cip"]!=null?returnCitySN["cip"]:"无法获取"),GetUrlRelativePath().toString(),new Date()),"/pageview");
};
/**
 * 离开页面
 */
window.onbeforeunload = function() {
    sent(new Leave(GetUrlRelativePath().toString(),new Date()),"/leave");
};
/**
 * 元素触发器
 */
// $(document).ready(function () {
//     $("button").click(function () {
//         alert($(this).text())
//     })
// })

/**
 * 触发自定义事件的记录
 */
function trace(eventName) {
    sent([new CustomEvent(arguments[0][0],arguments[0][1])],"/customEvent");
}

/*
 * 获取页面的URL
 */
function GetUrlRelativePath() {
    var url = document.location.toString();
    var arrUrl = url.split("//");

    var start = arrUrl[1].indexOf("/");
    var relUrl = arrUrl[1].substring(start);//stop省略，截取从start开始到结尾的所有字符

    if(relUrl.indexOf("?") != -1){
        relUrl = relUrl.split("?")[0];
    }
    if(relUrl.indexOf("#") != -1){
        relUrl = relUrl.split("#")[0];
    }
    return relUrl;
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

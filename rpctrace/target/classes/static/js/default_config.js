//alert("hhh");
var DEFAULT_CONFIG = {
    'api_host': "http://localhost:8080/",
    //'app_host': HTTP_PROTOCOL + 'mixpanel.com',
    'autotrack': true, // 是否打开全埋点监测
    //'cdn': HTTP_PROTOCOL + 'cdn.mxpnl.com',
    'detectComponent': ["button","href"],//监测的组件
    'detectId': [],//根据id选择器监测
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
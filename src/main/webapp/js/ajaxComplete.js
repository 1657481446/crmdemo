/*js ：用于Ajax请求接口 session为空 自在Ajax请求完后自动跳转登陆页面 */
function  redirectHandle(xhr) {
    var url = xhr.getResponseHeader("redirectUrl");
    var enable = xhr.getResponseHeader("enableRedirect");
    if((enable == "true") && (url != "")){
        var win = window;
        while(win != win.top){
            win = win.top;
        }
        win.location.href = url;
    }
}

$(function () {
    $(document).ajaxComplete(function (event, xhr, settings) {
        redirectHandle(xhr);
    })
})
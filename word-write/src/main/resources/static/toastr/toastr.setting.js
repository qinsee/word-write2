toastr.options = {
	positionClass:"toast-top-right",
	timeOut: 50,
	extendedTimeOut:50,
	hideDuration:4000
};

/*
toastr.options = {  
closeButton: false,  
debug: false,  
progressBar: true,  
positionClass: "toast-bottom-center",  
onclick: null,  
showDuration: "300",  
hideDuration: "1000",  
timeOut: "2000",  
extendedTimeOut: "1000",  
showEasing: "swing",  
hideEasing: "linear",  
showMethod: "fadeIn",  
hideMethod: "fadeOut"  
};  */

/*
参数说明： 
closeButton：false，是否显示关闭按钮（提示框右上角关闭按钮）； 
debug：false，是否为调试； 
progressBar：false，是否显示进度条（设置关闭的超时时间进度条）； 
positionClass，消息框在页面显示的位置

toast-top-left  顶端左边
toast-top-right    顶端右边
toast-top-center  顶端中间
toast-top-full-width 顶端，宽度铺满整个屏幕
toast-botton-right  
toast-bottom-left
toast-bottom-center
toast-bottom-full-width

onclick，点击消息框自定义事件 
showDuration: “300”，显示动作时间 
hideDuration: “1000”，隐藏动作时间 
timeOut: “2000”，自动关闭超时时间 
extendedTimeOut: “1000” 
showEasing: “swing”, 
hideEasing: “linear”, 
showMethod: “fadeIn” 显示的方式，和jquery相同 
hideMethod: “fadeOut” 隐藏的方式，和jquery相同
*/
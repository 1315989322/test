function down() {
    var index=$("#imgContext img:visible").next().index();
    var size= $('#imgContext').children().length;
    if(index==-1){
        alert("最后一个了哦");
        return;
    }
    $("#imgContext img:visible").hide().next().show();

};
function up() {
    var index=$("#imgContext img:visible").index($("#imgContext img"));
    if(index==0){
        alert("上面没有了");
        return;
    }
    $("#imgContext img:visible").hide().prev().show();
};
function del() {
    var photoId=$("#imgContext img:visible").attr('title');
    $.ajax({
        url:"/deletePhoto",
        data:{
            "photoId":photoId
        },
        success:function (res) {
            var str=JSON.stringify(res);
            $("#imgContext img:visible").remove();
            $("#imgContext img:hidden").eq(0).show();
            alert(str);
        },error:function (res) {
            alert("删除失败");
        }

    })
}
function message() {
    $("#imgContext img").hide();
    $("#imgContext img").eq(0).show();
    var message=$("#p").val();
    if(message!=null&&message!==""&&message!=undefined){
        alert(message);
    }
};
function look(studentPort) {
    $.ajax({
        url:"/lookPhoto",
        data:{
            "studentPort":studentPort
        },
        success:function (data) {
            var photos=eval(JSON.stringify(data));
            var len =photos.length;
            alert(len);
            var str=photos[0].photoStr;
            console.log(str);
            // var outputImg = document.createElement('img');
            // outputImg.src = 'data:image/png;base64,'+str;
        },error:function () {
            alert("error");
        }
    });
};
function arrayBufferToBase64( buffer ) {
    var binary = '';
    var bytes = new Uint8Array( buffer );
    var len = bytes.byteLength;
    for (var i = 0; i < len; i++) {
        binary += String.fromCharCode( bytes[ i ] );
    }
    return window.btoa( binary );
};
function imgChange(e) {
    console.info(e.target.files[0]);//图片文件
    var dom =$("input[id^='file']")[0];
    console.info(dom.value);
    console.log(e.target.value);//这个也是文件的路径和上面的dom.value是一样的
    var reader = new FileReader();
    reader.onload = (function (file) {
        return function (e) {
            console.info(this.result); //这个就是base64的数据了
            $("#showImage")[0].src=this.result;
            $("#inputs")[0].value=this.result;
        };
    })(e.target.files[0]);
    reader.readAsDataURL(e.target.files[0]);
}
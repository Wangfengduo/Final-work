window.onload=function()
{
    var userName = document.getElementById("userName");
    var userNamets = document.getElementById("userNamets");
    var passWord = document.getElementById("passWord");
     var passWordts = document.getElementById("passWordts");
    var qrPassWord = document.getElementById("qrPassWord");
    var qrPassWordts = document.getElementById("qrPassWordts");
    var form1=document.getElementById("form1");
    userName.onblur=function(){
     var oAjax = new XMLHttpRequest();
        
        oAjax.open("get","servlet?userName='"+userName+"'",true);
        oAjax.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        //3.发送请求
        oAjax.send();      //发送ajax


        //4.接收返回
        //客户端和服务器端有交互的时候会调用onreadystatechange
        oAjax.onreadystatechange=function()
        {
        
            if(oAjax.readyState==4)
            {
                if(oAjax.status==200)//判断是否成功,如果是200，就代表成功
                {
                    if(oAjax.responseText==这里写你在servlet里如果查询到用户名输出的值){//oAjax.responseText是servlet输出什么就是什么
                        userNamets.innerHTML="该用户名已经注册";
                    }
                }
                else
                {
                    alert("请求失败");
                }
            }
        };
    }

    form1.onsubmit=function(){
if(userName.value=="" || passWord.value=="" || qrPassWord.value==""){
    alert("填写信息错误");
return false;
}
    };

qrPassWord.onblur=function(){
    if (qrPassWord.value.length<6) {
        qrPassWordts.innerHTML="确认密码不能小于6位";
        qrPassWord.value="";
    }else if(qrPassWord.value!=passWord.value){
qrPassWordts.innerHTML="两次密码不一致";
passWord.value="";
qrPassWord.value="";
    }
}
 passWord.onblur=function(){
    if (passWord.value.length<6) {
        passWordts.innerHTML="密码不能小于6位";
        passWord.value="";

    }


}
    passWord.onfocus=function(){
        passWordts.innerHTML="";
        qrPassWordts.innerHTML="";

}

};
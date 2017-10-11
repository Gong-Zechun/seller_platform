
//退出登录
function signOut() {
    alertConfirm('Sure you want to exit?', function(){
        layer.closeAll('dialog');
        $.ajax({
            type: "POST",
            url: "/signOut",
            dataType: "json",
            success: function(data) {
                if(1 == data) {
                    window.location.href="/index";
                }
            },
            error: function(e) { //服务器响应失败处理函数
                console.log(e);
            }
        })
    },function(){
        return;
    });
}

//登录验证 将登录封装一个登陆函数
function mylogin(){

    var email = $('#formLogin .email').val();
    var psw = $('#formLogin .psw').val();

    if (email.length == 0) {
        $('#formLogin .email').siblings('.error').css('visibility',' visible').html('Please enter your e-mail');
    } else {
        if (!/^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/.test(email)) {
            $('#formLogin .email').siblings('.error').css('visibility',' visible').html('Please enter the correct E-mail address');
        }
    }

    if (psw.length == 0) {
        $('#formLogin .psw').siblings('.error').css('visibility',' visible').html('Please enter a password');
    }else {
        $.ajax({
            type: "POST",
            url: "/login",
            dataType: "json",
            async: false,
            data: {
                "email": email,
                "password": psw
            },
            success: function(data) {
                if(1 == data) {
                    $("#formLogin").hide();
                    $('.banner').addClass('.reg-login-after');
                    $('.banner').find('.txt-list').siblings('.txt-list-after').show();
                    $('.banner').find('.txt-list').hide();
                    $('#userAcc').show();
                    window.location.reload();
                }else if(0 == data) {
                    $("#passwordInput").val("");
                    $('#formLogin .psw').siblings('.error').css('visibility',' visible').html('incorrect password');
                }else if(-1 == data) {
                    $('#formLogin .email').siblings('.error').css('visibility',' visible').html('E-mail address doesn not exist');
                }
            },
            error: function(e) { //服务器响应失败处理函数
                console.log(e);
            }
        });
    }
}

$(function() {
    //使用点击按钮登陆
    $('#formLogin').on('click','.form-btn',function(){
        mylogin();
    })

    //使用点击enter登陆
    $(document).on('keydown',function(e){
        e=e||window.event;
        if(e.keyCode==13){
            mylogin();
        }
    })

    //用户框的下拉选项
    var myNum = 0;
    $('#userAcc').on('click','.ema,.arrow',function(){
        myNum++;
        if(myNum % 2 == 0){
            $('#userAcc').find('.sub-menu').slideUp();
        }else{
            $('#userAcc').find('.sub-menu').slideDown();
        }
    });
});


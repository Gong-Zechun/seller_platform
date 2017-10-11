$(function() {

    //密码更改--展示选择框
    $('#setting').on('click','.edit',function(){
        var j=$(this).attr('data-j');
        j++;
        $(this).attr({'data-j':j});
        if(j%2 == 0){
            $(this).parents('.row-info').next('.edit-box').slideUp(300);
        }else{

            $(this).parents('.row-info').next('.edit-box').slideDown(500);
        }

        var myNum = $(this).attr('data-num');
        switch(myNum){
            case "0" :
                $('.edit1').attr({'data-j':0});
                $('.edit2').attr({'data-j':0});
                $('.edit-phone').slideUp(300);
                $('.inp-addr').slideUp(300);

                $('.phone').val('');

                $('.inp1').val('');
                $('.inp2').val('');
                $('.l-inp').val('');
            break;

            case "1" :
                $('.edit0').attr({'data-j':0})
                $('.edit2').attr({'data-j':0})
                $('.edit-psw').slideUp(300);
                $('.inp-addr').slideUp(300);

                $('.new-psw1').val('');
                $('.new-psw2').val('');

                $('.inp1').val('');
                $('.inp2').val('');
                $('.l-inp').val('');
                break;

            case "2" :
                $('.edit0').attr({'data-j':0})
                $('.edit1').attr({'data-j':0})

                $('.edit-psw').slideUp(300);
                $('.edit-phone').slideUp(300);

                $('.new-psw1').val('');
                $('.new-psw2').val('');

                $('.phone').val('');
                break;

        }



    });

    //密码更改--提交
    $('#setting').on('click','.edit-psw .save',function(){
        var newPsw1 = $('#setting .new-psw1').val();
        var newPsw2 = $('#setting .new-psw2').val();

        if ($.string.isNullOrEmpty(newPsw1)) {
            $('#setting .new-psw1').parents('span').siblings('.error').show().html('Please enter a password');
            return false;
        } else {
            if (!/\w{8,}/.test(newPsw1)) {
                $('#setting .new-psw1').parents('span').siblings('.error').show().html('The password can only contain English characters，numbers and underscores(_) of free combination but the minimum length should be 8 characters');
                return false;
            }
        }
        if ($.string.isNullOrEmpty(newPsw2)) {
            $('#setting .new-psw2').parents('span').siblings('.error').show().html('Please enter a password');
            return false;
        } else {
            if (newPsw2 != newPsw1) {
                $('#setting .new-psw2').parents('span').siblings('.error').show().html('Confirm password must match with previous entry');
                return false;
            }
        }

        $.ajax({
            url: '/userCenter/updatePassword',
            type: 'POST',
            data: {
                newPsw1 : newPsw1,
                newPsw2 : newPsw2
            },
            async: false,
            dataType: "json",
            success: function (data) {
                // if(1 == 1){
                //     $('#setting .cur-psw').parents('span').siblings('.error').show().html('error');
                // }else{
                //     $('.mask-bg').show();
                //     $('#loginAgain').show();
                // }
                if(1 == data) {
                    alertConfirm("Modify password successfully, please login in <br/>again", function() {
                        window.location.reload();
                    })
                }
            }
        });
    });

    //手机号码更改--提交
    $('#setting').on('click','.edit-phone .save',function(){
        var phone = $('#setting .phone').val();
        //var reg = /^1[3|4|5|7|8]\d{9}$/;

        if($.string.isNullOrEmpty(phone)) {
            $('#setting .phone').parents('span').siblings('.error').show().html('error');
            return false;
        }else {
            // if(!reg.test(phone)){
            //     $('#setting .phone').parents('span').siblings('.error').show().html('error');
            //     return false;
            // }
        }

        $.ajax({
            url: '/userCenter/updatePhone',
            type: 'POST',
            data: {
                phone : phone
            },
            async: false,
            dataType: "json",
            success: function (data) {
                if(1 == data) {
                    window.location.reload();
                }
            }
        });

    });

    //地址更改
    $('#setting').on('click','.inp-addr .save',function(){
        var addressee =  $('#setting .inp-addr .inp1').val();
        var phone =  $('#setting .inp-addr .inp2').val();
        var address =  $('#setting .inp-addr .l-inp').val();

        if($.string.isNullOrEmpty(addressee) || $.string.isNullOrEmpty(phone) || $.string.isNullOrEmpty(address)){
            $('#setting .inp-addr').find('.error').show().html('error');
        }else{
            $.ajax({
                url: '/userCenter/updateDeliveryInfo',
                type: 'POST',
                data: {
                    addressee: addressee,
                    phone: phone,
                    address: address
                },
                async: false,
                dataType: "json",
                success: function (data) {
                    if(1 == data) {
                        window.location.reload();
                    }
                }
            });
        }
    });

});

//
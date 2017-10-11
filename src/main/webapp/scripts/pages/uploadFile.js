var uploader = null;
var orderNo = null;
var timer = null;

//订单流程进入step2：service
function toServicePage() {
    var country = "";
    if($("p.box .state").html() != "Country") {
        country = $("p.box .state").html();
    }

    //sLanStr:原语种名称；sLan：原语种的id值（对应sg_language表）
    var sLan;
    var sLanStr = $("#sLan").html();
    $(".spinner-box ul li .select1").each(function() {
        if($(this).html() == sLanStr) {
            sLan = $(this).parent().attr("value");
        }
    });

    //sLanStr:目标语种名称；sLan：目标语种的id值（对应sg_language表）
    var tLan;
    var tLanStr = $("#tLan").html();
    $(".spinner-box ul li .select1").each(function() {
        if($(this).html() == tLanStr) {
            tLan = $(this).parent().attr("value");
        }
    });

    var price = $("#price").html();
    //fileInfo用于记录“文件名”和“页数”
    var fileInfo = "";
    $("#fileListTable tbody tr").each(function() {
        var fileName = $(this).find("td:eq(1) .file-name span").html();
        var content = $(this).find("td:eq(2) .box .state").html();
        if(content.indexOf("Please Choose") >= 0) {
            content = "";
        }
        var pageNums = $(this).find("td:eq(3) input").val();
        //每个文件的价格
        var singleFilePrice = getPriceRate() * pageNums;
        fileInfo = fileInfo + fileName + "," + content + "," + pageNums + "," + singleFilePrice + ",";
    });

    if(!$.string.isNullOrEmpty(country) && !$.string.isNullOrEmpty(sLan) && !$.string.isNullOrEmpty(tLan) && Number(price) > 0) {
        //遍历table，要求用户必须填写"type of document"
        var documentTypeFlag = 1;
        $("#fileListTable tbody tr").each(function() {
            var documentType = $(this).find("td:eq(2) .box .state").html();
            if($.string.isNullOrEmpty(documentType) || documentType == "Please Choose") {
                documentTypeFlag = 0;
            }
        });

        if(documentTypeFlag == 0) {
            alertInfo("Please fill in the type of document");
        }else if(documentTypeFlag == 1) {
            //isLanChanged(country, sLan, tLan, fileInfo, price, orderNo);
            saveOrder(country, sLan, tLan, fileInfo, price, orderNo)
        }
    }else {
        alertInfo("Please fill in all the order information");
    }
}

//语种是否被更换（页面回填后，检测用户是否更改了语种选择）
// function isLanChanged(country, sLan, tLan, fileInfo, price, orderNo) {
//     $.ajax({
//         type: "POST",
//         url: "/placeOrder/isLanChanged",
//         dataType: "json",
//         async: false,
//         data: {
//             "sLan": sLan,
//             "tLan": tLan,
//             "orderNo": orderNo
//         },
//         success: function(data) {
//             if(0 == data) {
//                 alertConfirm("The price is subjected to changes as the translation language is changed.", function() {
//                     layer.closeAll("dialog");
//                     getPrice();
//                     alertConfirm("The price is changed.", function() {
//                         layer.closeAll("dialog");
//                         saveOrder(country, sLan, tLan, fileInfo, price, orderNo)
//                     });
//                 });
//             }else if(1 == data) {
//                 saveOrder(country, sLan, tLan, fileInfo, price, orderNo);
//             }
//         },
//         error: function(e) { //服务器响应失败处理函数
//             console.log(e);
//         }
//     });
// }

/**
 * 订单入库
 * @param country
 * @param sLan
 * @param tLan
 * @param fileInfo
 * @param price
 * @param orderNo
 */
function saveOrder(country, sLan, tLan, fileInfo, price, orderNo) {
    $.ajax({
        type: "POST",
        url: "/placeOrder/saveOrder",
        dataType: "json",
        async: false,
        data: {
            "country": country,
            "sLan": sLan,
            "tLan": tLan,
            "fileInfo": fileInfo,
            "price": price,
            "orderNo": orderNo
        },
        success: function(data) {
            if(1 == data) {
                window.location.href="/placeOrder/toServiePage?orderNo=" + orderNo;
            }else {
                //alertInfo("提交订单失败");
                alertInfo("The order submission is unsuccessful.");
            }
        },
        error: function(e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}


//传文件列表点击出现下拉选项
$(function(){
    $('#uploadTable').on('click','.box',function(){
        var i = $(this).attr('data-num')
        i++;
        var mynum=$(this).attr({'data-num' :i});
        if(i%2==0){
            $(this).next().css({'display':'none'});
        }else{
            $('#uploadTable .spinner-box').css({'display':'none'});
            $(this).next().css({'display':'block'});
        }
    });

    //点击选择服务
    $('#uploadTable').on('click','.spinner-box ul li',function(){

        var myValue=$(this).html();
        $(this).parent().parent().prev().find('.state').html(myValue);
        $('#uploadTable  .box').attr({'data-num':"0"})
        $(this).parent().parent().prev().attr({'data-num':"0"})
        $(this).parent().parent().css({'display':'none'})
    })

    //关闭弹框
    $('.mask-box').on('click','.close',function(){
        $('.mask-bg').hide();
        $('.mask-box').fadeOut();
    });

    // $('.spinner-box').on('mouseleave',function(){
    //     $('.spinner-box').slideUp();
    // });

    $('.order-upload-slt .spinner1').on('click','.state , a',function(){
        var myDataNum = $('.spinner1').attr('data-num');
        myDataNum++;
        $('.spinner1').attr({'data-num':myDataNum});
        if(myDataNum%2==0){
            $(this).parents('.spinner').find('.spinner-box').slideUp();
        }else{
            $(this).parents('.spinner').find('.spinner-box').slideDown();
        }

        $('.spinner-warp .spinner-box-left').slideUp();
        $('.spinner-warp .spinner-box-right').slideUp();
        $(this).parents('.spinner').find('.spinner-box').on('click','li',function(){
            $('.spinner1').attr({'data-num':0});
            $(this).parents('.spinner').find('.spinner-box').slideUp();
            $(this).parents('.spinner').find('.state').html($(this).text());
            $('.right-inner .country').find('.p-right').show().html($(this).text());
        });
    });

    //原语种选择框
    $('.order-upload-slt .spinner2-warp').on('click','.state , a',function(){
        $(this).parents('.spinner').find('.spinner-box').slideDown();
        var myDataNum1 = $('.spinner2-warp').attr('data-num');
        myDataNum1++;
        $('.spinner2-warp').attr({'data-num':myDataNum1});
        if(myDataNum1%2==0){
            $(this).parents('.spinner').find('.spinner-box').slideUp();
        }else{
            $(this).parents('.spinner').find('.spinner-box').slideDown();
        }
        $('.spinner1 .spinner-box').slideUp();
        $('.spinner-warp .spinner-box-right').slideUp();
        $(this).parents('.spinner').find('.spinner-box').on('click','.select1',function(){

            var index=$(this).parent().index();
            // $('.spinner-box-right ul li').eq(index).find('span').css({'display':'block'});
            // $('.spinner-box-right ul li').eq(index).siblings().find('span').css({'display':'none'});
            $(this).parents('.spinner').find('.spinner-box').slideUp();
            $(this).parents('.spinner').find('.state').html($(this).text());
            $('.right-inner .lang').find('.p-right').show().find('span:first').html($(this).text());

            var leftVal = $('#sLan').html();
            var rightVal = $('#tLan').html();
            if(leftVal == rightVal) {
                $('.spinner2-warp').attr({'data-num': 0});
                $('#tLan').html("Translate to");
                $('.right-inner .lang').find('.p-right').show().find('span:last').html("");
            }

                //原语种名称
                var sLanStr = $('#sLan').html();
                //目标语种名称
                var tLanStr = $('#tLan').html();

                //选择原语种后，生成目标语种的规则
                $(".spinner-box ul li .select1").each(function () {
                    if ($(this).html() == sLanStr) {
                        var sLanId = $(this).parent().attr("value");
                        //English对应的id值为2(sys_language表)
                        if (sLanId != 2) {
                            $(".spinner-box ul li .select").each(function () {
                                var thisId = $(this).parent().attr("value");
                                if (thisId == 2) {
                                    $(this).parent().css("display", "block");
                                } else {
                                    $(this).parent().css("display", "none");
                                }
                            });
                        } else {
                            $(".spinner-box ul li .select").each(function () {
                                $(this).parent().css("display", "block");
                            });
                        }
                    }
                });

                if (sLanStr == tLanStr) {
                    $('#tLan').html("Translate to");
                    $('.right-inner .lang').find('.p-right').show().find('span:last').html("");
                }

                //在用户上传文件后，若改变语种选择，则重新计价
                getPrice();
        });
    });

    //目标语种选择框
    $('.order-upload-slt .spinner3-warp').on('click','.state , a',function(){
        var myDataNum2 = $('.spinner3-warp').attr('data-num');
        myDataNum2++;
        $('.spinner3-warp').attr({'data-num':myDataNum2});
        if(myDataNum2%2==0){
            $(this).parents('.spinner').find('.spinner-box').slideUp();
        }else{
            $(this).parents('.spinner').find('.spinner-box').slideDown();
        }
        $('.spinner1 .spinner-box').slideUp();
        $('.spinner-warp .spinner-box-left').slideUp();
       // $(this).parents('.spinner').find('.spinner-box').slideDown();
        $(this).parents('.spinner').find('.spinner-box').on('click','.select',function(){
            $(this).parents('.spinner').find('.spinner-box').slideUp();
            $(this).parents('.spinner').find('.state').html($(this).text());
            $('.right-inner .lang').find('.p-right').show().find('span:last').html($(this).text());
            $('.spinner3-warp').attr({'data-num':0});
            //原语种名称
            var sLanStr = $('#sLan').html();
            //目标语种名称
            var tLanStr = $('#tLan').html();

            //如果先选择目标语种，则对应生成原语种的生成规则
            $(".spinner-box ul li .select").each(function() {
                if($(this).html() == tLanStr) {
                    var tLanId = $(this).parent().attr("value");
                    //English对应的id值为2(sys_language表)
                    if(tLanId != 2) {
                        $(".spinner-box ul li .select1").each(function() {
                            var thisId = $(this).parent().attr("value");
                            if(thisId == 2) {
                                $(this).parent().css("display", "block");
                            }else {
                                $(this).parent().css("display", "none");
                            }
                        });
                    }else {
                        $(".spinner-box ul li .select1").each(function() {
                            $(this).parent().css("display", "block");
                        });
                    }
                }
                //在用户上传文件后，若改变语种选择，则重新计价
                getPrice();
            });
        });
    });

    //删除上传文件行
    $('#uploadTable').on('click','.delete', function(){
        var fileName = $(this).prev().html();
        var currentTag = $(this);
        alertConfirm("Do you need to delete this file?", function(){
            layer.closeAll('dialog');
            $.ajax({
                type: "POST",
                url: "/file/deleteFile",
                dataType: "json",
                data: {
                    "fileName": fileName,
                    "orderNo": orderNo
                },
                success: function(data) {
                    //删除文件成功
                    if(1 == data) {
                        $(this).parents('tr').nextAll('tr').each(function(){
                            var xuhao =  $(this).find('td:first').text();
                            $(this).find('td:first').text(xuhao-1);
                        });

                        currentTag.parent().parent().parent().remove();
                        var $index = currentTag.parent().parent().parent().find('td:eq(0)').html()*1-1;
                        $('.order-file-list1 li').eq($index).remove();

                        $('#fileListTable tbody tr').each(function(index){
                            $(this).find('td').eq(0).html(index*1+1);
                        })

                        $('.order-file-list1 li').each(function(index){
                            $(this).find('.file-name span').html(index*1+1);
                        })

                        getPrice();
                    }else if(0 == data) {
                        alertInfo("delete file failure");
                    }
                },
                error: function(e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });
        },function(){
            return;
        });
    });

    //页面数量控制--减少页面
    $('#uploadTable').on('click','.reduce',function(){
        var num = $(this).siblings('input').val();
        num--;
        if(num < 1){
            num = 1;
        }
        $(this).siblings('input').val(num);
        var $index = $(this).parent().parent().parent().find('td:eq(0)').html()*1-1;
        $('.order-file-list1 li').eq($index).find('#pageNum').html(num);
        getPrice();
    });

    //页面数量控制--增加页面
    $('#uploadTable').on('click','.plus',function(){
        var num = $(this).siblings('input').val();
        num++;
        $(this).siblings('input').val(num);
        var $index = $(this).parent().parent().parent().find('td:eq(0)').html()*1-1;
        $('.order-file-list1 li').eq($index).find('#pageNum').html(num);
        getPrice();
    });

    //点击update file按钮
    $('.uploadLink').on('click',function() {
        var country = $('.right-inner .country').find('.p-right').show().html();
        var sLanStr = $('.right-inner .lang').find('.p-right').show().find('span:first').html();
        var tLanStr = $('.right-inner .lang').find('.p-right').show().find('span:last').html();
//        uploader.options.formData.orderid = encryptedStr($("#orderid").val());
        //uploader.options.formData.orderNo = encryptedStr(orderNo);
        if(!$.string.isNullOrEmpty(country) && !$.string.isNullOrEmpty(sLanStr) && !$.string.isNullOrEmpty(tLanStr)) {
            $('.mask-bg').show();
            $('#uploadFile').css('left','50%').show();
        }else {
            // alertInfo("请先完善国家和语种选择（文字待翻译）");
            alertInfo("Please select country and translation languages first!");
        }
    });
    //初始化上传组件
    uploadFile();
});

function uploadFile() {
	orderNo = getUrlParam("orderNo");
    var $list = $('#thelist'),
        $filelistTable = $('#fileListTable'),
        $orderFileList = $('#orderFileList'),
        $btn = $('#ctlBtn'),
        state = 'pending',
        $picker = $('#picker');

    uploader = WebUploader.create({

        // 不压缩image
        resize: false,

        formData: {
            orderNo: ""
        },

        pick: {
            id: '#picker',
            name: "file",  //这个地方 name 没什么用，虽然打开调试器，input的名字确实改过来了。但是提交到后台取不到文件。如果想自定义file的name属性，还是要和fileVal 配合使用。
            multiple:true            //默认为true，true表示可以多选文件，HTML5的属性
        },

        //单个文件最大为20M
        fileSingleSizeLimit: 20*1024*1024,

        // swf文件路径
        swf: BASE_URL + '/js/Uploader.swf',

        // 文件接收服务端。
        server: '/file/uploadFile',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        //pick: '#picker',
        duplicate : false //前端对重复的文件名不作拦截，拦截放在后台
    });

    WebUploader.ser

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        //$list.append( '<div id="' + file.id + '" class="item">' +
        //'<h4 class="info">' + file.name + '</h4>' +
        //'<p class="state">等待上传...</p>' +
        //'</div>' );
        $orderFileList.show();
        // $orderFileList.append('<li class="clearfix"><p class="file-name"> <span>1</span>、' + file.name + '</p><div class="file-num">' + '<div><p id="pageNum">1</p>Page(s)</div>' + '</div></li>');
        //$orderFileList.append("");
        $orderFileList.append('<li class="clearfix" style="display:none;">1</li>');
        $orderFileList.find('li').hasClass('clearfix');
        //文件添加到文件队列，提交时才能全部提交到后台；设置定时器确保所有文件都添加到队列
        if(!timer){
            timer = window.setTimeout(function () {
                $btn.trigger('click');
            }, 500);
        }

        // var lengthLeft=$('#fileListTable tbody tr').length*1;
        // var lengthRight=$('.order-file-list li').length*1;
        // var myIndex=lengthRight-2;
        // if(lengthRight-lengthLeft>1){
        //     //alert(lengthRight-lengthLeft);
        //     $('.order-file-list li').eq(myIndex).remove();
        // }
//        if($orderFileList.find('li').hasClass('clearfix')){
//            $btn.trigger('click');
//        }
    });

    // 文件上传过程中创建进度条实时显示。
    uploader.on( 'uploadProgress', function( file, percentage ) {
        var $li = $( '#'+file.id ),
            $percent = $li.find('.progress .progress-bar');

        // 避免重复创建
        if ( !$percent.length ) {
            $percent = $('<div class="progress progress-striped active">' +
                '<div class="progress-bar" role="progressbar" style="width: 0%">' +
                '</div>' +
                '</div>').appendTo( $li ).find('.progress-bar');
        }

        $li.find('p.state').text('UPLOADING');

        $percent.css( 'width', percentage * 100 + '%' );
    });

    uploader.on('uploadSuccess', function(file, data) {
        if(data == 1) {
            $filelistTable.find('tbody').append(
                '<tr id ="' + file.id + '"><td>' + 123+ '</td><td><p class="file-name"><span>' + file.name +'</span><a href="javascript:;" class="delete"> + ' +
                '删除' + '</a></p></td><td><div class="spinner-warp"><div class="spinner"><p class="box" data-num="0"><span class="state">' + 'Please Choose' +
                '</span><a href="javascript:;" >' + '下拉箭头' + '</a></p><div class="spinner-box"><ul><li>' + 'Birth / Death Certificate' + '</li><li>' +
                'Marriage / Divorce Certificate' + '</li><li>' + 'Graduation/Educational Certificate' + '</li><li>' + 'Transcript' +'</li><li>'+ 'License'+
                '</li><li>' + 'Identification Card' +'</li><li>' + 'Household Register' + '</li><li>' + 'Passport' + '</li><li>' + 'Medical/Hospitalization Certificate'+
                '</li><li>' + 'Property Paper/Real Estate Deed' + '</li><li>' + 'Contract' + '</li><li>' + 'Statement' + '</li><li>' + 'Court Document' + '</li><li>' +
                'Agreement' + '</li><li>' + 'Affidavits' + '</li><li>' + 'Others' + '</li></ul>' + '</div></div></div></td><td>' +
                '<div class="num-inp clearfix">' + '<a href="javascript:;" class="reduce">' + '-' + '</a><input type="text" value="1" readonly/><a href="javascript:;" class="plus">'
                + '+' + '</a></div></td></tr>'
            );
            $('#fileListTable tbody tr').each(function(index,data){
                $(this).find('td').eq(0).html(index * 1 + 1);
            })

            $("#orderFileList1").show();
            $("#orderFileList1").append('<li class="clearfix"><p class="file-name"> <span>1</span>、' + file.name + '</p><div class="file-num">' + '<div><p id="pageNum">1</p>Page(s)</div>' + '</div></li>');
            $('.order-file-list1 li').each(function(index,data){
                $(this).find('.file-name span').html(index * 1 + 1);
            });

//            $("#orderid").val(Number(data));
            getPrice();
        }else if(-1 == data) {
            //alertInfo("请选择符合格式要求的文件!");
            alertInfo("Please upload files with only JPG, JPEG, GIF, PNG, BMP, PDF, PPT, PPTX, DOC AND <br/>DOCX format.");
        }else if(-2 == data) {
            //alertInfo("上传文件最多为5个");
            alertInfo("You can only upload maximum FIVE files.")
        }else if(-3 == data) {
            //alertInfo("请不要上传同名文件");
            alertInfo("Please do not upload files with identical file name.");
        }
        $( '#'+file.id ).find('p.state').text('UPLOADED');
    });

    uploader.on( 'uploadError', function( file ) {
        //alertInfo("请选择小于20M的文件!");
        alertinfo("Please upload file with size less than 20M.");
        $( '#'+file.id ).find('p.state').text('UPLOAD ERROR');
    });

    uploader.on( 'uploadComplete', function( file ) {
        $( '#'+file.id ).find('.progress').fadeOut();
    });

    uploader.on( 'all', function( type ) {
        if ( type === 'startUpload' ) {
            state = 'uploading';
        } else if ( type === 'stopUpload' ) {
            state = 'paused';
        } else if ( type === 'uploadFinished' ) {
            state = 'done';
        }

        if ( state === 'uploading' ) {
            $btn.text('PAUSE UPLOADING');
        } else {
            $btn.text('START UPLOADING');
        }
    });

    $btn.on( 'click', function() {
        if ( state === 'uploading' ) {
            uploader.stop();
        } else {
        	if(!orderNo){
        		orderNo = encryptedStr(generateOrderNo());
        	}
        	uploader.options.formData.orderNo = orderNo;
            timer = null;
            uploader.upload();
        }

        $('.mask-bg').hide();
        $('#uploadFile').hide();
    });
};

/**
 * 生成订单编号
 * @returns {String}
 */
function generateOrderNo() {
    return "CE" + new Date().Format("yyyyMMddhhmmssSSS") + Math.floor(Math.random()*9000000+999999);
}

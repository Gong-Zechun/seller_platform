jQuery(function() {
    var $ = jQuery,
        $list = $('#thelist'),
        $filelistTable = $('#fileListTable'),
        $orderFileList = $('#orderFileList'),
        $btn = $('#ctlBtn'),
        state = 'pending',
        $picker = $('#picker'),
        uploader;

    uploader = WebUploader.create({

        // 不压缩image
        resize: false,

        // swf文件路径
        swf: BASE_URL + '/jslib/Uploader.swf',

        // 文件接收服务端。
        server: 'http://webuploader.duapp.com/server/fileupload.php',

        // 选择文件的按钮。可选。
        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
        pick: '#picker'
    });

    // 当有文件添加进来的时候
    uploader.on( 'fileQueued', function( file ) {
        //$list.append( '<div id="' + file.id + '" class="item">' +
        //'<h4 class="info">' + file.name + '</h4>' +
        //'<p class="state">等待上传...</p>' +
        //'</div>' );

        //console.log(Number((file.id).replace(/[^0-9]+/g, '')) + 1);

        $filelistTable.find('tbody').append(
        '<tr id ="' + file.id + '"><td>' + (Number((file.id).replace(/[^0-9]+/g, '')) + 1) + '</td><td><p class="file-name"><span>' + file.name +'</span><a href="javascript:;" class="delete"> + ' +
        '删除' + '</a></p></td><td><div class="spinner-warp"><div class="spinner"><p class="box"><span class="state">' + 'Please Choose' +
        '</span><a href="javascript:;">' + '下拉箭头' + '</a></p><div class="spinner-box"><ul><li>' + 'Birth / Death Certificate' + '</li><li>' +
        'Marriage / Divorce Certificate' + '</li><li>' + 'Graduation/Educational Certificate' + '</li><li>' + 'Transcript' +'</li><li>'+ 'License'+
        '</li><li>' + 'Identification Card' +'</li><li>' + 'Household Register' + '</li><li>' + 'Passport' + '</li><li>' + 'Medical/Hospitalization Certificate'+
        '</li><li>' + 'Property Paper/Real Estate Deed' + '</li><li>' + 'Contract' + '</li><li>' + 'Statement' + '</li><li>' + 'Court Document' + '</li><li>' +
            'Agreement' + '</li><li>' + 'Affidavits' + '</li><li>' + 'Others' + '</li></ul>' + '</div></div></div></td><td>' +
        '<div class="num-inp clearfix">' + '<a href="javascript:;" class="reduce">' + '-' + '</a><input type="text" value="1"/><a href="javascript:;" class="plus">'
            + '+' + '</a></div></td></tr>'
        );

        $orderFileList.show();
        $orderFileList.append('<li class="clearfix"><p class="file-name">' +
        (Number((file.id).replace(/[^0-9]+/g, '')) + 1) + '、' +  file.name +
        '</p><p class="file-num">' + '1Pages' + '</p></li>');


        if($orderFileList.find('li').hasClass('clearfix')){
            $btn.trigger('click');
        }

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

    uploader.on( 'uploadSuccess', function( file ) {
        $( '#'+file.id ).find('p.state').text('UPLOADED');
    });

    uploader.on( 'uploadError', function( file ) {
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
            uploader.upload();
        }

        $('.mask-bg').hide();
        $('#uploadFile').hide();
    });
});

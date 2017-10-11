//f&q
$('#fqForm .inp-txt').focus(function() {
    $(this).siblings('.error').show().html('');
});

$('#fqForm').on('click', '.btn', function() {
    var email = $(".user p span").html();
    if($.string.isNullOrEmpty(email)) {
        alertConfirm("Please login first.", function() {
            window.location.href="/index";
        })
    }else{
        var faqContent = $('#fqForm .inp-txt').val();

        if($.string.isNullOrEmpty(faqContent)){
            $(this).siblings('.error').show().html('error');
        }else{
            $.ajax({
                type: "POST",
                url: "/sgfaq/submitContent",
                dataType: "json",
                data: {
                    "faqContent": faqContent
                },
                success: function(data) {
                    if(data > 0) {
                        alertConfirm("Do you want to submit?", function() {
                            alertInfo("Submission successful");
                            $('#fqForm .inp-txt').val("");
                        })
                    }
                },
                error: function(e) { //服务器响应失败处理函数
                    console.log(e);
                }
            });

        }
    }
});
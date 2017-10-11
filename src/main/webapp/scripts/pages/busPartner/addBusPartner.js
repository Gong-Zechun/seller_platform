$(function(){
   $('.myform').find('.slt-warp').each(function(){	   	
        $(this).on('click','input,lable',function(){
            if($(this).parents('.slt-warp').find('input').is(':checked')){
                $(this).parents('.slt-warp').find('.chk').addClass('chked');
            }else{
                $(this).parents('.slt-warp').find('.chk').removeClass('chked');
            }
        });
    });
    $('.prev').html("<");
    $('.next').html(">");
//  鼠标放上的动画效果
	$('.imgBox ul li div').on('mouseenter',function(){
		$(this).find('i').animate({'height':"100%"},500);
		$(this).find("i span p").css({'display':"block","color":'#fff'}).addClass('myactive1');
		
	})	
	$('.imgBox ul li div').on('mouseleave',function(){
		$(this).find('i').animate({'height':"0%"},500);
		$(this).find("i span p").css({'display':"none","color":'#fff'}).removeClass('myactive1');
		
	});
	$("#birthday").fdatepicker();
	var birthday = $("#birthday").val();
	if(!$.string.isNullOrEmpty(birthday)){
		$("#birthday").val($.date.format(birthday,'MM/dd/yyyy'));
	}
	if(isUploadingPhoto == '1'){
		focusElement("chkEmail");
	}
	isUploadingPhoto = "0";
});

/**
 * 选择代理人照片
 */
function selectAgentPhoto(){
	$("#agentPhoto").click();
}

/**
 * 选中资格证书
 */
function selectCertPhoto(){
	$("#certificatePhoto").click();
}

/**
 * 选择企业资格证书
 */
function selectEnterCe(){
	$("#enterpriseQualifyPhoto").click();
}

/**
 * 上传图片
 */
function uploadPhoto(){
	$("#busPartnerForm").submit();
}

/**
 * 提交表单
 */
function submitForm(){
	var busPartnerFormData = getFormData("busPartnerForm");
	if(!validate(busPartnerFormData)){
		return;
	}
	$.ajax({
        type: "POST",
        url: "/busPartner/submitPartner",
        dataType: "json",
        async: false,
        data: busPartnerFormData,
        success: function(data) {
            if(1 == data) {
            	alertInfo("Your information has sent successfully!", vt.GOLBAL_INDEX_URL);
            } else {
            	alertWarn("Sorry, please rewrite your information and submit!");
            }
        },
        error: function(e) { //服务器响应失败处理函数
            console.log(e);
        }
    });
}

/**
 * 验证form
 * @param formData
 * @returns {Boolean}
 */
function validate(formData){
	if($.string.isNullOrEmpty(formData.name)){
		alertWarn("Please enter name!");
		focusElement("name");
		return false;
	}
	if($.string.isNullOrEmpty(formData.birthday)){
		alertWarn("Please enter birthday!");
		focusElement("birthday");
		return false;
	}
	if($.string.isNullOrEmpty(formData.gender)){
		alertWarn("Please enter gender!");
		focusElement("gender");
		return false;
	}
	if($.string.isNullOrEmpty(formData.certificateType)){
		alertWarn("Please enter certificate type!");
		focusElement("certificateType");
		return false;
	}
	if($.string.isNullOrEmpty(formData.education)){
		alertWarn("Please enter education!");
		focusElement("education");
		return false;
	}
	if($.string.isNullOrEmpty(formData.certificateNumber)){
		alertWarn("Please enter certificate number!");
		focusElement("certificateNumber");
		return false;
	}
	if($.string.isNullOrEmpty(formData.occupation)){
		alertWarn("Please enter occupation!");
		focusElement("occupation");
		return false;
	}
	if($.string.isNullOrEmpty(formData.languageSkill)){
		alertWarn("Please enter language skill!");
		focusElement("languageSkill");
		return false;
	}
	if($.string.isNullOrEmpty(formData.companyName)){
		alertWarn("Please enter company name!");
		focusElement("companyName");
		return false;
	}
	if($.string.isNullOrEmpty(formData.tel)){
		alertWarn("Please enter company telphone!");
		focusElement("tel");
		return false;
	}
	if($.string.isNullOrEmpty(formData.email)){
		alertWarn("Please enter company email!");
		focusElement("email");
		return false;
	}
	var reg = /\w+[@]{1}\w+[.]\w+/;
	if(!reg.test(formData.email)){
		alertWarn("Please enter right company email format");
		focusElement("email");
		return false;
	}
	if($.string.isNullOrEmpty(formData.bankAccountName)){
		alertWarn("Please enter company bank account name!");
		focusElement("bankAccountName");
		return false;
	}
	if($.string.isNullOrEmpty(formData.bankAccountNumber)){
		alertWarn("Please enter company bank account number!");
		focusElement("bankAccountNumber");
		return false;
	}
	if($.string.isNullOrEmpty(formData.address)){
		alertWarn("Please enter company address!");
		focusElement("address");
		return false;
	}
	if($.string.isNullOrEmpty($("#agentPhoto").attr("valueAttr"))){
		alertWarn("Please upload photo of agent(Persional)!");
		focusElement("agentPhoto");
		return false;
	}
	if($.string.isNullOrEmpty($("#certificatePhoto").attr("valueAttr"))){
		alertWarn("Please upload photo copy of valid certificate!");
		focusElement("certificatePhoto");
		return false;
	}
	if($.string.isNullOrEmpty($("#enterpriseQualifyPhoto").attr("valueAttr"))){
		alertWarn("Please upload photo copy of enterprise qualification certificate(If avaiable)!");
		focusElement("enterpriseQualifyPhoto");
		return false;
	}
	if(!$('#chkEmail').is(':checked')) {
		alertWarn("If you confirm the information, please check the check box!");
		focusElement("chkEmail");
		return false;
	}
	return true;
}
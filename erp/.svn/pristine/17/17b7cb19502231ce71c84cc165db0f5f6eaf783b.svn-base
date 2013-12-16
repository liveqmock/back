/**
 *
 *  统计录入框的字数
 *
**/

function valueChangeGetCount(valueId, countId){
	var value = $("#" + valueId).val();
	if(value != ""){
		$("#" + countId).html(value.length);
	}else{
		$("#" + countId).html("");
	}
}


function valueChangeGetCount(valueId, countId, redLength){
	var value = $("#" + valueId).val();
	if(value != ""){
		var length = value.length;
		if(length >= redLength){
			$("#" + countId).html("<font color='red'>" + length + "</font>");
		}else{
			$("#" + countId).html(length);
		}
	}else{
		$("#" + countId).html("");
	}
}


function initPageValue(){
	getBirthday();
	getGenderAndArea();
}

function getBirthday(){
	var idcardType = $("#idcardType").combobox("getValue");
	var idcardNo = $("#idcardNo").val();
	if(idcardType=='1'){
		var birthday = '';
		if(idcardNo.length==15){
			birthday = '19'+idcardNo[6]+idcardNo[7]+'-'+idcardNo[8]+idcardNo[9]+'-'+idcardNo[10]+idcardNo[11];
		}
		if(idcardNo.length==18){
			birthday = idcardNo[6]+idcardNo[7]+idcardNo[8]+idcardNo[9]+'-'+idcardNo[10]+idcardNo[11]+'-'+idcardNo[12]+idcardNo[13];
		}
		if(birthday[5]>1){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		if(birthday[5]==1&&birthday[6]>2){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		if(birthday[5]==0&&birthday[6]==0){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		if(birthday[8]>3){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		if(birthday[8]==3&&birthday[9]>1){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		if(birthday[8]==0&&birthday[9]==0){
			$("#birthday").attr("value",'');
			$("#birthday").val('');
			return;
		}
		$("#birthday").attr("value",birthday);
	}
	
}

function getGenderAndArea(){
	var idcardType = $("#idcardType").combobox("getValue");
	var idcardNo = $("#idcardNo").val();
	if(idcardType=='1'){
		if(idcardNo.length==15){
			if(idcardNo[13]%2==1){
				$("#gender").combobox("setValue","1");
			}else{
				$("#gender").combobox("setValue","0");
			}
			$.ajax({
				type:"post",
				url:"./saleunit_new/appoint/guangzhou/getLocationFromIdCard.action",
				data:"idcardNo="+idcardNo,
				dataType:"json",
				success:function(data){
					if($("#householdProvince").combobox("getValue")==""){
					$("#householdProvince").combobox("setValue",data.province);
					$("#householdCity").combobox("setValue",data.city);
					$("#householdRegion").combobox("setValue",data.region);
					}
				}
			})
		}else if(idcardNo.length==18){
			if(idcardNo[16]%2==1){
				$("#gender").combobox("setValue","1");
			}else{
				$("#gender").combobox("setValue","0");
			}
			$.ajax({
				type:"post",
				url:"./saleunit_new/appoint/guangzhou/getLocationFromIdCard.action",
				data:"idcardNo="+idcardNo,
				dataType:"json",
				success:function(data){
					if($("#householdProvince").combobox("getValue")==""){
					$("#householdProvince").combobox("setValue",data.province);
					$("#householdCity").combobox("setValue",data.city);
					$("#householdRegion").combobox("setValue",data.region);
					}
				}
			})
		}
	}
		
}




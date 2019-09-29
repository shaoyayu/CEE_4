var InterValObj; 
var count = 90;
var curCount; 
function sendMessage() {
	var user_mail = $("#userName").val();
	var responseData;
	$.ajax({
		url:"LogInToToken.do",
		type:"POST",
		data: {
			"user_mail": user_mail
		},
		success:function (data) {
			alert(data);
			responseData = data;
		}
	});
	curCount = count;
	document.getElementById("btnSendCode").setAttribute("disabled", "true");
	document.getElementById("btnSendCode").value = curCount + "秒后重获";
	InterValObj = window.setInterval(SetRemainTime, 1000);
}
function SetRemainTime() {
	if (curCount == 0) { 
		window.clearInterval(InterValObj); 
		document.getElementById("btnSendCode").removeAttribute("disabled");
		document.getElementById("btnSendCode").innerHTML = "重获验证码";
	} else {
		curCount--;
		document.getElementById("btnSendCode").innerHTML = curCount + "秒后重获";
	}
}

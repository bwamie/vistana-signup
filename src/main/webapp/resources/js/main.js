/**
 * 
 */

function loginSubmit() {
	
	if(!validateLogin()){
		document.getElementById("invalid-username").innerHTML = "Invalid Username. 	Username must be alphanumeric values and	length	most	be	between	5	and	12	character.";
		return false;
	}
	
	let username = $("#username").val();
	
	$.ajax({
		url : 'login',
		method : 'post',
		data : 'username=' + username,
		complete : function(data) {
			if (data.responseText == "ok") {
				window.location = "login-qns?username="+username;
			}else{
				document.getElementById("invalid-username").innerHTML = "Invalid Username. Try again!";
			}
		}
	});

}

//Validate login form
var validateLogin = function(){
	let username = $('#username').val();
	let len = username.length;
	if(username == ""){
		return false;
	}else if(len < 5 || len > 12 || !containsOnlyAlphanumeric(username)){
		return false;
	}
	return true;
	
};


function containsOnlyAlphanumeric(str){
    if( /[^a-zA-Z0-9]/.test( str ) ) {
       return false;
    }
    return true;     
 }

//Validate Registration form


//Validate security questions
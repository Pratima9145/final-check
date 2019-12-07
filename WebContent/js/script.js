function validation() {
	var a=document.forms["movieform"]["txtTitle"].value;
	if(a=="") {
		alert("Title is required");
		return false;
	}
	if((a.length <2) || (a.length > 100)) {
		alert("Title should have 2 to 100 characters");
		document.forms["movieform"]["txtTitle"].select();
		return false;
	}
	var b=document.forms["movieform"]["txtGrosss"].value;
	if(b=="") {
		alert("Gross is required");
		document.forms["movieform"]["txtGrosss"].focus();
		return false;
	}
	if(/[^0-9]/.test(b)) {
		alert("Gross has to be a number");
		return false;
	}
	var c=document.forms["movieform"]["txtLaunch"].value;
	if(c=="") {
		alert("Date of launch is required");
		document.forms["movieform"]["txtLaunch"].focus();
		return false;
	}
	var d=document.forms["movieform"]["genres"].value;
		if(d=="") {
			alert("Select one genre");
			return false;
		}
	alert("Details submitted successfully");
}
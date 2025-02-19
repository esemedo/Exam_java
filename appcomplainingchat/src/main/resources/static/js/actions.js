window.onload = function() {
	var div = document.getElementById("chat");
    div.scrollTop = div.scrollHeight;
};


function pressEnter(event) {
	var code=event.which || event.keyCode; 
    if (code==13) {              
		document.getElementById("form-message").submit();
    }
}
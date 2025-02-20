function toggleMessages(li) {
	var userId = li.getAttribute("data-user-id")
    let allMessageBoxes = document.querySelectorAll('.historic-chat');
    allMessageBoxes.forEach(box => box.style.display = 'none');
    let messageBox = document.getElementById('messages-' + userId);
    if (messageBox) {
       messageBox.style.display = 'block';
    }
}
	   
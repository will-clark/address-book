function clearInput(ele) {
    $(ele).find(":input").each(function() {
        switch(this.type) {
            case "password":
            case "select-multiple":
            case "select-one":
            case "text":
            case "textarea":
                $(this).val("");
                break;
            case "checkbox":
            case "radio":
                this.checked = false;
        }
    });
}

function openWindow(url) {
	window.open(url);
	return false;
}

function openSmallerWindow(url) {
	window.open(url, 'smallerWindow', config='height=450, width=800, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, directories=no, status=no');
	return false;
}

function redirect(url) {
	window.location.href = base_url + url;
}
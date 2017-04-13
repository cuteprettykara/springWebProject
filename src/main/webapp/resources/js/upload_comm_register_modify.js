var template = Handlebars.compile($("#templateAttach").html());

var formObj = $("form[role='form']");

formObj.submit(function(event){
	event.preventDefault();
	var that = $(this);
	
	var str ="";
	$(".uploadedList .delbtn").each(function(index){
		 str += "<input type='hidden' name='files["+index+"]' value='"+$(this).attr("href") +"'> ";
	});
	
	that.append(str);

	that.get(0).submit();
});

$(".fileDrop").on("dragenter dragover", function(event) {
	event.preventDefault();
});

$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var file = files[0];

	var formData = new FormData();
	formData.append("file", file);
	
	$.ajax({
		type: 'POST',
		url: '/uploadAjax',
		dataType:'text',
		data: formData,
		processData: false,
		contentType: false,
		success: function(data){
			
			var fileInfo = getFileInfo(data);
			var html = template(fileInfo);
			$(".uploadedList").append(html);
		  }
	});	
});
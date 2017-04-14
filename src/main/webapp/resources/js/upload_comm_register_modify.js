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

//수정화면에서 파일 첨부시에 tbl_attach에 insert하기 위한 용도로 bno 값이 필요함.
//등록화면일 경우는 강제로 0으로 세팅하여 구별함.
if (typeof bno == 'undefined') {// 등록화면(register.jsp)
	var bno = 0;
} else {						//수정화면(modifyPage.jsp)
	var bno = bno;	// 한 번 더 정의해주어야 에러가 안남. 이해불가...
}

$(".fileDrop").on("drop", function(event){
	event.preventDefault();
	
	var files = event.originalEvent.dataTransfer.files;
	
	var file = files[0];

	var formData = new FormData();
	formData.append("file", file);
	
	// 수정화면에서 파일 첨부시에 tbl_attach에 insert하기 위한 용도로 'bno'를 append하고 있음.
	console.log(typeof bno + " : " + bno);
	
	formData.append("bno", bno);
	
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

$(".uploadedList").on("click", ".delbtn", function(event){
	event.preventDefault();
	var that = $(this);
	
	$.ajax({
		url: '/deleteFile',
		type: 'POST',
		dataType:'text',
		data: {fileName:$(this).attr("href")},
		success: function(result){
			if (result == 'deleted') {
				//that.parent().parent("li").remove();
				that.closest("li").remove();
			} else {
				alert("delete failed");
			}
		}
	});
});
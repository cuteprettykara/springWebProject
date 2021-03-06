<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<script type="text/javascript" src="/resources/js/upload.js"></script>

<style>
	.fileDrop {
	  width: 80%;
	  height: 100px;
	  border: 1px dotted gray;
	  background-color: lightslategrey;
	  margin: auto;
	}
	.popup {position: absolute;}
	.back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;}
	.front { 
   		z-index:1110; opacity:1; boarder:1px; margin: auto; 
  	}
 	.show{
  		position:relative;
   		max-width: 1200px; 
   		max-height: 800px; 
   		overflow: auto;       
 	} 
</style>

<div class='popup back' style="display:none;"></div>
<div id="popup_front" class='popup front' style="display:none;">
	<img id="popup_img">
</div>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

<form id="modifyForm" role="form" method="post" action="modifyPage">
	<input type='hidden' name='page' value="${cri.page}">
	<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
	<input type='hidden' name='searchType' value="${cri.searchType}">
	<input type='hidden' name='keyword' value="${cri.keyword}">
	
	<div class="box-body">

		<div class="form-group">
			<label for="exampleInputEmail1">BNO</label> 
			<input type="text" name='bno' class="form-control" value="${boardVO.bno}" readonly>
		</div>

		<div class="form-group">
			<label for="exampleInputEmail1">Title</label> 
			<input type="text" name='title' class="form-control" value="${boardVO.title}">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label> 
			<input type="text" name="writer" class="form-control" value="${boardVO.writer}">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">File DROP Here</label>
			<div class="fileDrop"></div>
		</div>
	</div>
	<!-- /.box-body -->


	<div class="box-footer">
		<div>
			<hr>
		</div>
		<ul class="mailbox-attachments clearfix uploadedList"></ul>
		
		<button type="submit" class="btn btn-primary">SAVE</button>
		<button type="button" class="btn btn-warning">CANCEL</button>
	</div>

</form>

			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script id="templateAttach" type="text/x-handlebars-template">
<li>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">
		{{fileName}}
    </a>
	<a href="{{fullName}}" class="btn btn-default btn-xs pull-right delbtn">
		<i class="fa fa-fw fa-remove"></i>
	</a>
  </div>
</li>                
</script>  


<script>
$(".btn-warning").on("click", function() {console.log("cancel");
	self.location = "/sboard/list?page=${cri.page}&perPageNum=${cri.perPageNum}"
			  + "&searchType=${cri.searchType}"
			  + "&keyword=${cri.keyword}";
});

var bno = ${boardVO.bno};
</script>	
		
			
<!-- #####################################-->
<!-- register.jsp / modifyPage.jsp 중복 부분 -->
<!-- #####################################-->
<script type="text/javascript" src="/resources/js/upload_comm_register_modify.js"></script>
<!-- #####################################-->
<!-- register.jsp / modifyPage.jsp 중복 부분 -->
<!-- #####################################-->



<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!-- readPage.jsp / modifyPage.jsp 중복 부분 -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<script type="text/javascript" src="/resources/js/upload_comm_read_modify.js"></script>
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
<!-- readPage.jsp / modifyPage.jsp 중복 부분 -->
<!-- @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->

<%@include file="../include/footer.jsp"%>

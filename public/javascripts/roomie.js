// register click handler for new activity

function newActivityClicked(){
	$.ajax({
	  url: "/act/new",
	  type: "GET",
	  success: function(result){
	  	showModal(result)
	  }
	});
}

function showModal(result){
	$("#modalWrapperId").html(result);
	$('#activityModal').modal('show')
}

$("#addActivityId").on("click",newActivityClicked);

function newDocumentClicked(){
	$(".doc").removeClass("current");
	$(this).addClass("current");
	
	$.ajax({
	  url: "/doc/new",
	  type: "GET",
	  success: function(result){
	  	showDocModal(result)
	  }
	});
}

function showDocModal(result){
	$("#modalWrapperId").html(result);
	$('#documentModal').modal('show');
	$("#taskId").attr("value", $(".doc.current").attr("data"));
}

$(".doc").on("click",newDocumentClicked)
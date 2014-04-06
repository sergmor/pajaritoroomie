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
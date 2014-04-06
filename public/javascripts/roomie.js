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

function shopClicked(){
	$.ajax({
	  url: "/delivery/stores/1330%201st%20Ave,%2010021",
	  type: "GET",
	  success: function(result){
	  	showShopModal(result)
	  }
	});
}

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


function showShopModal(result){
	$("#modalWrapperId").html(result);
	$('#storesModal').modal('show');
	$(".menulink").on("click",menulinkClicked);
}

$("#shopId").on("click",shopClicked);


function menulinkClicked(){
	var url = $(this).attr("url")
	$.ajax({
	  url: url,
	  type: "GET",
	  success: function(result){
	  	showmenuModal(result)
	  }
	});
}

function showmenuModal(result){
	$("#modalWrapperId .modal-body").html(result);
	$('#storesModal').modal('show')
}



function showDocModal(result){
	$("#modalWrapperId").html(result);
	$('#documentModal').modal('show');
	$("#taskId").attr("value", $(".doc.current").attr("data"));
}

$(".doc").on("click",newDocumentClicked)


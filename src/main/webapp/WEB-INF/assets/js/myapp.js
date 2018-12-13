$(function () {

    switch (menu) {
        case'products':
            $('#products').addClass('active');
            break;
    }


    $("input[type='checkbox']").on('change', function () {
        $(this).val(this.checked ? "TRUE" : "FALSE");
    });
    
    
    
//    $("#formR").submit(function(event) {
//		// Prevent the form from submitting via the browser.
//		event.preventDefault();
//		ajaxPost();
//	});
//
//
//
//function ajaxPost(){
//    	
//    	// PREPARE FORM DATA
//    	var formData = {
//    		username : $("#registerUsernameInput").val(),
//    		password : $("#registerUsernameInput").val()
//    	}
//
//$.ajax({
//			type : "POST",
//			contentType : "application/json",
//			url : window.location + "users/save",
//			data : JSON.stringify(formData),
//			dataType : 'json',
//			success : function(result) {
//				if(result.status == "Done"){
//					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
//												"Post Successfully! <br>" +
//												"---> Customer's Info: Username = " + 
//												result.data.username + "</p>");
//				}else{
//					$("#postResultDiv").html("<strong>Error</strong>");
//				}
//				console.log(result);
//			},
//			error : function(e) {
//				alert("Error!")
//				console.log("ERROR: ", e);
//			}
//		});
//
//};

});



/*function ajaxSubmit(method, link, input, success) {
    $.ajax({
    	url: link,
    	type: method,
    	data: input,
    	beforeSend: function(xhr){
    		xhr.setRequestHeader("Accept", "application/json");
    		xhr.setRequestHeader("Content-Type", "application/json");
    	},
    	success: function(data){
    		if (typeof success == 'function') {
    			success(data);
    		}
    	},
    	error: function(data, status,er){
    		console.log("error: " + data + " Status: " + status + " er: " + er);
    	}
    });
}*/




$(document).ready(function(){	
	
    $("#btnSearch").click(function(){
    	var json = {
    		"stuId": $("#stuId").val()
    	};
    	
    /*	ajaxSubmit('GET', baseUrl + '/searchstudent', input, function(res) {
    		console.log(res);
    	});*/
        $.ajax({
        	url: baseUrl + "/searchstudent",
        	type: "GET",
        	data: json,
        	beforeSend: function(xhr){
        		xhr.setRequestHeader("Accept", "application/json");
        		xhr.setRequestHeader("Content-Type", "application/json");
        	},
        	success: function(data){
        		console.log(data);
        	},
        	error: function(data, status,er){
        		console.log("error: " + data + " Status: " + status + " er: " + er);
        	}
        });
    });
    
    $("#btnDelete").click(function(){
    	/*ajaxSubmit('POST', baseUrl + '/deletestudent/' + $("#stuId").val(), {}, function(res) {
    		console.log(res);
    	});*/
    	$.ajax({
    		url: baseUrl + "/deletestudent/" + $("#stuId").val(),
    		type: "POST",
    		beforeSend: function(xhr){
    			xhr.setRequestHeader("Accept", "application/json");
    			xhr.setRequestHeader("Content-Type", "application/json");
    		},
    		success: function(data){
    			console.log(data);
    			if(data.deteletstudent)
    				location.reload();
    		},
    		error: function(data, status, er){
    			console.log("error: " + error + " status: " + status + " err " + er);
    		}
    	});
    });
    
/*   $("#btnUpdate").click(function(){ //work with stringify data 0001
    	var json = {
    			stuid : $("#stuId").val(),
    			stuname: $("#stuname").val(),
    			lvlyear: $("#lvlyear").val(),
    			score: $("#score").val()
    	};
    	$.ajax({
    		url: baseUrl + "/editstudent",
    		type: "POST",
    		dataType: "json",
    		data: JSON.stringify(json), // stringify the data
    		contentType: 'application/json',
    		beforeSend: function(a, b){
    			console.log(a);
    			console.log(b);
    		},
    		success: function(data){
    			console.log(data);
    		},
    		error: function(data, status, er){
    			console.log("error: " + data + " status: " + status + "er: " + er);
    		}
    		
    	});
    });*/
    $("#btnAdd").click(function(){
    	$("#frmStudent").ajaxSubmit({
    		url: baseUrl + "/insertstudent",
    		dataType: "JSON",
    		type: "POST",
    		beforeSend: function(a, b){
    			console.log(a);
    			console.log(b);
    		},
    		success: function(data){
    			console.log(data);
    			location.reload();
    		},
    		error: function(data, status, er){
    			console.log("Error: " + data + " Status " + status + " error " + er);
    		}
    	});
    });
    
    $("#btnUpdate").click(function(){ // work
    	$("#frmStudent").ajaxSubmit({
    		url: baseUrl + "/updatestudent/" + $("#stuId").val(),
    		dataType: "JSON",
    		type: "POST",
    		beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Context-Type", "application/json");
            },
            success: function(data){
    			console.log(data);
    		},
    		error: function(data, status, error){
    			console.log("Error: " + data + " Status " + status + " error " + error);
    		}
    	});
    });
    
});
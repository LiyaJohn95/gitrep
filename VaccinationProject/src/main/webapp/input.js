

$.ajax({
        type: "GET",
        url: "AddUsers",
        contentType: "application/json",
        dataType:'json',
        data:{"name":name,
        	"address":address,
        	"contactNo":contactNo,
        	"cityID":cityID,
        	"contact_person":contact_person,
        	"contact_mobile":contact_mobile,
        	"emailID":emailID,
        	"password":password,
        	"roleID":roleID,
        	"status":status,
        	"isNotification":isNotification
        	},
        success: function(status){
            console.log("Entered",status);
        },
        error:function(error){
            console.log("error",error);
        }
        
       
    });
//send(JSON.stringify(data));
function orderlist() {

	$.ajax({



		type: 'ajax',
		method: 'GET',
		data: {},
		url: '/orderlist',
		async: false,
		dataType: 'json',

		success: function(data) {

			var a = "";

			for (i = 0; i < data.length; i++) {
				a += '<tr style="text-align: center; vertical-align: middle; font-size:15px;">' +

					'<td style="text-align: center; vertical-align: middle;">' + data[i].bookFrom + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].bookTo + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].booking_date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].name + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].persons + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].mobileno + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#booking" onclick="editbooking(this.id);" th:id="${p.id}"></i> '+'&nbsp;&nbsp;&nbsp;&nbsp;'+'<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deleteBooking(this.id);"></i>'  + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + '<a id="' + data[i].id + '" class="btn  btn-primary btn-sm" style="padding :1%"data-toggle="modal" data-target="#gbccc" onclick="edit(this.id);" "> ' + data[i].status + '</a>' + '</td>' +

					'</tr>';
			}

			$("#order").html(a);
		},
		error: function() {

			alert("not fetch list");
		}





	});
};

function edit(id) {
	var id = id;

	$.ajax({

		method: 'GET',
		data: { id: id },
		url: "/edit_status",

		success: function(data) {
			console.log(data);
			$('#ids12').val(data.id);
			$('#g1').val(data.status);
		}


	});



};

function update() {
	//alert('processing order')
	var e = document.getElementById("g1").value;
	var id = document.getElementById("ids12").value;

	$.ajax({
        
		method: 'POST',
		data: { status: e, id: id },
		url: '/update_orders',
       
		success: function(data) {
			
			//alert('aaaaaa');
			$("#gbccc").modal('hide');
			changeStatus();
			
			//alert("update");
		},
	});

};




function changeStatus() {
	
	//var status = status;
 var stat= document.getElementById('selecttag').value;
 
  
  //alert(stat)
	$.ajax({



		type: 'ajax',
		method: 'GET',
		data: { status: stat },
		url: '/orderlist',
		async: false,
		dataType: 'json',

		success: function(data) {

			var a = "";

			for (i = 0; i < data.length; i++) {
				a += '<tr style="text-align: center; vertical-align: middle;">' +

					'<td style="text-align: center; vertical-align: middle;">' + data[i].bookFrom + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].bookTo + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].booking_date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].name + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].persons + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].mobileno + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#booking"  onclick="editbooking(this.id);" th:id="${p.id}"></i>  '+'<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deleteBooking(this.id);"></i>' + '</td>' +
					
					'<td style="text-align: center; vertical-align: middle;">' + '<a id="' + data[i].id + '" class="btn btn-sm btn-primary " style="padding :1%"data-toggle="modal" data-target="#gbccc" onclick="edit(this.id);" "> '+ data[i].status +'</a>' + '</td>' +

					'</tr>';
			}

			$("#order").html(a);
		},
		error: function() {

			alert("not fetch list");
		}

	});
};

function editbooking(id){
	
	$.ajax({
		
		method:'POST',
		data:{id:id},
		url:'/editbooking',
		
		success:function(data){
			//alert(data.status)
			$("#unique").val(data.id);
			
			$("#bookfromsss").val(data.bookFrom);
			$("#bookTo").val(data.bookTo);
		
			$("#name").val(data.name);
			$("#persons").val(data.persons);
			$("#mobileno").val(data.mobileno);
			$("#blogdate").val(data.date);
			 $("#bookingdate").val(data.booking_date);
		    $("#status").val(data.status);
		},
	});
};

$('document').ready(function() {

	$(document).on('submit', '#editbookings', function(e) {
		e.preventDefault();
		//var data=new FormData(this.name);

		//alert('editing  ');
		$.ajax({

			url: "/updateBookings",
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success')
				//this JQuery used for refresh page
				$("#editbookings")[0].reset();
				//This is used to hide Bootstap modal				
				$("#booking").modal('hide');
				
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
                 changeStatus();
				//Used to changed the inner HTML in bootstrp modal 
				
			},
		});


	});


});

function deleteBooking(id)
{
	//alert('deleting');
	var r = confirm("Want to delete!");
	
	if(r==true){
	$.ajax({
		
		method:'POST',
		data:{id:id},
		url:'/deleteBooking',
		
		success:function(data){
			//alert('deletoing');
			//$("#selecttag").prop('selectedIndex',0);
			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			//orderlist();
            changeStatus();
		},
		
	});
	};
};

$(document).ready(function () {
			$("#myInput").on("keyup", function () {
				var value = $(this).val().toLowerCase();
				$("#order tr").filter(function () {
					$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
				});
			});
		});

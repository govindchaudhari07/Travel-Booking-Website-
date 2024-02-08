//Add
$('document').ready(function() {

	$(document).on('submit', '#insertaboutus', function(e) {
		e.preventDefault();
		//var data = new FormData(this.name);

		//alert('comming  blog');
		$.ajax({

			url: '/addAbout',
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success');
				//this JQuery used for refresh page
				$("#insertaboutus")[0].reset();
				//This is used to hide Bootstap modal				
				$("#aboutus").modal('hide');

				//Used to changed the inner HTML in bootstrp modal 
				document.getElementById('toast').innerHTML = "Added successfully..!!";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				showToast();
				getAbout();
			},
		});
	});
});

function getAbout(){
	//alert('aaaaa');
	$.ajax({
		method:'POST',
		data:{},
		url:"/getAboutInfo",
		
		success:function(data){
			var a = "";

			for (i = 0; i < data.length; i++) {

				a += '<tr style="text-align: center; vertical-align: middle;font-size:15px;">' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<img src="' + '/uploads/' + data[i].image + '" height="80px;" width="80px;">' + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;middle;white-space: nowrap; overflow: hidden;text-overflow: ellipsis;max-width: 100px;">' + data[i].heading + '</td>' +
					'<td style="text-align: center; vertical-align: middle;middle;white-space: nowrap; overflow: hidden;text-overflow: ellipsis;max-width: 100px;">' + data[i].description + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#editabout" onclick="editaboutus(this.id);" th:id="${p.id}"></i>   '+'&nbsp;&nbsp;&nbsp;&nbsp;'+ '<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deleteaboutus(this.id);"></i>' + '</td>' +
			
					'<tr>'
			}
			
			     $("#gettingaboutus").html(a);
		},
	});
};

function editaboutus(id){
	$.ajax({
		method:'POST',
		data:{id:id},
		url:'/editAbout',
		
		success:function(data){
			
			
			$("#aid").val(data.id);
			$("#aheading").val(data.heading);
			$("#adescription").val(data.description);
			
		},
	});
};

$('document').ready(function() {

	$(document).on('submit', '#editabouts', function(e) {
		e.preventDefault();


        // alert('updating ');

		$.ajax({

			url: "/updateAboutus",
			method: "POST",
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,
			

			success: function(data) {
				
				//alert('success');
				$("#editabouts")[0].reset();
				$("#editabout").modal('hide');
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
				// $("#toast")[0].reset();
				getAbout();
			},

		});
	});
});
function deleteaboutus(id){
		//alert('deleting');
		var r = confirm(" Want to delete!");
if(r==true){
	$.ajax({
		
	
		method:'POST',
		data:{id:id},
		url:'/deleteAboutUs',
		
		success:function (data){
			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			getAbout();
		},
	});
	};
};


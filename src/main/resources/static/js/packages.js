
$('document').ready(function() {

	$(document).on('submit', '#insertpackages', function(e) {
		e.preventDefault();
		//var data = new FormData(this.name);

		//alert('comming  packages');
		$.ajax({

			url: '/addPackages',
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success');
				//this JQuery used for refresh page
				$("#insertpackages")[0].reset();
				//This is used to hide Bootstap modal				
				$("#packages").modal('hide');

				//Used to changed the inner HTML in bootstrp modal 
				document.getElementById('toast').innerHTML = "Added successfully..!!";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				showToast();
				show_packages();
			},
		});
	});
});

function show_packages() {
	//alert('success');
	$.ajax({

		method: 'POST',
		data: {},
		url: '/show_packages',

		success: function(data) {
			var a = "";

			for (i = 0; i < data.length; i++) {

				a += '<tr style="text-align: center; vertical-align: middle;font-size:15px;">' +
					'<td style="text-align: center; vertical-align: middle;">' + '<img src="' + '/uploads/' + data[i].image + '" height="80px;" width="80px;">' + '</td>' +
					'<td style="text-align: center; vertical-align: middle; width:25%;">' + data[i].heading + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + data[i].state + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].duration + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].extras + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + data[i].price + '</td>' +
					'<td style="text-align: center; vertical-align: middle;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#editpackage" onclick="editpackage(this.id);" th:id="${p.id}"></i>    '+'&nbsp'+ '<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deletepackage(this.id);"></i>' + '</td>' +
					
					'<tr>'
			}

			$("#gettingpackages").html(a);
		},
	});

};

function editpackage(id) {
	//alert("editing");
	$.ajax({
		method: 'POST',
		data: { id: id },
		url: '/editPackage',

		success: function(data) {
			//alert("success");
			$("#id").val(data.id);
			//$("#image").val(data.image);
			$("#heading1").val(data.heading);
			$("#state").val(data.state);
			$("#duration").val(data.duration);
			$("#date").val(data.date);
			$("#extras").val(data.extras);
			$("#price").val(data.price);

		},
	});
};

$('document').ready(function() {

	$(document).on('submit', '#updatepackages', function(e) {
		e.preventDefault();
		//var data = new FormData(this.name);

		//alert('comming  packages');
		$.ajax({

			url: '/Update_Packages',
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success');
				$("#updatepackages")[0].reset();
				$("#editpackage").modal('hide');
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
				// $("#toast")[0].reset();
				show_packages();
			},
		});
	});
});

function deletepackage(id){
	
	var r = confirm(" Want to delete!");
if(r==true){
	$.ajax({
		method:'POST',
		data:{id:id},
		url:'/deletePackage',
		
		success:function(data){
			
			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			show_packages();
			
		},
	});
	};
};
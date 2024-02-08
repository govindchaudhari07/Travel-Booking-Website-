//
$('document').ready(function() {

	$(document).on('submit', '#insert', function(e) {
		e.preventDefault();
		//var data=new FormData(this.name);

		//alert('comming  '+this.id)
		$.ajax({

			url: "/addDestination2",
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success')

				//this JQuery used for refresh page
				$("#insert")[0].reset();
				//This is used to hide Bootstap modal				
				$("#exampleModal").modal('hide');

				//Used to changed the inner HTML in bootstrp modal 
				document.getElementById('toast').innerHTML = "Added successfully..!!";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				showToast();
				getdestination();
				//window.location.reload();
			},
		});


	});


});
function destination() {

	var desti = document.getElementById('desti').value;
	alert(typeof (desti))
	var images = document.getElementById('images').value;
	alert(images)
	var price = document.getElementById('price').value;
	alert(price)

	$.ajax({

		method: "GET",
		data: { destination: desti, images: images, price: price },
		url: "/destination2",

		success: function(data) {
			//alert('success')
			window.location.reload();
		},
	});

};

function getdestination() {


	$.ajax({


		type: 'ajax',
		method: 'GET',
		data: {},
		url: '/getdestination',

		success: function(data) {
			var getdesti = "";

			for (i = 0; i < data.length; i++) {
				getdesti += '<tr style="text-align: center; vertical-align: middle;font-size:15px;">' +
					'<td style="text-align: center; vertical-align: middle; width:15%;">' + data[i].destinations + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<img src="' + '/uploads/' + data[i].images + '" height="80px;" width="80px;">' + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + data[i].price + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#editdest" onclick="editdesti(this.id);" th:id="${p.id}"></i>  '+'&nbsp;&nbsp;&nbsp;&nbsp;'+ '<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deletedestination(this.id);"></i>'  + '</td>' +
					
					'<tr>'

			}

			$("#getdestination").html(getdesti);

		},

	});


};

function editdesti(id) {
	//alert(id);


	$.ajax({


		method: "GET",
		data: { id: id },
		url: "/editdestination",

		success: function(data) {

			$("#unique").val(data.id);
			$("#desti").val(data.destinations);
			$("#price1").val(data.price);
			$("#images").val(data.images);

		},

	});
};


$('document').ready(function() {

	$(document).on('submit', '#edit55', function(e) {
		e.preventDefault();


		//alert('updating ');

		$.ajax({

			url: "/updateDestination",
			method: "POST",
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,


			success: function(data) {

				//alert('success');
				$("#edit55")[0].reset();
				$("#editdest").modal('hide');
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
				// $("#toast")[0].reset();
				getdestination();

			},

		});
	});
	
});


function deletedestination(id) {
	var id = id;
	// alert('deleting');

var r = confirm(" Want to delete!");
if(r==true){
	$.ajax({

		method: "POST",
		data: { id: id },
		url: "/deleteDestination",

		success: function(data) {


			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			getdestination();
		},
	});
	};	
};





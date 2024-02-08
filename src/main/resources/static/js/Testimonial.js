              //Add

$('document').ready(function() {

	$(document).on('submit', '#insert', function(e) {
		e.preventDefault();
		//var data=new FormData(this.name);

		//alert('comming  ');
		$.ajax({

			url: "/addTestimonial1",
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
				$("#testimonial1").modal('hide');

				//Used to changed the inner HTML in bootstrp modal 
				document.getElementById('toast').innerHTML = "Added successfully..!!";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				showToast();
				testimonial();
			},
		});


	});


});
                     //Get 
function testimonial() {


	$.ajax({
		url: "/getTestiminaldataByOnlaod",
		data: {},
		method: 'POST',

		success: function(data) {
			console.log(data);
			var a = "";

			for (i = 0; i < data.length; i++) {
				a += '<tr style="text-align: center; vertical-align: middle;font-size:15px;">' +

					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<img src="' + '/uploads/' + data[i].image2 + '" height="80px;" width="80px;">' + '</td>' +
					'<td style=" text-align:justify;white-space: nowrap; overflow: hidden;text-overflow: ellipsis;max-width: 80px;"title='+ data[i].feedback +'>' + data[i].feedback + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:20%">' + data[i].name + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:10px;">' + data[i].rating + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#edittesti" onclick="edittesti(this.id);" th:id="${p.id}"></i> '+'&nbsp;&nbsp;'+ '<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deletetesti(this.id);"></i>' + '</td>' +
					
					'<tr>'
			}
                  $("#testimonial").html(a);
		},
	});
};

                           //Edit
                           
 function edittesti(id){
	$.ajax({
		
		method:'GET',
		data:{id:id},
		url:'/edittestimonial',
		
		success:function(data){
			//alert(data.id);
			//console.log(data);
			$("#id").val(data.id);
			
			$("#feedback").val(data.feedback);
			$("#name").val(data.name);
			//$("#image").val(data.image2);
			$("#rating").val(data.rating);
		},
	});
};                         
                           
              //update
                           
                           
$('document').ready(function() {

	$(document).on('submit', '#edit', function(e) {
		e.preventDefault();
		//var data=new FormData(this.name);

		//alert('comming edit ');
		$.ajax({

			url: "/update_testimonial",
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success')
				$("#edit")[0].reset();
				$("#edittesti").modal('hide');
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
				// $("#toast")[0].reset();
				testimonial();
			},
		});


	});


});


           //Delete
function deletetesti(id)
{
	//alert('deleting');  
	 var r = confirm("Want to delete!");        // use to confirm delete 
	
	if(r==true){
	$.ajax({
		
		method:'POST',
		data:{id:id},
		url:'/deletetestimonial',
		
		success:function(data){
			//alert('deletoing');
			
			
			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			testimonial();

		},
		
	});
	};
	
};
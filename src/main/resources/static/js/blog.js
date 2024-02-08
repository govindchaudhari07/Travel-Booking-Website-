//for Add
$('document').ready(function() {

	$(document).on('submit', '#insertblog', function(e) {
		e.preventDefault();
		//var data = new FormData(this.name);

		//alert('comming  blog');
		$.ajax({

			url: '/addblog22',
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success');
				//this JQuery used for refresh page
				$("#insertblog")[0].reset();
				//This is used to hide Bootstap modal				
				$("#blog").modal('hide');

				//Used to changed the inner HTML in bootstrp modal 
				document.getElementById('toast').innerHTML = "Added successfully..!!";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				showToast();
				getBlog();
			},
		});


	});


});

function getBlog() {
	//alert('gettin blog');
	$.ajax({
		mehtod: 'GET',
		data: {},
		url: '/getBlogData',

		success: function(data) {
			//alert('getting blog success');
			var a = "";

			for (i = 0; i < data.length; i++) {

				a += '<tr style="text-align: center; vertical-align: middle;font-size:15px;">' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<img src="' + '/uploads/' + data[i].blogimage + '" height="80px;" width="80px;">' + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:25%;middle;white-space: nowrap; overflow: hidden;text-overflow: ellipsis;max-width: 100px;">' + data[i].heading + '</td>' +
					'<td style="text-align: center; vertical-align: middle;white-space: nowrap; overflow: hidden;text-overflow: ellipsis;max-width: 100px;"">' + data[i].blog1 + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + data[i].date + '</td>' +
					'<td style="text-align: center; vertical-align: middle;width:15%;">' + '<i id="' + data[i].id + '"  style=font-size:20px;color:blue;cursor:pointer; class="fa fa-edit" data-toggle="modal" data-target="#editblog" onclick="editblog(this.id);" th:id="${p.id}"></i>   '+'&nbsp;&nbsp;&nbsp;&nbsp'+ '<i id="' + data[i].id + '" style=font-size:20px;color:#FF7F50;cursor:pointer; class="fa fa-trash" id="toastbtn"onclick="deleteblog(this.id);"></i>' + '</td>' +
				
					'<tr>'
			}
			
			     $("#gettingblog").html(a);
		},

	});
};

function editblog(id){
	//alert('editing');
	$.ajax({
		method:'POST',
		data:{id:id},
		url:"/editBlog",
		success:function(data){
			//alert('success'+data.blogimage+data.heading+data.blog1+data.date);
			$("#blogid").val(data.id);
			
			$("#blogheading").val(data.heading);
			$("#blogblog1").val(data.blog1);
			$("#blogdate").val(data.date);
		},
	});
};


$('document').ready(function() {

	$(document).on('submit', '#editblogs', function(e) {
		e.preventDefault();


        // alert('updating ');

		$.ajax({

			url: "/updateBlog",
			method: "POST",
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,
			

			success: function(data) {
				
				//alert('success');
				$("#editblogs")[0].reset();
				$("#editblog").modal('hide');
				document.getElementById('toast').innerHTML = "Edit  successfully..!!";//.style.color = "#4581cf".style.backgroundColor = "#B7E2FF";
				document.getElementById('toast').style.color = "white";
				document.getElementById('toast').style.backgroundColor = "black";
				// $('#toast').css('background-color', 'white').css('color', 'red');
				//document.getElementById('toast').style.color = "#4581cf";
				showToast();
				// $("#toast")[0].reset();
				getBlog();
			},

		});
	});
});

function deleteblog(id){
	var r = confirm(" Want to delete!");
if(r==true){
	$.ajax({
		method:'POST',
		data:{id:id},
		url:'/deleteblog',
		
		success:function(data){
			
			document.getElementById('toast').innerHTML = "Delete  successfully..!!";
			document.getElementById('toast').style.color = "red";
			document.getElementById('toast').style.backgroundColor = "yellow";
			showToast();
			getBlog();
		},
	});
	};
};

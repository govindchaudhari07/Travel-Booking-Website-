$('document').ready(function() {

	$(document).on('submit', '#insertbooking', function(e) {
		e.preventDefault();
		//var data = new FormData(this.name);

		//alert('booking');
		$.ajax({

			url: '/saveBooking',
			method: 'POST',
			data: new FormData(this),
			contentType: false,
			processData: false,
			cache: false,

			success: function(data) {
				//alert('success booking');
				$("#insertbooking")[0].reset();
				document.getElementById('toast').innerHTML = "Enquiry successfully..!!";
				
			showToast();
			
			
			},
		});
	});
});



/*function busBooking1() {

	var bookfrom = document.getElementById("from1").value;

	var bookto = document.getElementById("to1").value;

	var date = document.getElementById("date1").value;

	var name = document.getElementById("name1").value;

	var persons = document.getElementById("person1").value;

	var mono = document.getElementById("mobileno1").value;


	//alert(bookfrom+" "+bookto+" "+date+" "+name+" "+persons+" "+mono)

	$.ajax({


		method: "POST",

		data: { bookFrom: bookfrom, bookTo: bookto, date: date, name: name, persons: persons, mobileno: mono },

		url: '/saveBooking',

		success: function(data) {
			document.getElementById('toast').innerHTML = "Book successfully..!!";
			showToast();

			//window.location.reload();
			//alert(success);
		}
	});
};*/

function showToast(){
	 $('#toast').addClass("display");
	 setTimeout(() => {
	   $('#toast').removeClass("display");},5000);
	 }


	
function getAllDashboardCount() {
// alert('count booking')
	$.ajax({
		type: 'ajax',
		method: 'POST',
		url: "/get-all-dashboard-count",
		data: {},

		success: function(data) {
			//console.log(data)
                // alert('       dfdfdf    '+data.ConfirmedBooking)
			document.getElementById('DailyBooking').innerHTML = data.dailyBooking;
			document.getElementById('monthlyBooking22').innerHTML = data.monthlyBooking;
			document.getElementById('weeklyBooking22').innerHTML = data.weeklyBooking;
			document.getElementById('yearlybooking').innerHTML=data.yearlyBooking;
			document.getElementById('confirmedbooking').innerHTML=data.confirmedBooking;
			

		},
		error: function() {

		}
	});
};
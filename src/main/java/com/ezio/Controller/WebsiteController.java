package com.ezio.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ezio.Entity.About;
import com.ezio.Entity.Blog;
import com.ezio.Entity.Booking;
import com.ezio.Entity.Destination;
import com.ezio.Entity.Packagefield;
import com.ezio.Entity.Testimonial;
import com.ezio.Service.AboutService;
import com.ezio.Service.BlogService;
import com.ezio.Service.DestinationService;
import com.ezio.Service.OrderService;
import com.ezio.Service.PackagesService;
import com.ezio.Service.TestimonialService;

@Controller
public class WebsiteController {

	@Autowired
	OrderService orderserv;
	@Autowired
	DestinationService destserv;
	@Autowired
	TestimonialService testiserv;
	@Autowired
	BlogService blogserv;
	@Autowired
	AboutService aboutserv;
	@Autowired
	PackagesService packageserv;

	@RequestMapping("/")
	public String Homepage(Model m) {
		List<Destination> list = destserv.destinationinformationgeti();
		m.addAttribute("destinations", list);
		List<Testimonial> testt = testiserv.testimonialinformationgetting();
		m.addAttribute("testimonial", testt);
		List<Blog> blogss = blogserv.blogInformationGetting();
		m.addAttribute("blogs", blogss);

		return "website/index";
	}

	@RequestMapping("/about")
	public String About(Model m) {
		List<About> about = aboutserv.aboutInformationGetting();
		m.addAttribute("aboutus", about);

		List<Testimonial> testt = testiserv.testimonialinformationgetting();
		m.addAttribute("testimonial", testt);
		
		List<Packagefield> pack=packageserv.packageinformationgetting();
		m.addAttribute("pack",pack);
		return "website/about";
	}

	@RequestMapping("/home")
	public String Home2() {
		return ("redirect:/");
	}

	@RequestMapping("/packages")
	public String Packages(Model m) {

		List<Destination> list = destserv.destinationinformationgeti();
		m.addAttribute("destinations", list);
		List<Packagefield> pack=packageserv.packageinformationgetting();
		m.addAttribute("pack",pack);

		return "website/packages";
	}

	@RequestMapping("/hotels")
	public String Hotels() {
		return "website/hotels";
	}

	@RequestMapping("/insurance")
	public String Insurance() {
		return "website/insurance";
	}

	@RequestMapping("/contact")
	public String Contact() {
		return "website/contact";
	}

	@RequestMapping(value = "/saveBooking", method = RequestMethod.POST)
	@ResponseBody
	public void booksave(Booking booking ) {
		java.util.Date date1 = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd ");
		String booking_date = formatter1.format(date1);
		
		booking.setBooking_date(booking_date);
		
		
		orderserv.Savebooking(booking);
		//session.setAttribute("msg", "Booking Successful..");
	}

	@RequestMapping(value = "/orderlist", method = RequestMethod.GET)
	@ResponseBody
	public List<Booking> orderlist(Booking order, String status) {
		List<Booking> list = new ArrayList<Booking>();
		list = orderserv.getorders();
		java.util.Date date1 = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd ");
		String booking_date = formatter1.format(date1);
		
		if (status == null) {
			status = "All";
		}
		if (status.equals("All")) {
			list = orderserv.getorders();

		} else {
			list = orderserv.getordersByStatus(status);
		}

		return list;
	}

	@RequestMapping(value = "/gettingListByStatus", method = RequestMethod.GET)
	@ResponseBody
	public List<Booking> gettingListByStatus(String status) {

		//System.out.println("1212121221   " + status);
		List<Booking> list = orderserv.getordersByStatus(status);
		return list;

	}

	@RequestMapping(value = "/edit_status", method = RequestMethod.GET)
	@ResponseBody

	public Optional<Booking> editForm(long id, Model m) {
		Optional<Booking> status = orderserv.findById(id);

		return status;

	}

	@RequestMapping(value = "/update_orders", method = RequestMethod.POST)
	@ResponseBody

	public void updateorders(Long id, String status) {
		//System.out.println(id);
	   	orderserv.updatestatusById(id, status);

		
	}
	
	

	@RequestMapping(value = "/editbooking", method = RequestMethod.POST)
	@ResponseBody
	public Optional<Booking> editbooking(Long id) {
		Optional<Booking> list =orderserv.findById(id);
		return list;
	}
	
	@RequestMapping(value = "/updateBookings", method = RequestMethod.POST)
	@ResponseBody
	public void updateBooking(Booking booking) {
		orderserv.Savebooking(booking);
	}
	
	@RequestMapping(value = "/deleteBooking", method = RequestMethod.POST)
	@ResponseBody
	public void deleteBooking(Long id) {
		
		orderserv.deleteBooking(id);
		
	}
	  
	
	
}

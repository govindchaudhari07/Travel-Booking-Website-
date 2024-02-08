package com.ezio.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezio.Common.AppJsonResponse;
import com.ezio.Entity.About;
import com.ezio.Entity.Admin;
import com.ezio.Entity.Blog;
import com.ezio.Entity.Packagefield;
import com.ezio.Entity.Testimonial;
import com.ezio.Service.AboutService;
import com.ezio.Service.AdminService;
import com.ezio.Service.BlogService;
import com.ezio.Service.PackagesService;
import com.ezio.Service.TestimonialService;

@Controller
public class AdminController {

	@Autowired
	AdminService addserv;

	@Autowired
	TestimonialService testiserv;

	@Autowired
	BlogService blogserv;

	@Autowired
	AboutService aboutserv;

	@Autowired
	PackagesService packageserv;

	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/";

	@RequestMapping("/admin")
	public String AdminPannel() {

		File f = new File(uploadProductDirectory);

		if (!f.exists()) {
			f.mkdirs();
		}

		return "loginpage/login_index";
	}
	// (/validation given to sign in button which is on login page)

	@RequestMapping("/validation")
	public String dashBoard(Model model, @RequestParam("name") String name, @RequestParam("password") String password,
			HttpSession session) {
		Admin user = addserv.checkexistByNameAndPassword(name, password);
		// System.out.println(" check existence "+user);

		// System.out.println(name+" "+password);
		if (user != null) {

			// (((((((((((((((((((((((((( name store in session ))))))))))))))))))))))))))

			session.setAttribute("username", name);

			return "adm/index";
		} else {
			session.setAttribute("msg", "Incorrect Username and Password");
			return "loginpage/login_index";

		}
	}

	@RequestMapping(value = "/get-all-dashboard-count", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse getdayBookingCount(HttpSession session ) throws IOException {
		java.util.Date date1 = new java.util.Date(System.currentTimeMillis());
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		String date = formatter1.format(date1);  
		AppJsonResponse response = new AppJsonResponse();
		response.setDailyBooking(addserv.getDailyBookingCount(date));
		response.setWeeklyBooking(addserv.getWeekBookingCount());
		response.setMonthlyBooking(addserv.geMonthlyBookingCount());
	   response.setYearlyBooking(addserv.getYearlyBookingCount());
	  
	   response.setConfirmedBooking(addserv.getConfirmedBookingCount(date));
	
		return response;
	}

	@RequestMapping("/Logout")
	public String LogoutFromAdminPannel(HttpSession session) {

		session.invalidate();
		return "loginpage/login_index";
	}

	@RequestMapping("/AdminHomePage")
	public String AdminHomePage(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "adm/index";
		}
		return "loginpage/login_index";
	}

	@RequestMapping("/Bookings")
	public String basictable(HttpSession session) {

		if (session.getAttribute("username") != null) { // when username store in session then if condition is execute

			return "adm/bookings"; // Bookings
		}

		return "loginpage/login_index";
	}

	/* Controller for Testimonial */

	@RequestMapping("/Testimonial")
	public String feedbacks(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "adm/Testimonial";
		}
		return "loginpage/login_index";
	}

	/*
	 * @RequestMapping(value = "/addTestimonial1", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public void addTestimonial(Testimonial testimonial) {
	 * 
	 * testiserv.saveTestimonial(testimonial);
	 * 
	 * }
	 */

	@RequestMapping(value = "/addTestimonial1", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination(Testimonial testi, BindingResult bindingResult, HttpSession session,
			@RequestParam("image2") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+"
		// "+desti.getPrice());
		// Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			testi.setImage2(originalFileName);
		} else {

			testi.setImage2("");
		}
		// System.out.println(" desti.getImages "+desti.getImages());
		// desti.setPrice(price);
		// desti.setDestination(destination);
		testiserv.saveTestimonial(testi);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/getTestiminaldataByOnlaod", method = RequestMethod.POST)
	@ResponseBody
	public List<Testimonial> getdataTestimonal(Testimonial testimonial) {

		List<Testimonial> list = testiserv.findAll();
		return list;

	}

	@RequestMapping(value = "/edittestimonial", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Testimonial> editTestiminoal(Long id) {

		Optional<Testimonial> list = testiserv.findById(id);
		return list;
	}

	// Controller for update

	@RequestMapping(value = "/update_testimonial", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination1(Testimonial testi, BindingResult bindingResult, HttpSession session,

			@RequestParam("image2") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+" //
		// "+desti.getPrice()); // Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			testi.setImage2(originalFileName);
		} else {
			Testimonial testimonial = testiserv.findtestimonialById(testi.getId());
			testi.setImage2(testimonial.getImage2());
		} //
		System.out.println(" desti.getImages " + testi.getImage2()); //
		// desti.setPrice(price); // desti.setDestination(destination);
		testiserv.saveTestimonial(testi);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	// Delete

	@RequestMapping(value = "/deletetestimonial", method = RequestMethod.POST)
	@ResponseBody
	public void deletetestimonial(Long id) {
		testiserv.deleteById(id);
	}

	/* Controller for Blog */

	@RequestMapping("/spiritualblog")
	public String blog_index(HttpSession session) {

		if (session.getAttribute("username") != null) {
			return "adm/blog";
		}

		return "loginpage/login_index";
	}

	@RequestMapping(value = "/addblog22", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination(Blog blog, BindingResult bindingResult, HttpSession session,
			@RequestParam("blogimage") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+"
		// "+desti.getPrice());
		// Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			// System.out.println(" coming 1111 " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			blog.setBlogimage(originalFileName);
		} else {

			blog.setBlogimage("");
		}
		// System.out.println(" desti.getImages "+desti.getImages());
		// desti.setPrice(price);
		// desti.setDestination(destination);
		blogserv.saveblog(blog);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	/* getting blog Data by */
	@RequestMapping(value = "/getBlogData", method = RequestMethod.GET)
	@ResponseBody
	public List<Blog> getBlogData(Blog blog) {

		List<Blog> list = blogserv.findAll();

		return list;
	}

	@RequestMapping(value = "/editBlog", method = RequestMethod.POST)
	@ResponseBody
	public Optional<Blog> findById(Long id) {
		Optional<Blog> list = blogserv.findById(id);
		return list;
	}

	@RequestMapping(value = "/updateBlog", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination1(Blog blog, BindingResult bindingResult, HttpSession session,

			@RequestParam("blogimage") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+" //
		// "+desti.getPrice()); // Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			blog.setBlogimage(originalFileName);
		} else {
			Blog blog22 = blogserv.findblogById(blog.getId());
			blog.setBlogimage(blog22.getBlogimage());
		} //
		System.out.println(" desti.getImages " + blog.getBlogimage()); //
		// desti.setPrice(price); // desti.setDestination(destination);
		blogserv.saveBlog(blog);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/deleteblog", method = RequestMethod.POST)
	@ResponseBody
	public void deleteblog(Long id) {

		blogserv.deleteById(id);

	}

	/* About us Controller */
	@RequestMapping("/Aboutus")
	public String aboutus(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "adm/aboutus";
		}

		return "loginpage/login_index";
	}

	@RequestMapping(value = "/addAbout", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination(About about, BindingResult bindingResult, HttpSession session,
			@RequestParam("image") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+"
		// "+desti.getPrice());
		// Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			about.setImage(originalFileName);
		} else {

			about.setImage("");
		}
		// System.out.println(" desti.getImages "+desti.getImages());
		// desti.setPrice(price);
		// desti.setDestination(destination);
		aboutserv.saveAbout(about);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/getAboutInfo", method = RequestMethod.POST)
	@ResponseBody
	public List<About> gettingAboutusDetails(About about) {
		List<About> list = aboutserv.findAll(about);
		return list;
	}

	@RequestMapping(value = "/editAbout", method = RequestMethod.POST)
	@ResponseBody
	public Optional<About> editAbout(Long id) {

		Optional<About> list = aboutserv.findById(id);
		return list;
	}

	@RequestMapping(value = "/deleteAboutUs", method = RequestMethod.POST)
	@ResponseBody
	public void deleteAboutUs(Long id) {
		aboutserv.deleteById(id);
	}

	@RequestMapping(value = "/updateAboutus", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination1(About about, BindingResult bindingResult, HttpSession session,

			@RequestParam("image") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+" //
		// "+desti.getPrice()); // Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			about.setImage(originalFileName);
		} else {
			About about22 = aboutserv.findAboutById(about.getId());
			about.setImage(about22.getImage());
		} //
			// System.out.println(" desti.getImages " + blog.getBlogimage()); //
			// desti.setPrice(price); // desti.setDestination(destination);
		aboutserv.saveAboutus(about);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	// Controller for Packages Start here
	@RequestMapping("/Packagesadm")
	public String Packages(HttpSession session) {
		if (session.getAttribute("username") != null) {
			return "adm/packagesadmin";
		}
		return "loginpage/login_index";
	}

	@RequestMapping(value = "/addPackages", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination(Packagefield pack, BindingResult bindingResult, HttpSession session,
			@RequestParam("image") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+"
		// "+desti.getPrice());
		// Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			pack.setImage(originalFileName);
		} else {

			pack.setImage("");
		}
		// System.out.println(" desti.getImages "+desti.getImages());
		// desti.setPrice(price);
		// desti.setDestination(destination);
		packageserv.savePackage(pack);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/show_packages", method = RequestMethod.POST)
	@ResponseBody
	public List<Packagefield> showPackage(Packagefield packagefield) {

		List<Packagefield> list = packageserv.findAll(packagefield);

		return list;
	}

	@RequestMapping(value = "/editPackage", method = RequestMethod.POST)
	@ResponseBody
	public Optional<Packagefield> editPackage(Long id) {
		Optional<Packagefield> list = packageserv.findById(id);
		return list;
	}

	@RequestMapping(value = "/Update_Packages", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination1(Packagefield packagefield, BindingResult bindingResult, HttpSession session,

			@RequestParam("image") MultipartFile images) throws IOException {

		// System.out.println(" comming "+desti.getDestination()+ " "+images+" //
		// "+desti.getPrice()); // Destination desti=new Destination();

		if (!images.isEmpty() && images != null) {
			System.out.println("    coming 1111   " + images);
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + images.getOriginalFilename().replace(" ", "-").toLowerCase();

			Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

			try {
				Files.write(fileNameAndPath, images.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			packagefield.setImage(originalFileName);
		} else {
			Packagefield package22 = packageserv.findPackageById(packagefield.getId());
			packagefield.setImage(package22.getImage());
		} //
			// System.out.println(" desti.getImages " + blog.getBlogimage()); //
			// desti.setPrice(price); // desti.setDestination(destination);
		packageserv.savePackage(packagefield);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/deletePackage", method = RequestMethod.POST)
	@ResponseBody
	public void deletePackage(Long id) {
		packageserv.DeleteById(id);

	}
}

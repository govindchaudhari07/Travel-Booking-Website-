package com.ezio.Controller;

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ezio.Common.AppJsonResponse;
import com.ezio.Entity.Destination;
import com.ezio.Service.DestinationService;

@Controller
public class DestinationController {

	@Autowired
	DestinationService destserv;

	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/";

	@RequestMapping("/Destination")
	public String Homepage(HttpSession session) {
		if(session.getAttribute("username") != null) {
			
			return "adm/destination";
		}

		return "loginpage/login_index";
	}

	/*
	 * @RequestMapping(value = "/destination2", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public void AddDestionation( String destination,String
	 * images,String price) {
	 * 
	 * System.out.println("  comming   "+destination+ "   "+images+"   "+price);
	 * 
	 * 
	 * Destination desti=new Destination(); desti.setDestination(destination);
	 * desti.setImages(images); desti.setPrice(price);
	 * destserv.saveDestination(desti); }
	 */

	@RequestMapping(value = "/addDestination2", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse addDestination(Destination desti, BindingResult bindingResult, HttpSession session,
			@RequestParam("images") MultipartFile images) throws IOException {

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

			desti.setImages(originalFileName);
		} else {

			desti.setImages("");
		}
		// System.out.println(" desti.getImages "+desti.getImages());
		// desti.setPrice(price);
		// desti.setDestination(destination);
		destserv.saveDestination(desti);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/getdestination", method = RequestMethod.GET)
	@ResponseBody
	public List<Destination> getDestination(Destination destination) {

		List<Destination> list = destserv.findAllDestination(destination);
		System.out.println(list);

		return list;

	}

	@RequestMapping(value = "/editdestination", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Destination> editdestination(Long id) {

		/* System.out.println("id comming "+id); */
		Optional<Destination> list = destserv.findById(id);

		return list;
	}

	/*
	 * @RequestMapping(value = "/updateDestination", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public void editDestination(Destination destination) {
	 * 
	 * 
	 * destserv.editdesti(destination); }
	 */

	@RequestMapping(value = "/updateDestination", method = RequestMethod.POST)

	@ResponseBody
	public AppJsonResponse addDestination1(Destination desti, BindingResult bindingResult, HttpSession session,

			@RequestParam("images") MultipartFile images) throws IOException {

		//System.out.println(" comming ****"+desti.getDestinations()+ " "+images+"  "+desti.getPrice()); // Destination desti=new Destination();

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

			desti.setImages(originalFileName);
		} else {
			
			Destination destination = destserv.getDataById(desti.getId());
			
			desti.setImages(destination.getImages());
		} //
	//	System.out.println(" desti.getImages " + desti.getImages()); //
		// desti.setPrice(price); // desti.setDestination(destination);
		destserv.saveDestination(desti);

		AppJsonResponse resp = new AppJsonResponse();
		return resp;
	}

	@RequestMapping(value = "/deleteDestination", method = RequestMethod.POST)
	@ResponseBody
	public void main(Long id, HttpSession session) {

		System.out.println("deleteing desgtination" + id);
		destserv.deleteById(id);
		session.setAttribute("msg", " Delete Sucessfully..");
	}

}

package com.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.models.Orders;
import com.example.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/home")
	public String homepage(){
		return "home";
	}
/*	
	@GetMapping("/error")
	public String errorpage(){
		return "error";
	}
	
*/	
	@GetMapping("/displayImage")
	public void displayImage(@RequestParam("id") int orderId, HttpServletResponse response, HttpServletRequest request) {
		
		byte[] image = orderService.getImage(orderId);        
	    response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    try {
			response.getOutputStream().write(image);
		    response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("/create")
	public String createIssue(@RequestParam("title")       String title,
			                  @RequestParam("description") String description,
			                  @RequestParam("remark")      String remark,
			                  @RequestParam("image")       MultipartFile image) {

/**
	@RequestMapping(value="/create",method = RequestMethod.POST )
	public @ResponseBody String createIssue(@RequestParam(value = "title", required = false) String title,
			                                @RequestParam(value = "description", required = false) String description,
			                                @RequestParam(value = "remark", required = false) String remark,
			                                @RequestParam("image") MultipartFile image) {
**/
		
		boolean ret = false ;
		String message = null;
		if(!image.isEmpty())	
		{
			try {
				byte[] imageBytes = image.getBytes();
				
				System.out.println("File Name: " + image.getOriginalFilename());
				System.out.println("File type: " + image.getContentType());
				System.out.println("File Size: " + image.getSize());
				
				
				ret = orderService.createOrder(title, description, remark, imageBytes);
				
				
				if(ret) {
					message = "Order created successfully!";
				} else {
					message = "Order creation failed!";
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = "Order creation failed!";
				e.printStackTrace();
			}
		
		}
		// return message;
		return "success";
	    
		/*if(orderService.createOrder(orderRequest)) {
			orderResponse.setReturnCode(CommonConstants.SUCCESS);
			orderResponse.setReturnMessage(CommonConstants.CREATE_ISSUE_SUCCESS_MSG);
		} else {
			orderResponse.setReturnCode(CommonConstants.FAIL);
			orderResponse.setReturnMessage(CommonConstants.CREATE_ISSUE_FAILURE_MSG);
		}*/
	}
	
	
	@RequestMapping(value="/create2",method = RequestMethod.POST )
	public @ResponseBody String createOrder(@RequestParam(value = "orgId", required = false) String orgId ,
											@RequestParam(value = "assignedWorkerId", required = false) String assignedWorkerId,
											@RequestParam(value = "title", required = false) String title,
											@RequestParam(value = "description", required = false) String description,
											@RequestParam(value = "remark", required = false) String remark,
											@RequestParam("image") MultipartFile[] images) {
		boolean ret = false ;
		String message = null;

		if(images != null && images.length > 0)	{
			byte[][] imageByteArray = new byte[images.length][];

			try {
				for(int i =0 ;i< images.length; i++){
					imageByteArray[i] = images[i].getBytes();
				}

				ret = orderService.createOrderWithMultipleImage(orgId, assignedWorkerId, title, description, remark, imageByteArray);

				if(ret) {
					message = "Order created successfully!";
				} else {
					message = "Order creation failed!";
				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				message = "Order creation failed!";
				e.printStackTrace();
			}

		}
		return message;
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = {"/getOrderDetails/{orderId}"} )
	public @ResponseBody Orders getIssueDetails(@PathVariable("orderId") String orderId) {
		
		if (orderId != null && !orderId.isEmpty()) {
			return orderService.getOrderDetails(orderId);
		}
		
		return null;
	}
}

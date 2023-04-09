package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Welcome to spring MVC");
	}
	@RequestMapping(value="hello2", method=RequestMethod.GET)
	public String sayHello2() {
		System.out.println("sayhello is called");
		return "web";
	}
	@RequestMapping(method=RequestMethod.GET,value="hello3")
		public ResponseEntity<String> sayHello3(){
			return ResponseEntity.ok("hai ,hello ");
		}
	
	@RequestMapping(value="hello4",method=RequestMethod.GET)
	public ModelAndView sayHello4() {
		ModelAndView mv=new ModelAndView();
		System.out.println("hello4 is called...");
		mv.addObject("mykey","Welcome to spring mv4");
		mv.addObject("hello1","Hello world1..");
		mv.addObject("hello2","Hello world2..");
		mv.setViewName("web");
		return mv;	
	}
	
	@RequestMapping(value="hello5",method=RequestMethod.GET)
	public ModelAndView sayHello5(ModelAndView mv) {
		System.out.println("hello5 is called...");
//		mv.addObject("mykey","Welcome to spring mv5");
		mv.setViewName("web");
		return mv;	
	}
	
	@RequestMapping(value="hello6",method=RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv,HttpServletRequest request) {
		mandv.addObject("mykey","welcome to spring3 mvc3..");
		mandv.setViewName("web");
		HttpSession session=request.getSession();
		request.setAttribute("hello1","hi hi hello");
		return mandv;	
	}
	
//	@RequestMapping(value="repeat",method=RequestMethod.GET)
//	public ModelAndView repeat(ModelAndView mandv,HttpServletRequest request) {
//		mandv.addObject("mykey","welcome to spring3 mvc3..");
//		mandv.setViewName("web");
//		HttpSession session=request.getSession();
//		request.setAttribute("hello","hi hi hello");
//		return mandv;	
//	}
//	
	@RequestMapping(value="hello/7{name}",method=RequestMethod.GET)
	public ModelAndView sayHello6(@PathVariable String name,ModelAndView mandv,HttpServletRequest request) {
		mandv.addObject("mykey","name");
		mandv.setViewName("web");
//		HttpSession session=request.getSession();
		request.setAttribute("hello","hi hi hello");
		return mandv;	
	}
//	
//	@RequestMapping(value="hello8",method=RequestMethod.GET)
//	public ModelAndView sayHello8(@RequestParam("uname") String name,ModelAndView mandv,HttpServletRequest request) {
//		mandv.addObject("mykey","name");
//		mandv.setViewName("web");
////		HttpSession session=request.getSession();
//		request.setAttribute("hello","hi hi hello"+name);
//		return mandv;	
//	}
//	@RequestMapping(value="hello/7{name}",method=RequestMethod.GET)
//	public ModelAndView sayHello6(@PathVariable String name,ModelAndView mandv,HttpServletRequest request) {
//		mandv.addObject("mykey","name");
//		mandv.setViewName("web");
////		HttpSession session=request.getSession();
//		request.setAttribute("hello","hi hi hello");
//		return mandv;	
//	}
	@RequestMapping(method=RequestMethod.GET,value="hello10")
	public ResponseEntity<User> sayHello10(){
		User user=new User();
		user.setUid(100);
		user.setUname("hari");
		return ResponseEntity.ok(user);	
	}
	
	@RequestMapping(method=RequestMethod.POST,value="hello11")
	public ResponseEntity<User> sayHello11(@RequestBody User user){
		user.setUid(100+user.getid());
		user.setUname(user.getName());
		return ResponseEntity.ok(user);	
	}
	@RequestMapping(method=RequestMethod.POST,value="hello12")
	public ResponseEntity<User> sayHello12(@RequestBody User user){
		user.setUid(199000);
		user.setUname("sdfghj");
		return ResponseEntity.ok(user);	
	}
}
	class User{
		int uid;
		String uname;
		public void setUid(int i) {
			this.uid=i;
		}
		public void setUname(String string) {
			this.uname=string;
		}
		public int getid() {
			return uid;
		}
		public String getName() {
			return uname;
		}
		

	
	
	
	
}

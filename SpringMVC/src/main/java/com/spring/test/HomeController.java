package com.spring.test;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.service.PersonService;
import com.spring.test.frlx.Person;
import com.spring.test.frlx.SiteLink;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private PersonService personService;
	
	private SiteLink<String> tree;
    
    @Autowired(required=true)
    @Qualifier(value="personService")
    public void setPersonService(PersonService ps){
        this.personService = ps;
    }
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 * @throws IOException 
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) throws IOException {
		logger.info("Welcome home! The client locale is {}.", locale);
		Person p = new Person();
		
		p.setName("Dima");
		p.setCountry("USA");
		
		this.personService.addPerson(p);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		//System.out.println(Util.downloadPage("http://google.com"));
		
//		Util.downloadPage("http://google.com");
		tree = new SiteLink<String>("http://data.black3dsnake.com");
		Util.parseLink(tree, 0);
		
		
		
		return "home";
	}
	
	@RequestMapping(value = "/frlx", method = RequestMethod.GET)
	public String frlx(Locale locale, Model model) {
		
		Person p = new Person();
		
		model.addAttribute("pName", p.getName());
		
		return "home";
	}
	
}

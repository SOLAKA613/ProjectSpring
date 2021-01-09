package com.example.master.controller;

import java.util.Collection;
import java.util.Hashtable;

import javax.websocket.server.PathParam;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.master.dao.PersonneDaoImpl;
import com.example.master.dao.iPersonneDao;
import com.example.master.entity.Departement;
import com.example.master.entity.Person;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class Controlleur {

	iPersonneDao person=new PersonneDaoImpl();
	
    @GetMapping("/go")
    public ModelAndView go() {
    	ModelAndView mav= new ModelAndView("page");
    	Hashtable<String,Person> employee = new Hashtable<String,Person>();
    	
    	employee.put("1",new Person(0l,"Adil",19));
    	employee.put("2",new Person(1l,"Slimane",23));
    	employee.put("3",new Person(2l,"Zakaria",25));
    	
    	Departement dp = new Departement("Informatique",employee);
    	
    	mav.addObject("Information",dp);
    	
	    return mav;
    }

	@GetMapping("/go2")
	public  String go2() {
		return "Hello2";
	}
	
	@GetMapping("/form")
	public ModelAndView form() {
	    	ModelAndView mav= new ModelAndView("FormPerson.xhtml");    	
		    return mav;
	}
	
	@GetMapping("/shearch")
	public ModelAndView shearch() {
	    	ModelAndView mav= new ModelAndView("GetId.xhtml");    	
		    return mav;
	}
	
	@PostMapping("person")
	public Person addperson(@ModelAttribute Person personne) {
		return person.addPerson(personne);		
	}
	
	@GetMapping("person")
	public Collection<Person> Allperson(@ModelAttribute Person personne) {
		return person.findAllPersons().values();		
	}
	
	@GetMapping("/findPerson/{id}")
	public Person findById(@PathVariable(value="id") long id) { //@PathVariable or @PathParam
		return person.findById(id);
	}
	
	@RequestMapping(value="/supprimerPerson", method=RequestMethod.POST)
	public Person deleteperson(@ModelAttribute Person personne) { 
		try {
			System.out.println("delete "+personne.getId());	
		    return person.deletePerson(personne.getId());
		
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@PostMapping("update")
	public ModelAndView update(@ModelAttribute Person personne) { 
		try { 
			person.addPerson(personne);
			System.out.println(findById(personne.getId()));	
			ModelAndView mav= new ModelAndView("GetId.xhtml"); 
		    return mav;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
	
	@RequestMapping(value="/updatePerson", method=RequestMethod.POST)
	public ModelAndView updateperson(@ModelAttribute Person personne) { 
		try {
			System.out.println("HELLO "+personne.getId());
			ModelAndView mav= new ModelAndView("UpdatePerson.xhtml"); 
			mav.addObject("person",findById(personne.getId()));

			return mav;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}	
	}
}

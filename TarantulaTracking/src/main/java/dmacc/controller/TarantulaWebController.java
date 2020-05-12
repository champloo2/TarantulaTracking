package dmacc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

//import dmacc.attributes.MoltAttribute;
import dmacc.beans.Molt;
import dmacc.beans.Tarantula;
import dmacc.repository.MoltRepository;
import dmacc.repository.TarantulaRepository;



@Controller
public class TarantulaWebController {

	@Autowired
	TarantulaRepository tRepo;
	@Autowired
	MoltRepository mRepo;
	
	
	//@GetMapping("/viewAll")
	@GetMapping({"/", "viewAll"})
	public String viewAllTarantulas(Model model) {
		
	if(tRepo.findAll().isEmpty()) 
		{
		return addNewTarantula(model);
		}
	model.addAttribute("tarantulas", tRepo.findAll());
	return "ListTarantulas";   //ListTarantulas.html

	}
	
	@GetMapping("/inputTarantula")
	//new tarantula is created before it is validated in HTML
	public String addNewTarantula(Model model) {
	Tarantula t = new Tarantula();
	model.addAttribute("newTarantula", t);
	return "inputTarantula";
	}
	
	@PostMapping("/inputTarantula")
	public String addNewContact(@ModelAttribute Tarantula t,Model model) {
	tRepo.save(t);
	return viewAllTarantulas(model);
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateContact(@PathVariable("id") long id,Model model) {

	Tarantula t = tRepo.findById(id).orElse(null);
	
	model.addAttribute("newTarantula", t);
	System.out.println("********Tarantula ID: " + t.getTId() +"/edit*********");
	return "inputTarantula";
	}
	
	@PostMapping("/update/{id}")
	public String reviseTarantula(Tarantula t, Model model) {
	System.out.println("********Tarantula ID: " + t.getTId() +"/update*********");
	tRepo.save(t);
	System.out.println("********Tarantula ID: " + t.getTId() +" after save*********");
	return viewAllTarantulas(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteTarantula(@PathVariable("id") long id, Model model) 
	{
	Tarantula t = tRepo.findById(id).orElse(null);
	tRepo.delete(t);
	return viewAllTarantulas(model);
	
	}
	
	@GetMapping("/listMoltsByTId/{id}")
	public String viewMoltsByTId(@PathVariable("id") long id, Model model) 
	{
		
		System.out.print("***************"+ " HELLO WATS UP "+ id+ "**********");
	List<Molt> listByT= mRepo.findBytID(id);
	System.out.print("***************"+ " HELLO WATS UP size "+ listByT.size()+ "**********");
	//mRepo.findAll().forEach(listByT::add);
	//model.addAttribute("listMoltsByT", listByT);
	return "ListMolts";
	
	
	}
	
	@GetMapping ("/inputAMolt/{id}")
	public String addNewMolt (@PathVariable("id") long id, Model model) 
	{
	Tarantula t = tRepo.getOne(id);
	
	Molt m = new Molt(t);
	
	model.addAttribute("newMolt", m);
	return "inputMolt";  //earlier, this said "index" and it was not working
	
	}
	
	@PostMapping("/inputAMolt")
	public String addNewMolt (@ModelAttribute Molt m,Model model) {
	mRepo.save(m);  //NOT SAVING
	
	return viewAllTarantulas(model);
	}
	

}

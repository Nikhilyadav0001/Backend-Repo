package nikhil.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {
	
	static {
		System.out.println("WelcomeController.class file is loading...()");
	}
	
	public WelcomeController() {
		System.out.println("WelcomeController:: Zero param constructor...");
	}

	/**
	 * 1. REQUEST TYPE :: GET/POST
	 * 2. PATH         :: URL
	 * 3. MODEL   	   :: Sending the data from Controller to View
	 * 4. R.T          :: ViewName(with no technology details)
	 * 
	 */
	//@RequestMapping(value = "/",method = RequestMethod.GET)
	//you can go for any of these for data map,model,modelmap they all uses BindingawareModelMap,so as good programing practice is go for model
	@GetMapping(value="/")
	public String welcomeMsg(Model model,ModelMap map) {
		System.out.println("Model Implementation class is :: "+model.getClass().getName());
		System.out.println("Model map Implementation class is :: "+map.getClass().getName());
		System.out.println("RQ :: WelcomeController.welcomeMsg()");
		
		model.addAttribute("BRAND", "Nikhil's");
		map.put("BR", "Nik's");
		
		return "welcomepage";
	}

}

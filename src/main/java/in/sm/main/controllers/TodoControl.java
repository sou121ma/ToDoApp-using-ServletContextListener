package in.sm.main.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.sm.main.entity.Todo;
import jakarta.servlet.ServletContext;

@Controller
public class TodoControl {
	
	@Autowired
	ServletContext context;

// Loading home page with contents......................................................	
	@GetMapping({"/" , "/home"})
	public String viewHome(Model model) {
		model.addAttribute("page", "home");
		
		List<Todo> todos = (List<Todo>) context.getAttribute("list");
		
		model.addAttribute("todos", todos);
		
		return "home";
	}
	
// Opening add to form ...................................................................	
	@GetMapping("/add")
	public String addTODO(Model model) {
		model.addAttribute("page", "add");
		
		Todo t = new Todo();
		model.addAttribute("todo", t);
		
		return "home";
	}
	
// Adding todo into the arrayList........................................................	
	@PostMapping("/add")
	public String saveTodo(@ModelAttribute("todo") Todo todo ,Model model) {
		
		todo.setTodoDate(new Date());
		
		
		
		List<Todo> list = (List<Todo>) context.getAttribute("list");
		
		list.add(todo);
		
		model.addAttribute("msg", "Successfully Added.");
		
		return "redirect:/home";
	}
	
// Opening update form ....................................................................	
	@GetMapping("/update")
	public String updateTodo(Model model, @RequestParam int id) {
	    model.addAttribute("page", "edit");	    
//	    System.out.println(id);
	    
	    Todo newt = null;
	    
	    List<Todo> todos = (List<Todo>) context.getAttribute("list");
	    
// Checking the the object number from ArrayList 	    
	    for (Todo t : todos) {
		if (t.getId() == id) {
		    newt = t;
		    break;
		}
	    }
	    model.addAttribute("editTodo", newt);	 
	    
	    return "home";
	}
	
// Updating the todo into the arrayList.......................................................	
	@PostMapping("/update")
	public String updateTodo(@ModelAttribute("editTodo")Todo todo,@RequestParam int id) {
	    
	    List<Todo> list = (List<Todo>) context.getAttribute("list");
	    
// Checking the the object and index number from ArrayList 	    
	    for (Todo t : list) {
		if (t.getId() == id) {
		   list.set(list.indexOf(t), todo);
		    break;
		}
	    }	    	    
	    return "redirect:/home";
	}

// deleting todo from arrayList........................................
	@GetMapping("/delete")
	public String deleteTodo(@RequestParam int id) {
	    List<Todo> list = (List<Todo>) context.getAttribute("list");
	    for(Todo t : list) {
		if (t.getId() == id) {
		    list.remove(list.indexOf(t));
		    break;
		}
	    }
	    
	    return "redirect:/home";
	}
	
	
	
	

	

}


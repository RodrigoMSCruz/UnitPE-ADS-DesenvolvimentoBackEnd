package com.example.CRUD.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.CRUD.Models.JournalEntry;
import com.example.CRUD.Repositories.JournalEntryRepository;

@Controller
public class JournalEntryController {
    @Autowired
    JournalEntryRepository repo;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/addEntry")
    public String addJournalEntry(JournalEntry journalEntry){
        repo.save(journalEntry);
        return "home";
    }

    @RequestMapping("/getAllEntries")
	public ModelAndView getAllJournalEntries() {
		ModelAndView mv = new ModelAndView();
		List<JournalEntry> entries = repo.findAll();
		mv.addObject("entries", entries);
		mv.setViewName("getAllEntries");
		return mv;
	}

    @RequestMapping("/getEntry")
	public ModelAndView getJournalEntry(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		JournalEntry entry = repo.findById(id).orElse(new JournalEntry());
		mv.addObject("entry", entry);
		mv.setViewName("getEntry");
		return mv;
	}

    @RequestMapping("/deleteEntry")
	public String deleteJournalEntry(@RequestParam int id) {
		repo.deleteById(id);
		return "home";
	}


    @RequestMapping("/getEntriesByCategory")
    public ModelAndView getEntriesByCategory(@RequestParam String category){
        ModelAndView mv = new ModelAndView();
		List<JournalEntry> entries = repo.findByCategory(category);
		mv.addObject("entries", entries);
		mv.setViewName("getEntriesByCategory");
		return mv;
    }

    @RequestMapping("/getEntriesByIdGT")
	public ModelAndView getEntriesByIdGT(@RequestParam int id) {
		ModelAndView mv = new ModelAndView();
		List<JournalEntry> entries = repo.findByIdGreaterThan(id);
		mv.addObject("entries", entries);
		mv.setViewName("getEntriesByIdGT");
		return mv;
	}

	// Find By Category but sorted by title
	@RequestMapping("/getEntriesByCategorySorted")
	public ModelAndView getEntriesByCategorySorted(@RequestParam String category) {

		ModelAndView mv = new ModelAndView();
		List<JournalEntry> entries = repo.findByCategorySorted(category);
		System.out.println(repo.findByCategorySorted(category));
		mv.addObject("entries", entries);
		mv.setViewName("getEntriesByCategorySorted");
		return mv;
	}
    
}

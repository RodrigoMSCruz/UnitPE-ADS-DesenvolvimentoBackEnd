package com.example.CRUD.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


    
}

package com.example.CRUD.Repository;

import com.example.CRUD.Model.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry, Integer>{
    
}

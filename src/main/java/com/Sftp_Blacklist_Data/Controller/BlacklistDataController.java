package com.Sftp_Blacklist_Data.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Sftp_Blacklist_Data.Entity.BlacklistData;
import com.Sftp_Blacklist_Data.Service.BlacklistDataService;

@Controller
@RequestMapping("/api/blacklist")
public class BlacklistDataController {
    
    @Autowired
    private BlacklistDataService service;
    
    @GetMapping("/")
    public String showHomePage() {
        return "blacklist_data"; // This will render the "blacklist_data.html" page
    }


    // Modified API endpoint to support pagination
    @GetMapping("/tag/all")
    public ResponseEntity<List<BlacklistData>> getAllRecords(
        @RequestParam(defaultValue = "0") int page, 
        @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        List<BlacklistData> records = service.getAllBlacklistData(pageable);
        return ResponseEntity.ok(records);
    }

    @GetMapping("/tag/{tagId}")
    public ResponseEntity<?> getRecordsByTagId(@PathVariable String tagId) {
        List<BlacklistData> records = service.getBlacklistDataByTagId(tagId);
        if (records.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(records);
    }
}

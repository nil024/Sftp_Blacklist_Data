package com.Sftp_Blacklist_Data.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Sftp_Blacklist_Data.Entity.BlacklistData;
import com.Sftp_Blacklist_Data.Repository.BlacklistDataRepository;

import java.util.List;

@Service
public class BlacklistDataService {
    
    @Autowired
    private BlacklistDataRepository repository;

    public List<BlacklistData> getAllBlacklistData(Pageable pageable) {
        return repository.findAll(pageable).getContent(); // Fetch paginated records
    }

//    public List<BlacklistData> getBlacklistDataByTagId(String tagId) {
//        return repository.findByTagId(tagId); // Adjust the repository method to fetch by tagId
//    }
    
    public List<BlacklistData> getBlacklistDataByTagId(String tagId) {
        // Sort by effective_datetime in descending order
        return repository.findByTagId(tagId, Sort.by(Sort.Direction.DESC, "effectiveDatetime"));
    }
}

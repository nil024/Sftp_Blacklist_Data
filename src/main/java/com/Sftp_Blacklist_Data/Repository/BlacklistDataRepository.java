package com.Sftp_Blacklist_Data.Repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Sftp_Blacklist_Data.Entity.BlacklistData;

import java.util.List;

@Repository
public interface BlacklistDataRepository extends JpaRepository<BlacklistData, Long> {
    
    //List<BlacklistData> findByTagId(String tagId); // Assuming there's a method to filter by tagId
	
	List<BlacklistData> findByTagId(String tagId, Sort sort);
}

package com.Sftp_Blacklist_Data.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "blacklist_data")
public class BlacklistData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_id", length = 255)
    private String tagId;

    @Column(name = "tag_status", length = 1, nullable = false)
    private String tagStatus;

    @Column(name = "effective_datetime", nullable = false)
    private LocalDateTime effectiveDatetime;

    @Column(name = "reason_code", length = 20)
    private String reasonCode;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(String tagStatus) {
        this.tagStatus = tagStatus;
    }

    public LocalDateTime getEffectiveDatetime() {
        return effectiveDatetime;
    }

    public void setEffectiveDatetime(LocalDateTime effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
}


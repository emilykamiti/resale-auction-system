package com.resale.app.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlFormField;
import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;


@Entity
@Table(name = "tracks")
@HtmlTable(addUrl = "./track?action=add")
@HtmlForm(label = "Track", url = "./track")
public class Track extends BaseEntity {

    @HtmlFormField(label = "Track Number ", required = true)
     @Column(name = "TrackNo", nullable = false, unique = true)
    private String trackNo;

    @Column(name = "BidNo", nullable = false, unique = true)
    @HtmlTableColHeader(header = "Bid Nmuber")
    private String bidNo;

    @Column(name = "TrackTime")
    @HtmlTableColHeader(header = "Track Time")
    private LocalDateTime trackTime;

    @Column(name ="status")
    @HtmlTableColHeader(header = "Status")
    private String status;

    public Track() {
    }

    public String getTrackNo() {
        return trackNo;
    }

    public void setTrackNo(String trackNo) {
        this.trackNo = trackNo;
    }

    public String getBidNo() {
        return bidNo;
    }

    public void setBidNo(String bidNo) {
        this.bidNo = bidNo;
    }

    public LocalDateTime getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(LocalDateTime trackTime) {
        this.trackTime = trackTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Track(String trackNo, String bidNo, LocalDateTime trackTime, String status) {
        this.trackNo = trackNo;
        this.bidNo = bidNo;
        this.trackTime = trackTime;
        this.status = status;
    }

    
}
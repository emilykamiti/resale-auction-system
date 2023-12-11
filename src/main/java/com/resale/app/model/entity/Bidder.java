package com.resale.app.model.entity;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import com.resale.app.view.helper.HtmlForm;
import com.resale.app.view.helper.HtmlTable;
import com.resale.app.view.helper.HtmlTableColHeader;
@Entity
@Table(name = "bidders")
@HtmlTable(addUrl = "./bidders?action=add")
@HtmlForm(label = "Bidder", url = "./bidders")
public class Bidder extends BaseEntity {

    @Column(name = "bidNo")
    @HtmlTableColHeader(header = "Bidder No")
    private String bidNo;

    @Column(name = "CustomerTrackId")
    private String customerTrackId;

    @Column
    @Enumerated(EnumType.STRING)
    private BidStatus status;


    public Bidder(String bidNo, BidStatus status) {
        this.bidNo = bidNo;
        this.status = status;
    }


    public String getBidNo() {
        return bidNo;
    }


    public void setBidNo(String bidNo) {
        this.bidNo = bidNo;
    }


    public BidStatus getStatus() {
        return status;
    }


    public void setStatus(BidStatus status) {
        this.status = status;
    }



   

}
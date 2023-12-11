package com.resale.app.model.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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

    @Column(name = "BidderName")
    @HtmlTableColHeader(header = "Bidder Name")
    private String bidderName;

    @OneToMany(mappedBy = "bidder", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Bid> bids = new ArrayList<>();

    public Bidder(String bidNo, String customerTrackId, String bidderName) {
        this.bidNo = bidNo;
        this.customerTrackId = customerTrackId;
        this.bidderName = bidderName;
    }

    public String getBidNo() {
        return bidNo;
    }

    public void setBidNo(String bidNo) {
        this.bidNo = bidNo;
    }

    public String getCustomerTrackId() {
        return customerTrackId;
    }

    public void setCustomerTrackId(String customerTrackId) {
        this.customerTrackId = customerTrackId;
    }

    public String getBidderName() {
        return bidderName;
    }
    public void setBidderName(String bidderName) {
        this.bidderName = bidderName;
    }

 @JsonIgnore
    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

}
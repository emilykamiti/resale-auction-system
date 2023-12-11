package com.resale.app.bean;

import com.resale.app.utility.CustomerTrackId;
import com.resale.app.model.entity.Track;
import com.resale.app.utility.BidNo;
import com.resale.app.utility.TrackNoGenerator;
import com.resale.app.utility.BidNoGenerator;

import javax.inject.Inject;
import java.time.LocalDateTime;

public class TrackBean extends GenericBean<Track> implements TrackBeanI {

    @Inject
    @CustomerTrackId
    private TrackNoGenerator trackNoGenerator;

    @Inject
    @BidNo
    private BidNoGenerator bidNoGenerator;

    public Track addOrUpdate(Track track) {
        Track managedTrack;

        if (track.getId() != null) {
            managedTrack = getDao().getEm().find(Track.class, track.getId());
        } else {
            managedTrack = new Track();
            managedTrack.setTrackNo(trackNoGenerator.generateCustomerTrackId());

        }
        managedTrack.setBidNo(bidNoGenerator.generateBidNumber());
        managedTrack.setTrackTime(LocalDateTime.now());
        return getDao().addOrUpdate(managedTrack);
    }
}
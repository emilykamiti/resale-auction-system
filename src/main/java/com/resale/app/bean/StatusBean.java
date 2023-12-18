// package com.resale.app.bean;

// import com.resale.app.model.entity.Bid;

// public class StatusBean implements StatusBeanI {

// @Autowired
// private Bid bid; // Assuming you have a Bid repository for data access

// @Override
// public boolean acceptBid(Long bidId) {
// // Logic to accept the bid
// // Example: Update bid status to "accepted" in the database
// Bid bid = bidRepository.findById(bidId).orElse(null);
// if (bid != null) {
// bid.setStatus("accepted");
// bidRepository.save(bid);
// return true;
// }
// return false;
// }

// @Override
// public boolean rejectBid(Long bidId) {
// // Logic to reject the bid
// // Example: Update bid status to "rejected" in the database
// Bid bid = bidRepository.findById(bidId).orElse(null);
// if (bid != null) {
// bid.setStatus("rejected");
// bidRepository.save(bid);
// return true;
// }
// return false;
// }

// // Other methods related to bid operations
// }

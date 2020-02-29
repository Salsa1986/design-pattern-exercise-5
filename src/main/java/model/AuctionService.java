package model;



public class AuctionService extends BidAuctionSubjectService{
    private static AuctionService instance;

    private BidAuctionSubjectService bidAuctionSubjectService;

    private AuctionService(BidAuctionSubjectService bidAuctionSubjectService) {
        this.bidAuctionSubjectService = bidAuctionSubjectService;
    }

    private AuctionService() {
    }

    public boolean bid(Auction auction, Customer buyer, double amount) {
        if (auction.getHighestBid()<amount) {
            auction.setHighestBid(amount);
            auction.setBuyer(buyer);
            this.notifyCustomers(auction);
            return true;
        }
        return false;
    }



    public static AuctionService getInstance(){
        if (instance == null){
            synchronized (AuctionService.class){
                if (instance == null){
                    instance = new AuctionService(new BidAuctionSubjectService());
                }
            }
        }
        return instance;
    }

}

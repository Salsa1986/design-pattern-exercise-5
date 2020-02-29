package main;

import model.Auction;
import model.AuctionService;
import model.BidAuctionSubjectService;
import model.Customer;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Customer seller = new Customer("Jan Kowalski");
        Auction auction = Auction.builder()
                .withDescription("Super")
                .withItem("Coffee")
                .withDueDate(LocalDateTime.now().plusDays(2L))
                .withId(1)
                .withSeller(seller)
                .build();


        AuctionService auctionService = AuctionService.getInstance();
        Customer firstCustomer = new Customer("Anna Kowalik");
        Customer secondCustomer = new Customer("Krzysztof Adamowicz");
        auctionService.addCustomer(firstCustomer);
        auctionService.addCustomer(secondCustomer);

        auctionService.bid(auction,firstCustomer,20);
        System.out.println("After first bid");
        System.out.println(firstCustomer.getMessages());
        System.out.println(secondCustomer.getMessages());
        auctionService.bid(auction,secondCustomer,25);
        System.out.println("After second bid");
        System.out.println(firstCustomer.getMessages());
        System.out.println(secondCustomer.getMessages());


        System.out.println("Auction with id: " + auction.getId()+ " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}

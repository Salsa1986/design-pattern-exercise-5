package model;

import java.util.ArrayList;
import java.util.List;

public class BidAuctionSubjectService {

    private List<Observer> observers = new ArrayList<>();

    public BidAuctionSubjectService() {
    }

    public void addCustomer(Observer observer) {
        observers.add(observer);
    }

    public void removeCustomer(Observer observer){
        observers.remove(observer);
    }

    public void notifyCustomers(Auction auction){
        observers.forEach(o -> o.update(auction));
    }
}
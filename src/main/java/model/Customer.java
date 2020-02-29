package model;

import java.util.ArrayList;
import java.util.List;

public class Customer implements Observer{
    private String fullName;
    private List<String> messages = new ArrayList<>();

    public Customer(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public void update(Auction auction) {
        getMessages().clear();
        getMessages().add("Drogi kliencie kwota aukcji nr " + auction.getId() + " została przebita!!");
    }

    public List<String> getMessages() {
        return messages;
    }
}

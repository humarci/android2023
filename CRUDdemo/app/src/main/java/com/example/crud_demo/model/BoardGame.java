package com.example.crud_demo.model;

import java.io.Serializable;

public class BoardGame implements Serializable {



    private int id;
    private String title;
    private String categoryName;
    private int playingTime;
    private int maxNumOfplayers;
    private int price;
    private int quantity;
    private int totalRevenueByGame;
    private boolean isSold;

    public BoardGame(int id, String title,
                     String categoryName, int playingTime,
                     int maxNumOfplayers, int price, int quantity) {
        this.id = id;
        this.title = title;
        this.categoryName = categoryName;
        this.playingTime = playingTime;
        this.maxNumOfplayers = maxNumOfplayers;
        this.price = price;
        this.quantity = quantity;
    }

    public BoardGame(String title,
                     String categoryName, int playingTime,
                     int maxNumOfplayers, int price, int quantity) {
        this.title = title;
        this.categoryName = categoryName;
        this.playingTime = playingTime;
        this.maxNumOfplayers = maxNumOfplayers;
        this.price = price;
        this.quantity = quantity;
    }

    public BoardGame() {
    }

    @Override
    public String toString() {
        return title
                + "    " + price + "Ft    "
                +quantity+"pcs  "
                + calculateTotalRevenueByGame()+" Ft";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getPlayingTime() {
        return playingTime;
    }

    public void setPlayingTime(int playingTime) {
        this.playingTime = playingTime;
    }

    public int getMaxNumOfplayers() {
        return maxNumOfplayers;
    }

    public void setMaxNumOfplayers(int maxNumOfplayers) {
        this.maxNumOfplayers = maxNumOfplayers;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalRevenueByGame() {
        return totalRevenueByGame;
    }

    public void setTotalRevenueByGame(int totalRevenueByGame) {
        this.totalRevenueByGame = totalRevenueByGame;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public int calculateTotalRevenueByGame(){
        return price*quantity;
    }


}

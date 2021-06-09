package com.example.almuhtazibah11.APplicationLayer;

public class CustomCart {

   private Integer id;
   private String name;
   private String price;
    private String size;
   private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLENGTH() {
        return LENGTH;
    }

    public void setLENGTH(String LENGTH) {
        this.LENGTH = LENGTH;
    }

    public String getPdid() {
        return pdid;
    }

    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

   private String LENGTH;
   private String pdid;
    public CustomCart( String pdid,String name, String price, String size, String color, String LENGTH) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.LENGTH = LENGTH;
        this.pdid = pdid;
    }


    public CustomCart(Integer id,String pdid, String name, String price, String size, String color, String LENGTH ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.size = size;
        this.color = color;
        this.LENGTH = LENGTH;
        this.pdid = pdid;
    }







}

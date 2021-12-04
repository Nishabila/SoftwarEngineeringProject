package com.example.almuhtazibah11.APplicationLayer;

public class CartBuilder {
    private Integer id;
    private String name;
    private String price;
    private String size;
    private String color;

    public Integer getId() {
        return id;
    }

    public CartBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CartBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public CartBuilder setPrice(String price) {
        this.price = price; return this;
    }

    public String getSize() {
        return size;
    }

    public CartBuilder setSize(String size) {
        this.size = size; return this;
    }

    public String getColor() {
        return color;
    }

    public CartBuilder setColor(String color) {
        this.color = color; return this;
    }

    public String getLENGTH() {
        return LENGTH;
    }

    public CartBuilder setLENGTH(String LENGTH) {
        this.LENGTH = LENGTH; return this;
    }

    public String getPdid() {
        return pdid;
    }

    public CartBuilder setPdid(String pdid) {
        this.pdid = pdid; return this;
    }

    private String LENGTH;
    private String pdid;
    public CustomCart build(){
        CustomCart customCart=new CustomCart(id,pdid,name,price,size,color,LENGTH);
        return customCart;
    }
}

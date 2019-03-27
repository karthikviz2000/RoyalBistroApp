package com.example.RoyalBistro;

public class menu_item {
    private String item;
    private String cost;

    public menu_item(String item,String cost)
    {
        this.item=item;
        this.cost=cost;

    }

    public String getItem()
    {
        return item;
    }

    public String getCost()
    {
        return cost;
    }

}

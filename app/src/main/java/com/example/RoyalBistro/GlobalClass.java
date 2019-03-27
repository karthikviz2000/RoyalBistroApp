package com.example.RoyalBistro;

import android.app.Application;
import android.widget.TextView;

import java.util.ArrayList;

public class GlobalClass extends Application {

    private final ArrayList<Boolean> burgers=new ArrayList<Boolean>();
    private final ArrayList<Boolean> fries=new ArrayList<Boolean>();
    private final ArrayList<Boolean> milkshake=new ArrayList<Boolean>();
    private final ArrayList<Boolean> moctail=new ArrayList<Boolean>();
    private final ArrayList<Boolean> monstershake=new ArrayList<Boolean>();
    private final ArrayList<Boolean> pasta=new ArrayList<Boolean>();
    private final ArrayList<Boolean> pizza=new ArrayList<Boolean>();
    private final ArrayList<Boolean> sandwich=new ArrayList<Boolean>();
    private final ArrayList<Boolean> wraps=new ArrayList<Boolean>();

     TextView order_summary;

    public ArrayList<Boolean> getburger(){
        return burgers;
    }

    public ArrayList<Boolean> getfries(){
        return fries;
    }

    public ArrayList<Boolean> getMilkshake(){
        return milkshake;
    }

    public ArrayList<Boolean> getMoctail(){
        return moctail;
    }

    public ArrayList<Boolean> getMonstershake(){
        return monstershake;
    }

    public ArrayList<Boolean> getPasta(){
        return pasta;
    }

    public ArrayList<Boolean> getPizza(){
        return pizza;
    }

   public ArrayList<Boolean> getSandwich(){
        return sandwich;
    }

    public ArrayList<Boolean> getWraps(){
        return wraps;
    }

    public void setBurgers(int ind,Boolean val){
        burgers.add(ind,val);
    }

    public void setFries(int ind,Boolean val){
        fries.add(ind,val);
    }

    public void setMilkshake(int ind,Boolean val){
        milkshake.add(ind,val);
    }

    public void setMoctail(int ind,Boolean val){
        moctail.add(ind,val);
    }

    public void setMonstershake(int ind,Boolean val){
        monstershake.add(ind,val);
    }

    public void setPasta(int ind,Boolean val){
        pasta.add(ind,val);
    }

    public void setPizza(int ind,Boolean val){
        pizza.add(ind,val);
    }

    public void setSandwich(int ind,Boolean val){
        sandwich.add(ind,val);
    }

    public void setWraps(int ind,Boolean val){
        wraps.add(ind,val);
    }



}

package com.example.RoyalBistro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class pizza extends Fragment {

    private boolean[] flag_pizza;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_pizza+=1;
        View v=inflater.inflate(R.layout.pizza,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("Magherita pizza","79"));
        menu_items.add(new menu_item("Corn pizza","89"));
        menu_items.add(new menu_item("Paneer Tikka Pizza","89"));
        menu_items.add(new menu_item("Mushroom veg pizza","89"));
        menu_items.add(new menu_item("Exotic veg pizza","100"));
        menu_items.add(new menu_item("Chicken Pizza","99"));
        menu_items.add(new menu_item("Chicken Tikka Pizza","109"));
        menu_items.add(new menu_item("BBQ Chicken Pizza","110"));
        menu_items.add(new menu_item("Chicken Sausage Pizza","110"));
        menu_items.add(new menu_item("Spicy Chicken Pizza","110"));
        menu_items.add(new menu_item("Pepperoni Chicken Pizza","120"));

        flag_pizza=new boolean[menu_items.size()];


        if(MainActivity.count_pizza==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setPizza(i,false);
            }
        }


        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getPizza());

        ListView listview=(ListView)v.findViewById(R.id.pizzaview);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

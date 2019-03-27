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

public class sandwich_fragment extends Fragment {


    private boolean[] flag_sandwich;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_sandwich+=1;
        View v=inflater.inflate(R.layout.sandwichview,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("Plain Cheese Sandwich","30"));
        menu_items.add(new menu_item("Plain chilly cheese sandwich","35"));
        menu_items.add(new menu_item("veg sandwich","40"));
        menu_items.add(new menu_item("corn sandwich","45"));
        menu_items.add(new menu_item("lays sandwich","45"));
        menu_items.add(new menu_item("Buja spicy sandwich","45"));
        menu_items.add(new menu_item("veg jalapeno sandwich","50"));
        menu_items.add(new menu_item("corn cheese sandwich","50"));
        menu_items.add(new menu_item("paneer sandwich","50"));
        menu_items.add(new menu_item("corn and paneer sandwich","55"));
        menu_items.add(new menu_item("paneer tikka sandwich","60"));

        menu_items.add(new menu_item("Chicken sandwich","50"));
        menu_items.add(new menu_item("chilly chicken spicy sandwich","54"));
        menu_items.add(new menu_item("schezwan spicy chicken sandwich","54"));
        menu_items.add(new menu_item("pepperoni chicken sandwich","60"));
        menu_items.add(new menu_item("BBQ chicken sandwich","60"));
        menu_items.add(new menu_item("chicken cheese sandwich","65"));
        menu_items.add(new menu_item("pepperoni cheese chicken sandwich","70"));
        menu_items.add(new menu_item("chicken tikka sandwich","79"));
        menu_items.add(new menu_item("chicken tikka cheese sandwich","79"));
        menu_items.add(new menu_item("chicken cube bites sandwich","84"));

        flag_sandwich=new boolean[menu_items.size()];


        if(MainActivity.count_sandwich==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setSandwich(i,false);
            }
        }

        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getSandwich());

        ListView listview=(ListView)v.findViewById(R.id.sandwichview);
        listview.setAdapter(menu_adapter);
        return v;
    }
}

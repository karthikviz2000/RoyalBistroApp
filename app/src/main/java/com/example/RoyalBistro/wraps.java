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

public class wraps extends Fragment {

    private boolean[] flag_wraps;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.count_wrap+=1;
        View v=inflater.inflate(R.layout.wraps,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("veg wrap","50"));
        menu_items.add(new menu_item("paneer tikka wrap","50"));
        menu_items.add(new menu_item("corn wrap","60"));
        menu_items.add(new menu_item("corn cheese wrap","65"));
        menu_items.add(new menu_item("mushroom and broccoli wrap","70"));
        menu_items.add(new menu_item("chicken wrap","70"));
        menu_items.add(new menu_item("sausage chicken wrap","70"));
        menu_items.add(new menu_item("chicken tikka wrap","79"));
        menu_items.add(new menu_item("spicy chicken wrap","76"));
        menu_items.add(new menu_item("pepperoni chicken wrap","80"));

        flag_wraps=new boolean[menu_items.size()];


        if(MainActivity.count_wrap==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setWraps(i,false);
            }
        }

        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getWraps());

        ListView listview=(ListView)v.findViewById(R.id.wrapsview);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

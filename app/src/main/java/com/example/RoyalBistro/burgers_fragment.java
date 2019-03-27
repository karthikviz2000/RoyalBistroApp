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

public class burgers_fragment extends Fragment {



    private static final String TAG="Tab2Fragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.count_burger+=1;
        View v=inflater.inflate(R.layout.burgerview,container,false);

        final GlobalClass globalVariable = (GlobalClass)getActivity().getApplication();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("paneer veg burger","55"));
        menu_items.add(new menu_item("veg burger","65"));
        menu_items.add(new menu_item("spicy veg burger","65"));
        menu_items.add(new menu_item("veg cheese burger","70"));
        menu_items.add(new menu_item("ROYAL 'B' SPECIAL BURGER","103"));
        menu_items.add(new menu_item("chicken burger","70"));
        menu_items.add(new menu_item("Chicken cheese burger","76"));
        menu_items.add(new menu_item("spicy Chicken burger","80"));
        menu_items.add(new menu_item("ROYAL 'B' SPECIAL BURGER","125"));


        if(MainActivity.count_burger==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setBurgers(i,false);
            }
        }
        //flag_burgers=new boolean[menu_items.size()];

        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getburger());

        ListView listview=(ListView)v.findViewById(R.id.burgerview);
        listview.setAdapter(menu_adapter);
        return v;
    }
}

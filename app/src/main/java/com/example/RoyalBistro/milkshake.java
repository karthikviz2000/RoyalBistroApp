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

public class milkshake extends Fragment {

    private boolean[] flag_milkshakes;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_milkshake+=1;
        View v=inflater.inflate(R.layout.milkshake,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("strawberry milkshake","55"));
        menu_items.add(new menu_item("black current milkshake","55"));
        menu_items.add(new menu_item("mango milkshake","55"));
        menu_items.add(new menu_item("kiwi milkshake","55"));
        menu_items.add(new menu_item("oreo milkshake","55"));
        menu_items.add(new menu_item("cold coffee","60"));
        menu_items.add(new menu_item("chocolate shake","60"));

        flag_milkshakes=new boolean[menu_items.size()];


        if(MainActivity.count_milkshake==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setMilkshake(i,false);
            }
        }


        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getMilkshake());

        ListView listview=(ListView)v.findViewById(R.id.milkshake);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

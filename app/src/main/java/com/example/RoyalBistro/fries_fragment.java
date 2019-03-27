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

public class fries_fragment extends Fragment {

    private boolean[] flag_fries;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_fries+=1;
        View v=inflater.inflate(R.layout.fries_view,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();
        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("Salted Fries(Normal)","60"));
        menu_items.add(new menu_item("Masala Fries(Normal)","60"));
        menu_items.add(new menu_item("Normal Cheesy Fries","70"));
        menu_items.add(new menu_item("Spicy Cheesy Fries","89"));

        flag_fries=new boolean[menu_items.size()];



        if(MainActivity.count_fries==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setFries(i,false);
            }
        }



        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getfries());

        ListView listview=(ListView)v.findViewById(R.id.friesview);
        listview.setAdapter(menu_adapter);

        return v;
    }


}

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

public class moctail extends Fragment {

    private boolean[] flag_moctial;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_moctail+=1;
        View v=inflater.inflate(R.layout.moctail,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("strawberry","40"));
        menu_items.add(new menu_item("kiwi","40"));
        menu_items.add(new menu_item("black current","40"));
        menu_items.add(new menu_item("blue curacao","50"));
        menu_items.add(new menu_item("mojito mint","55"));

        flag_moctial=new boolean[menu_items.size()];


        if(MainActivity.count_moctail==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setMoctail(i,false);
            }
        }

        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getMoctail());

        ListView listview=(ListView)v.findViewById(R.id.moctail);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

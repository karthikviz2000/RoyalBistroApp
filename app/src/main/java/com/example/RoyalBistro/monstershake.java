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

public class monstershake extends Fragment {

    private boolean[] flag_monstershake;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        MainActivity.count_monstershake+=1;
        View v=inflater.inflate(R.layout.monstershake,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplicationContext();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("oreo monstershake","159"));
        menu_items.add(new menu_item("chocolate monstershake","159"));
        menu_items.add(new menu_item("strawberry monstershake","159"));
        menu_items.add(new menu_item("blackcurrent monstershake","159"));

        flag_monstershake=new boolean[menu_items.size()];

        if(MainActivity.count_monstershake==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setMonstershake(i,false);
            }
        }

        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getMonstershake());

        ListView listview=(ListView)v.findViewById(R.id.monstershake);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

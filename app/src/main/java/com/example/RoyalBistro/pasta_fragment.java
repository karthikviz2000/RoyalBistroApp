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




public class pasta_fragment extends Fragment {

    private boolean[] flag_pasta;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainActivity.count_pasta+=1;
        View v=inflater.inflate(R.layout.pasta_fragment,container,false);

        final GlobalClass globalVariable = (GlobalClass) getActivity().getApplication();

        ArrayList<menu_item> menu_items=new ArrayList<menu_item>();
        menu_items.add(new menu_item("penne alferdo veg","60"));
        menu_items.add(new menu_item("MAC 'N' CHEESE","60"));
        menu_items.add(new menu_item("penne arabiata veg","70"));
        menu_items.add(new menu_item("penne alferdo exotic veg","89"));
        menu_items.add(new menu_item("penne alferdo chicken","90"));
        menu_items.add(new menu_item("penne arrabiate chicken","99"));



        //flag_pasta=new boolean[menu_items.size()];

        if(MainActivity.count_pasta==1){
            for(int i=0;i<menu_items.size();i++){
                globalVariable.setPasta(i,false);
            }
        }


        menu_card_adapter menu_adapter=new menu_card_adapter(getActivity(),menu_items,globalVariable.getPasta());

        ListView listview=(ListView) v.findViewById(R.id.pastaview);
        listview.setAdapter(menu_adapter);

        return v;
    }
}

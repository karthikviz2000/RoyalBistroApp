package com.example.RoyalBistro;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class menu_card_adapter extends ArrayAdapter<menu_item> {



    private final ArrayList<Boolean> itemChecked;


    public menu_card_adapter(Activity context, ArrayList<menu_item> menu_items,ArrayList<Boolean> flag)
    {
        super(context,0,menu_items);
       itemChecked = flag;
    }

    @Override
    public View getView(final int position, View convertview, ViewGroup parent)
    {   View ordersummary_layout=null;
         View order_button=null;
        View listItemView=convertview;
        if(listItemView==null)
        {
            listItemView= LayoutInflater.from(getContext()).inflate(
                    R.layout.menu_view,parent,false);

            ordersummary_layout=LayoutInflater.from(getContext()).inflate(R.layout.activity_order_summary,parent,false);
            order_button=LayoutInflater.from(getContext()).inflate(R.layout.activity_main,parent,false);
        }
        final boolean flag=itemChecked.get(position);
        menu_item currentMenuItem=getItem(position);

        TextView menu=(TextView)listItemView.findViewById(R.id.item);
        menu.setText(currentMenuItem.getItem());

        final TextView cost=(TextView)listItemView.findViewById(R.id.cost);
        cost.setText(currentMenuItem.getCost());

        final NumberPicker qty=(NumberPicker)listItemView.findViewById(R.id.qty_id);
        qty.setMinValue(0);
        qty.setMaxValue(10);





        final CheckBox orders=(CheckBox)listItemView.findViewById(R.id.order);
       orders.setChecked(flag);

        qty.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                MainActivity.new_value=newVal;
                if(orders.isChecked())
                {
                    if(newVal<oldVal) {
                        MainActivity.sum -= Integer.parseInt(cost.getText().toString());
                        MainActivity.viewsum.setText(String.valueOf(MainActivity.sum));
                    }
                    else {
                        MainActivity.sum += Integer.parseInt(cost.getText().toString());
                        MainActivity.viewsum.setText(String.valueOf(MainActivity.sum));
                    }
                }

            }
        });




        final GlobalClass globalVariable = (GlobalClass)getContext().getApplicationContext();

         final String name=menu.getText().toString();


        if(orders.isChecked())
       {
           MainActivity.viewsum.setText(String.valueOf(MainActivity.sum));

           //ordersummary.append(name+"\t"+quant+"\t"+price+"\n");


       }



        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (orders.isChecked()) {
                    itemChecked.set(position, true);
                    int s=qty.getValue();
                    MainActivity.sum+=s*(Integer.parseInt(cost.getText().toString()));
                    MainActivity.viewsum.setText(String.valueOf(MainActivity.sum));
                    if(globalVariable.order_summary==null) {
                        globalVariable.order_summary = new TextView(getContext());
                        globalVariable.order_summary.setText("ITEM NAME        QUANTITY          PRICE");
                        globalVariable.order_summary.setTextSize(25);
                        globalVariable.order_summary.setTypeface(Typeface.DEFAULT_BOLD);
                        globalVariable.order_summary.append("\n\n"+name+"\t\t\t\t"+MainActivity.new_value+"\t\t\t\t"+s*(Integer.parseInt(cost.getText().toString())));
                    }
                   else
                       globalVariable.order_summary.append("\n\n"+name+"\t\t\t\t"+MainActivity.new_value+"\t\t\t\t"+s*(Integer.parseInt(cost.getText().toString())));
                   // ordersummary.setText(name+"    "+quant+"    "+price+"\n");

                }
                else if(!(orders.isChecked())){
                       itemChecked.set(position, false);
                       int s=qty.getValue();
                       String target="\n\n"+name+"\t\t\t\t"+MainActivity.new_value+"\t\t\t\t"+s*(Integer.parseInt(cost.getText().toString()));
                       String textcontent=globalVariable.order_summary.getText().toString();
                       textcontent=textcontent.replace(target,"");
                       globalVariable.order_summary.setText(textcontent);
                    MainActivity.sum-=s*(Integer.parseInt(cost.getText().toString()));
                    MainActivity.viewsum.setText(String.valueOf(MainActivity.sum));
                }
            }
        });




        return listItemView;


    }





}

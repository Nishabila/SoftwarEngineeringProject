package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.almuhtazibah11.DAl.CartLocalDAL;
import com.example.almuhtazibah11.R;


import java.util.ArrayList;
import java.util.List;

public class CartAdapterAL extends RecyclerView.Adapter<CartAdapterAL.ViewHolder> {
List<CustomCart>customCartList;

    Context context;
    CartLocalDAL databaseHelperClass;
    public CartAdapterAL(List<CustomCart> customCartList, Context context) {
        this.customCartList = customCartList;
        this.context = context;
        databaseHelperClass=new CartLocalDAL(context);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        final CustomCart cartModelClass = customCartList.get(position);

        holder.text1.setText( "Product ID:"+cartModelClass.getPdid());
        holder.text2.setText( "Product Name: "+cartModelClass.getName());
        holder.text3.setText( "Product Price:"+cartModelClass.getPrice());
        holder.text4.setText( "Product Size:"+cartModelClass.getSize());
        holder.text5.setText( "Product Color:"+cartModelClass.getColor());
        holder.text6.setText( "Product Length:"+cartModelClass.getLENGTH());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(cartModelClass.getId());
               customCartList.remove(position);
                notifyDataSetChanged();
            }
        });

    }
public void cartDelete(){
        databaseHelperClass.deleteAll();
}
    public List<CustomCart> cartList(){
        List<CustomCart> storeCart = new ArrayList<>();
        storeCart=databaseHelperClass.getCartList();
        return storeCart;
    }
    @Override
    public int getItemCount() {
        return customCartList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView text1,text2,text3,text4,text5,text6;
        Button btn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text1=itemView.findViewById(R.id.Itempid3);
            text2 = itemView.findViewById(R.id.ItemName);
            text3 = itemView.findViewById(R.id.ItemPrice);
            text4 = itemView.findViewById(R.id.ItemSize);
            text5 = itemView.findViewById(R.id.ItemLength);
            text6 = itemView.findViewById(R.id.ItemColor);
            btn = itemView.findViewById(R.id.deleteitem);
        }
    }
}

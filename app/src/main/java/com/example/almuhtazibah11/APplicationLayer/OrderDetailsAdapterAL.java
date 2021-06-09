package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.almuhtazibah11.DAl.ShowOrderDetailsDAL;
import com.example.almuhtazibah11.R;

import java.util.List;

public class OrderDetailsAdapterAL extends RecyclerView.Adapter< OrderDetailsAdapterAL.ViewHolder>{

    private Context context;

    public OrderDetailsAdapterAL(Context context, List<OrderDeteailModel> orderdetailsList) {
        this.context = context;
        this.orderdetailsList = orderdetailsList;
    }

    private List<OrderDeteailModel> orderdetailsList;
    @NonNull
    @Override
    public  OrderDetailsAdapterAL.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.orderitems,null);
        return new  OrderDetailsAdapterAL.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull OrderDetailsAdapterAL.ViewHolder holder, int position) {

        OrderDeteailModel pro=orderdetailsList.get(position);



        holder.id.setText("Order Id: "+ pro.getOrder_id());
        holder.TV_positionname.setText("Product Names :"+pro.getPname());
        holder.TV_price.setText("Product Price :"+pro.getPprice());
        holder.TV_size.setText("Product Sizes :"+pro.getPsize());
        holder.TV_length.setText("Product Lengths :"+pro.getPlength());
        holder.TV_email.setText("Customer Email :"+pro.getCustomer_email());
        holder.TV_proof.setText("Payment proofs :"+pro.getPayProof());
        holder.TV_description.setText("Delivery & Payments Description :"+pro.getDescription());
        holder.TV_Delivery.setText("Product Delibery Method :"+pro.getDeliviery_option());
        holder.TV_color.setText("Product Colors :"+pro.getPcolor());
    }

    @Override
    public int getItemCount() {
        return orderdetailsList.size();
    }


    public void showOrdersdata(RecyclerView recyclerView) {
        ShowOrderDetailsDAL showOrderDetailsDAL=new ShowOrderDetailsDAL(context,orderdetailsList);
        showOrderDetailsDAL.showOrderdata(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView id,TV_positionname ,TV_price,TV_size,TV_length,TV_email,TV_proof,TV_description,TV_color,TV_Delivery;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id=itemView.findViewById(R.id.oidtxtds);
            TV_positionname=itemView.findViewById(R.id.pnametxtds);
            TV_price=itemView.findViewById(R.id.ppricedstxt);
            TV_color=itemView.findViewById(R.id.pcolorTxtds);
            TV_size=itemView.findViewById(R.id.psizeTxtds);
            TV_length=itemView.findViewById(R.id.plrngthTxtds);
            TV_email=itemView.findViewById(R.id.pcsemailTxtds);
            TV_proof=itemView.findViewById(R.id.pproofdTxtds);
            TV_description=itemView.findViewById(R.id.pdescritTxtds);
            TV_Delivery=itemView.findViewById(R.id.pdeliveryTxtds);
        }

    }
}

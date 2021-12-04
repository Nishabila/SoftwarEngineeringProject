package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.almuhtazibah11.DAl.ShowTransactionDAL;
import com.example.almuhtazibah11.PresentationLayer.OwnerDashboardUIPL;

import com.example.almuhtazibah11.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Money_transaction_adapterAL extends RecyclerView.Adapter<Money_transaction_adapterAL.Money_transaction_viewHolder>{

    public Money_transaction_adapterAL(Context context, List<Money_transaction_model> money_transaction_model_list) {
        this.context = context;
        this.money_transaction_model_list = money_transaction_model_list;
    }

    private Context context;
    private List<Money_transaction_model> money_transaction_model_list;

    TextView paid;


    @NonNull
    @Override
    public Money_transaction_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.money_tran_list,null);


        return new Money_transaction_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Money_transaction_viewHolder holder, int position) {

        Money_transaction_model money_transaction_model = money_transaction_model_list.get(position);

        holder.ed_orderId.setText("Order Id:"+String.valueOf(money_transaction_model.getOrder_id()));

        holder.ed_userId.setText("User ID: "+String.valueOf(money_transaction_model.getUser_id()));
        holder.ed_name.setText("Products Name: "+money_transaction_model.getP_name());
        holder.ed_price.setText("Product Price :"+money_transaction_model.getP_price());
        holder.ed_paid.setText("Status :" +money_transaction_model.getPaid());


        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://almuhtazibah.000webhostapp.com/update_money_transaction.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(context, "update successfully", Toast.LENGTH_SHORT).show();
                                context.startActivity(new Intent(context, OwnerDashboardUIPL.class));
                                try {
                                    JSONObject res = new JSONObject(response);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Log.e("TAG", "msg: "+response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> map = new HashMap<>();

                        map.put("Order_id",String.valueOf(money_transaction_model.getOrder_id()));
                        map.put("paid","Paid ");

                        return map;

                    }
                };

                Volley.newRequestQueue(context).add(stringRequest);

            }
        });




    }


    @Override
    public int getItemCount() {
        return money_transaction_model_list.size();
    }


    public void showTransactiondata(RecyclerView recyclerView) {
        ShowTransactionDAL showTransactionDAL=new ShowTransactionDAL(context,money_transaction_model_list);
        showTransactionDAL.showTransectionDetail(recyclerView);
    }

    public class Money_transaction_viewHolder extends RecyclerView.ViewHolder {

        TextView ed_userId,ed_name,ed_price,ed_paid,ed_orderId;
        Button btn;
        public Money_transaction_viewHolder(@NonNull View itemView) {
            super(itemView);


            ed_orderId = itemView.findViewById(R.id.Order_id);
            ed_userId = itemView.findViewById(R.id.User_id);
            ed_name = itemView.findViewById(R.id.p_name);
            ed_price = itemView.findViewById(R.id.p_price);
            ed_paid = itemView.findViewById(R.id.paid);
            btn=itemView.findViewById(R.id.upmnpd);

        }
    }


}

package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.almuhtazibah11.DAl.ShowReviewDAL;
import com.example.almuhtazibah11.R;

import java.util.List;

public class ReviewAdapterAL extends RecyclerView.Adapter< ReviewAdapterAL.ViewHolder>{

    private Context context;

    public ReviewAdapterAL(Context context, List<ReviewModel> reviewList) {
        this.context = context;
        this.reviewList = reviewList;
    }

    private List<ReviewModel> reviewList;
    @NonNull
    @Override
    public  ReviewAdapterAL.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.rv_items_review,null);
        return new  ReviewAdapterAL.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  ReviewAdapterAL.ViewHolder holder, int position) {

       ReviewModel pro=reviewList.get(position);
        holder.txtrid.setText("Review_ID: "+pro.getRId());
        holder.txtremail.setText("customer Email: "+pro.getEmail());
        holder.txtrvalue.setText( "Rating Value out of 5: "+pro.getValue());

        holder.txtrcmnt.setText("Customer Comment: "+pro.getCmt());
    }

    @Override
    public int getItemCount() {
        return reviewList.size();
    }



    public void showReviewdata(RecyclerView recyclerView) {
        ShowReviewDAL showReviewDAL=new ShowReviewDAL(context,reviewList);
        showReviewDAL.showReviewdata(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtrid;
        TextView txtrvalue;
        TextView txtrcmnt;
        TextView txtremail;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtrid=itemView.findViewById(R.id.ridtxt);
            txtremail=itemView.findViewById(R.id.remailtxt);
            txtrvalue=itemView.findViewById(R.id.valuetxt);
            txtrcmnt=itemView.findViewById(R.id.cmtTxt);
        }

    }
}

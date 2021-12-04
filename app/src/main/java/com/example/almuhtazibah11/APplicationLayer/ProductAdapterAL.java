package com.example.almuhtazibah11.APplicationLayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.almuhtazibah11.DAl.ProductsDetailDAL;
import com.example.almuhtazibah11.R;
import com.example.almuhtazibah11.PresentationLayer.SpecificproductUIPL;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_PName;
import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_Pprice;
import static com.example.almuhtazibah11.PresentationLayer.ProductUIPL.EXTRA_URL;


public class ProductAdapterAL extends RecyclerView.Adapter<ProductAdapterAL.ProductViewHolder> {


    private Context mCtx;
    private List<Product> productList;

    public ProductAdapterAL(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;

    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler1item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        Picasso.get()
                .load(product.getPhoto()).fit().centerInside()
                .into(holder.image2);

        holder.imageName.setText(product.getName());
        holder.imagePrice.setText(product.getPrice());
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailIntent = new Intent(mCtx, SpecificproductUIPL.class);
                Product pItem =productList.get(position);
                detailIntent.putExtra("id",pItem.getId());
                detailIntent.putExtra(EXTRA_URL, pItem.getPhoto());
                detailIntent.putExtra(EXTRA_PName, pItem.getName());
                detailIntent.putExtra(EXTRA_Pprice, pItem.getPrice());
                mCtx.startActivity(detailIntent);
            }
        });
        holder.relativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(mCtx, productList.get(position).getName() + " is clicked!", Toast.LENGTH_SHORT).show();
                Toast.makeText(mCtx, productList.get(position).getName()+ " is clicked!", Toast.LENGTH_SHORT).show();

                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public void loadproducts(RecyclerView recyclerView) {
        ProductsDetailDAL productsDetailDAL=new ProductsDetailDAL(mCtx,productList);
        productsDetailDAL.retrieve_product_data(recyclerView);
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        ImageView image2;
        TextView imageName;
        TextView imagePrice;
        RelativeLayout relativeLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            image2=itemView.findViewById(R.id.recycler1image);
            imageName=itemView.findViewById(R.id.recycler1name);
            imagePrice=itemView.findViewById(R.id.recycler1price);
            relativeLayout=itemView.findViewById(R.id.relative);

        }
    }
}
package com.example.madassignment.model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.madassignment.R;
import com.example.madassignment.kids1;
import com.example.madassignment.kids10;
import com.example.madassignment.kids2;
import com.example.madassignment.kids3;
import com.example.madassignment.kids4;
import com.example.madassignment.kids5;
import com.example.madassignment.kids6;
import com.example.madassignment.kids7;
import com.example.madassignment.kids8;
import com.example.madassignment.kids9;
import com.example.madassignment.men1;
import com.example.madassignment.men10;
import com.example.madassignment.men2;
import com.example.madassignment.men3;
import com.example.madassignment.men4;
import com.example.madassignment.men5;
import com.example.madassignment.men6;
import com.example.madassignment.men7;
import com.example.madassignment.men8;
import com.example.madassignment.men9;
import com.example.madassignment.shoe1;
import com.example.madassignment.shoe10;
import com.example.madassignment.shoe2;
import com.example.madassignment.shoe3;
import com.example.madassignment.shoe4;
import com.example.madassignment.shoe5;
import com.example.madassignment.shoe6;
import com.example.madassignment.shoe7;
import com.example.madassignment.shoe8;
import com.example.madassignment.shoe9;
import com.example.madassignment.women1;
import com.example.madassignment.women10;
import com.example.madassignment.women2;
import com.example.madassignment.women3;
import com.example.madassignment.women4;
import com.example.madassignment.women5;
import com.example.madassignment.women6;
import com.example.madassignment.women7;
import com.example.madassignment.women8;
import com.example.madassignment.women9;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductAdapterVh> implements Filterable {

    private List<ProductModel> productModelList;
    private List<ProductModel> getProductModelListFiltered;
    private Context context;
    private SelectedProduct selectedProduct;

    public ProductAdapter(List<ProductModel> productModelList, SelectedProduct selectedProduct) {
        this.productModelList = productModelList;
        this.getProductModelListFiltered = productModelList;
        this.selectedProduct = selectedProduct;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductAdapterVh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();

        return new ProductAdapterVh(LayoutInflater.from(context).inflate(R.layout.row_product, null));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductAdapterVh holder, int position) {
        ProductModel productModel = productModelList.get(position);

        String productName = productModel.getProductName();
        String prefix = productModel.getProductName().substring(0,1);

        holder.tvProductName.setText(productName);
        holder.tvPrefix.setText(prefix);
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    @Override
    public Filter getFilter() {

        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                FilterResults filterResults = new FilterResults();
                if(charSequence == null | charSequence.length() == 0){
                    filterResults.count = getProductModelListFiltered.size();
                    filterResults.values = getProductModelListFiltered;
                }else {
                    String searchChr = charSequence.toString().toLowerCase();
                    List<ProductModel> resultData = new ArrayList<>();
                    for(ProductModel productModel:getProductModelListFiltered){
                        if(productModel.getProductName().toLowerCase().contains(searchChr)){
                            resultData.add(productModel);
                        }
                    }
                    filterResults.count = resultData.size();
                    filterResults.values = resultData;
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                productModelList = (List<ProductModel>) filterResults.values;
                notifyDataSetChanged();

            }
        };

        return filter;
    }

    public interface SelectedProduct{
        void selectedProduct(ProductModel productModel);
    }

    public class ProductAdapterVh extends RecyclerView.ViewHolder {

        TextView tvPrefix;
        TextView tvProductName;
        ImageView imIcon;

        public ProductAdapterVh(@NonNull View itemView) {
            super(itemView);

            tvPrefix = itemView.findViewById(R.id.prefix);
            tvProductName = itemView.findViewById(R.id.productName);
            imIcon = itemView.findViewById(R.id.btnNext);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                    selectedProduct.selectedProduct(productModelList.get(getAdapterPosition()));
                    if (productModelList.get(getAdapterPosition()).getProductName().equals("Cargo Harem Pants")){
                        context.startActivity(new Intent(context, men1.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Black Pants")){
                        context.startActivity(new Intent(context, men2.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Hasel Pants")){
                        context.startActivity(new Intent(context, men3.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Pants Korean Style")){
                        context.startActivity(new Intent(context, men4.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Men Pockets Pants")){
                        context.startActivity(new Intent(context, men5.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Crystal Men's")){
                        context.startActivity(new Intent(context, men6.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Yfashion 3D")){
                        context.startActivity(new Intent(context, men7.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Stussy Sweatshirts")){
                        context.startActivity(new Intent(context, men8.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Cozy Japanese Men")){
                        context.startActivity(new Intent(context, men9.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("OFF White Hoodies")){
                        context.startActivity(new Intent(context, men10.class));
                    }
                    else if (productModelList.get(getAdapterPosition()).getProductName().equals("Adidas Cropped Hoodies")){
                        context.startActivity(new Intent(context, women1.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Shield")){
                        context.startActivity(new Intent(context, women2.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nerdunit Anatomy")){
                        context.startActivity(new Intent(context, women3.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Puma Evide")){
                        context.startActivity(new Intent(context, women4.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike A.A.E")){
                        context.startActivity(new Intent(context, women5.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nerdunit Dash")){
                        context.startActivity(new Intent(context, women6.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Rexagon Jacket")){
                        context.startActivity(new Intent(context, women7.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Adidas Track")){
                        context.startActivity(new Intent(context, women8.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Rexagon Spectra Pants")){
                        context.startActivity(new Intent(context, women9.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Tech Fleece")){
                        context.startActivity(new Intent(context, women10.class));
                    }
                    else if (productModelList.get(getAdapterPosition()).getProductName().equals("Natural History Shirt")){
                        context.startActivity(new Intent(context, kids1.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Lego Shirt Sleeve")){
                        context.startActivity(new Intent(context, kids2.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Satin Bomber")){
                        context.startActivity(new Intent(context, kids3.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Flock-print Hoodies")){
                        context.startActivity(new Intent(context, kids4.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Urban Walls T-Shirts")){
                        context.startActivity(new Intent(context, kids5.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Henley Shirt")){
                        context.startActivity(new Intent(context, kids6.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Puff-sleeved Top")){
                        context.startActivity(new Intent(context, kids7.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Twill Jacket")){
                        context.startActivity(new Intent(context, kids8.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Classic Blazer")){
                        context.startActivity(new Intent(context, kids9.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Patterned Dress")){
                        context.startActivity(new Intent(context, kids10.class));
                    }
                    else if (productModelList.get(getAdapterPosition()).getProductName().equals("Air Jordan Mid")){
                        context.startActivity(new Intent(context, shoe1.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Ryz 365")){
                        context.startActivity(new Intent(context, shoe2.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Air Force 1 Shadow")){
                        context.startActivity(new Intent(context, shoe3.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Classic Cortez")){
                        context.startActivity(new Intent(context, shoe4.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Jordan Jumpman")){
                        context.startActivity(new Intent(context, shoe5.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Kyrie Low")){
                        context.startActivity(new Intent(context, shoe6.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike React Element")){
                        context.startActivity(new Intent(context, shoe7.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Signal")){
                        context.startActivity(new Intent(context, shoe8.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Air Max 97")){
                        context.startActivity(new Intent(context, shoe9.class));
                    }
                    else if(productModelList.get(getAdapterPosition()).getProductName().equals("Nike Air Max 98")){
                        context.startActivity(new Intent(context, shoe10.class));
                    }
                }
            });
        }
    }
}

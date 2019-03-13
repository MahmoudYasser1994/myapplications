package com.example.daleel.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.MyViewHolder> {
    private List<Datum> datumList;
    private ListAllClickListener listAllClickListener;

    public CompaniesAdapter(List<Datum> datumList, ListAllClickListener listAllClickListener) {
        this.datumList = datumList;
        this.listAllClickListener = listAllClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from (parent.getContext ( )).inflate (R.layout.companies_design, parent, false);
        ButterKnife.bind (this, view);
        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Datum movie = datumList.get (position);
        holder.onBind (movie);
    }

    @Override
    public int getItemCount() {
        return datumList.size ( );
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewname)
        TextView txtName;
        @BindView(R.id.textViewcountry)
        TextView txtCountry;
        @BindView(R.id.textViewMohafza)
        TextView txtMohafza;
        @BindView(R.id.textviewsection)
        TextView txtsection;

        public MyViewHolder(@NonNull View itemView) {
            super (itemView);
            ButterKnife.bind (this, itemView);

        }

        void onBind(final Datum data) {

            txtName.setText (data.getName ( ));
            txtCountry.setText (data.getCountry ( ).getEnglishName ( ));
            txtMohafza.setText (data.getMohafza ( ).getEnglishName ( ));
            txtsection.setText (data.getSection ( ).getEnglishName ( ));

            itemView.setOnClickListener (v -> listAllClickListener.onItemClick (data,getAdapterPosition ()));


        }
    }

    public void replaceData(List<Datum> movies) {
        this.datumList.clear ();
        this.datumList.addAll (movies);
        notifyDataSetChanged ();
    }


}

package com.example.daleel.Adapters;

import android.database.CursorJoiner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.daleel.Interfaces.ListAllClickListener;
import com.example.daleel.Models.CompaniesModel.Datum;
import com.example.daleel.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.media.MediaBrowserServiceCompat;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.MyViewHolder> implements Filterable {
    private List<Datum> datumList;
    private List<Datum> datumListFull;
    private ListAllClickListener listAllClickListener;

    public CompaniesAdapter(List<Datum> datumList, ListAllClickListener listAllClickListener) {
        this.datumList = datumList;
        datumListFull = new ArrayList<> (datumList);
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

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter ( ) {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Datum> filteredlist = new ArrayList<> ();
            if (constraint == null || constraint.length ()==0){
                filteredlist.addAll (datumListFull);
            } else {
                String searchpattern = constraint.toString ().toLowerCase ().trim ();
                for (Datum item : datumListFull){
                    if (item.getName ().toLowerCase ().contains (searchpattern)){
                        filteredlist.add (item);
                    }
                }
            }
            FilterResults Result = new FilterResults ();
            Result.values=filteredlist;

            return Result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            datumList.clear ();
            datumList.addAll ((List)results.values);
            notifyDataSetChanged ();

        }
    };


    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.textViewname)
        TextView txtName;
        @BindView(R.id.textViewcountry)
        TextView txtCountry;
        @BindView(R.id.textViewmohafza)
        TextView txtMohafza;
        @BindView(R.id.textviewsection)
        TextView txtsection;

        public MyViewHolder(@NonNull View itemView) {
            super (itemView);
            ButterKnife.bind (this, itemView);

        }

        void onBind(final Datum data) {

            txtName.setText (data.getName ( ));
            txtCountry.setText (data.getCountry ( ).getArabicName ());
            txtMohafza.setText (data.getMohafza ( ).getArabicName ());
            txtsection.setText (data.getSection ( ).getArabicName ());

            itemView.setOnClickListener (v -> listAllClickListener.onItemClick (data,getAdapterPosition ()));


        }
    }

    public void replaceData(List<Datum> movies) {
        this.datumList.clear ();
        this.datumList.addAll (movies);
        notifyDataSetChanged ();
    }


}

//package com.example.daleel.Filter;
//
//import android.widget.Filter;
//import android.widget.Filterable;
//
//import com.example.daleel.Adapters.CompaniesAdapter;
//import com.example.daleel.Interfaces.ListAllClickListener;
//import com.example.daleel.Models.CompaniesModel.Datum;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class FilterDesign extends CompaniesAdapter implements Filterable {
//
//    private List<Datum> datumList;
//    private List<Datum> datumListFull;
//
//    public FilterDesign(List<Datum> datumList, ListAllClickListener listAllClickListener) {
//        super (datumList, listAllClickListener);
//    }
//
//    @Override
//    public Filter getFilter() {
//        return exampleFilter;
//    }
//
//    private Filter exampleFilter = new Filter ( ) {
//        @Override
//        protected FilterResults performFiltering(CharSequence constraint) {
//            List<Datum> filteredlist = new ArrayList<> ();
//            if (constraint == null || constraint.length ()==0){
//                filteredlist.addAll (datumListFull);
//            } else {
//                String searchpattern = constraint.toString ().toLowerCase ().trim ();
//                for (Datum item : datumListFull){
//                    if (item.getName ().toLowerCase ().contains (searchpattern)){
//                        filteredlist.add (item);
//                    }
//                }
//            }
//            FilterResults Result = new FilterResults ();
//            Result.values=filteredlist;
//
//            return Result;
//        }
//
//        @Override
//        protected void publishResults(CharSequence constraint, FilterResults results) {
//            datumList.clear ();
//            datumList.addAll ((List)results.values);
//            notifyDataSetChanged ();
//
//        }
//    };
//}

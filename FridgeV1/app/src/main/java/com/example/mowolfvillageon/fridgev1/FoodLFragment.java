package com.example.mowolfvillageon.fridgev1;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by mowolfvillageon on 3/15/16.
 */
public class FoodLFragment extends ListFragment {
    private static ArrayList<String> aList;
    private static ArrayAdapter<String> adapter;

   /*  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragmentlayout, container, false);
        String[] items={"A->Z", "Category", "Expiration Date"};
        aList = new ArrayList<>(Arrays.asList(items));
        adapter=new ArrayAdapter<String>(getActivity(), R.layout.rowlayout, R.id.txtitem, aList);
        setListAdapter(adapter);
        setRetainInstance(true);
        return rootView;
    }
    public static void sortList(int order) {
        Collections.sort(aList, new Sorter(order));
        adapter.notifyDataSetChanged();
    }
    static class Sorter implements Comparator<Object> {
        int order = -1;

        Sorter(int order) {
            this.order = order;
        }

        public int compare(Object obj1, Object obj2) {
            if (obj1.toString().compareTo(obj2.toString()) == 0) return 0;
            // if object1 < object 2
            else if (obj1.toString().compareTo(obj2.toString()) < 0) return order;
            else return (-1 * order);
        }
    } */
}

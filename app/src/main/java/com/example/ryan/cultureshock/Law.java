package com.example.ryan.cultureshock;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Law extends Fragment {


    public Law() {
        // Required empty public constructor
    }

    View v;
    ListView listView;
    ArrayAdapter<String> lawAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_law, container, false);
        Resources res = getResources();
        lawAdapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_law, res.getStringArray(R.array.law_usa) );

        listView = (ListView) v.findViewById(R.id.lawList);
        listView.setAdapter(lawAdapter);

        return v;
    }

}

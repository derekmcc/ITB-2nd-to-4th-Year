package com.example.its.citymap;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.MapFragment;

import java.util.ArrayList;
import java.util.Arrays;


public class CityListFragment extends Fragment {

    private static final String TAG = "CityListFragment";

    public CityListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);
        ArrayAdapter<String> adapter =
        new ArrayAdapter<>(
                this.getActivity(),
                android.R.layout.simple_list_item_1,
                Arrays.asList(
                        "My Location",
                        "Dublin", "Kerry",
                        "Belfast", "Cork",
                        "Galway", "Wexford"
                )
        );

        ListView list = (ListView) view.findViewById(R.id.listView);
        list.setAdapter(adapter);

        list.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> list, View row, int index, long rowID) {
                    if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        Toast.makeText(getActivity(),"In IF on activity list", Toast.LENGTH_SHORT).show();
                        MapFragment frag = (MapFragment) getFragmentManager().findFragmentById(R.id.the_map);
                        frag.getMapAsync((CityMap)getActivity());
                        ((CityMap)getActivity()).setCity((String)list.getItemAtPosition(index));
                    }
                    else {
                        Toast.makeText(getActivity(),"In ELSE on activity list " + (String)list.getItemAtPosition(index), Toast.LENGTH_SHORT).show();
                        ((CityMap)getActivity()).setCity((String)list.getItemAtPosition(index));
                        ((CityMap)getActivity()).showMap();
                                            }
                    }
                }
        );
        return view;
    }
}

package commaciejprogramuje.facebook.solarsystem;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SolarObjectsFragment extends Fragment {


    public static final String OBJECTS_KEY = "objects";
    @InjectView(R.id.objectRecyclerView)
    RecyclerView objectRecyclerView;

    public SolarObjectsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_solar_objects, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SolarObject[] solarObjects = (SolarObject[]) getArguments().getSerializable(OBJECTS_KEY);
        objectRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        objectRecyclerView.setAdapter(new SolarObjectAdapter(solarObjects));
    }

    public static SolarObjectsFragment newInstance(SolarObject[] objects) {
        Bundle args = new Bundle();
        args.putSerializable(OBJECTS_KEY, objects);

        SolarObjectsFragment fragment = new SolarObjectsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.reset(this);
    }
}

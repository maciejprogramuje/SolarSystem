package commaciejprogramuje.facebook.solarsystem;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoonsFragment extends Fragment {
    public static final String OBJECTS_KEY = "objects";
    @Bind(R.id.moonsViewPager)
    ViewPager moonsViewPager;

    private TabCallBack tabCallBack;

    public MoonsFragment() {
        // Required empty public constructor
    }

    public static MoonsFragment newInstance(SolarObject[] solarObjects) {
        Bundle args = new Bundle();
        args.putSerializable(OBJECTS_KEY, solarObjects);
        MoonsFragment fragment = new MoonsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_moons, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tabCallBack = (TabCallBack) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        tabCallBack = null;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SolarObject[] solarObjects = (SolarObject[]) getArguments().getSerializable(OBJECTS_KEY);
        MoonsFragmentAdapter moonsFragmentAdapter = new MoonsFragmentAdapter(getChildFragmentManager(), solarObjects);
        moonsViewPager.setAdapter(moonsFragmentAdapter);

        tabCallBack.showTabs(moonsViewPager);
    }

    @Override
    public void onDestroyView() {
        tabCallBack.hideTabs();
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface TabCallBack {
        void showTabs(ViewPager viewPager);
        void hideTabs();
    }
}

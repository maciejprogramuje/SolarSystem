package commaciejprogramuje.facebook.solarsystem;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by m.szymczyk on 2017-09-14.
 */

public class MoonsFragmentAdapter extends FragmentStatePagerAdapter {
    private final SolarObject[] objectWithMoons;

    public MoonsFragmentAdapter(FragmentManager fm, SolarObject[] objectWithMoons) {
        super(fm);
        this.objectWithMoons = objectWithMoons;
    }

    @Override
    public Fragment getItem(int position) {
        return SolarObjectsFragment.newInstance(objectWithMoons[position].getMoons());
    }

    @Override
    public int getCount() {
        return objectWithMoons.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return objectWithMoons[position].getName();
    }
}

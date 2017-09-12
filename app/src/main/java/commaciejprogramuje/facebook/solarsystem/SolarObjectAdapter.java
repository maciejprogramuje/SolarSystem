package commaciejprogramuje.facebook.solarsystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by m.szymczyk on 2017-09-12.
 */

class SolarObjectAdapter extends RecyclerView.Adapter<SolarObjectAdapter.SolarObjectViewHolder> {
    private final SolarObject[] solarObjects;

    class SolarObjectViewHolder extends RecyclerView.ViewHolder {
        public SolarObjectViewHolder(View itemView) {
            super(itemView);
        }
    }

    public SolarObjectAdapter(SolarObject[] solarObjects) {
        this.solarObjects = solarObjects;
    }

    @Override
    public SolarObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_solar_object, parent, false);
        return new SolarObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SolarObjectViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return solarObjects.length;
    }
}

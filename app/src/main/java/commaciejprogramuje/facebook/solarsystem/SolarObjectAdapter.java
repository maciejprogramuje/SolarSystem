package commaciejprogramuje.facebook.solarsystem;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by m.szymczyk on 2017-09-12.
 */

class SolarObjectAdapter extends RecyclerView.Adapter<SolarObjectAdapter.SolarObjectViewHolder> {
    private final SolarObject[] solarObjects;
    private SolarObjectClickedListener solarObjectClickedListener;

    public void setSolarObjectClickedListener(SolarObjectClickedListener solarObjectClickedListener) {
        this.solarObjectClickedListener = solarObjectClickedListener;
    }

    class SolarObjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SolarObject solarObject;

        @Bind(R.id.itemImageView)
        ImageView itemImageView;
        @Bind(R.id.itemTextView)
        TextView itemTextView;

        public SolarObjectViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        public void setSolarObject(SolarObject solarObject) {
            this.solarObject = solarObject;

            itemTextView.setText(solarObject.getName());

            Glide.with(itemImageView.getContext())
                    .load("file:///android_asset/" + solarObject.getImage())
                    .placeholder(R.drawable.planet_placeholder)
                    .fitCenter()
                    .into(itemImageView);
        }

        public SolarObject getSolarObject() {
            return solarObject;
        }

        @Override
        public void onClick(View view) {
            itemClicked(solarObject);
        }
    }

    private void itemClicked(SolarObject solarObject) {
        if(solarObjectClickedListener != null) {
            solarObjectClickedListener.solarObjectClicked(solarObject);
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
        SolarObject solarObject = solarObjects[position];
        holder.setSolarObject(solarObject);
    }

    @Override
    public int getItemCount() {
        return solarObjects.length;
    }

    public interface SolarObjectClickedListener {
        void solarObjectClicked(SolarObject solarObject);
    }
}

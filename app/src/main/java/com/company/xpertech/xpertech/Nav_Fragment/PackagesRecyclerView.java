package com.company.xpertech.xpertech.Nav_Fragment;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.company.xpertech.xpertech.Packages;
import com.company.xpertech.xpertech.R;

import java.util.List;

/**
 * Created by Skylar Gail on 8/12/2018.
 */

public class PackagesRecyclerView extends RecyclerView.Adapter<PackagesRecyclerView.ViewHolder> implements PackagesFragment.OnFragmentInteractionListener {

    private final List<Packages> mPackages;
    private final PackagesFragment.OnFragmentInteractionListener mListener;
    private Context ctx;
    FragmentActivity activity;

    public PackagesRecyclerView(List<Packages> mPackages, PackagesFragment.OnFragmentInteractionListener mListener) {
        this.mPackages = mPackages;
        this.mListener = mListener;
    }

    @Override
    public PackagesRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx = parent.getContext())
                .inflate(R.layout.fragment_packages, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackagesRecyclerView.ViewHolder holder, int position) {
        holder.mTitleView.setText(mPackages.get(position).getTitle());
        holder.mChannelView.setText(mPackages.get(position).getNumOfChannel());
        holder.mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity = (FragmentActivity) ctx;
                ChannelFragment channelf = new ChannelFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_main, channelf).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return mPackages.size();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mTitleView;
        public final TextView mChannelView;
        public final Button mButtonView;


        public ViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mTitleView = (TextView) itemView.findViewById(R.id.package_title);
            mChannelView = (TextView) itemView.findViewById(R.id.package_channels);
            mButtonView = (Button) itemView.findViewById(R.id.btn_learnmore);
        }
    }
}

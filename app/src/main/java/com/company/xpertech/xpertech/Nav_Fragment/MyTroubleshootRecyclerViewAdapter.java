package com.company.xpertech.xpertech.Nav_Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.company.xpertech.xpertech.ListViewAdapter;
import com.company.xpertech.xpertech.R;
import com.company.xpertech.xpertech.TroubleShoot_List.DummyContent.DummyItem;
import com.company.xpertech.xpertech.Troubleshoot;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link TroubleshootFragment.OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTroubleshootRecyclerViewAdapter extends RecyclerView.Adapter<MyTroubleshootRecyclerViewAdapter.ViewHolder>
        implements TroubleeshootItemFragment.OnFragmentInteractionListener {

    private final List<Troubleshoot> mValues;
    private final TroubleshootFragment.OnListFragmentInteractionListener mListener;

    ListView list;
    ListViewAdapter adapter;
    ArrayList<String> troubleshootTitle;
    ArrayList <Troubleshoot> troubleshootList;
    Context ctx;
    String steps = "Steps: \n";

    public MyTroubleshootRecyclerViewAdapter(List<Troubleshoot> items, TroubleshootFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx = parent.getContext())
                .inflate(R.layout.fragment_troubleshoot, parent, false);
        return new ViewHolder(view);
    }




    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        /*holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);*/
        holder.mContentView.setText(mValues.get(position).getTitle());
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentActivity actvty = (FragmentActivity) ctx;
                Bundle bundle = new Bundle();
                String line = null;

//                Toast.makeText(ctx, mValues.get(position).getTitle() + " " + position, Toast.LENGTH_SHORT).show();

//                try {
//                    BufferedWriter bw = new BufferedWriter(new FileWriter("SameText.txt"));
//                    bw.write("Sgsm,gmhgshhm");
//                    BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\USER\\Desktop\\Xpertech\\app\\src\\main\\java\\com\\company\\xpertech\\xpertech\\TroubleShoot_List\\STB_1.txt"));
//                    line = br.readLine();
//                    while(line != null){
//                        steps += line + "\n";
//                        line = br.readLine();
//                    }
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }

//                Toast.makeText(ctx, steps, Toast.LENGTH_SHORT).show();

                steps = getProcess(position);
                bundle.putString("data", steps);
                TroubleeshootItemFragment tf = new TroubleeshootItemFragment();
                tf.setArguments(bundle);
                actvty.getSupportFragmentManager().beginTransaction().replace(R.id.content_main, tf).commit();

                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Troubleshoot mItem;

//        ArrayList<Troubleshoot> tItem = new ArrayList<Troubleshoot>();
//        Context ctx;

        public ViewHolder(View view) {
            super(view);
//            this.tItem = tItem;
//            this.ctx = ctx;
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }


        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

    private String getProcess(int position){
        switch(position){
            case 0:
                return "1.) On the Remote, press and hold OK button and Power button simultaneously until LED blinks 2x\n" +
                        "2.) Press 9-8-2 on the remote to unlock it for RCU programming, LED should blink 4x\n" +
                        "3.)\tPress and hold the OK button and Power button again simultaneously for 3-5 seconds until the LED blinks 2x\n" +
                        "4.)\tPress the assigned code 4998/2319 to be controlled\n" +
                        "5.)\tRemote control LED will blink 2x once correct code is entered\n" +
                        "6.)\tPress and hold the OK button and Power button simultaneously for 3-5 seconds until the LED blinks 2x\n" +
                        "7.)\tPress 9-8-2 on the remote to lock it for RCU programming, LED should blink 2x\n";
            case 1:
                return "1.)\tTurn on your TV\n" +
                        "2.)\tPress and hold the Simple Set button until LED blinks 2x\n" +
                        "3.)\tWhile pointing the remote control to your TV, press and hold the number button which corresponds to your TV brand until the TV turns off by itself\n" +
                        "        1 = Samsung\t6 = Sharp\n" +
                        "        2 = LG\t7 = Philips\n" +
                        "        3 = Sony\t8 = JVC\n" +
                        "        4 = Panasonic\t9 = Hitachi\n" +
                        "        5 = Toshiba\t0 = Haier\n" +
                        "4.)\tTurn on your TV using the TV remote control\n" +
                        "5.)\tOnce turned on, perform a test using your remote control to your TV by\n" +
                        "6.)\tpressing the Volume Up and Volume Down\n" +
                        "7.)\tpressing the Mute button\n" +
                        "8.)\tTest the Channel +/- key on the Remote control\n";
            case 2:
                return "1.)\tMake sure your STB is plugged in\n" +
                        "2.)\tCheck your STB front panel if it is turned on (LED is green)\n" +
                        "3.)\tIf light is green and still not booting up, perform hard reset by unplugging the STB from the wall socket and plug it back in after 5 seconds\n";
            case 3:
                return "1.)\tMake sure that your TV is not on standby mode\n" +
                        "2.)\tCheck the connections between the STB and TV if firmly and properly connected\n" +
                        "3.)\tOn your TV, select the correct Audio/Video input or source (example: AV1, AV2, HDM1 HDM2, etc.)\n" +
                        "4.)\tPower on the l STB\n" +
                        "5.)\tCheck TV and STB volume functions\n" +
                        "6.)\tIf issue persists, perform hard reset by unplugging the STB from the wall socket and plug it back in after 5 seconds\n";
            case 4:
                return "1.)\tCheck if coaxial cable (RG6) is firmly connected and secured\n" +
                        "2.)\tPress the MENU button on your remote control then navigate to SETTINGS\n" +
                        "3.)\tKey in default PIN as 0000 or 9998\n" +
                        "4.)\tNavigate to the following options SYSTEM SETUP > INSTALLATION SETUP > SATELLITE SETUP > LNB POWERING\n" +
                        "5.)\tToggle ON/OFF using the LEFT and RIGHT buttons on the remote\n" +
                        "6.)\tfor the Primary STB - must be set to ON\n" +
                        "7.)\tfor 2nd/3rd STB - must be set to OFF\n";
            case 5:
                return "1.)\tTurn the STB off and locate where the smart card is inserted\n" +
                        "2.)\tGently take out the smart card and check for any physical defects\n" +
                        "3.)\tYou may try to wipe the gold chip with a soft, dry, non-abrasive cloth to clear any dirt build up\n" +
                        "4.)\tInsert the smart card back to the card slot the same way how it was removed\n" +
                        "5.)\tMake sure that the smart card is properly inserted and seated securely\n";
        }
        return "";
    }
}
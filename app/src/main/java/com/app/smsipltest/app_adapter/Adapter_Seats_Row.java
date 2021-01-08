package com.app.smsipltest.app_adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.app.smsipltest.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

public class Adapter_Seats_Row extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private String TAG = Adapter_Seats_Row.class.getSimpleName();

    private ArrayList<String> resultEntities;

    private Context mContext;


    public Adapter_Seats_Row(Context context, ArrayList<String> resultEntities) {
        this.resultEntities = resultEntities;
        this.mContext = context;
    }

    @Override
    public int getItemCount() {
        return resultEntities.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_seat_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder1, int position) {

        MyViewHolder holder = (MyViewHolder) holder1;

        holder.mLaySeatRowOne.setVisibility(View.INVISIBLE);
        holder.mLaySeatRowTwo.setVisibility(View.INVISIBLE);
        holder.mLaySeatRowThree.setVisibility(View.INVISIBLE);
        holder.mLaySeatRowFour.setVisibility(View.INVISIBLE);
        holder.mLaySeatRowFive.setVisibility(View.INVISIBLE);

        String[] seatList = resultEntities.get(position).split(",");

        for (int i = 0; i < seatList.length; i++) {

            switch (i) {

                case 0:
                    if (!seatList[0].equals("0")) {
                        holder.mLaySeatRowOne.setVisibility(View.VISIBLE);
                        String[] seatName = seatList[0].split("-");
                        holder.mTxtSeatOne.setText(seatName[3]);
                    }
                    break;

                case 1:
                    if (!seatList[1].equals("0")) {
                        holder.mLaySeatRowTwo.setVisibility(View.VISIBLE);
                        String[] seatName = seatList[1].split("-");
                        holder.mTxtSeatTwo.setText(seatName[3]);
                    }
                    break;

                case 2:
                    if (!seatList[2].equals("0")) {
                        holder.mLaySeatRowThree.setVisibility(View.VISIBLE);
                        String[] seatName = seatList[2].split("-");
                        holder.mTxtSeatThree.setText(seatName[3]);
                    }
                    break;

                case 3:
                    if (!seatList[3].equals("0")) {
                        holder.mLaySeatRowFour.setVisibility(View.VISIBLE);
                        String[] seatName = seatList[3].split("-");
                        holder.mTxtSeatFour.setText(seatName[3]);
                    }
                    break;

                case 4:
                    if (!seatList[4].equals("0")) {
                        holder.mLaySeatRowFive.setVisibility(View.VISIBLE);
                        String[] seatName = seatList[4].split("-");
                        holder.mTxtSeatFive.setText(seatName[3]);
                    }
                    break;
            }


        }

    }


    ///Todo Pagination

    public ArrayList<String> getList() {
        return this.resultEntities;
    }

    public void setList(ArrayList<String> list) {
        this.resultEntities = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

       /* private CardView mCardRow1;
        private CardView mCardRow2;
        private CardView mCardRow3;
        private CardView mCardRow4;
        private CardView mCardRow;*/
       private LinearLayout mLaySeatRowOne;
        private MaterialTextView mTxtSeatOne;
        private LinearLayout mLaySeatRowTwo;
        private MaterialTextView mTxtSeatTwo;
        private LinearLayout mLaySeatRowThree;
        private MaterialTextView mTxtSeatThree;
        private LinearLayout mLaySeatRowFour;
        private MaterialTextView mTxtSeatFour;
        private LinearLayout mLaySeatRowFive;
        private MaterialTextView mTxtSeatFive;


        public MyViewHolder(View view) {
            super(view);
           /* mCardRow1 = view.findViewById(R.id.cardRow1);
            mCardRow2 = view.findViewById(R.id.cardRow2);
            mCardRow3 = view.findViewById(R.id.cardRow3);
            mCardRow4 = view.findViewById(R.id.cardRow4);
            mCardRow = view.findViewById(R.id.cardRow);*/

            mLaySeatRowOne = view.findViewById(R.id.laySeatRow_one);
            mTxtSeatOne = view.findViewById(R.id.txtSeat_one);
            mLaySeatRowTwo = view.findViewById(R.id.laySeatRow_two);
            mTxtSeatTwo = view.findViewById(R.id.txtSeat_two);
            mLaySeatRowThree = view.findViewById(R.id.laySeatRow_three);
            mTxtSeatThree = view.findViewById(R.id.txtSeat_three);
            mLaySeatRowFour = view.findViewById(R.id.laySeatRow_four);
            mTxtSeatFour = view.findViewById(R.id.txtSeat_four);
            mLaySeatRowFive = view.findViewById(R.id.laySeatRow_five);
            mTxtSeatFive = view.findViewById(R.id.txtSeat_five);
        }
    }


}
package com.app.smsipltest.app_ui;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.app.smsipltest.R;
import com.app.smsipltest.app_adapter.Adapter_Seats_Row;
import com.app.smsipltest.app_constants.AppAlert;
import com.app.smsipltest.app_constants.AppUtills;
import com.app.smsipltest.app_constants.ProgressView;
import com.app.smsipltest.app_network_call.NetworkCall;
import com.app.smsipltest.app_network_call.RequestNotifier;
import com.app.smsipltest.model.Resp_testAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Random;

public class SeatBook_Activity extends AppCompatActivity implements RequestNotifier {
    Adapter_Seats_Row adapter_seats_row;
    ArrayList<String> stringArrayList = new ArrayList<>();
    private String TAG = SeatBook_Activity.class.getSimpleName();
    private NetworkCall networkCall;
    private Random random = new Random();
    private String key, auth_key, password;
    private int randomNum;
    private ArrayList<Resp_testAPI.SeatMapEntity> resultEntityArrayList = new ArrayList<>();
    private LinearLayout mMainLay;
    private RecyclerView mRecyclerView;
    private LinearLayout mLayError;
    private TextView mTxtDataMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_book);

        networkCall = new NetworkCall(this, this);

        password = getIntent().getStringExtra("password");
        Log.d(TAG, "onCreate: password--->" + password);

        initView();

        callApis(password);


        //https://github.com/ManishAndroidIos/AndroidAssignMent.git
    }

    private void initView() {
        mMainLay = findViewById(R.id.main_lay);
        mRecyclerView = findViewById(R.id.RecyclerView);
        mLayError = findViewById(R.id.lay_error);
        mTxtDataMsg = findViewById(R.id.txt_data_msg);


        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter_seats_row = new Adapter_Seats_Row(this, stringArrayList);
        mRecyclerView.setAdapter(adapter_seats_row);
        adapter_seats_row.getList().clear();
    }


    private void callApis(String password) {
//        randomNum = random.nextInt(4 - 1 + 1);

        randomNum = AppUtills.getRandomInteger(4, 1);
        Log.d(TAG, "onCreate: MyRandOmNumber---->" + randomNum);
        switch (randomNum) {
            case 0:
                auth_key = "MD5";
                break;

            case 1:
                auth_key = "MD5";
                break;

            case 2:
                auth_key = "SHA-1";
                break;

            case 3:
                auth_key = "SHA-256";
                break;

            case 4:
                auth_key = "SHA-512";
                break;
        }


        key = AppUtills.encrypt(
                AppUtills.encrypt(
                        AppUtills.encrypt(password, "SHA-256"), "MD5"), auth_key);

        Log.d(TAG, "callApis: Key--->" + key);
        ProgressView.show(this);
        networkCall.testAPI(key, String.valueOf(randomNum), password);
    }

    @Override
    public void notifySuccess(JsonObject response) {

        Log.d(TAG, "notifySuccess: Response--->" + response);

        ProgressView.dismiss();
        if (response != null) {
            if (response.get("status").getAsInt() == 200) {
                JsonArray jsonArray = response.getAsJsonArray("seat_map");
                for (int i = 0; i < jsonArray.size(); i++) {
                    try {
                        JSONObject obj = new JSONObject(jsonArray.get(i).toString());

                        if (obj.has("SeatRow1")) {
                            stringArrayList.add(obj.getString("SeatRow1"));
                        } else if (obj.has("SeatRow2")) {
                            stringArrayList.add(obj.getString("SeatRow2"));
                        } else if (obj.has("SeatRow3")) {
                            stringArrayList.add(obj.getString("SeatRow3"));
                        } else if (obj.has("SeatRow3")) {
                            stringArrayList.add(obj.getString("SeatRow3"));
                        } else if (obj.has("SeatRow4")) {
                            stringArrayList.add(obj.getString("SeatRow4"));
                        } else if (obj.has("SeatRow5")) {
                            stringArrayList.add(obj.getString("SeatRow5"));
                        } else if (obj.has("SeatRow6")) {
                            stringArrayList.add(obj.getString("SeatRow6"));
                        } else if (obj.has("SeatRow7")) {
                            stringArrayList.add(obj.getString("SeatRow7"));
                        } else if (obj.has("SeatRow8")) {
                            stringArrayList.add(obj.getString("SeatRow8"));
                        } else if (obj.has("SeatRow10")) {
                            stringArrayList.add(obj.getString("SeatRow10"));
                        } else if (obj.has("SeatRow11")) {
                            stringArrayList.add(obj.getString("SeatRow11"));
                        } else if (obj.has("SeatRow12")) {
                            stringArrayList.add(obj.getString("SeatRow12"));
                        } else if (obj.has("SeatRow13")) {
                            stringArrayList.add(obj.getString("SeatRow13"));
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }

                mMainLay.setVisibility(View.VISIBLE);
                mLayError.setVisibility(View.GONE);
                adapter_seats_row.setList(stringArrayList);

                Log.d(TAG, "notifySuccess:stringArrayList--->" + stringArrayList);
            } else {
                mMainLay.setVisibility(View.GONE);
                mLayError.setVisibility(View.VISIBLE);
            }
        } else {
            mMainLay.setVisibility(View.GONE);
            mLayError.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public void notifyNoInternet() {
        ProgressView.dismiss();
        AppAlert._noInternetAlert(this);

    }

    @Override
    public void notifyError(Throwable throwable) {
        ProgressView.dismiss();
        AppAlert.callAlert(this, throwable.getMessage());
    }

    @Override
    public void notifyString(String s) {

    }


}
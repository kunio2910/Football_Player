package com.letran.football_player.views;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.letran.football_player.R;

public class MainActivity extends Base_Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.activity_main,null,false);
        constraintLayout.addView(contentView);
    }
}

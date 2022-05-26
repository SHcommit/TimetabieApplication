package project.timetable_recommend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Controller.bottomNavigationListenerInFirstActivity;

public class PreviousActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private FragmentManager fragmentManager;
    private PreviousFragment1 fragment1;
    private PreviousFragment2 fragment2;
    private PreviousFragment3 fragment3;
    private PreviousFragment4 fragment4;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_previous);
        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new bottomNavigationListenerInFirstActivity());
        fragment1 = new PreviousFragment1();
        fragment2 = new PreviousFragment2();
        fragment3 = new PreviousFragment3();
        fragment4 = new PreviousFragment4();
        transaction = fragmentManager.beginTransaction();
    }
    public void clickHandler(View view)
    {
        transaction = fragmentManager.beginTransaction();
        switch(view.getId())
        {
            case R.id.button:
                transaction.replace(R.id.frameLayout, fragment1).commitAllowingStateLoss();
                break;
            case R.id.button2:
                transaction.replace(R.id.frameLayout, fragment2).commitAllowingStateLoss();
                break;
            case R.id.button3:
                transaction.replace(R.id.frameLayout, fragment3).commitAllowingStateLoss();
                break;
            case R.id.button4:
                transaction.replace(R.id.frameLayout, fragment4).commitAllowingStateLoss();
        }
    }
}}
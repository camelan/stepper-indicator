package com.badoualy.stepperindicator.sample;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.badoualy.stepperindicator.StepperIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ViewPager pager = findViewById(R.id.pager);
        assert pager != null;
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        final StepperIndicator indicator = findViewById(R.id.stepper_indicator);
        // We keep last page for a "finishing" page
        indicator.setViewPager(pager, true);

        indicator.addOnStepClickListener(new StepperIndicator.OnStepClickListener() {
            @Override
            public void onStepClicked(int step) {
                pager.setCurrentItem(step, true);
            }
        });
    }

}

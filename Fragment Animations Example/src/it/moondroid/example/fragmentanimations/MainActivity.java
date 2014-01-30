
package it.moondroid.example.fragmentanimations;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.View;

import it.moondroid.example.fragmentanimations.HomeFragment.OnActionListener;

public class MainActivity extends FragmentActivity implements OnActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager
                    .beginTransaction();

            // add a fragment
            HomeFragment fragment = new HomeFragment();
            fragmentTransaction.add(R.id.content, fragment);
            fragmentTransaction.commit();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onButtonClick(View v) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction ft = fragmentManager
                .beginTransaction();

        ft.setCustomAnimations(R.anim.pull_in_from_right, R.anim.pull_out_to_left, R.anim.pull_in_from_left, R.anim.pull_out_to_right);

        // replace fragment
        Fragment newFragment = new SecondaryFragment();

        ft.replace(R.id.content, newFragment);

        ft.addToBackStack(null);
        ft.commit();

    }

}

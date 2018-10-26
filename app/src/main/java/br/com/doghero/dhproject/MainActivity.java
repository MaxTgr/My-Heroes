package br.com.doghero.dhproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.doghero.dhproject.fragments.HeroFragment;
import br.com.doghero.dhproject.fragments.blank.BlankFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_search:
                    fragment = new BlankFragment(); // TODO: implement search activity
                    break;

                case R.id.navigation_messages:
                    fragment = new BlankFragment(); // TODO: implement messages activity
                    break;

                case R.id.navigation_heroes:
                    fragment = new HeroFragment();
                    break;

                case R.id.navigation_reservations:
                    fragment = new BlankFragment(); // TODO: implement reservation activity
                    break;

                case R.id.navigation_profile:
                    fragment = new BlankFragment(); // TODO: implement profile activity
                    break;
            }
            return load(fragment);
        }
    };

    private boolean load(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_heroes); // the default item selected will be heroes

        load(new HeroFragment()); // loading the default view
    }

}

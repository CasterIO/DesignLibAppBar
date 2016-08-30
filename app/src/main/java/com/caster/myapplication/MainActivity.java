package com.caster.myapplication;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Activity Title");

        setCustomView(toolbar);
    }

    private void setCustomView(Toolbar toolbar) {
        View customView = getLayoutInflater().inflate(R.layout.view_toolbar, null);
        toolbar.addView(customView);

        ImageView happyFace = (ImageView) customView.findViewById(R.id.toolbar_image);
        happyFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeImage();
            }
        });
    }

    private void changeImage() {
        ImageView backdropIV = (ImageView) findViewById(R.id.backdrop);

        backdropIV.setImageResource(R.drawable.hero_statues);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CoordinatorLayout cl = (CoordinatorLayout) findViewById(R.id.main_content);
        switch (item.getItemId()) {
            case R.id.action_heart:
                Snackbar snackbar = Snackbar.make(cl, "HEART HEART HEART HEART", Snackbar.LENGTH_SHORT);
                snackbar.show();
                return true;
            case R.id.action_star:
                Snackbar snackbar1 = Snackbar.make(cl, "STAR STAR STAR STAR", Snackbar.LENGTH_SHORT);
                snackbar1.show();
                return true;
            case R.id.action_joystick:
                Snackbar snackbar2 = Snackbar.make(cl, "JOYSTICK JOYSTICK JOYSTICK", Snackbar.LENGTH_SHORT);
                snackbar2.show();
                return true;
        }
        return true;
    }

    private void showCustomTitleAndSubtitle() {
        getSupportActionBar().setTitle( "Custom Title");
        getSupportActionBar().setSubtitle( "subtitle" );
        getSupportActionBar().setDisplayShowTitleEnabled( true );
    }

    private void hideTitleAndSubtitle() {
        getSupportActionBar().setDisplayShowTitleEnabled( false );
    }

    private void showDefaultLogo() {
        getSupportActionBar().setLogo( R.drawable.ic_action_joystick);
        getSupportActionBar().setDisplayUseLogoEnabled( true );
    }

    private void hideLogo() {
        getSupportActionBar().setDisplayUseLogoEnabled( false );
    }

}

package com.example.dongja94.sampleslidingmenu;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity implements MenuFragment.OnMenuItemSelectListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBehindContentView(R.layout.menu_layout);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.menu_container, new MenuFragment())
                    .commit();
        }

        SlidingMenu menu = getSlidingMenu();
        menu.setBehindWidthRes(R.dimen.behind_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        ActionBar action = getSupportActionBar();
        action.setDisplayHomeAsUpEnabled(true);
        action.setHomeAsUpIndicator(R.drawable.ic_drawer);
    }

    @Override
    public void onMenuItemSelected(int menuId) {
        switch (menuId) {
            case MenuFragment.MENU_MAIN :
            {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new MainFragment())
                        .commit();
                break;
            }
            case MenuFragment.MENU_FIRST :
            {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new FirstFragment())
                        .commit();
                break;
            }
            case MenuFragment.MENU_SECOND :
            {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, new SecondFragment())
                        .commit();
                break;
            }
        }
        showContent();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            toggle();
        }
        return super.onOptionsItemSelected(item);
    }
}

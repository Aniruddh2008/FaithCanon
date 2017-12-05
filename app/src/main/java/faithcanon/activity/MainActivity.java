package faithcanon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.faithcanon.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import faithcanon.fragement.FriendListView;
import faithcanon.fragement.NotificationView;
import faithcanon.fragement.PostView;
import faithcanon.fragement.ProfileView;
import faithcanon.fragement.SettingView;
import faithcanon.utils.Fragments;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.view_post)
    ImageView viewPost;
    @BindView(R.id.frd_list)
    ImageView frdList;
    @BindView(R.id.notification)
    ImageView notification;
    @BindView(R.id.serach_record)
    ImageView serachRecord;
    @BindView(R.id.top_layout)
    LinearLayout topLayout;
    @BindView(R.id.search_layout)
    LinearLayout searchLayout;
    ActionBarDrawerToggle mDrawerToggle;
    @BindView(R.id.feedback)
    TextView feedback;
    private boolean mToolBarNavigationListenerIsRegistered = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initViews();


    }

    @Override
    protected int myView() {
        return R.layout.activity_main;
    }

    private void initViews() {
        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        viewPost.setOnClickListener(this);
        frdList.setOnClickListener(this);
        notification.setOnClickListener(this);
        serachRecord.setOnClickListener(this);

        PostView mPostView = new PostView();
        addFragementView(mPostView);
    }

    public void addFragementView(Fragment fragment) {
        replaceFragment(R.id.container, fragment, fragment.getClass().getName(), fragment.getClass().getName());
    }

    public void hideShowTopLayout(boolean isHide) {
        if (isHide) {
            topLayout.setVisibility(View.GONE);
            searchLayout.setVisibility(View.GONE);
        } else {
            topLayout.setVisibility(View.VISIBLE);
            searchLayout.setVisibility(View.VISIBLE);
        }
    }

    public void hideShowFeedback(boolean isHide) {
        if (isHide) {
            feedback.setVisibility(View.VISIBLE);
        } else {
            feedback.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void enableViews(boolean enable) {

        // To keep states of ActionBar and ActionBarDrawerToggle synchronized,
        // when you enable on one, you disable on the other.
        // And as you may notice, the order for this operation is disable first, then enable - VERY VERY IMPORTANT.
        if (enable) {
            // Remove hamburger
            mDrawerToggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            // when DrawerToggle is disabled i.e. setDrawerIndicatorEnabled(false), navigation icon
            // clicks are disabled i.e. the UP button will not work.
            // We need to add a listener, as in below, so DrawerToggle will forward
            // click events to this listener.
            if (!mToolBarNavigationListenerIsRegistered) {
                mDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Doesn't have to be onBackPressed
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            mDrawerToggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.logout) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.profile) {
            ProfileView profileView = new ProfileView();
            addFragementView(profileView);
        }
        else if (id == R.id.setting) {
            SettingView mSettingView = new SettingView();
            addFragementView(mSettingView);
        }
        /*else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.view_post:
                PostView mPostView = new PostView();
                addFragementView(mPostView);
                break;
            case R.id.frd_list:
                FriendListView mFriendListView = new FriendListView();
                addFragementView(mFriendListView);
                break;
            case R.id.notification:
                NotificationView mNotificationView = new NotificationView();
                addFragementView(mNotificationView);
                break;
        }
    }

    @Override
    public void onInteraction(Fragments fragments, View v, Bundle bundle) {

    }

    @Override
    public void headerTitleUpdate(String title) {

    }

    @Override
    public void updateHeaderForSearch() {

    }

    @Override
    public void resetHeader() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void dismissProgressBar() {

    }

    @Override
    public void openSearchKeyboard() {

    }

    @Override
    public void hideShowSaveDraftButton(boolean isDraft) {

    }
}

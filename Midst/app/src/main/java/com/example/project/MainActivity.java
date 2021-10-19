package com.example.project;

import android.os.Bundle;
import android.widget.Toast;
import com.example.project.ui.home.HomeFragment;
import com.example.project.ui.home.faculty;
import com.example.project.ui.home.miscellaneous;
import com.example.project.ui.home.parent;
import com.example.project.ui.home.student;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);

        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_home, R.id.nav_parent,
                R.id.nav_student, R.id.nav_faculty, R.id.nav_miscellaneous).setDrawerLayout(drawer).build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        navController.addOnDestinationChangedListener(
                new NavController.OnDestinationChangedListener() {
                @Override
                public void onDestinationChanged(@NonNull NavController controller,
                                                 @NonNull NavDestination destination,
                                                 @Nullable Bundle arguments) {
                    int fragmentId = destination.getId();

                    switch(fragmentId) {
                        case R.id.nav_parent:
                            FragmentTransaction parent_fragmentTransaction = getSupportFragmentManager().
                                    beginTransaction();
                            parent_fragmentTransaction.replace(R.id.nav_host_fragment, new parent());
                            break;
                        case R.id.nav_faculty:
                            FragmentTransaction faculty_fragmentTransaction = getSupportFragmentManager().
                                    beginTransaction();
                            faculty_fragmentTransaction.
                                    replace(R.id.nav_host_fragment, new faculty());
                            break;
                        case R.id.nav_student:
                            FragmentTransaction student_fragmentTransaction = getSupportFragmentManager().
                                    beginTransaction();
                            student_fragmentTransaction.replace(R.id.nav_host_fragment, new student());
                            break;
                        case R.id.nav_miscellaneous:
                            FragmentTransaction mis_fragmentTransaction = getSupportFragmentManager().
                                    beginTransaction();
                            mis_fragmentTransaction.replace(R.id.nav_host_fragment, new miscellaneous());
                            break;
                      case R.id.nav_home:
                            FragmentTransaction home_fragmentTransaction = getSupportFragmentManager().
                                    beginTransaction();
                            home_fragmentTransaction.
                                    replace(R.id.nav_host_fragment, new HomeFragment());
                            break;
                      default:
                            Toast.makeText(MainActivity.this,
                                    "No such activity", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }
            });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
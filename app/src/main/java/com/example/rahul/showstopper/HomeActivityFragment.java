package com.example.rahul.showstopper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class HomeActivityFragment extends Fragment {

    AlertDialog levelDialog;
    private int choice = -1;

    public HomeActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_home, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Returns the id of the item clicked in the menu
        int id = item.getItemId();


        if (id == R.id.action_sort_by) {
            // Strings to Show In Dialog with Radio Buttons
            final CharSequence[] items = {"Most Popular", "Highest Rating", "Favorites"};


            // Creating and Building the Dialog
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Sort By");

            builder.setSingleChoiceItems(items, choice, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int item) {

                    switch (item) {
                        case 0:
                            Log.e("ABC", "Most Popular");
                            //Display Popular Movies
                            break;
                        case 1:
                            Log.e("ABC", "Highest Rating");
                            break;
                        case 2:
                            Log.e("ABC", "Favorites");
                            break;
                    }
                    levelDialog.dismiss();

                }
            });

            levelDialog = builder.create();
            levelDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

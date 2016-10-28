package com.menulaterala.central.loadimagesasync;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.menulaterala.central.loadimagesasync.R;




public class MainActivity extends Activity implements OnItemClickListener {

    private ListView mListViewItems;
    private CustomAdapter mAdapter;
    private List<ModelCategory> mListCategories = new ArrayList<ModelCategory>();
    private String[] mUrls = {};
    private Random mRandom = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getViews();
        init();
    }

    private void getViews() {

        mListViewItems = (ListView) findViewById(R.id.listView__activity_main_items);
    }

    private void init() {

        mUrls = getResources().getStringArray(R.array.urls);

        mListViewItems.setOnItemClickListener(this);

        for(int i = 0; i < 50; i++) {

            mListCategories.add(new ModelCategory("Item " + i, mUrls[mRandom.nextInt(mUrls.length - 1)]));
        }

        mAdapter = new CustomAdapter(MainActivity.this, mListCategories);
        mListViewItems.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:

                mListCategories.add(new ModelCategory("Object added", mUrls[mRandom
                        .nextInt(mUrls.length - 1)]));
                break;
            case R.id.action_remove:

                if (mListCategories.size() > 0)
                    mListCategories.remove(mListCategories.size() - 1);
                break;
            case R.id.action_reset:

                mListCategories = new ArrayList<ModelCategory>();
                break;

            default:
                break;
        }

        mAdapter.setDataset(mListCategories);
        mAdapter.notifyDataSetChanged();

        return false;
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {

        Toast.makeText(MainActivity.this, mListCategories.get(position).getTitle(), Toast.LENGTH_SHORT).show();
    }

}

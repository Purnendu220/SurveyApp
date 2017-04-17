package com.survey;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SurveyDetail extends AppCompatActivity {

    private RecyclerView mRVJobListing;
    private JobListingAdapter mJobListAdapter;
    private List<CollectionPageTableModel> mlist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_detail);
        mRVJobListing = (RecyclerView) findViewById(R.id.jobListingRV);
        CollectionPageTableDao collectionPageTableDao=new CollectionPageTableDao(DatabaseHelper.getDatabase());
        mlist= collectionPageTableDao.getList();
        setJobListAdapter(mlist);

    }
    private void setJobListAdapter(List<CollectionPageTableModel> list) {

        mJobListAdapter = new JobListingAdapter(SurveyDetail.this, list);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRVJobListing.setLayoutManager(layoutManager);
        mRVJobListing.setAdapter(mJobListAdapter);

    }
}

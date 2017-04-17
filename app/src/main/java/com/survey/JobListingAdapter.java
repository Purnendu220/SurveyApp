package com.survey;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by purnendu on 22-02-2017.
 */

public class JobListingAdapter extends RecyclerView.Adapter<JobListingAdapter.ViewHolder> {


    private Context mContext;
    private List<CollectionPageTableModel> mList;

    public JobListingAdapter(Context context, List<CollectionPageTableModel> list) {
        this.mContext = context;
        this.mList = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_joblisting_row, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return new JobListingAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTxtNickName.setText(Constants.FAMILY_NUMBER+":-"+mList.get(position).getFamily_no());
        holder.mTxtPostedDate.setText(Constants.FAMILY_COUNT+":-"+mList.get(position).getFamily_member_count());
        holder.mTxtJobTiming.setText(Constants.FAMILY_MEMBER+":-\n"+mList.get(position).getFamily_members_detail());
        holder.mTxtCompentationTV.setText(Constants.FAMILY_DATE+":-\n"+mList.get(position).getFamily_date());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        TextView mTxtNickName = (TextView) itemView.findViewById(R.id.nickNameHintTV);
        TextView mTxtPostedDate = (TextView) itemView.findViewById(R.id.text_posted_date);
        TextView mTxtJobTiming = (TextView) itemView.findViewById(R.id.jobTimingTV);
        TextView mTxtCompentationTV = (TextView) itemView.findViewById(R.id.compentationTV);
    }

}

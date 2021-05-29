package com.example.praveshaadhaar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolderClass> {
    List<FetchData> fetchDataList;

    public RecordAdapter(List<FetchData>fetchData){
        this.fetchDataList = fetchData;
    }
    @NonNull
    @Override
    public RecordAdapter.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.record_row,parent,false);
        RecordAdapter.ViewHolderClass viewHolderClass = new RecordAdapter.ViewHolderClass(view);
        return viewHolderClass;
    }

    @Override
    public void onBindViewHolder(@NonNull RecordAdapter.ViewHolderClass holder, int position) {
        RecordAdapter.ViewHolderClass viewHolderClass = (RecordAdapter.ViewHolderClass)holder;
        FetchData fetchData = fetchDataList.get(position);
        viewHolderClass.nomask.setText("No Mask : "+fetchData.getNoMask());
        viewHolderClass.mask.setText("With Mask : "+fetchData.getMask());
        viewHolderClass.camno.setText("Camera : "+fetchData.getCamNo() );
    }
    @Override
    public int getItemCount() {
        return fetchDataList.size();
    }
    public class ViewHolderClass extends RecyclerView.ViewHolder{
        TextView nomask,mask,camno;

        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);
            nomask = itemView.findViewById(R.id.tv_nomask);
            mask = itemView.findViewById(R.id.tv_mask);
            camno = itemView.findViewById(R.id.tv_camno);

        }
    }
}

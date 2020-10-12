package com.tgsbesar.myapplication.menu_rawatJalan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.tgsbesar.myapplication.R;
import com.tgsbesar.myapplication.databinding.ActivityListDoctorBinding;

import java.util.ArrayList;
import java.util.List;


public class DokterAdapter extends RecyclerView.Adapter<DokterAdapter.MyViewHolder>{
    private Context context;
    private List<Dokter> result = new ArrayList<>();
    private ActivityListDoctorBinding activityListDoctorBinding;


    public DokterAdapter(Context context, List<Dokter> result){
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        activityListDoctorBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.activity_list_doctor,parent,false);
        return new MyViewHolder(activityListDoctorBinding);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Dokter dtr = result.get(position);
        holder.bind(dtr);
        holder.cv_doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),Input.class);
                intent.putExtra("Dokter",dtr);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageButton buttonNext;
        private CardView cv_doctor;
        private final ActivityListDoctorBinding itemView;

        public MyViewHolder(@NonNull ActivityListDoctorBinding itemView) {
            super(itemView.getRoot());
            this.itemView = itemView;
            cv_doctor = (CardView) itemView.cardDoctor;

        }

        public void bind(Dokter dtr){
            itemView.setDtr(dtr);
        }
    }
}
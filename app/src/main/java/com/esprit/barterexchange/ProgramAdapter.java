package com.esprit.barterexchange;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProgramAdapter extends RecyclerView.Adapter<ProgramAdapter.ViewHolder> {

    Context context;
    String[] name, description, location;
    int[] img;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.single_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.fullName.setText(name[position]);
        holder.description.setText(description[position]);
        holder.location.setText(location[position]);
        holder.img.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return name.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView fullName, location, description;
        ImageView img;

        public ViewHolder(View itemView){
            super(itemView);
            fullName = itemView.findViewById(R.id.full_name);
            location = itemView.findViewById(R.id.location);
            description = itemView.findViewById(R.id.description);
            img = itemView.findViewById(R.id.prfile_pic);
        }

    }

    public ProgramAdapter(Context context, String[] fullName, String[] desc, String[] location,  int[] img){
        this.context = context;
        this.name = fullName;
        this.description=desc;
        this.location = location;

        this.img = img;
    }


}

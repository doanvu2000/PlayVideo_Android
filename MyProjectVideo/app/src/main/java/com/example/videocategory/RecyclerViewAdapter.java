package com.example.videocategory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<VideoObject> videoObjectList;
    Context context;

    public RecyclerViewAdapter(List<VideoObject> videoObjectList, Context context) {
        this.videoObjectList = videoObjectList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from( parent.getContext() );
        View view = inflater.inflate( R.layout.item_layout, parent, false );
        ViewHolder viewHolder = new ViewHolder( view );
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        {
//            holder.tv1.setText( String.valueOf( "ID: "+videoObjectList.get( position ).getId() ) );

//            holder.tv2.setText( String.valueOf( videoObjectList.get( position ).getPublisher_id() ) );
//            holder.tv3.setText( String.valueOf( videoObjectList.get( position ).getContent_type() ) );
//            holder.tv4.setText( String.valueOf( videoObjectList.get( position ).getTab() ) );
            holder.tv5.setText( videoObjectList.get( position ).getTitle() );
//            holder.tv6.setText( videoObjectList.get( position ).getAvatar() );
//            holder.tv7.setText( String.valueOf( videoObjectList.get( position ).getStatus() ) );
//            holder.tv8.setText( String.valueOf( videoObjectList.get( position ).getDeleted() ) );
//            holder.tv9.setText( String.valueOf( videoObjectList.get( position ).getUser_created() ) );
//            holder.tv10.setText( String.valueOf( videoObjectList.get( position ).getUser_modified() ) );
//            holder.tv11.setText( videoObjectList.get( position ).getDate_created() );
            holder.tv11.setVisibility( View.GONE );
//            holder.tv12.setText( videoObjectList.get( position ).getDate_modified() );
//            holder.tv13.setText( String.valueOf( videoObjectList.get( position ).getParent_id() ) );
//            holder.tv14.setText( String.valueOf( videoObjectList.get( position ).getLft() ) );
//            holder.tv15.setText( String.valueOf( videoObjectList.get( position ).getRgt() ) );
//            holder.tv16.setText( String.valueOf( videoObjectList.get( position ).getLevel() ) );
//            holder.tv17.setText( videoObjectList.get( position ).getShort_code() );
//            holder.tv18.setText( videoObjectList.get( position ).getCommand_code() );
//            holder.tv19.setText( String.valueOf( videoObjectList.get( position ).getPrice() ) );
//            holder.tv20.setText( videoObjectList.get( position ).getFinished_message() );
//            holder.tv21.setText( videoObjectList.get( position ).getHelp_message() );
//            holder.tv22.setText( String.valueOf( videoObjectList.get( position ).getIcash() ) );
            Glide.with( context ).load( videoObjectList.get( position ).getThumb() ).into( holder.tv23 );
        }
    }

    @Override
    public int getItemCount() {
        return videoObjectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv1, tv5, tv11;
        ImageView tv23;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );
            {
//                tv1 = itemView.findViewById( R.id.tvID );
                tv5 = itemView.findViewById( R.id.tvTitle );
                tv11 = itemView.findViewById( R.id.tv11 );
                tv23 = itemView.findViewById( R.id.img_video );
            }
        }
    }
}

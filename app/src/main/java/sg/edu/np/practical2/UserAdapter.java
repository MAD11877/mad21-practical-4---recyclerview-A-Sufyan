package sg.edu.np.practical2;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    ArrayList<User> data;
    private UserAdapter.RecyclerViewClickListener listener;

    public UserAdapter(ArrayList<User> input, RecyclerViewClickListener listener) {
        this.data = input;
        this.listener = listener;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView desc;
        ImageView image;

        public UserViewHolder (View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameView);
            desc = itemView.findViewById(R.id.descView);
            image = itemView.findViewById(R.id.userImage);
            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onClick(v, getAdapterPosition());
        }
    }

    /*@Override
    public int getItemViewType(int position) {
        if (data.get(position).randomNumber % 10 == 7) {
            return 1;
        }
        else {
            return 0;
        }
    }*/

    //@NonNull
    //@Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        item = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.recyclerview_user, parent, false);
        return new UserViewHolder(item);
    }

    //@Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User list_items = data.get(position);
        /*if (data.get(position).randomNumber % 10 == 7) {
            ViewHolder2 viewholder2 = (ViewHolder2) holder;
            viewholder2.lastSeven.setImageResource(R.drawable.android_logo);
        }
        UserAdapter.ViewHolder1 viewholder1 = (UserAdapter.ViewHolder1) holder;
        viewholder1.name.setText(list_items.getName());
        viewholder1.desc.setText(list_items.getDescription());*/

        holder.name.setText(list_items.getName());
        holder.desc.setText(list_items.getDescription());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface RecyclerViewClickListener {
        void onClick(View v, int position);
    }
    /*
    class ViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView name;
        TextView desc;
        ImageView image;
        public ViewHolder1(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameView);
            desc = itemView.findViewById(R.id.descView);
            image = itemView.findViewById(R.id.userImage);
            image.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }
    class ViewHolder2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView lastSeven;
        public ViewHolder2(View itemView) {
            super(itemView);
            lastSeven = itemView.findViewById(R.id.ifLastDigit7);
        }
        @Override
        public void onClick(View v) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

     */
}

package com.example.harrypotterlegend;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;

/*
Cette classe correspond au Modèle dans le modèle MVC: elle gère la logique
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Character> values;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView nameCharacter;
        public TextView speciesCharacter;
        public ImageView image;
        public View layout;


public ViewHolder(View v) {
        super(v);
        layout = v;
        nameCharacter = (TextView) v.findViewById(R.id.name);
        speciesCharacter = (TextView) v.findViewById(R.id.species);
       // image = (ImageView)v.findViewById(R.id.image);
        }
        }

public void add(int position, Character item) {
        values.add(position, item);
        notifyItemInserted(position);
        }

public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
        }

// Provide a suitable constructor (depends on the kind of dataset)
public MyAdapter(List<Character> myDataset) {
        values = myDataset;
        }

// Create new views (invoked by the layout manager)
@Override
public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
        int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
        parent.getContext());
        View v =
        inflater.inflate(R.layout.row_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
        }

// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
// - get element from your dataset at this position
// - replace the contents of the view with that element
final Character character = values.get(position);
        holder.nameCharacter.setText(character.name);
       //Glide.with(this).asBitmap().load(character.image).into(holder.image);
        holder.nameCharacter.setOnClickListener((v) ->{

            Intent intent = new Intent(v.getContext(),SecondActivity.class);
            intent.putExtra("name", character.getName());
            intent.putExtra("species", character.getSpecies());
            intent.putExtra("gender", character.getGender());
            intent.putExtra("house", character.getHouse());
            v.getContext().startActivity(intent);
            notifyDataSetChanged();
/*@Override
public void onClick(View v) {
       // remove(position);
    Intent intent = new Intent(v.getContext(),SecondActivity.class);
    intent.putExtra("name", character.getName());
    v.getContext().startActivity(intent);
        }*/
        });
        holder.layout.setOnClickListener((v)->{
            Intent intent = new Intent(v.getContext(),SecondActivity.class);
            intent.putExtra("name", character.getName());
            intent.putExtra("species", character.getSpecies());
            intent.putExtra("gender", character.getGender());
            intent.putExtra("house", character.getHouse());

            v.getContext().startActivity(intent);
            notifyDataSetChanged();
        });

        holder.speciesCharacter.setText( character.species);
        }

// Return the size of your dataset (invoked by the layout manager)
@Override
public int getItemCount() {
        return values.size();
        }

        }
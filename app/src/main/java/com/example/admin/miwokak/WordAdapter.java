package com.example.admin.miwokak;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link WordAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Word}
 */

public class WordAdapter extends ArrayAdapter<Word> {
    /** Resource Id for the background color for this list of words */
    private int mColorResourceId;
    /**
     * Creat a new {@link WordAdapter} object.
     * @param context is the current context (i.e Activity) that the adapter is being created item
     * @param words is the list of {@link Word}s to be displayed.
     */

    public WordAdapter(Activity context, ArrayList<Word> words, int ColorResourceId) {

        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);
        mColorResourceId = ColorResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwokak_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokak_text_view);
        // Get the Miwok translation from the current the currentWord object and
        // set this text on the Miwok TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the default translation from the currentWord object and
        // set this text on the default TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current Word object and
        // set the image to ImageView

        if(currentWord.hasImage()) {
            // Set the ImageView to the image of the resource specified in the current Word
            imageView.setImageResource(currentWord.getImageResourceId());


            //Make sure that view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            // otherwise hide the image view (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // set the color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container view
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}

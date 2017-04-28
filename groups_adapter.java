package mad.listv;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by root on 28/03/17.
 */

public class groups_adapter extends ArrayAdapter<groups> {
    Context context;
    int layoutResourceId;
    groups data[] = null;

    //Constructor
    public groups_adapter(Context context, int layoutResourceId, groups[] data){
        super(context, layoutResourceId, data);

        this.context = context;
        this.layoutResourceId = layoutResourceId;
        this.data = data;
    }

    // Create the view
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        groups_holder holder = null;

        if (row == null){
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new groups_holder();
            holder.image = (ImageView) row.findViewById(R.id.ima1);
            holder.text = (TextView) row.findViewById(R.id.text1);
            holder.textnot = (TextView) row.findViewById(R.id.text2);
            row.setTag(holder);
        }else{
            holder = (groups_holder)row.getTag();
        }

        groups pos_gro = data[position];
        holder.text.setText(pos_gro.title);
        holder.textnot.setText(pos_gro.noti);
        holder.image.setImageResource(pos_gro.icon);



        //In order to return the view
        return row;
    }

    //Keep the data ir order to be alble to work with them
    static class groups_holder{
        ImageView image;
        TextView text;
        TextView textnot;


    }

}

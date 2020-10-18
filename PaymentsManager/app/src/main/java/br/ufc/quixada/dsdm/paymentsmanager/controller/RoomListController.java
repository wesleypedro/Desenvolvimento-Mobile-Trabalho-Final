package br.ufc.quixada.dsdm.paymentsmanager.controller;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dsdm.paymentsmanager.R;
import br.ufc.quixada.dsdm.paymentsmanager.model.Room;

public class RoomListController extends ArrayAdapter<String> {

//    private String[] names;
//    private String[] desc;
////    private Integer[] imageid;
//    private Integer imageid;
//    private Activity context;

    private List<Room> rooms;
    private Integer imageId;
    private Activity context;
    private List<String> names;

//    public RoomListController(Activity context, String[] names, String[] desc, Integer imageid) {
//        super(context, R.layout.activity_room_list, names);
//        this.context = context;
//        this.names = names;
//        this.desc = desc;
//        this.imageid = imageid;
//    }

    public RoomListController(Activity context, List<Room> rooms, Integer imageId, List<String> names){
        super(context, R.layout.activity_room_list, names);
        this.context = context;
        this.rooms = rooms;
        this.imageId = imageId;
        this.names = names;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.activity_room_list, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.RoomListTextViewName);
        TextView textViewDescription = (TextView) listViewItem.findViewById(R.id.RoomListTextViewDescription);
        ImageView image = (ImageView) listViewItem.findViewById(R.id.imageView);

//        textViewName.setText(names[position]);
//        textViewDescription.setText(desc[position]);
//        image.setImageResource(imageid);
        textViewName.setText(rooms.get(position).getName());
        textViewDescription.setText(rooms.get(position).getDescription());
        image.setImageResource(imageId);
        return  listViewItem;
    }

}

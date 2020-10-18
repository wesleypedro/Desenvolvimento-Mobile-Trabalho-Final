package br.ufc.quixada.dsdm.paymentsmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufc.quixada.dsdm.paymentsmanager.controller.RoomListController;
import br.ufc.quixada.dsdm.paymentsmanager.model.Room;
import br.ufc.quixada.dsdm.paymentsmanager.static_local_informations.StaticInformations;

public class RoomsActivity extends AppCompatActivity {

    StaticInformations staticInformations = new StaticInformations();

    ListView list;
    List<Room> rooms;
    Integer imageId;
//    ArrayAdapter<CustomAdapter> a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);

        list = findViewById(R.id.roomListview);

        rooms = staticInformations.getRooms();
        imageId = staticInformations.getImage();

//        RoomListController customList = new RoomListController(this, names, desc, imageid);

        List<String> names = new ArrayList<>();

        for (Room room : rooms) {
            names.add(room.getName());
        }

        RoomListController roomList = new RoomListController(this, rooms, imageId, names);

        list = (ListView) findViewById(R.id.roomListview);
        list.setAdapter(roomList);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),"You Clicked "+rooms.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }


//    class CustomAdapter extends BaseAdapter {
//
//        @Override
//        public int getCount() {
//            return rooms.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int i, View view, ViewGroup viewGroup) {
//            return null;
//        }
//    }
}

package br.ufc.quixada.dsdm.paymentsmanager.static_local_informations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ufc.quixada.dsdm.paymentsmanager.R;
import br.ufc.quixada.dsdm.paymentsmanager.model.Card;
import br.ufc.quixada.dsdm.paymentsmanager.model.Photo;
import br.ufc.quixada.dsdm.paymentsmanager.model.Room;
import br.ufc.quixada.dsdm.paymentsmanager.model.User;

public class StaticInformations {
    List<User> users = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    List<Card> cards = new ArrayList<>();
    Integer image;


    public StaticInformations() {
        User u1 = new User(1, new Photo(1, "Foto_user_1"), "User 1", "e1@mail", "pass");
        User u2 = new User(2, new Photo(2, "Foto_user_2"), "User 2", "e2@mail", "pass");
        User u3 = new User(3, new Photo(3, "Foto_user_3"), "User 3", "e3@mail", "pass");
        User u4 = new User(4, new Photo(4, "Foto_user_4"), "User 4", "e4@mail", "pass");
        User u5 = new User(5, new Photo(5, "Foto_user_5"), "User 5", "e5@mail", "pass");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        users.add(u5);

        Room room1 = new Room(1, "Room 1", new Photo(6, "Foto 6"), "Descricao 1", users);
        Room room2 = new Room(2, "Room 2", new Photo(7, "Foto 7"), "Descricao 2", users);
        rooms.add(room1);
        rooms.add(room2);

        Card card = new Card(1, "Card 1", "Desc 1", new Photo(7, "Foto 7"), new Date(), 250);
        cards.add(card);

        image = R.drawable.icon_user;
    }

    public List<Card> getCards(){
        return cards;
    }

    public List<Room> getRooms(){
        return rooms;
    }

    public Integer getImage() {
        return image;
    }
}

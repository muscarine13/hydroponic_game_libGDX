package com.acidcarpet.hydroponist.player;

import com.acidcarpet.hydroponist.equipment.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Room {
    private static Room instance;
    public static Room getInstance(){
        if(instance==null) instance = new Room();
        return instance;
    }

    private List<Box> boxes_in_grow_room;

    private Box current_box;
    public synchronized void select_box(int index){

        boxes_in_grow_room.add(current_box);

        Box temp = current_box;
        current_box = boxes_in_grow_room.remove(index);
    }
    public Box get_current_box(){
        return current_box;
    }

//    Room(){
//        boxes_in_grow_room = new ArrayList<>();
//        create_new_box(
//                "Гроубокс новичка",
//                "Самый простецкий гроубокс ос стандартным оборудованем. Используется тестерами для получения тестового урожая.",
//                22,
//                new NoviceLamp(),
//                new NoviceFan(),
//                new NovicePot(),
//                new NoviceCompressor()
//        );
//    }

    public synchronized void add_new_box(Box box){
        try{
            boxes_in_grow_room.add(box);
        }catch (Exception e){

        }
    }
    public synchronized void create_new_box(
            String name,
            String description,
            double ordinary_t,

            Lamp lamp,
            Fan fan,
            Pot pot,
            Compressor compressor
    ){
        try{
            boxes_in_grow_room.add(new Box(
                    name,
                    description,
                    ordinary_t,

                    lamp,
                    fan,
                    pot,
                    compressor
            ));
        }catch (Exception e){

        }
    }
    public synchronized void remove_box(Box box){

        try{
            boxes_in_grow_room.remove(box);
        }catch (Exception e){

        }
    }
    public synchronized List<Box> get_all_boxes(){
        return boxes_in_grow_room;
    }

}

package com.company;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


import java.io.*;

import java.util.ArrayList;

import java.util.Collections;


public class Main {

    public static void main(String[] args) {
        AdIn input =new AdIn();
        System.out.println("to do list time");
        int choice;
        Gson gson=new Gson();
        JsonParser parser= new JsonParser();


FileReader reader=null;
        try {
            reader=new FileReader("save.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ArrayList<Task> theList=new ArrayList<>();

        JsonDecipherer json=gson.fromJson(reader, JsonDecipherer.class);
        for (int i = 0; i < json.getTasks().length; i++) {
            theList.add(json.getTasks()[i]);

        }
        do {

            choice=(input.promptInt("pick time! choos e nuber for action\n" +
                    "1: add task\n"+
                    "2: remove task\n" +
                    "3:update task\n" +
                    "4:list all task\n" +
                    "5: sort tasks by priority and then name\n"+
                    "0: exit\nChoice:", 5));
            switch(choice)
            {
                case 1:
                    theList=addTask(input, theList);
                    break;
                case 2:
                    if (theList.size()!=0) {
                        theList = removeTask(input, theList);
                    }else System.out.println("bruh what you gon remove there aint none here");

                    break;
                case 3:
                    if (theList.size()!=0) {
                        theList=updateTask(input, theList);
                    }else System.out.println("bruh what you gon update there aint none here");
                    break;
                case 4:

                    sendList(input, theList);
                    break;
                case 5:
                    System.out.println("the list got sorted!");
                    Collections.sort(theList);
                    break;
                case 0:
                    System.out.println("*saves ur file uwu*");

                    Task[] gang= new Task[theList.size()];
                    for (int i = 0; i < theList.size(); i++) {
                        gang[i]=theList.get(i);
                        System.out.println(gang[i]);

                    }

                    json.setTasks(gang);
                    try (FileWriter writer = new FileWriter("save.json")) {
                        gson.toJson(json, writer);
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    System.out.println("buh bye");

                    break;
                default:
                    System.out.println("how does he even read it?");
                    break;

            }
        }while (choice!=0);
    }
    private static ArrayList<Task> addTask(AdIn input, ArrayList<Task> theList){
        theList.add(new Task(input));
        return theList;


    }
    private static ArrayList<Task> removeTask(AdIn input,ArrayList<Task> theList){
        theList.remove(input.promptInt("which index wold you like to remove", theList.size()-1));
        return theList;
    }
    private static ArrayList<Task> updateTask(AdIn input, ArrayList<Task> theList){
        System.out.println();
        int replaceIndex=input.promptInt("which index would you like to update", theList.size()-1);
        theList.set(replaceIndex, new Task(input));
        return theList;
    }

    private static void sendList(AdIn input, ArrayList<Task> theList) {


        int priority = input.promptInt("If you would like to only look for a certain priority level of items, please input that priority number. if you wish to print all items, hit the 6 key and then the enter key", 6);
        if (priority == 6) {
            for (Task e: theList) {
                System.out.println(e.toString());
            }
        } else {
            for (Task e: theList) {
                if (e.getPriority() == priority) {
                    System.out.println(e.toString());
                }
            }
        }
    }

}
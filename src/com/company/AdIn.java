package com.company;

import java.util.Scanner;

public class AdIn {
    Scanner input = new Scanner(System.in);

    public int promptInt(String message, int limit) {
        boolean i = false;
        String inp="";
        int inpt=0;
        while (i!=true || inpt>limit || inpt<0) {
            try {
                System.out.println(message);
                inp = input.nextLine();
                inpt=Integer.parseInt(inp);
                i=true;
            } catch (Exception NumberFormatException) {
                i=false;
                System.out.println("try a number in the range goofball");
            }


        }
        return inpt;
    }

    public double promptDouble(String message){
        boolean i = false;
        String inp="";
        double inpt=0;
        while (i!=true) {
            try {
                System.out.println(message);
                inp = input.nextLine();
                inpt=Double.parseDouble(inp);
                i=true;
            } catch (Exception NumberFormatException) {
                System.out.println("try agian");
            }


        }
        return inpt;
    }
    public String promptString(String message){
        boolean i = false;
        String inp="";
        while (i!=true) {
            try {
                System.out.println(message);
                inp = input.nextLine();
                Double.parseDouble(inp);
                System.out.println("that's a number. try a word or sumn next time");
            } catch (Exception NumberFormatException) {
                i = true;
            }
        }
        return inp;
    }

}

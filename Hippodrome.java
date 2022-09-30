package com.javarush.task.task21.task2113;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hippodrome {
    static Hippodrome game;
    private List<Horse> horses;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }

    public void run(){
        try {
            for (int i = 0; i < 100; i++) {
                move();
                print();
                Thread.sleep(200);
            }
        } catch (Exception e){
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void move(){
        for (Horse horse :
                horses) {
            horse.move();
        }
    }
    public void print(){
        for (Horse horse :
                horses) {
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        Horse fastHorse = horses.get(0);
        for (Horse horse :
                horses) {
            if (fastHorse.getDistance() < horse.getDistance()){
                fastHorse = horse;
            }
        }

        return fastHorse;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        ArrayList<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Lucky", 3, 0));
        horses.add(new Horse("Slevin", 3, 0));
        horses.add(new Horse("Homer", 3, 0));
        game = new Hippodrome(horses);
        game.run();
        game.printWinner();
    }
}

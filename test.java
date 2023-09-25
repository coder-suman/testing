package com.company;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
class Play_game{
    Scanner sc=new Scanner(System.in);
    Random rn=new Random();
    int user_dif;
    int[] userInputs = new int[5];
    int[] computerInputs = new int[5];
    String [][]arr=new String[3][3];
    int [][]arr2=new int[3][3];
    int []digit={1,2,3,4,5,6,7,8,9};
    int s=0;
    int b=0;

    public void instraction(){
        int r=1;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr2[i][j]=r;
                r++;
            }
        }
        display_game_2();
    }
    public void display_game_2(){
        System.out.println("Enter only number like this instruction. . .");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void arr_gen(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
//                System.out.println("enter: ");
                arr[i][j]="0";
            }
        }
        display_game();
    }
    public void display_game(){
        System.out.println();
        System.out.println("GAME BORD-->");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void user_input(){
        for (int i = 0; i < userInputs.length; i++) {
            System.out.print("Enter user input: ");
            int a = sc.nextInt();
            for(int j=0;j<userInputs.length;j++) {
                if (userInputs[j] == a || computerInputs[j] == a) {
                    user_input();
                } else {
                    userInputs[j] = a;
                    switch (a) {
                        case 1 -> {
                            arr[0][0] = "X";
                        }
                        case 2 -> {
                            arr[0][1] = "X";
                        }
                        case 3 -> {
                            arr[0][2] = "X";
                        }
                        case 4 -> {
                            arr[1][0] = "X";
                        }
                        case 5 -> {
                            arr[1][1] = "X";
                        }
                        case 6 -> {
                            arr[1][2] = "X";
                        }
                        case 7 -> {
                            arr[2][0] = "X";
                        }
                        case 8 -> {
                            arr[2][1] = "X";
                        }
                        case 9 -> {
                            arr[2][2] = "X";
                        }

                    }
                }
            }
            board_display();
        }
    }
    public void board_display(){
        System.out.println();
        System.out.println("USER MOVE (X)-->");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        computer_input();
    }
    public void board_display3(){
        System.out.println();
        System.out.println("COMPUTER MOVE (*)-->");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        user_input();

    }
    public void computer_input() {
        for (int i = 0; i < computerInputs.length; i++) {
            int b = rn.nextInt(1, 10);
            System.out.println("Com input: " + b);
            for (int j = 0; j < computerInputs.length; j++) {
                if (userInputs[j] == b || computerInputs[j] == b) {
                    computer_input();
                } else {

                    computerInputs[j] = b;


                    switch (b) {
                        case 1 -> {
                            arr[0][0] = "*";
                        }
                        case 2 -> {
                            arr[0][1] = "*";
                        }
                        case 3 -> {
                            arr[0][2] = "*";
                        }
                        case 4 -> {
                            arr[1][0] = "*";
                        }
                        case 5 -> {
                            arr[1][1] = "*";
                        }
                        case 6 -> {
                            arr[1][2] = "*";
                        }
                        case 7 -> {
                            arr[2][0] = "*";
                        }
                        case 8 -> {
                            arr[2][1] = "*";
                        }
                        case 9 -> {
                            arr[2][2] = "*";
                        }
                    }
                }
            }

                board_display3();

        }
    }




    public void win_game(){
        if((arr[0][0]=="X" && arr[0][1]=="X" && arr[0][2]=="X") || (arr[0][0]=="X" && arr[1][1]=="X" && arr[2][2]=="X") || (arr[0][0]=="X" && arr[1][0]=="X" && arr[2][0]=="X") || (arr[0][2]=="X" && arr[1][2]=="X" && arr[2][2]=="X") || (arr[2][0]=="X" && arr[2][1]=="X" && arr[2][2]=="X") || (arr[2][0]=="X" && arr[1][1]=="X" && arr[0][2]=="X") || (arr[0][1]=="X" && arr[1][1]=="X" && arr[2][1]=="X")){
            System.out.println("You Win The Match...");
        }
        else if((arr[0][0]=="*" && arr[0][1]=="*" && arr[0][2]=="*") || (arr[0][0]=="*" && arr[1][1]=="*" && arr[2][2]=="*") || (arr[0][0]=="*" && arr[1][0]=="*" && arr[2][0]=="*") || (arr[0][2]=="*" && arr[1][2]=="*" && arr[2][2]=="*") || (arr[2][0]=="*" && arr[2][1]=="*" && arr[2][2]=="*") || (arr[2][0]=="*" && arr[1][1]=="*" && arr[0][2]=="*") || (arr[0][1]=="*" && arr[1][1]=="*" && arr[2][1]=="*")){
            System.out.println("Computer Win The Match...");
            instraction();
        }

    }
}

public class test {
    public static void main(String[] args) {
        Play_game pg = new Play_game();
        pg.instraction();
        pg.arr_gen();
        while (true){
            pg.user_input();
            pg.win_game();
        }







    }
}

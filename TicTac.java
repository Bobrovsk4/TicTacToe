import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.Console;
public class TicTac {
    final char X = 'x';
    final char O = 'o';
    final char EMPTY = ' ';
    char[][] table = new char[3][3];
    ArrayList<Integer> used = new ArrayList<>(9);
    Random random;
    Scanner scanner;

    TicTac() {
        random = new Random();
        scanner = new Scanner(System.in);
    }

    void initTable() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                table[i][j] = EMPTY;
            }
        }
    }

    void printTable() {
        System.out.println("   |   |   |   |");
        System.out.println("---|---|---|---|---");
        System.out.println("   | " + table[0][0] + " | " + table[0][1] + " | " + table[0][2] + " |   ");
        System.out.println("---|---|---|---|---");
        System.out.println("   | " + table[1][0] + " | " + table[1][1] + " | " + table[1][2] + " |   ");
        System.out.println("---|---|---|---|---");
        System.out.println("   | " + table[2][0] + " | " + table[2][1] + " | " + table[2][2] + " |   ");
        System.out.println("---|---|---|---|---");
        System.out.println("   |   |   |   |");
    }

    void PlayerOne() {
        System.out.println("Игрок 1, вы играете за Х\nВведите незанятое поле: ");
        int choice = scanner.nextInt();
        if(used.contains(choice)) {
            System.out.println("Поле занято");
            PlayerOne();
        }
        else {
            used.add(choice);
            int x = 0, y = 0;
            switch (choice) {
                case 1: {
                    x = 0;
                    y = 0;
                    break;
                }
                case 2: {
                    x = 1;
                    y = 0;
                    break;
                }
                case 3: {
                    x = 2;
                    y = 0;
                    break;
                }
                case 4: {
                    x = 0;
                    y = 1;
                    break;
                }
                case 5: {
                    x = 1;
                    y = 1;
                    break;
                }
                case 6: {
                    x = 2;
                    y = 1;
                    break;
                }
                case 7: {
                    x = 0;
                    y = 2;
                    break;
                }
                case 8: {
                    x = 1;
                    y = 2;
                    break;
                }
                case 9: {
                    x = 2;
                    y = 2;
                    break;
                }
                default: {
                    System.out.println("Неверный ввод");
                    break;
                }
            }
            table[y][x] = X;
        }
    }

    void PlayerTwo() {
        System.out.println("Игрок 2, вы играете за O\nВведите незанятое поле: ");
        int choice = scanner.nextInt();
        if(used.contains(choice)) {
            System.out.println("Поле занято");
            PlayerTwo();
        }
        else {
            used.add(choice);
            int x = 0, y = 0;
            switch (choice) {
                case 1: {
                    x = 0;
                    y = 0;
                    break;
                }
                case 2: {
                    x = 1;
                    y = 0;
                    break;
                }
                case 3: {
                    x = 2;
                    y = 0;
                    break;
                }
                case 4: {
                    x = 0;
                    y = 1;
                    break;
                }
                case 5: {
                    x = 1;
                    y = 1;
                    break;
                }
                case 6: {
                    x = 2;
                    y = 1;
                    break;
                }
                case 7: {
                    x = 0;
                    y = 2;
                    break;
                }
                case 8: {
                    x = 1;
                    y = 2;
                    break;
                }
                case 9: {
                    x = 2;
                    y = 2;
                    break;
                }
                default: {
                    System.out.println("Неверный ввод");
                    break;
                }
            }
            table[y][x] = O;
        }
    }

    boolean checkWin(char dot) {
        for(int i = 0; i < 3; i++) {
            if((table[i][0] == dot && table[i][1] == dot && table[i][2] == dot) || (table[0][i] == dot && table[1][i] == dot && table[2][i] == dot)) {return true;}
            if((table[0][0] == dot && table[1][1] == dot && table[2][2] == dot) || (table[0][2] == dot && table[1][1] == dot && table[2][0] == dot)) {return true;}
        }
        return false;
    }

    boolean isTableFull() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(table[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    void game() {
        initTable();
        while(true) {
            printTable();
            PlayerOne();

            if(checkWin(X)) {
                System.out.println("Игрок 1 победил!");
                break;
            }
            if(isTableFull()) {
                System.out.println("Ничья!");
                break;
            }

            printTable();
            PlayerTwo();

            if(checkWin(O)) {
                System.out.println("Игрок 2 победил!");
                break;
            }
            if(isTableFull()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void main(String[] args) {
        new TicTac().game();
    }
}

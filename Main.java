package battleship;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    //final char markX = 88;
    //final char markM = 77;
    //final char markO = 79;

    public static void main(String[] args) {
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();

        //CREATING GAME FIELDS//
        Tools tools = new Tools();
        Actions actions = new Actions();
        actions.createGameField(Player1.player1Array);
        actions.createGameField(Player1.player1Aircraft);
        actions.createGameField(Player1.player1Battleship);
        actions.createGameField(Player1.player1Submarine);
        actions.createGameField(Player1.player1Cruiser);
        actions.createGameField(Player1.player1Destroyer);

        actions.createGameField(Player2.player2Array);
        actions.createGameField(Player2.player2Aircraft);
        actions.createGameField(Player2.player2Battleship);
        actions.createGameField(Player2.player2Submarine);
        actions.createGameField(Player2.player2Cruiser);
        actions.createGameField(Player2.player2Destroyer);

        //PLACING SHIPS//
        System.out.println("Player 1, place your ships on the game field:");
        System.out.println();
        actions.showGameField(Player1.player1Array);
        actions.player1PlacingShips();
        System.out.println();
        tools.promptEnterKey();
        //System.out.println("Press Enter and pass the move to another player");

        System.out.println("Player 2, place your ships on the game field:");
        System.out.println();
        actions.showGameField(Player2.player2Array);
        actions.player2PlacingShips();
        System.out.println();
        //System.out.println("Press Enter and pass the move to another player");
        tools.promptEnterKey();

        //BATTLE//
        int rounds = 1;

        actions.createGameField(Player1.player1ArrayFog);
        actions.createGameField(Player2.player2ArrayFog);

        //boolean p1a = false;
        boolean werePlayer2AircraftSunkenShown = false;
        boolean werePlayer2BattleshipSunkenShown = false;
        boolean werePlayer2SubmarineSunkenShown = false;
        boolean werePlayer2CruiserSunkenShown = false;
        boolean werePlayer2DestroyerSunkenShown = false;

        boolean werePlayer1AircraftSunkenShown = false;
        boolean werePlayer1BattleshipSunkenShown = false;
        boolean werePlayer1SubmarineSunkenShown = false;
        boolean werePlayer1CruiserSunkenShown = false;
        boolean werePlayer1DestroyerSunkenShown = false;

        while (true) {
            if (rounds % 2 != 0) {
                actions.showGameField(Player1.player1ArrayFog);
                System.out.println("---------------------");
                actions.showGameField(Player1.player1Array);
                System.out.println();
                System.out.println("Player 1, its your turn: ");
                System.out.println();

                boolean isHit = player1.player1Attacks();
                if (isHit) {
                    Player2.isPlayer2AircraftSunken = player2.isPlayer2AircraftSunken();
                    Player2.isPlayer2BattleshipSunken = player2.isPlayer2BattleshipSunken();
                    Player2.isPlayer2SubmarineSunken = player2.isPlayer2SubmarineSunken();
                    Player2.isPlayer2CruiserSunken = player2.isPlayer2CruiserSunken();
                    Player2.isPlayer2DestroyerSunken = player2.isPlayer2DestroyerSunken();
                    if (tools.checkChar(Player2.player2Array) == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    } else {
                        if (Player2.isPlayer2AircraftSunken && !werePlayer2AircraftSunkenShown) {
                            System.out.println("You sank a ship!");
                            werePlayer2AircraftSunkenShown = true;
                        } else if (Player2.isPlayer2BattleshipSunken && !werePlayer2BattleshipSunkenShown) {
                            System.out.println("You sank a ship!");
                            werePlayer2BattleshipSunkenShown = true;
                        } else if (Player2.isPlayer2SubmarineSunken && !werePlayer2SubmarineSunkenShown) {
                            System.out.println("You sank a ship!");
                            werePlayer2SubmarineSunkenShown = true;
                        } else if (Player2.isPlayer2CruiserSunken && !werePlayer2CruiserSunkenShown) {
                            System.out.println("You sank a ship!");
                            werePlayer2CruiserSunkenShown = true;
                        } else if (Player2.isPlayer2DestroyerSunken && !werePlayer2DestroyerSunkenShown) {
                            System.out.println("You sank a ship!");
                            werePlayer2DestroyerSunkenShown = true;
                        } else {
                            System.out.println("You hit a ship!");
                        }
                        tools.promptEnterKey();
                        //System.out.println("Press Enter and pass the move to another player");
                    }
                }
                rounds++;
            } else {
                actions.showGameField(Player2.player2ArrayFog);
                System.out.println("---------------------");
                actions.showGameField(Player2.player2Array);
                System.out.println();
                System.out.println("Player 2, its your turn: ");

                boolean isHit = player2.player2Attacks();
                if (isHit) {
                    Player1.isPlayer1AircraftSunken = player1.isPlayer1AircraftSunken();
                    Player1.isPlayer1BattleshipSunken = player1.isPlayer1BattleshipSunken();
                    Player1.isPlayer1SubmarineSunken = player1.isPlayer1SubmarineSunken();
                    Player1.isPlayer1CruiserSunken = player1.isPlayer1CruiserSunken();
                    Player1.isPlayer1DestroyerSunken = player1.isPlayer1DestroyerSunken();
                    if (tools.checkChar(Player1.player1Array) == 0) {
                        System.out.println("You sank the last ship. You won. Congratulations!");
                        break;
                    } else {
                        if (Player1.isPlayer1AircraftSunken && !werePlayer1AircraftSunkenShown) {
                            System.out.println("You sank a ship1!");
                            werePlayer1AircraftSunkenShown = true;
                        } else if (Player1.isPlayer1BattleshipSunken && !werePlayer1BattleshipSunkenShown) {
                            System.out.println("You sank a ship2!");
                            werePlayer1BattleshipSunkenShown = true;
                        } else if (Player1.isPlayer1SubmarineSunken && !werePlayer1SubmarineSunkenShown) {
                            System.out.println("You sank a ship3!");
                            werePlayer1SubmarineSunkenShown = true;
                        } else if (Player1.isPlayer1CruiserSunken && !werePlayer1CruiserSunkenShown) {
                            System.out.println("You sank a ship!4");
                            werePlayer1CruiserSunkenShown = true;
                        } else if (Player1.isPlayer1DestroyerSunken && !werePlayer1DestroyerSunkenShown) {
                            System.out.println("You sank a ship5!");
                            werePlayer1DestroyerSunkenShown = true;
                        } else {
                            System.out.println("You hit a ship!");
                        }
                        tools.promptEnterKey();
                        //System.out.println("Press Enter and pass the move to another player");
                    }
                }
                rounds++;
            }
        }
    }
}

class Player1 extends Actions {
    static char[][] player1Array = new char[10][10];
    static char[][] player1ArrayFog = new char[10][10];

    static char[][] player1Aircraft = new char[10][10];
    static char[][] player1Battleship = new char[10][10];
    static char[][] player1Submarine = new char[10][10];
    static char[][] player1Cruiser = new char[10][10];
    static char[][] player1Destroyer = new char[10][10];

    static boolean isPlayer1AircraftSunken = false;
    static boolean isPlayer1BattleshipSunken = false;
    static boolean isPlayer1SubmarineSunken = false;
    static boolean isPlayer1CruiserSunken = false;
    static boolean isPlayer1DestroyerSunken = false;
}

class Player2 extends Actions {
    static char[][] player2Array = new char[10][10];
    static char[][] player2ArrayFog = new char[10][10];

    static char[][] player2Aircraft = new char[10][10];
    static char[][] player2Battleship = new char[10][10];
    static char[][] player2Submarine = new char[10][10];
    static char[][] player2Cruiser = new char[10][10];
    static char[][] player2Destroyer = new char[10][10];

    static boolean isPlayer2AircraftSunken = false;
    static boolean isPlayer2BattleshipSunken = false;
    static boolean isPlayer2SubmarineSunken = false;
    static boolean isPlayer2CruiserSunken = false;
    static boolean isPlayer2DestroyerSunken = false;
}

class Actions {
    void createGameField(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = 126;
            }
        }

        //return array;
    }

    void showGameField(char[][] array) {
        System.out.print(" ");
        for (int i = 0; i < 10; i++) {
            System.out.print(" ");
            System.out.print((i + 1));
        }

        System.out.println();
        String letters = "ABCDEFGHIJ";

        for (int i = 0; i < array.length; i++) {
            System.out.print(Character.toString(letters.charAt(i)));
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(" " + Character.toString(array[i][j]));
            }
            System.out.println();
        }
    }

    void createShip(char[][] array, int litt1, int x1, int litt2, int x2) {
        int dlugoscPion = Math.abs(litt1 - litt2);
        int dlugoscPoziom = Math.abs(x1 - x2);

        if (litt1 != litt2 && x1 == x2) { //pion
            if (litt1 < litt2) { // w dół
                for (int i = 0; i < dlugoscPion + 1; i++) {
                    array[litt2 - i][x1] = 79; //79
                }
            } else { // w górę
                for (int i = 0; i < dlugoscPion + 1; i++) {
                    array[litt1 - i][x1] = 79;
                }
            }
        } else if (litt1 == litt2 && x1 != x2) { //poziom
            if (x1 < x2) { // w prawo
                for (int i = 0; i < dlugoscPoziom + 1; i++) {
                    array[litt1][x2 - i] = 79;
                }
            } else { // w lewo
                for (int i = 0; i < dlugoscPoziom + 1; i++) {
                    array[litt1][x1 - i] = 79;
                }
            }
        }
        //return array;
    }

    boolean checkSurroundings(char[][] array, int litt1, int x1, int litt2, int x2) {
        boolean notClearInside = false;

        if (x1 == 0 || x1 == 9 || x2 == 0 || x2 == 9 || litt1 == 0 || litt1 == 9 || litt2 == 0 || litt2 == 9) {
            if (litt1 == litt2) { //poziom
                if (litt1 == 0) { // przy ściance górnej
                    if (x1 == 0) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 + 1][x1 + i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x2 + 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x2 == 0) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 + 1][x2 + i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x1 + 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x1 == 9) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 + 1][x1 - i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x2 - 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x2 == 9) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 + 1][x2 - i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x1 - 1] != 126) {
                            notClearInside = true;
                        }
                    }
                } else if (litt1 == 9) { // przy ściance dolnej
                    if (x1 == 0) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 - 1][x1 + i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x2 + 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x2 == 0) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 - 1][x2 + i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x1 + 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x1 == 9) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 - 1][x1 - i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x2 - 1] != 126) {
                            notClearInside = true;
                        }
                    } else if (x2 == 9) {
                        for (int i = 0; i < Math.abs(x1 - x2) + 1; i++) {
                            if (array[litt1 - 1][x2 - i] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1][x1 - 1] != 126) {
                            notClearInside = true;
                        }
                    }
                }
            } else if (x1 == x2) { // pion
                if (x1 == 0) { // przy ściance lewej
                    if (litt1 == 0) { // lewy góry róg
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt1 + i][x1 + 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt2 + 1][x1] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt2 == 0) {
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt2 + i][x1 + 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1 + 1][x1] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt1 == 9) { // lewy dolny róg
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt1 - i][x1 + 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt2 - 1][x2] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt2 == 9) {
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt2 - i][x1 + 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1 - 1][x1] != 126) {
                            notClearInside = true;
                        }
                    }
                } else if (x1 == 9) { // przy ściance prawej
                    if (litt1 == 0) { // prawy górny róg
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt1 + i][x1 - 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt2 - 1][x1] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt2 == 0) { // prawy górny róg
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt2 + i][x1 - 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1 + 1][x1] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt1 == 9) {
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt1 - i][x1 - 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt2 - 1][x1] != 126) {
                            notClearInside = true;
                        }
                    } else if (litt2 == 9) {
                        for (int i = 0; i < Math.abs(litt1 - litt2) + 1; i++) {
                            if (array[litt2 - i][x1 - 1] != 126) {
                                notClearInside = true;
                                break;
                            }
                        }
                        if (array[litt1 - 1][x1] != 126) {
                            notClearInside = true;
                        }
                    }
                }
            }
        } else if (litt1 == litt2) { // poziom
            if (x1 < x2) {
                for (int i = 0; i < Math.abs(x1 - x2) + 2; i++) {
                    if (array[litt1 - 1][x2 + 1 - i] != 126 || array[litt1 + 1][x2 + 1 - i] != 126) {
                        notClearInside = true;
                        break;
                    }
                }
                if (array[litt1][x2 + 1] != 126 || array[litt1][x1 - 1] != 126) {
                    notClearInside = true;
                }
            } else if (x1 > x2) {
                for (int i = 0; i < Math.abs(x1 - x2) + 2; i++) {
                    if (array[litt1 - 1][x1 + 1 - i] != 126 || array[litt1 + 1][x1 + 1 - i] != 126) {
                        notClearInside = true;
                        break;
                    }
                }
                if (array[litt1][x1 + 1] != 126 || array[litt1][x2 - 1] != 126) {
                    notClearInside = true;
                }
            }
        } else if (x1 == x2) { // pion
            if (litt1 < litt2) { // w dół
                for (int i = 0; i < Math.abs(litt1 - litt2) + 2; i++) {
                    if (array[litt2 + 1 - i][x1 - 1] != 126 || array[litt2 + 1 - i][x1 + 1] != 126) {
                        notClearInside = true;
                        break;
                    }
                }
                if (array[litt1 - 1][x1] != 126 || array[litt2 + 1][x1] != 126) {
                    notClearInside = true;
                }
            } else if (litt1 > litt2) { // w górę
                for (int i = 0; i < Math.abs(litt1 - litt2) + 2; i++) {
                    if (array[litt1 + 1 - i][x1 - 1] != 126 || array[litt1 + 1 - i][x1 + 1] != 126) {
                        notClearInside = true;
                        break;
                    }
                }
                if (array[litt1 + 1][x1] != 126 || array[litt2 - 1][x1] != 126) {
                    notClearInside = true;
                }
            }
        }
        return notClearInside;
    }

    void player1PlacingShips() {
        String letters = "ABCDEFGHIJ";
        String shipArray[] = new String[5];
        shipArray[0] = "Aircraft Carrier (5 cells)";
        shipArray[1] = "Battleship (4 cells)";
        shipArray[2] = "Submarine (3 cells)";
        shipArray[3] = "Cruiser (3 cells)";
        shipArray[4] = "Destroyer (2 cells)";
        int[] intArray = new int[5];
        intArray[0] = 5;
        intArray[1] = 4;
        intArray[2] = 3;
        intArray[3] = 3;
        intArray[4] = 2;
        int x1 = 0;
        int litt1 = 0;
        int x2 = 0;
        int litt2 = 0;
        Scanner scanner = new Scanner(System.in);
        Tools tools = new Tools();

        for (int i = 0; i < 5;) {
            System.out.printf("Enter the coordinates of the %s:", shipArray[i]);
            System.out.println();

            String stringInput = "";
            stringInput = scanner.nextLine();

            int indexOfSpace = stringInput.indexOf(" ");

            if (stringInput.length() == 7) {
                litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                x1 = 10;
                litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(4)));
                x2 = 10;
            } else if (stringInput.length() == 6) {
                if (indexOfSpace + 1 > 3) { // więcej znaków po lewej
                    litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                    x1 = 10;
                    litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(4)));
                    x2 = Integer.parseInt(Character.toString(stringInput.charAt(5)));
                } else if (indexOfSpace + 1 < 3) { // więcej znaków po prawej
                    litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                    x1 = Integer.parseInt(Character.toString(stringInput.charAt(1)));
                    litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(3)));
                    x2 = 10;
                }
            } else if (stringInput.length() == 5) {
                litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                x1 = Integer.parseInt(Character.toString(stringInput.charAt(1)));
                litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(3)));
                x2 = Integer.parseInt(Character.toString(stringInput.charAt(4)));
            } else {
                System.out.println("Error, Input nie pasuje kurwa");
            }

            x1 = x1 - 1;
            x2 = x2 - 1;

            if (x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || litt1 < 0 || litt1 > 9 || litt2 < 0 || litt2 > 9) {
                System.out.println("Error! Coordinates outside board! Try again:");
                System.out.println();
            } else if (x1 != x2 && litt1 != litt2) {
                System.out.println("Error! Wrong coordinates! Try again:");
                System.out.println();
            } else if ((litt1 == litt2 && Math.abs(x1 - x2) != intArray[i] - 1) || (x1 == x2 && Math.abs(litt1 - litt2) != intArray[i] - 1)) {
                System.out.printf("Error! Wrong length of the %s! Try again:", shipArray[i]);
                System.out.println();
            } else {
                boolean notClear = checkSurroundings(Player1.player1Array, litt1, x1, litt2, x2);
                if (notClear) {
                    System.out.println("Error! Too close to another ship");
                    System.out.println();
                } else {
                    createShip(Player1.player1Array, litt1, x1, litt2, x2);
                    if (i == 0) {
                        createShip(Player1.player1Aircraft, litt1, x1, litt2, x2);
                    } else if (i == 1) {
                        createShip(Player1.player1Battleship, litt1, x1, litt2, x2);
                    } else if (i == 2) {
                        createShip(Player1.player1Submarine, litt1, x1, litt2, x2);
                    } else if (i == 3) {
                        createShip(Player1.player1Cruiser, litt1, x1, litt2, x2);
                    } else {
                        createShip(Player1.player1Destroyer, litt1, x1, litt2, x2);
                    }
                    System.out.println();
                    showGameField(Player1.player1Array);
                    System.out.println();
                    i++;
                }
            }
        }
    }

    boolean player1Attacks() {
        boolean isHit = false;
        Scanner scanner = new Scanner(System.in);
        int targetLitt = 0;
        int targetX = 0;
        Tools tools = new Tools();
        String input = null;

        while (!isHit) {
            input = scanner.nextLine();
            input = input.trim();

            System.out.println(input);
            if (input.length() == 3) {
                targetLitt = tools.toolStringToInt(Character.toString(input.charAt(0)));
                String targetXString = input.substring(1);
                targetX = Integer.parseInt(targetXString);
            } else if (input.length() == 2) {
                targetLitt = tools.toolStringToInt(Character.toString(input.charAt(0)));
                targetX = Integer.parseInt(Character.toString(input.charAt(1)));
            } else if (input.length() < 2) {
                System.out.println("Error! Wrong coordinates!FUCK Try again: ");
                System.out.println();
                continue;
            }
            targetX--;

            if (targetLitt > 9 || targetLitt < 0 || targetX < 0 || targetX > 9) {
                System.out.println("Error! Coordinates outside FUCK board! Try again: ");
                System.out.println();
            } else if (Player2.player2Array[targetLitt][targetX] == 77 || Player2.player2Array[targetLitt][targetX] == 88) {
                System.out.println("Already shot there");
                System.out.println();
            } else if (Player2.player2Array[targetLitt][targetX] == 126) {
                Player2.player2Array[targetLitt][targetX] = 77;
                Player1.player1ArrayFog[targetLitt][targetX] = 77;
                System.out.println();
                System.out.println("You missed!");
                tools.promptEnterKey();
                break;
            } else if (Player2.player2Array[targetLitt][targetX] == 79) {
                Player2.player2Array[targetLitt][targetX] = 88;
                Player1.player1ArrayFog[targetLitt][targetX] = 88;
                Player2.player2Aircraft[targetLitt][targetX] = 88;
                Player2.player2Destroyer[targetLitt][targetX] = 88;
                Player2.player2Submarine[targetLitt][targetX] = 88;
                Player2.player2Cruiser[targetLitt][targetX] = 88;
                Player2.player2Battleship[targetLitt][targetX] = 88;
                System.out.println();
                //actions.showGameField(Player1.player1ArrayFog);
                //System.out.println();
                isHit = true;
            }
        }
        return isHit;
    }

    boolean player2Attacks() {
        boolean isHit = false;
        Scanner scanner = new Scanner(System.in);
        int targetLitt = 0;
        int targetX = 0;
        Tools tools = new Tools();
        String input = null;

        while (!isHit) {
            input = scanner.nextLine();
            input = input.trim();

            System.out.println(input);
            if (input.length() == 3) {
                targetLitt = tools.toolStringToInt(Character.toString(input.charAt(0)));
                String targetXString = input.substring(1);
                targetX = Integer.parseInt(targetXString);
            } else if (input.length() == 2) {
                targetLitt = tools.toolStringToInt(Character.toString(input.charAt(0)));
                targetX = Integer.parseInt(Character.toString(input.charAt(1)));
            } else if (input.length() < 2) {
                System.out.println(input);
                System.out.println("Error! Wrong coordinates!FUCK Try again: ");
                System.out.println();
                continue;
            }
            targetX = targetX - 1;

            if (targetLitt > 9 || targetLitt < 0 || targetX < 0 || targetX > 9) {
                System.out.println("Error! Coordinates outside FUCK board! Try again: ");
                System.out.println();
            } else if (Player1.player1Array[targetLitt][targetX] == 77 || Player1.player1Array[targetLitt][targetX] == 88) {
                System.out.println("Already shot there");
                System.out.println();
            } else if (Player1.player1Array[targetLitt][targetX] == 126) {
                Player1.player1Array[targetLitt][targetX] = 77;
                Player2.player2ArrayFog[targetLitt][targetX] = 77;
                System.out.println();
                System.out.println("You missed!");
                tools.promptEnterKey();
                break;
            } else if (Player1.player1Array[targetLitt][targetX] == 79) {
                Player1.player1Array[targetLitt][targetX] = 88;
                Player2.player2ArrayFog[targetLitt][targetX] = 88;
                Player1.player1Aircraft[targetLitt][targetX] = 88;
                Player1.player1Destroyer[targetLitt][targetX] = 88;
                Player1.player1Submarine[targetLitt][targetX] = 88;
                Player1.player1Cruiser[targetLitt][targetX] = 88;
                Player1.player1Battleship[targetLitt][targetX] = 88;
                System.out.println();
                //actions.showGameField(Player2.player2ArrayFog);
                //System.out.println();
                isHit = true;
            }
        }
        return isHit;
    }

    void player2PlacingShips() {
        //String letters = "ABCDEFGHIJ";
        String shipArray[] = new String[5];
        shipArray[0] = "Aircraft Carrier (5 cells)";
        shipArray[1] = "Battleship (4 cells)";
        shipArray[2] = "Submarine (3 cells)";
        shipArray[3] = "Cruiser (3 cells)";
        shipArray[4] = "Destroyer (2 cells)";
        int[] intArray = new int[5];
        intArray[0] = 5;
        intArray[1] = 4;
        intArray[2] = 3;
        intArray[3] = 3;
        intArray[4] = 2;
        int x1 = 0;
        int litt1 = 0;
        int x2 = 0;
        int litt2 = 0;
        Scanner scanner = new Scanner(System.in);
        Tools tools = new Tools();

        for (int i = 0; i < 5;) {
            System.out.printf("Enter the coordinates of the %s:", shipArray[i]);
            System.out.println();

            String stringInput = scanner.nextLine();

            int indexOfSpace = stringInput.indexOf(" ");

            if (stringInput.length() == 7) {
                litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                x1 = 10;
                litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(4)));
                x2 = 10;
            } else if (stringInput.length() == 6) {
                if (indexOfSpace + 1 > 3) { // więcej znaków po lewej
                    litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                    x1 = 10;
                    litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(4)));
                    x2 = Integer.parseInt(Character.toString(stringInput.charAt(5)));
                } else if (indexOfSpace + 1 < 3) { // więcej znaków po prawej
                    litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                    x1 = Integer.parseInt(Character.toString(stringInput.charAt(1)));
                    litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(3)));
                    x2 = 10;
                }
            } else if (stringInput.length() == 5) {
                litt1 = tools.toolStringToInt(Character.toString(stringInput.charAt(0)));
                x1 = Integer.parseInt(Character.toString(stringInput.charAt(1)));
                litt2 = tools.toolStringToInt(Character.toString(stringInput.charAt(3)));
                x2 = Integer.parseInt(Character.toString(stringInput.charAt(4)));
            } else {
                System.out.println("Error, Input nie pasuje kurwa");
            }

            x1 = x1 - 1;
            x2 = x2 - 1;

            if (x1 < 0 || x1 > 9 || x2 < 0 || x2 > 9 || litt1 < 0 || litt1 > 9 || litt2 < 0 || litt2 > 9) {
                System.out.println("Error! Coordinates outside board! Try again:");
                System.out.println();
            } else if (x1 != x2 && litt1 != litt2) {
                System.out.println("Error! Wrong coordinates! Try again:");
                System.out.println();
            } else if ((litt1 == litt2 && Math.abs(x1 - x2) != intArray[i] - 1) || (x1 == x2 && Math.abs(litt1 - litt2) != intArray[i] - 1)) {
                System.out.printf("Error! Wrong length of the %s! Try again:", shipArray[i]);
                System.out.println();
            } else {
                boolean notClear = checkSurroundings(Player2.player2Array, litt1, x1, litt2, x2);
                if (notClear) {
                    System.out.println("Error! Too close to another ship");
                    System.out.println();
                } else {
                    createShip(Player2.player2Array, litt1, x1, litt2, x2);
                    if (i == 0) {
                        createShip(Player2.player2Aircraft, litt1, x1, litt2, x2);
                    } else if (i == 1) {
                        createShip(Player2.player2Battleship, litt1, x1, litt2, x2);
                    } else if (i == 2) {
                        createShip(Player2.player2Submarine, litt1, x1, litt2, x2);
                    } else if (i == 3) {
                        createShip(Player2.player2Cruiser, litt1, x1, litt2, x2);
                    } else {
                        createShip(Player2.player2Destroyer, litt1, x1, litt2, x2);
                    }
                    System.out.println();
                    showGameField(Player2.player2Array);
                    System.out.println();
                    i++;
                }
            }
        }
    }

    boolean isPlayer1AircraftSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player1.player1Aircraft.length; i++) {
            for (int j = 0; j < Player1.player1Aircraft[i].length; j++) {
                if (Player1.player1Aircraft[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer1BattleshipSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player1.player1Battleship.length; i++) {
            for (int j = 0; j < Player1.player1Battleship[i].length; j++) {
                if (Player1.player1Battleship[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer1SubmarineSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player1.player1Submarine.length; i++) {
            for (int j = 0; j < Player1.player1Submarine[i].length; j++) {
                if (Player1.player1Submarine[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer1CruiserSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player1.player1Cruiser.length; i++) {
            for (int j = 0; j < Player1.player1Cruiser[i].length; j++) {
                if (Player1.player1Cruiser[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer1DestroyerSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player1.player1Destroyer.length; i++) {
            for (int j = 0; j < Player1.player1Destroyer[i].length; j++) {
                if (Player1.player1Destroyer[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer2AircraftSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player2.player2Aircraft.length; i++) {
            for (int j = 0; j < Player2.player2Aircraft[i].length; j++) {
                if (Player2.player2Aircraft[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer2BattleshipSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player2.player2Battleship.length; i++) {
            for (int j = 0; j < Player2.player2Battleship[i].length; j++) {
                if (Player2.player2Battleship[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer2SubmarineSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player2.player2Submarine.length; i++) {
            for (int j = 0; j < Player2.player2Submarine[i].length; j++) {
                if (Player2.player2Submarine[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer2CruiserSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player2.player2Cruiser.length; i++) {
            for (int j = 0; j < Player2.player2Cruiser[i].length; j++) {
                if (Player2.player2Cruiser[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

    boolean isPlayer2DestroyerSunken() {
        boolean isSunken = true;
        for (int i  = 0; i < Player2.player2Destroyer.length; i++) {
            for (int j = 0; j < Player2.player2Destroyer[i].length; j++) {
                if (Player2.player2Destroyer[i][j] == 79) {
                    isSunken = false;
                    break;
                }
            }
        }
        return isSunken;
    }

}
class Tools {
    public int toolStringToInt(String inputString) {
        int coordinate = -1;
        if ("A".equals(inputString)) {
            coordinate = 0;
        } else if ("B".equals(inputString)) {
            coordinate = 1;
        } else if ("C".equals(inputString)) {
            coordinate = 2;
        } else if ("D".equals(inputString)) {
            coordinate = 3;
        } else if ("E".equals(inputString)) {
            coordinate = 4;
        } else if ("F".equals(inputString)) {
            coordinate = 5;
        } else if ("G".equals(inputString)) {
            coordinate = 6;
        } else if ("H".equals(inputString)) {
            coordinate = 7;
        } else if ("I".equals(inputString)) {
            coordinate = 8;
        } else if ("J".equals(inputString)) {
            coordinate = 9;
        }
        return coordinate;
    }

    void promptEnterKey() {
        System.out.println("Press Enter and pass the move to another player");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    int checkChar(char[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j <array[i].length; j++) {
                if (array[i][j] == 79) {
                    count++;
                }
            }
        }
        return count;
    }
}

package org.example;

public class CinemaApp {
    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS_PER_ROW = 21;

    private int[][][] cinemaSeats;

    public CinemaApp() {
        // Ініціалізація кінотеатру
        cinemaSeats = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (cinemaSeats[hallNumber][row][seat] == 1) {
                System.out.println("Місце " + seat + " в ряду " + row + " у залі " + hallNumber + " вже заброньоване.");
            } else {
                cinemaSeats[hallNumber][row][seat] = 1;
                System.out.println("Місце " + seat + " в ряду " + row + " у залі " + hallNumber + " успішно заброньоване.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            cinemaSeats[hallNumber][row][seat] = 0;
            System.out.println("Скасовано бронювання для місця " + seat + " в ряду " + row + " у залі " + hallNumber + ".");
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            int consecutiveSeats = 0;
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (cinemaSeats[hallNumber][row][seat] == 0) {
                    consecutiveSeats++;
                    if (consecutiveSeats == numSeats) {
                        return true;
                    }
                } else {
                    consecutiveSeats = 0;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Схема розміщення місць для залу " + hallNumber + ":");
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                System.out.print(cinemaSeats[hallNumber][row][seat] + " ");
            }
            System.out.println();
        }
    }


    public int[] findBestAvailable(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            int consecutiveSeats = 0;
            int startSeat = -1;

            for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                if (cinemaSeats[hallNumber][row][seat] == 0) {
                    consecutiveSeats++;

                    if (startSeat == -1) {
                        startSeat = seat;
                    }

                    if (consecutiveSeats == numSeats) {
                        // Повертаємо координати початкового місця
                        return new int[]{row, startSeat};
                    }
                } else {
                    consecutiveSeats = 0;
                    startSeat = -1;
                }
            }
        }

        // Якщо не знайдено, повертаємо null або інше значення, що вказує на відсутність вільних місць
        return null;
    }

    public static void main(String[] args) {
        CinemaApp cinema = new CinemaApp();

        // Приклад використання методів
//        cinema.bookSeats(1, 9, new int[]{5, 6, 7});
        cinema.bookSeats(1, 8, new int[]{0,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
        cinema.cancelBooking(1, 8, new int[]{0,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20});
        cinema.bookSeats(1, 7, new int[]{5});
        cinema.bookSeats(2, 9, new int[]{5});
        cinema.printSeatingArrangement(1);

        cinema.cancelBooking(1, 3, new int[]{6});

        int[] bestAvailable = cinema.findBestAvailable(1, 1);

        if (bestAvailable != null) {
            cinema.bookSeats(1, bestAvailable[0], new int[]{bestAvailable[1], bestAvailable[1] + 1, bestAvailable[1] + 2});
            System.out.println("Найкращі доступні місця були успішно заброньовані.");
        } else {
            System.out.println("Немає вільних місць для бронювання.");
        }

        cinema.printSeatingArrangement(1);
//        cinema.printSeatingArrangement(2);
        boolean isAvailable = cinema.checkAvailability(1, 21);
//        boolean isAvailable_hall_two = cinema.checkAvailability(1, 3);
        System.out.println("Доступність 3 послідовних місць у залі 1: " + isAvailable);
//        System.out.println("Доступність 3 послідовних місць у залі 2: " + isAvailable_hall_two);


    }
}
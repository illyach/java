package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CinemaAppTest {
    private CinemaApp cinema;

    @BeforeEach
    void setUp() {
        cinema = new CinemaApp();
    }

    @AfterEach
    void tearDown() {
        // Додаткові дії по звільненню ресурсів, якщо потрібно
    }

    @Test
    void bookSeats() {
        cinema.bookSeats(1, 8, new int[]{0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        assertTrue(cinema.checkAvailability(1, 17)); // Перевірка, чи заброньовані місця вірно
    }

    @Test
    void cancelBooking() {
        cinema.bookSeats(1, 8, new int[]{0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        cinema.cancelBooking(1, 8, new int[]{5, 6, 7});
        assertFalse(cinema.checkAvailability(1, 3)); // Перевірка, чи вільні місця після скасування бронювання
    }


    @Test
    void checkAvailability() {
        assertTrue(cinema.checkAvailability(1, 21)); // Всі місця у залі 1 повинні бути вільні
    }

    @Test
    void printSeatingArrangement() {
        cinema.bookSeats(1, 8, new int[]{0, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
        cinema.printSeatingArrangement(1); // Друкуємо розміщення місць для залу 1
        // Забезпечте вручну перевірку, оскільки вивід на консоль не легко автоматизувати в юніт-тестах
    }

    @Test
    void findBestAvailable() {
        int[] bestAvailable = cinema.findBestAvailable(1, 3);
        assertNotNull(bestAvailable); // Перевірка, чи знайдено доступні місця
        assertEquals(0, bestAvailable[0]); // Перевірка ряду для найкращих доступних місць
        assertEquals(0, bestAvailable[1]); // Перевірка початкового місця для найкращих доступних місць
    }

}
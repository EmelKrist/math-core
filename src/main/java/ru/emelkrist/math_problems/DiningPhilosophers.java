package ru.emelkrist.math_problems;

import java.util.concurrent.Semaphore;

/**
 * Задача об обедающих философах — классический пример, используемый в информатике
 * для иллюстрации проблем синхронизации при разработке параллельных алгоритмов
 * техник решения этих проблем.
 * <p>
 * link: https://ru.wikipedia.org/wiki/Задача_об_обедающих_философах
 */
public class DiningPhilosophers implements Solable {
    private final String problemName = "Задача об обедающих философах";
    private static final int NUM_PHILOSOPHERS = 5;
    private static Semaphore[] forks = new Semaphore[NUM_PHILOSOPHERS];
    private static Semaphore dining = new Semaphore(NUM_PHILOSOPHERS - 1);
    private int countOfIterations = 3;

    /**
     * Метод для запуска процесса решения проблемы.
     */
    public void solve() {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            final int philosopherId = i;
            new Thread(() -> {
                try {
                    int count = countOfIterations;
                    while (count > 0) {
                        think(philosopherId);
                        eat(philosopherId);
                        count--;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

    /**
     * Метод для запуска процесса "есть".
     *
     * @param philosopherId идентификатор философа
     * @throws InterruptedException исключение прерывания
     */
    private void eat(int philosopherId) throws InterruptedException {
        dining.acquire(); // лимитуруем число обедающих философов

        forks[philosopherId].acquire(); // получаем левую вилку
        forks[(philosopherId + 1) % NUM_PHILOSOPHERS].acquire(); // получаем правую вилку

        System.out.println("Philosopher " + philosopherId + " is eating...");
        Thread.sleep((long) Math.random() * 1000);

        forks[(philosopherId + 1) % NUM_PHILOSOPHERS].release(); // отпускаем правую вилку
        forks[philosopherId].release(); // отпускаем левую вилку

        dining.release(); // позволяем другому философу пообедать
    }

    /**
     * Метод для запуска процесса "думать".
     *
     * @param philosopherId идентификатор философа
     * @throws InterruptedException исключение прерывания
     */
    private void think(int philosopherId) throws InterruptedException {
        System.out.println("Philosopher " + philosopherId + " is thinking...");
        Thread.sleep((long) (Math.random() * 1000));
    }

    public String getProblemName() {
        return problemName;
    }
}

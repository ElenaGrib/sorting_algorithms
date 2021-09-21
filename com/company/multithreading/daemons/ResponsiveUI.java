package com.company.multithreading.daemons;

import java.io.IOException;

/*UnresponsiveUI выполняет вычисления в бесконечном цикле while. Строка чтения с консоли
не будет достигнута.

Чтобы программа реагировала на действия пользователя, вычисления помещаются в run().

Если нажать Enter, то мы увидим, что вычисления выполняются на заднем плане, в то время как программа ожидает
ввода пользователя.
 */

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws IOException {
        ///! new UnresponsiveUI(); //Процесс придется уничтожить
        new ResponsiveUI();
        System.in.read();
        System.out.println(d); //Вывод информации о ходе выполнения
    }
}

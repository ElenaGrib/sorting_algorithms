package com.company.multithreading.exceptions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* случай, если заранее известно, что один обработчик будет использоваться везде,
тогда устанавливаем обработчик неперехваченных исключений по умолчанию,
который задается в стат поле класса Thread.

Этот обработчик вызывается только при отсутствии обработчика неперехваченных исключений
уровня потока. Система проверяет наличие версии уровня потока, а если она не будет найдена - проверяет,
имеется ли у группы потоков специализированный метод uncaughtException(); если его нет -
вызывает defaultUncaughtExceptionHandler
*/
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread2());
    }
}

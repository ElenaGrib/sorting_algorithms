package com.company.classloaders.classloader1;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {

        //Получаем доступ ко всем Properties
        Properties p = System.getProperties();

        //Получаем разделитель, используемый в операционной системе
        String sep = p.getProperty("file.separator");

        //Получаем путь к папке JRE
        String jrePath = p.getProperty("java.home");

        //Выполняем необходимые манипуляции для получения пути к файлу javac (в данном случае javac.exe)
        int lastIndex = jrePath.lastIndexOf(sep);
        String javac = jrePath.substring(0, lastIndex) + sep + "bin" + sep + "javac";
        if (p.getProperty("sun.desktop").equals("ubuntu"))
            javac += ".exe";
        else javac += ".sh";

        //Проверяем, существует ли такой файл (javac.exe)
        File file = new File(javac);
        if (!file.isFile())
            throw new FileNotFoundException("Компилятор по адресу " + file.getAbsolutePath() + " недоступен ");
        System.out.println("Компилируем " + file.getAbsolutePath() + " " + file.getAbsolutePath());

        //Запускаем компилятор javac, чтобы получить байт-код внешнего класса
        Process p1 = Runtime.getRuntime().exec(javac + " " + file.getAbsolutePath());

        //Если javac завершился с ошибкой, выбрасываем Exception (собственный)
        //т.к. нам необходимо было проверять синтаксис класса, который подключался.
        //Таким образом, если возникала ошибка компиляции, то процесс p1 мог вернуть текст
        //ошибки (поток байтов) с помощью функции getErrorStream()
        if (p1.waitFor() != 0)
            try {
                throw new MyClassCompilationException("Ошибка компиляции", p1);
            } catch (MyClassCompilationException e) {
                e.printStackTrace();
                return;
            }

        //Здесь мы уже имеем созданный файл с байт-кодом
        System.out.println("Компиляция завершена");

        //Формируем абсолютный путь к файлу с байт-кодом
        int pointIndex = file.getAbsolutePath().lastIndexOf(".");
        String absulutePatch = file.getAbsolutePath().substring(0, pointIndex);

        //Объявляем MyClassLoader. Класс ClassLoader является абстрактным
        //поэтому необходимо его переопределить (каким образом, будет показано ниже)
        MyClassLoader loader = new MyClassLoader();

        //Объявляем переменную типа Class
        Class cl = loader.findClass(absulutePatch);
        System.out.println(cl);

        //Получаем метод m1 из загруженного класса
        Method method = cl.getMethod("m1", new Class[]{String.class, int.class});
        System.out.println(method);

        //Выполняем метод m1. Нельзя забывать про метод newInstance(), если метод динамический
        method.invoke(cl.newInstance(), new Object[]{"Test", 8});

        //Выполняем метод m2. Он статический, поэтому newInstance() в методе invoke писать не надо
        Method method2 = cl.getMethod("m2", new Class[]{String.class});
        method2.invoke(cl, "QWERRTY");
    }

}

package Lab2_Reflection;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    private static Object[] generateArguments(Class<?>[] argTypes) {
        Object[] params = new Object[argTypes.length];

        for (int i = 0; i < argTypes.length; i++) {
            if (argTypes[i].equals(int.class) || argTypes[i].equals(Integer.class)) {
                params[i] = 10;
            } else if (argTypes[i].equals(double.class) || argTypes[i].equals(Double.class)) {
                params[i] = 11.2;
            } else if (argTypes[i].equals(float.class) || argTypes[i].equals(Float.class)) {
                params[i] = 10.7f;
            } else if (argTypes[i].equals(boolean.class) || argTypes[i].equals(Boolean.class)) {
                params[i] = true;
            } else if (argTypes[i].equals(char.class) || argTypes[i].equals(Character.class)) {
                params[i] = 'l';
            } else if(argTypes[i].equals(String.class)) {
                params[i] = "String";
            } else params[i] = null;
        }
        return params;
    }


    public static void main(String[] args) {
        System.out.println();
        MyClass myClass = new MyClass();

        // Получаем закрытые и защищенные методы с помощью рефлексии
        Class<?> clazz = myClass.getClass();
        Method[] methods = clazz.getDeclaredMethods();

        // Проход по всем методам
        for (Method method : methods) {
            // Проверка наличия аннотации и типа метода
            if (method.isAnnotationPresent(Annotation.class)) {
                // Получение значения параметра аннотации
                Annotation annotation = method.getAnnotation(Annotation.class);
                int value = annotation.value();

                // Вызов метода указанное количество раз
                for (int i = 0; i < value; i++) {
                    method.setAccessible(true); // Установка доступа к приватному методу
                    try {
                        if (method.getParameterCount() > 0) {
                            Object[] params = generateArguments(method.getParameterTypes());
                            method.invoke(myClass, params);// Передача параметра
                        } else {
                            method.invoke(myClass);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                        //IllegalAccessException - если доступ к методу запрещен из-за его модификаторов доступа
                        //InvocationTargetException - исключение оборачивает другие исключения, которые могли возникнуть внутри вызываемого метода
                    }
                }
                System.out.println();
            }
        }
    }
}








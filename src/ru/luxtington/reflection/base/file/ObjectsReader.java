package ru.luxtington.reflection.base.file;

import static ru.luxtington.reflection.base.other.Reflector.findEmptyConstructorIndex;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ObjectsReader<T> {
    private final String fileName;

    public ObjectsReader(String fileName) {
        this.fileName = fileName;
    }

    public List<T> loadObjectsFromFile() throws Exception {
        File f = new File(fileName);
        List<T> res = new ArrayList<>();

        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()){
            res.add(createObjectFromLine(scanner.nextLine()));
        }
        return res;
    }

    private T createObjectFromLine(String line) throws Exception {
        Class<T> cl = (Class<T>) Class.forName(line.substring(0, line.indexOf('{')));

        int emptyConstructorIndex = findEmptyConstructorIndex(cl);

        // 50/50 while 0 index
        T obj = (T) cl.getDeclaredConstructors()[emptyConstructorIndex].newInstance();

        List<String> objectParams = List.of(
                line.substring(line.indexOf('{') + 1, line.lastIndexOf('}')).split(",")
        );


        for (String p : objectParams){
            List<String> pair = List.of(p.split("=")); // pair: key = value
            String fieldName = pair.get(0).trim();
            String fieldVal = pair.get(1).trim();

            Field field = cl.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, convertToFieldType(field.getType(), fieldVal));
            //field.setAccessible(false);
        }

        return obj;
    }

    // плохо, нет гибкости, непримитивы ?
    private Object convertToFieldType(Class<?> fieldType, String paramValue) throws Exception {
        if (fieldType.equals(String.class)) {
            return paramValue;
        }
        if (fieldType.equals(int.class) || fieldType.equals(Integer.class))
            return Integer.parseInt(paramValue);
        else if (fieldType.equals(double.class) || fieldType.equals(Double.class))
            return Double.parseDouble(paramValue);
        else if (fieldType.equals(boolean.class) || fieldType.equals(Boolean.class))
            return Boolean.parseBoolean(paramValue);
        else if (fieldType.equals(long.class) || fieldType.equals(Long.class))
            return Long.parseLong(paramValue);
        else if (fieldType.equals(float.class) || fieldType.equals(Float.class))
            return Float.parseFloat(paramValue);

        throw new IllegalArgumentException("Unknown parameter's type");
    }
}

package ru.luxtington.reflection.base.other;

import ru.luxtington.annotations.ToString;
import ru.luxtington.annotations.ToStringOption;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Entity {
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(getClass().getSimpleName() + " { ");

        Class<?> currCl = getClass();

        while (currCl != null) {
            try {
                collectFields(currCl, res);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            currCl = currCl.getSuperclass();
        }
        res.delete(res.length() - 1, res.length());
        res.append(" }");
        return res.toString();
    }

    public final void collectFields(Class<?> cl, StringBuilder sb) throws Exception {
        List<Field> fields = List.of(cl.getDeclaredFields());
        if (!cl.isAnnotationPresent(ToString.class) || (cl.isAnnotationPresent(ToString.class) && cl.getAnnotation(ToString.class).value() == ToStringOption.YES)){
            for (Field f : fields){
                f.setAccessible(true);
                if (!f.isAnnotationPresent(ToString.class) || (f.isAnnotationPresent(ToString.class) && f.getAnnotation(ToString.class).value() == ToStringOption.YES)){
                    sb.append(f.getName() + "=" + f.get(this) + ",");
                    f.setAccessible(false);
                }
            }
        } else {
            for (Field f : fields){
                f.setAccessible(true);
                if (f.isAnnotationPresent(ToString.class) && f.getAnnotation(ToString.class).value() == ToStringOption.YES){
                    sb.append(f.getName() + "=" + f.get(this) + ",");
                }
                f.setAccessible(false);
            }
        }
    }
}

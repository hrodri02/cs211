import java.lang.reflect.Field;

public class SizeValidator {
    public static void validate(Object object) {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                field.setAccessible(true);
                try {
                    Object value = field.get(object);
                    if (value instanceof String str) {
                        int len = str.length();
                        if (len < size.min() || len > size.max()) {
                            System.out.println("Validation failed on field '" + field.getName() + "': " + size.message());
                        }
                    }
                } catch (IllegalAccessException e) {
                    System.out.println("Could not access field: " + field.getName());
                }
            }
        }
    }
}

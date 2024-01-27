package io.github.asapin;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

class SimpleClass {
    private final String field;

    public SimpleClass(final String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }

    @Override
    public String toString() {
        return "SimpleClass{" +
                "field='" + field + '\'' +
                '}';
    }
}

@Data
class LombokClass {
    private final String field;
}

@Data
@Builder
class LombokBuilderClass {
    private final String field;
}

@Data
@Builder
class LombokBuilderWithAnnotationClass {
    @NonNull
    private final String field;
}

public class Main {
    public static void main(String[] args) {
        simpleClass();
        lombokClass();
        lombokBuilderClass();
        lombokBuilderWithAnnotationClass();
    }

    private static void simpleClass() {
        // Uncommenting this line will prevent the project from compiling. Expected behavior
//        SimpleClass object = new SimpleClass(null);
        SimpleClass object = new SimpleClass("value");
        System.out.println(object);
    }

    private static void lombokClass() {
        // Uncommenting this line will prevent the project from compiling. Expected behavior
//        LombokClass object = new LombokClass(null);
        LombokClass object = new LombokClass("value");
        System.out.println(object);
    }

    private static void lombokBuilderClass() {
        // Constructed object has null in its field. Unexpected behavior
        LombokBuilderClass object = LombokBuilderClass.builder().build();
        System.out.println(object);
    }

    private static void lombokBuilderWithAnnotationClass() {
        // This throws NullPointerException in runtime. Unexpected behavior
        LombokBuilderWithAnnotationClass object = LombokBuilderWithAnnotationClass.builder().build();
        System.out.println(object);
    }
}
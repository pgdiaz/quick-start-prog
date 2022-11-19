package ao2.punto2.dominio;

import java.util.Objects;
import java.util.stream.Stream;

public enum Talle {

    S, M, L, XL;

    public static Talle of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException("El talle no puede ser nulo");
        }

        return Stream.of(values())
                .filter(item -> item.name().equals(value.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("El valor del talle es incorrecto"));
    }

}

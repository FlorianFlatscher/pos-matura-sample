package at.spengergasse.ft2021pos1.part1.support;


import java.util.function.Function;
import java.util.function.Supplier;

public interface ArgumentSupport {

    static <T, R> Function<T, R> functionalArgument(Function<T, R> function) {
        return function;
    }

    static <T> Supplier<T> supplierArgument(Supplier<T> supplier) {
        return supplier;
    }

}

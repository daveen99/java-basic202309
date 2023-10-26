package day11.lambda;

@FunctionalInterface
public interface GenericFunction<X, Y> {

    // X에서 Y를 추출해주는 동작
    Y apply(X x);
}

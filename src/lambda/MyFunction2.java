package lambda;
@FunctionalInterface
public interface MyFunction2<T,R> {
    public R Handle(T t1,T t2);
}

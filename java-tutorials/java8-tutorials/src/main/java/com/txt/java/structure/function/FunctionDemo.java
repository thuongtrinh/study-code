package com.txt.java.structure.function;

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.ToDoubleBiFunction;

public class FunctionDemo {

    public static void main(String[] args) {
        // Function<T,R>
        System.out.println("------Function<T,R>------");
        Function<Integer, String> ob = new Function<Integer, String>() {
            @Override
            public String apply(Integer t) {
                return "Age:" + t;
            }
        };
        // ob = f1 -> "Age:" + f1;
        System.out.println(ob.apply(20));


        // DoubleFunction<R>
        System.out.println("\n------DoubleFunction<R>------");
        DoubleFunction<String> df = d -> String.valueOf(d * 2.3);
        System.out.println(df.apply(3.7));


        // DoubleToIntFunction
        System.out.println("\n------DoubleToIntFunction------");
        DoubleToIntFunction obd = new DoubleToIntFunction() {

            @Override
            public int applyAsInt(double d) {
                return new Double(2.3 * d).intValue();
            }
        };
        // obd = f -> new Double(f*2.3).intValue();

        System.out.println(obd.applyAsInt(3.7));


        // DoubleToLongFunction
        System.out.println("\n------DoubleToLongFunction------");
        DoubleToLongFunction obl = f -> new Double(f * 2.3).longValue();
        System.out.println(obl.applyAsLong(3.7));


        // IntFunction<R>
        System.out.println("\n------IntFunction<R>------");
        IntFunction<Integer> obi = f -> f * f;
        System.out.println(obi.apply(3));


        // IntToDoubleFunction
        System.out.println("\n------IntToDoubleFunction------");
        IntToDoubleFunction obid = f -> f * f;
        System.out.println(obid.applyAsDouble(3));


        // IntToLongFunction
        System.out.println("\n------IntToLongFunction------");
        IntToLongFunction obil = f -> f * f;
        System.out.println(obil.applyAsLong(2));

        // LongFunction<R>
        // LongToDoubleFunction
        // LongToIntFunction


        // ToDoubleBiFunction<T,U>
        System.out.println("\n------ToDoubleBiFunction<T,U>------");
        ToDoubleBiFunction<Integer, Integer> obdb = new ToDoubleBiFunction<Integer, Integer>() {

            @Override
            public double applyAsDouble(Integer t, Integer u) {
                return t + u;
            }
        };
        // obdb = (t, u) -> t + u;

        System.out.println(obdb.applyAsDouble(10, 3));


        // ToDoubleFunction<T>
        // ToIntBiFunction<T,U>
        // ToIntFunction<T>
        // ToLongBiFunction<T,U>
        // ToLongFunction<T>
    }
}

package pl.kiminoboku.topg;

import scala.Tuple2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SortOrderCrawler<T> {

    private final ArrayList<T> input;

    public SortOrderCrawler(Collection<T> collection) {
        input = new ArrayList<>(collection);
    }

    public List<Tuple2<T, T>> comparePairs() {
        List<Tuple2<T, T>> result = new ArrayList<>();
        int targetSize = size();
        while (result.size() < targetSize) {
            Tuple2<T, T> latestLegitTuple = null;
            mainLoop:
            for (int i = 0; i < input.size(); ++i) {
                for (int j = i + 1; j < input.size(); ++j) {
                    T t1 = input.get(i);
                    T t2 = input.get(j);
                    Tuple2<T, T> newTuple = Tuple2.<T, T>apply(t1, t2);
                    if (result.contains(newTuple)) {
                        continue;
                    }
                    latestLegitTuple = newTuple;
                    if (!result.isEmpty()) {
                        Tuple2<T, T> lastTuple = result.get(result.size() - 1);
                        if(lastTuple._1.equals(latestLegitTuple._1) || lastTuple._1.equals(latestLegitTuple._2) || lastTuple._2.equals(latestLegitTuple._1) || lastTuple._2.equals(latestLegitTuple._2)) {
                            continue;
                        }
                    }
                    break mainLoop;
                }
            }

            result.add(latestLegitTuple);
        }
        return result;
    }

    int size() {
        return factorial(input.size());
    }

    private int factorial(int factorial) {
        int result = 1;
        for (int i = 1; i <= factorial; ++i) {
            result *= i;
        }
        return result;
    }
}

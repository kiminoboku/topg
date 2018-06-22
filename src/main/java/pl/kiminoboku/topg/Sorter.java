package pl.kiminoboku.topg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sorter<T> {
    private Map<T, Node<T>> rootNodes = new HashMap<>();

    private class Node<T> {
        T value;
        List<Node<T>> lowerNodes = new ArrayList<>();
    }
}

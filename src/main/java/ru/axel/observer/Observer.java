package ru.axel.observer;

import java.util.ArrayList;
import java.util.List;

public class Observer<T> {
    T value;
    final List<UpdateMethod<T>> observeMethods = new ArrayList<>();

    public Observer(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;

        observeMethods.forEach(action -> {
            action.invoke(this.value);
        });
    }

    public void postUpdate(UpdateMethod<T> updateMethod) {
        observeMethods.add(updateMethod);
    }
}

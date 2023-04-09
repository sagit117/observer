package ru.axel.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observer<T> {
    T value;
    final List<UpdateMethod<T>> observeMethods = new ArrayList<>();

    protected Observer(T value) {
        setValue(value);
    }
    protected Observer(T value, UpdateMethod<T> updateMethod) {
        postUpdate(updateMethod);
        setValue(value);
    }

    protected T getValue() {
        return value;
    }
    protected void setValue(T value) {
        this.value = value;

        observeMethods.forEach(action -> {
            action.invoke(this.value);
        });
    }

    protected void postUpdate(UpdateMethod<T> updateMethod) {
        observeMethods.add(updateMethod);
    }
}

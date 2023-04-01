package ru.axel.observer;

public interface UpdateMethod<T> {
    void invoke(T currentValue);
}

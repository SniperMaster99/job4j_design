package ru.job4j.generics;

import java.util.ArrayList;
import java.util.List;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        int indicator = findIndexById(id);
        if(mem.get(indicator).getId().equals(id)) {
            mem.set(indicator, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        int indicator = findIndexById(id);
        if(mem.get(indicator).getId().equals(id)) {
            mem.remove(indicator);
            return true;
        }
        return false;
    }

    @Override
    public T findById(String id) {
        for (T element : mem) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }

    public int findIndexById(String id) {
        for (int index = 0; index < mem.size(); index++) {
            if(mem.get(index).getId().equals(id)) {
                return index;
            }
        }
        return -1;
    }
}
package project.repositories;

import project.repositories.exception.UndefinedEntityException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Repository<T> {
    private final Map<Integer, T> cache = new HashMap<>();

    protected void add(int id, T entity) {
        cache.put(id, entity);
    }

    protected void remove(int id) {
        cache.remove(id);
    }

    public List<T> all() {
        return List.copyOf(cache.values());
    }

    public T get(int id) {
        return Optional.of(cache.get(id)).orElseThrow(UndefinedEntityException::new);
    }
}

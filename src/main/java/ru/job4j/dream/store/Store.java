package ru.job4j.dream.store;

import ru.job4j.dream.model.Post;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Store {
    private static final Store INST = new Store();
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private Store() {
        posts.put(1, new Post(1, "Junior Java Job",
                "Basic hard skills needed",
                LocalDateTime.of(2021, 12, 11, 12, 30)));
        posts.put(2, new Post(2, "Middle Java Job",
                "Advanced hard skills needed",
                LocalDateTime.of(2021, 10, 1, 12, 0)));
        posts.put(3, new Post(3, "Senior Java Job",
                "Advanced hard and strong soft skills needed",
                LocalDateTime.of(2021, 6, 11, 12, 30)));
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAll() {
        return posts.values();
    }
}

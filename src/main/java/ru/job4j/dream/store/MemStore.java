package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.servlet.User;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store {
    private static final MemStore INST = new MemStore();
    private static final AtomicInteger POST_ID = new AtomicInteger(4);
    private static final AtomicInteger CANDIDATE_ID = new AtomicInteger(4);
    private static final AtomicInteger USER_ID = new AtomicInteger(4);
    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();
    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private MemStore() {
        posts.put(1, new Post(1, "Junior Java Job",
                "Basic hard skills needed",
                LocalDateTime.of(2021, 12, 11, 12, 30)));
        posts.put(2, new Post(2, "Middle Java Job",
                "Advanced hard skills needed",
                LocalDateTime.of(2021, 10, 1, 12, 0)));
        posts.put(3, new Post(3, "Senior Java Job",
                "Advanced hard and strong soft skills needed",
                LocalDateTime.of(2021, 6, 11, 12, 30)));
        candidates.put(1, new Candidate(1, "Junior Java"));
        candidates.put(2, new Candidate(2, "Middle Java"));
        candidates.put(3, new Candidate(3, "Senior Java"));
        User admin = new User();
        admin.setId(1);
        admin.setEmail("root@local");
        admin.setName("Admin");
        admin.setPassword("root");
        users.put(1, admin);
    }

    public static MemStore instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }

    public void save(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public Candidate findCandidateById(int id) {
        return candidates.get(id);
    }

    public void deletePost(int id) {
        posts.remove(id);
    }

    public void deleteCandidate(int id) {
        candidates.remove(id);
    }

    @Override
    public void addUser(User user) {
        user.setId(USER_ID.incrementAndGet());
        users.put(user.getId(), user);
    }

    @Override
    public User findByEmail(String email) {
        User result = null;
        for (int id : users.keySet()) {
            User user = users.get(id);
            if (user.getEmail().equals(email)) {
                result = user;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<City> findAllCities() {
        return null;
    }

    @Override
    public Collection<Post> findLastPosts() {
        return null;
    }

    @Override
    public Collection<Candidate> findLastCandidates() {
        return null;
    }
}

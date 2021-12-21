package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.City;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.servlet.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    Collection<City> findAllCities();

    Collection<Post> findLastPosts();

    Collection<Candidate> findLastCandidates();

    void save(Post post);

    void save(Candidate candidate);

    Post findById(int id);

    Candidate findCandidateById(int id);

    void deleteCandidate(int id);

    void deletePost(int id);

    void addUser(User user);

    User findByEmail(String email);
}

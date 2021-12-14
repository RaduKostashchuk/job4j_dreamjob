package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class MainStore {
    public static void main(String[] args) {
        Store store = DbStore.instOf();
        store.save(new Post(0, "Java Job Offer"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        store.save(new Post(7, "Junior Java Job Offer"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post);
        }
        System.out.println(store.findById(7));

        store.save(new Candidate(0, "Java Candidate"));
        for (Candidate can: store.findAllCandidates()) {
            System.out.println(can);
        }
        store.save(new Candidate(1, "Junior Java Candidate"));
        for (Candidate can: store.findAllCandidates()) {
            System.out.println(can);
        }
        System.out.println(store.findCandidateById(1));

    }
}

package ru.job4j.dream.store;

import org.junit.Test;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DbStoreTest {

    @Test
    public void whenFindAllPosts() {
        Store store = DbStore.instOf();
        Post post1 = new Post(0, "Java Job 1");
        Post post2 = new Post(0, "Java Job 2");
        List<Post> expected = List.of(post1, post2);
        store.save(post1);
        store.save(post2);
        assertThat(store.findAllPosts(), is(expected));
        store.deletePost(post1.getId());
        store.deletePost(post2.getId());
    }

    @Test
    public void whenCreatePost() {
        Store store = DbStore.instOf();
        Post post = new Post(0, "Java Job");
        store.save(post);
        Post postInDb = store.findById(post.getId());
        assertThat(postInDb.getName(), is(post.getName()));
        store.deletePost(post.getId());
    }

    @Test
    public void whenCreateCandidate() {
        Store store = DbStore.instOf();
        Candidate candidate = new Candidate(0, "Junior");
        store.save(candidate);
        Candidate candidateFromDb = store.findCandidateById(candidate.getId());
        assertThat(candidateFromDb.getName(), is(candidate.getName()));
        store.deleteCandidate(candidate.getId());
    }

    @Test
    public void whenFindAllCandidates() {
        Store store = DbStore.instOf();
        Candidate can1 = new Candidate(0, "Junior");
        Candidate can2 = new Candidate(0, "Middle");
        List<Candidate> expected = List.of(can1, can2);
        store.save(can1);
        store.save(can2);
        assertThat(store.findAllCandidates(), is(expected));
        store.deleteCandidate(can1.getId());
        store.deleteCandidate(can2.getId());
    }

}
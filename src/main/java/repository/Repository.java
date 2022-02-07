package repository;

import domain.Issue;

import java.util.ArrayList;
import java.util.Collection;

public class Repository {
    Collection<Issue> problems = new ArrayList<>();

    public void save(Issue problem) {
        problems.add(problem);
    }

    public void saveAll(Collection <Issue> problems) {
        this.problems.addAll(problems);
    }

    public Collection<Issue> getAll() {
        return problems;
    }

    public Issue findById(int id) {
        for (Issue problem : problems){
            if (problem.getId() == id) {
                return problem;
            }
        }
        return null;
    }
}

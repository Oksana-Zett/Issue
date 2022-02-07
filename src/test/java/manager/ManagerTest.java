package manager;

import domain.Issue;
import exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Issue problem1 = new Issue(1, "Ivanov", "dependencies", "Petrov", true);
    Issue problem2 = new Issue(2, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue problem3 = new Issue(3, "Ivanov", "dependencies", "Petrov", true);
    Issue problem4 = new Issue(4, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue problem5 = new Issue(5, "Ivanov", "dependencies", "Petrov", true);
    Issue problem6 = new Issue(6, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue problem7 = new Issue(7, "Ivanov", "dependencies", "Petrov", true);
    Issue problem8 = new Issue(8, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue problem9 = new Issue(9, "Ivanov", "dependencies", "Petrov", true);
    Issue problem10 = new Issue(10, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue problem11 = new Issue(11, "Ivanov", "dependencies", "Petrov", true);
    Issue problem12 = new Issue(12, "Sidorov", "up-for-grabs", "Orlov", false);
    Issue[] issues = new Issue[]{problem1, problem2, problem3, problem4, problem5, problem6, problem7, problem8, problem9, problem10, problem11, problem12};
    Issue[] issuesOpen = new Issue[]{problem1, problem3, problem5, problem7, problem9, problem11};
    Issue[] issuesClose = new Issue[]{problem2, problem4, problem6, problem8, problem10, problem12};
    Issue[] issuesLabel1 = new Issue[]{problem1, problem3, problem5, problem7, problem9, problem11};
    Issue[] issuesNameAssignee1 = new Issue[]{problem2, problem4, problem6, problem8, problem10, problem12};
    Issue[] issuesNameAuthor1 = new Issue[]{problem2, problem4, problem6, problem8, problem10, problem12};


    @Test
    void shouldAddOneIssue() {
        manager.add(problem1);

        Issue expected = problem1;
        Issue actual = repo.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddSomeIssues() {
        Collection<Issue> problems = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = problems;
        Collection<Issue> actual = repo.getAll();
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowListOpenIssue() {
        Collection<Issue> problems = new ArrayList<>();
        Collection<Issue> openIssue = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        for (Issue issue : issuesOpen) {
            openIssue.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = openIssue;
        Collection<Issue> actual = manager.showListOpenIssue();
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowListCloseIssue() {
        Collection<Issue> problems = new ArrayList<>();
        Collection<Issue> closeIssue = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        for (Issue issue : issuesClose) {
            closeIssue.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = closeIssue;
        Collection<Issue> actual = manager.showListCloseIssue();
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowFilterLabel() {
        Collection<Issue> problems = new ArrayList<>();
        Collection<Issue> label1Issue = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        for (Issue issue : issuesLabel1) {
            label1Issue.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = label1Issue;
        Collection<Issue> actual = manager.showFilterLabel("dependencies");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowFilterNameAssignee() {
        Collection<Issue> problems = new ArrayList<>();
        Collection<Issue> NameAssignee1Issue = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        for (Issue issue : issuesNameAssignee1) {
            NameAssignee1Issue.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = NameAssignee1Issue;
        Collection<Issue> actual = manager.showFilterNameAssignee("Orlov");
        assertEquals(expected, actual);
    }

    @Test
    void shouldShowFilterNameAuthor() {
        Collection<Issue> problems = new ArrayList<>();
        Collection<Issue> NameAuthor1Issue = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        for (Issue issue : issuesNameAuthor1) {
            NameAuthor1Issue.add(issue);
        }
        manager.addAll(problems);
        Collection<Issue> expected = NameAuthor1Issue;
        Collection<Issue> actual = manager.showFilterNameAuthor("Sidorov");
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenCloseIssueById() {
        Collection<Issue> problems = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        manager.addAll(problems);
        boolean expected = false;
        manager.OpenCloseIssueById(1, false);
        boolean actual = problem1.isOpenClose();
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenCloseIssueByIdNotExist() {
        Collection<Issue> problems = new ArrayList<>();
        for (Issue issue : issues) {
            problems.add(issue);
        }
        manager.addAll(problems);
        Assertions.assertThrows(NotFoundException.class, () -> {
            manager.OpenCloseIssueById(13, false);
        });
    }
}
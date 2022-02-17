package manager;

import domain.Issue;
import exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repository.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Manager manager = new Manager(repo);
    Set label1 = new HashSet();
    Set label2 = new HashSet();
    String labelName1 = "dependencies";
    String labelName2 = "up-for-grabs";
    String labelName3 = "Mozilla";
    String labelName4 = "Opera";

    Issue problem1 = new Issue(1, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem2 = new Issue(2, "Sidorov", (HashSet) label2, "Orlov", false);
    Issue problem3 = new Issue(3, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem4 = new Issue(4, "Sidorov", (HashSet) label2, "Orlov", false);
    Issue problem5 = new Issue(5, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem6 = new Issue(6, "Sidorov", (HashSet) label2, "Orlov", false);
    Issue problem7 = new Issue(7, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem8 = new Issue(8, "Sidorov", (HashSet) label2, "Orlov", false);
    Issue problem9 = new Issue(9, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem10 = new Issue(10, "Sidorov", (HashSet) label2, "Orlov", false);
    Issue problem11 = new Issue(11, "Ivanov", (HashSet) label1, "Petrov", true);
    Issue problem12 = new Issue(12, "Sidorov", (HashSet) label2, "Orlov", false);
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
        label1.add(labelName1);
        label1.add(labelName2);
        label2.add(labelName3);
        label2.add(labelName4);

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
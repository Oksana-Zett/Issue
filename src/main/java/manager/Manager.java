package manager;

import domain.Issue;
import exception.NotFoundException;
import repository.Repository;

import java.util.Collection;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public void add (Issue problem) {
        repo.save(problem);
    }

    public void addAll (Collection <Issue> problems) {
        repo.saveAll(problems);
    }

    public Collection<Issue> showListOpenIssue() {
        Collection<Issue> showListOpenIssue = repo.getAll();
        showListOpenIssue.removeIf(e -> e.isOpenClose() == false);
        return showListOpenIssue;
    }

    public Collection<Issue> showListCloseIssue() {
        Collection<Issue> showListCloseIssue = repo.getAll();
        showListCloseIssue.removeIf(e -> e.isOpenClose() == true);
        return showListCloseIssue;
    }

    public Collection<Issue> showFilterLabel(String label) {
        Collection<Issue> showFilterLabel = repo.getAll();
        showFilterLabel.removeIf(e -> e.getLabel() != label);
        return showFilterLabel;
    }

    public Collection<Issue> showFilterNameAssignee(String nameAssignee) {
        Collection<Issue> showFilterNameAssignee = repo.getAll();
        showFilterNameAssignee.removeIf(e -> e.getNameAssignee() != nameAssignee);
        return showFilterNameAssignee;
    }

    public Collection<Issue> showFilterNameAuthor(String nameAuthor) {
        Collection<Issue> showFilterNameAuthor = repo.getAll();
        showFilterNameAuthor.removeIf(e -> e.getNameAuthor() != nameAuthor);
        return showFilterNameAuthor;
    }

    public void OpenCloseIssueById(int id, boolean status) {
        if (repo.findById(id)==null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        repo.findById(id).setOpenClose(status);
    }


}

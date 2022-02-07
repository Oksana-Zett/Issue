package domain;

public class Issue {
    private int id;
    private String nameAuthor;
    private String label;
    private String nameAssignee;
    private boolean openClose; //когда true - открытый Issue, когда false - закрытый

    public Issue(int id, String nameAuthor, String label, String nameAssignee, boolean openClose) {
        this.id = id;
        this.nameAuthor = nameAuthor;
        this.label = label;
        this.nameAssignee = nameAssignee;
        this.openClose = openClose;
    }

    public Issue() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String nameAuthor) {
        this.nameAuthor = nameAuthor;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getNameAssignee() {
        return nameAssignee;
    }

    public void setNameAssignee(String nameAssignee) {
        this.nameAssignee = nameAssignee;
    }

    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }
}

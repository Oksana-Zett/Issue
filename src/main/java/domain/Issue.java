package domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Issue  {
    private int id;
    private String nameAuthor;
    private Set label=new HashSet();
    private String nameAssignee;
    private boolean openClose; //когда true - открытый Issue, когда false - закрытый

    public Issue(int id, String nameAuthor, HashSet label, String nameAssignee, boolean openClose) {
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


    public String getNameAuthor() {
        return nameAuthor;
    }

    public Collection getLabel() {
        return label;
    }
    public void setLabel(HashSet label) {
       this.label = label;
    }

    public String getNameAssignee() {
        return nameAssignee;
    }


    public boolean isOpenClose() {
        return openClose;
    }

    public void setOpenClose(boolean openClose) {
        this.openClose = openClose;
    }
}

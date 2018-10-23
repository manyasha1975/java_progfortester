package ru.mytest.addressbook;

public class GroupData {
    private final String grname;
    private final String grheader;
    private final String grfooter;

    public GroupData(String grname, String grheader, String grfooter) {
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
    }

    public String getGrname() {
        return grname;
    }

    public String getGrheader() {
        return grheader;
    }

    public String getGrfooter() {
        return grfooter;
    }
}

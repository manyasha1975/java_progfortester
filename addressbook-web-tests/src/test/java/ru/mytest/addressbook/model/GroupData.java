package ru.mytest.addressbook.model;

import java.util.Objects;

public class GroupData {
    private int grid;
    private final String grname;
    private final String grheader;
    private final String grfooter;

    public GroupData(String grname, String grheader, String grfooter) {
        this.grid = Integer.MAX_VALUE;
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
    }

    public GroupData(int grid, String grname, String grheader, String grfooter) {
        this.grid = grid;
        this.grname = grname;
        this.grheader = grheader;
        this.grfooter = grfooter;
    }

    public int getGrid() {
        return grid;
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

    public void setGrid(int grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "grid=" + grid +
                ", grname='" + grname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return Objects.equals(grname, groupData.grname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grname);
    }
}

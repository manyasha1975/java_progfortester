package ru.mytest.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group") //set name for tag, more convenient name
public class GroupData {
    @XStreamOmitField //miss this field in xml file
    private int grid = Integer.MAX_VALUE;
    @XStreamAlias("name") //set name for tag
    @Expose //include this field in json file
    private String grname;
    @Expose //include this field in json file
    @XStreamAlias("header") //set name for tag
    private String grheader;
    @Expose //include this field in json file
    @XStreamAlias("footer") //set name for tag
    private String grfooter;

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

    public GroupData withId(int grid) {
        this.grid = grid;
        return this;
    }

    public GroupData withName(String grname) {
        this.grname = grname;
        return this;
    }

    public GroupData withHeader(String grheader) {
        this.grheader = grheader;
        return this;
    }

    public GroupData withFooter(String grfooter) {
        this.grfooter = grfooter;
        return this;
    }

    @Override
    public String toString() {
        return "GroupData{" +    //we see in report these data, we can change it and add other parameters, header or footer
                "grid=" + grid +
                ", grname='" + grname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData groupData = (GroupData) o;
        return grid == groupData.grid &&
                Objects.equals(grname, groupData.grname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(grid, grname);
    }
}

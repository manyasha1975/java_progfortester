package ru.mytest.mantis.model;

public class Issue {

  private int id;
  private String summary;
  private String description;
  private Project project;

  public int getId() {
    return id;
  }

  public String getSummary() {
    return summary;
  }

  public String getDescription() {
    return description;
  }

  public Project getProject() {
    return project;
  }

  public Issue withId(int id) {
    this.id = id;
    return this;
  }

  public Issue withSummary(String summary) {
    this.summary = summary;
    return this;
  }

  public Issue withDescription(String description) {
    this.description = description;
    return this;
  }

  @Override
  public String toString() {
    return "Issue{" +
            "id=" + id +
            ", summary='" + summary + '\'' +
            ", description='" + description + '\'' +
            ", project=" + project +
            '}';
  }

  public Issue withProject(Project project) {
    this.project = project;
    return this;
  }
}

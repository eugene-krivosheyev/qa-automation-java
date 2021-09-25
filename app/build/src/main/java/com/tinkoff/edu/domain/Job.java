package com.tinkoff.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Job.
 */
@Entity
@Table(name = "job")
public class Job implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "job_title", length = 50, nullable = false, unique = true)
    private String jobTitle;

    @NotNull
    @DecimalMin(value = "12792")
    @Column(name = "min_salary", precision = 21, scale = 2, nullable = false)
    private BigDecimal minSalary;

    @Column(name = "max_salary", precision = 21, scale = 2)
    private BigDecimal maxSalary;

    @ManyToMany
    @JoinTable(name = "rel_job__task", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    @JsonIgnoreProperties(value = { "jobs" }, allowSetters = true)
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "jobs", "manager", "department" }, allowSetters = true)
    private Employee employee;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Job id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public Job jobTitle(String jobTitle) {
        this.setJobTitle(jobTitle);
        return this;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public BigDecimal getMinSalary() {
        return this.minSalary;
    }

    public Job minSalary(BigDecimal minSalary) {
        this.setMinSalary(minSalary);
        return this;
    }

    public void setMinSalary(BigDecimal minSalary) {
        this.minSalary = minSalary;
    }

    public BigDecimal getMaxSalary() {
        return this.maxSalary;
    }

    public Job maxSalary(BigDecimal maxSalary) {
        this.setMaxSalary(maxSalary);
        return this;
    }

    public void setMaxSalary(BigDecimal maxSalary) {
        this.maxSalary = maxSalary;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Job tasks(Set<Task> tasks) {
        this.setTasks(tasks);
        return this;
    }

    public Job addTask(Task task) {
        this.tasks.add(task);
        task.getJobs().add(this);
        return this;
    }

    public Job removeTask(Task task) {
        this.tasks.remove(task);
        task.getJobs().remove(this);
        return this;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Job employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Job)) {
            return false;
        }
        return id != null && id.equals(((Job) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Job{" +
            "id=" + getId() +
            ", jobTitle='" + getJobTitle() + "'" +
            ", minSalary=" + getMinSalary() +
            ", maxSalary=" + getMaxSalary() +
            "}";
    }
}

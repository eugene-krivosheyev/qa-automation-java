package com.tinkoff.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * A Employee.
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "last_name", length = 50, nullable = false)
    private String lastName;

    @NotNull
    @Size(min = 5, max = 100)
    @Pattern(regexp = "^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(min = 5, max = 12)
    @Pattern(regexp = "^([+]?[\\s0-9]+)?(\\d{3}|[(]?[0-9]+[)])?([-]?[\\s]?[0-9])+$")
    @Column(name = "phone", length = 12, nullable = false, unique = true)
    private String phone;

    @NotNull
    @Column(name = "hire_date", nullable = false)
    private Instant hireDate;

    @Column(name = "salary", precision = 21, scale = 2)
    private BigDecimal salary;

    @OneToMany(mappedBy = "employee")
    @JsonIgnoreProperties(value = { "tasks", "employee" }, allowSetters = true)
    private Set<Job> jobs = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "jobs", "manager", "department" }, allowSetters = true)
    private Employee manager;

    @ManyToOne
    @JsonIgnoreProperties(value = { "location", "employees" }, allowSetters = true)
    private Department department;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Employee id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Employee firstName(String firstName) {
        this.setFirstName(firstName);
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Employee lastName(String lastName) {
        this.setLastName(lastName);
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Employee email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public Employee phone(String phone) {
        this.setPhone(phone);
        return this;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Instant getHireDate() {
        return this.hireDate;
    }

    public Employee hireDate(Instant hireDate) {
        this.setHireDate(hireDate);
        return this;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public Employee salary(BigDecimal salary) {
        this.setSalary(salary);
        return this;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Set<Job> getJobs() {
        return this.jobs;
    }

    public void setJobs(Set<Job> jobs) {
        if (this.jobs != null) {
            this.jobs.forEach(i -> i.setEmployee(null));
        }
        if (jobs != null) {
            jobs.forEach(i -> i.setEmployee(this));
        }
        this.jobs = jobs;
    }

    public Employee jobs(Set<Job> jobs) {
        this.setJobs(jobs);
        return this;
    }

    public Employee addJob(Job job) {
        this.jobs.add(job);
        job.setEmployee(this);
        return this;
    }

    public Employee removeJob(Job job) {
        this.jobs.remove(job);
        job.setEmployee(null);
        return this;
    }

    public Employee getManager() {
        return this.manager;
    }

    public void setManager(Employee employee) {
        this.manager = employee;
    }

    public Employee manager(Employee employee) {
        this.setManager(employee);
        return this;
    }

    public Department getDepartment() {
        return this.department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee department(Department department) {
        this.setDepartment(department);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", phone='" + getPhone() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", salary=" + getSalary() +
            "}";
    }
}

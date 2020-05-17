package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @Column(name = "emp_id", updatable = false)
    @SequenceGenerator(name="emp_id_seq", sequenceName="id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "emp_id_seq")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "designation")
    private String designation;

    @Column(name = "date_of_joining")
    private Date doj;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @Column(name = "modified_date")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    @Column(name = "date_of_exit")
    private Date dateOfExit;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "emp_dep_map",
            joinColumns = {@JoinColumn(name = "emp_id")},
            inverseJoinColumns = {@JoinColumn(name = "dept_id")})
    private Set<Department> departments = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getDateOfExit() {
        return dateOfExit;
    }

    public void setDateOfExit(Date dateOfExit) {
        this.dateOfExit = dateOfExit;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }
}

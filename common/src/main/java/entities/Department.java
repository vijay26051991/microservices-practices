package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name = "dept_id", updatable = false, nullable = false)
    @GenericGenerator(strategy = "entities.DeptIDGenerator", name = "DEPT_ID")
    @GeneratedValue(generator = "DEPT_ID")
    private String deptId;

    @Column(name = "dept_name", nullable = false, updatable = true)
    private String deptName;

    @Column(name = "dept_head", updatable = true, nullable = false)
    private String deptHead;

    @ManyToMany(mappedBy = "departments", cascade = CascadeType.ALL)
    private Set<Employee> employeeSet = new HashSet<>();

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptHead() {
        return deptHead;
    }

    public void setDeptHead(String deptHead) {
        this.deptHead = deptHead;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }
}

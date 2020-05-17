package model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeInfo {

    private String id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String middleName;

    @NotNull
    private String age;

    @NotNull
    private Date doj;

    @NotNull
    private String designation;

    @NotNull
    private List<String> deptIds;

    public EmployeeInfo() {
        //empty constructor.
    }

    @JsonCreator
    public EmployeeInfo(@JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY) String id,
                        @JsonProperty(value = "firstName") String firstName,
                        @JsonProperty(value = "lastName") String lastName,
                        @JsonProperty(value = "middleName") String middleName,
                        @JsonProperty(value = "`") String age,
                        @JsonProperty(value = "doj") Date doj,
                        @JsonProperty(value = "designation") String designation,
                        @JsonProperty(value = "deptIds") List<String> deptIds) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
        this.doj = doj;
        this.designation = designation;
        this.deptIds = deptIds;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<String> getDeptIds() {
        return deptIds;
    }

    public void setDeptIds(List<String> deptIds) {
        this.deptIds = deptIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeInfo that = (EmployeeInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (middleName != null ? !middleName.equals(that.middleName) : that.middleName != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (doj != null ? !doj.equals(that.doj) : that.doj != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        return deptIds != null ? deptIds.equals(that.deptIds) : that.deptIds == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (doj != null ? doj.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + (deptIds != null ? deptIds.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age='" + age + '\'' +
                ", doj=" + doj +
                ", designation='" + designation + '\'' +
                ", deptIds=" + deptIds +
                '}';
    }
}

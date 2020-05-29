package model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DepartmentInfo {

    private String deptId;

    @NotNull
    private String deptName;

    @NotNull
    private String deptHead;

    public DepartmentInfo() {
        //empty constructor
    }

    @JsonCreator
    public DepartmentInfo(@JsonProperty("deptId") String deptId,
                          @JsonProperty("deptName") String deptName,
                          @JsonProperty("deptHead") String deptHead) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptHead = deptHead;
    }


    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDeptHead() {
        return deptHead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentInfo that = (DepartmentInfo) o;

        if (deptId != null ? !deptId.equals(that.deptId) : that.deptId != null) return false;
        if (deptName != null ? !deptName.equals(that.deptName) : that.deptName != null)
            return false;
        return deptHead != null ? deptHead.equals(that.deptHead) : that.deptHead == null;
    }

    @Override
    public int hashCode() {
        int result = deptId != null ? deptId.hashCode() : 0;
        result = 31 * result + (deptName != null ? deptName.hashCode() : 0);
        result = 31 * result + (deptHead != null ? deptHead.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DepartmentInfo{" +
                "deptId='" + deptId + '\'' +
                ", departmentName='" + deptName + '\'' +
                ", departmentHead='" + deptHead + '\'' +
                '}';
    }
}

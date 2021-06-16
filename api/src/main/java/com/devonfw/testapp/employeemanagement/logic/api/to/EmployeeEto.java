package com.devonfw.testapp.employeemanagement.logic.api.to;

import com.devonfw.module.basic.common.api.to.AbstractEto;
import com.devonfw.testapp.employeemanagement.common.api.Employee;

/**
 * Entity transport object of Employee
 */
public class EmployeeEto extends AbstractEto implements Employee {

  private static final long serialVersionUID = 1L;

  private String name;

  private long empId;

  @Override
  public String getName() {

    return name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public long getEmpId() {

    return empId;
  }

  @Override
  public void setEmpId(long empId) {

    this.empId = empId;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((Long) empId).hashCode();
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    EmployeeEto other = (EmployeeEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.empId != other.empId) {
      return false;
    }
    return true;
  }
}

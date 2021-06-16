package com.devonfw.testapp.employeemanagement.dataaccess.api;

import javax.persistence.Entity;

import com.devonfw.testapp.employeemanagement.common.api.Employee;
import com.devonfw.testapp.general.dataaccess.api.ApplicationPersistenceEntity;

/**
 * TODO snesarmo This type ...
 */
@Entity
public class EmployeeEntity extends ApplicationPersistenceEntity implements Employee {

  private String name;

  private long empId;

  private static final long serialVersionUID = 1L;

  public EmployeeEntity() {

    super();
  }

  /**
   * The constructor.
   *
   * @param name
   * @param empId
   */
  public EmployeeEntity(String name, long empId) {

    super();
    this.name = name;
    this.empId = empId;
  }

  /**
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getname}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return empId
   */
  public long getEmpId() {

    return this.empId;
  }

  /**
   * @param empId new value of {@link #getempId}.
   */
  public void setEmpId(long empId) {

    this.empId = empId;
  }

}

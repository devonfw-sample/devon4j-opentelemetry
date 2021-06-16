package com.devonfw.testapp.employeemanagement.common.api;

import com.devonfw.testapp.general.common.api.ApplicationEntity;

public interface Employee extends ApplicationEntity {

  /**
   * @return nameId
   */

  public String getName();

  /**
   * @param name setter for name attribute
   */

  public void setName(String name);

  /**
   * @return empIdId
   */

  public long getEmpId();

  /**
   * @param empId setter for empId attribute
   */

  public void setEmpId(long empId);

}

package com.devonfw.testapp.employeemanagement.logic.base.usecase;

import javax.inject.Inject;

import com.devonfw.testapp.employeemanagement.dataaccess.api.repo.EmployeeRepository;
import com.devonfw.testapp.general.logic.base.AbstractUc;

/**
 * Abstract use case for Employees, which provides access to the commonly necessary data access objects.
 */
public class AbstractEmployeeUc extends AbstractUc {

  /** @see #getEmployeeRepository() */
  @Inject
  private EmployeeRepository employeeRepository;

  /**
   * Returns the field 'employeeRepository'.
   * 
   * @return the {@link EmployeeRepository} instance.
   */
  public EmployeeRepository getEmployeeRepository() {

    return this.employeeRepository;
  }

}

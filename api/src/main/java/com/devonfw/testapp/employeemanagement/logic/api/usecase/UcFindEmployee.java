package com.devonfw.testapp.employeemanagement.logic.api.usecase;

import java.util.List;

import org.springframework.data.domain.Page;

import com.devonfw.testapp.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.testapp.employeemanagement.logic.api.to.EmployeeSearchCriteriaTo;

public interface UcFindEmployee {

  /**
   * Returns a Employee by its id 'id'.
   *
   * @param id The id 'id' of the Employee.
   * @return The {@link EmployeeEto} with id 'id'
   */
  EmployeeEto findEmployee(long id);

  /**
   * Returns a paginated list of Employees matching the search criteria.
   *
   * @param criteria the {@link EmployeeSearchCriteriaTo}.
   * @return the {@link List} of matching {@link EmployeeEto}s.
   */
  Page<EmployeeEto> findEmployees(EmployeeSearchCriteriaTo criteria);

}

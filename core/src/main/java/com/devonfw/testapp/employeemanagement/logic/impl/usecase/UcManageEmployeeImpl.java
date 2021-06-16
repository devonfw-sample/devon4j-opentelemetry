package com.devonfw.testapp.employeemanagement.logic.impl.usecase;

import java.util.Objects;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.devonfw.testapp.employeemanagement.dataaccess.api.EmployeeEntity;
import com.devonfw.testapp.employeemanagement.logic.api.to.EmployeeEto;
import com.devonfw.testapp.employeemanagement.logic.api.usecase.UcManageEmployee;
import com.devonfw.testapp.employeemanagement.logic.base.usecase.AbstractEmployeeUc;

/**
 * Use case implementation for modifying and deleting Employees
 */
@Named
@Validated
@Transactional
public class UcManageEmployeeImpl extends AbstractEmployeeUc implements UcManageEmployee {

  /** Logger instance. */
  private static final Logger LOG = LoggerFactory.getLogger(UcManageEmployeeImpl.class);

  @Override
  public boolean deleteEmployee(long employeeId) {

    EmployeeEntity employee = getEmployeeRepository().find(employeeId);
    getEmployeeRepository().delete(employee);
    LOG.debug("The employee with id '{}' has been deleted.", employeeId);
    return true;
  }

  @Override
  public EmployeeEto saveEmployee(EmployeeEto employee) {

    Objects.requireNonNull(employee, "employee");

    EmployeeEntity employeeEntity = getBeanMapper().map(employee, EmployeeEntity.class);

    // initialize, validate employeeEntity here if necessary
    EmployeeEntity resultEntity = getEmployeeRepository().save(employeeEntity);
    LOG.debug("Employee with id '{}' has been created.", resultEntity.getId());
    return getBeanMapper().map(resultEntity, EmployeeEto.class);
  }
}

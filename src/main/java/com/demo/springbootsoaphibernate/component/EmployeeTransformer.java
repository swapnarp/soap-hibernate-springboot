package com.demo.springbootsoaphibernate.component;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.demo.springbootsoaphibernate.aop.LoggableService;
import com.demo.springbootsoaphibernate.entity.Employee;

import payroll.bestpay.employee.EmployeeInfo;

@Component
public class EmployeeTransformer {

	@LoggableService
	public EmployeeInfo convert(Employee emp) {
		EmployeeInfo empInfor = new EmployeeInfo();
		BeanUtils.copyProperties(emp, empInfor);
		empInfor.setHourlyRate(new BigDecimal(emp.getHourlyRate()));
		empInfor.setEid(String.valueOf(emp.getId()));
		return empInfor;
	}

}

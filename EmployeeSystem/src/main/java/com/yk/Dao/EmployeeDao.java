package com.yk.Dao;

import com.yk.pojo.Department;
import com.yk.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tang
 * @Tate 2022/10/5-15:28
 * @Version 1.0
 */
@Repository
public class EmployeeDao {
    //模拟数据库数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer, Employee>();//创建员工表
        employees.put(1001,new Employee(1001, "AA","A1954087742@qq.com",0,new Department(101,"教学部")));
        employees.put(1002,new Employee(1002, "BB","B1954087742@qq.com",1,new Department(102,"教研部")));
        employees.put(1003,new Employee(1003, "CC","C1954087742@qq.com",0,new Department(103,"科研部")));
        employees.put(1004,new Employee(1004, "DD","D1954087742@qq.com",1,new Department(104,"文艺部")));
        employees.put(1005,new Employee(1005, "EE","E1954087742@qq.com",0,new Department(105,"后勤部")));
    }

    //ID自增
    private static Integer InitId = 1006;
    //添加员工
    public void save(Employee employee){
        if(employee.getId() == null)
            employee.setId(InitId++);
        System.out.println(employee.getDepartment().getId());
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        System.out.println(employee);
        employees.put(employee.getId(), employee);
    }

    //获取全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //根据id获取员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //删除指定员工
    public void delete(Integer id){
        employees.remove(id);
    }
}

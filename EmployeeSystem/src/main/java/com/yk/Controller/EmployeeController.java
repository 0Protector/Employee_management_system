package com.yk.Controller;

import com.yk.Dao.DepartmentDao;
import com.yk.Dao.EmployeeDao;
import com.yk.pojo.Department;
import com.yk.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Author Tang
 * @Tate 2022/10/6-16:27
 * @Version 1.0
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
//        Iterator<Employee> iterator = employees.iterator();
//        while (iterator.hasNext()) {
//            Employee emp = iterator.next() ;
//            System.out.println(emp);
//        }
        return "/employee/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/employee/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
//        System.out.println(employee);
        employeeDao.save(employee);//添加操作
        return "redirect:/emps";
    }
    //去员工的修改页面
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id") Integer id, Model model){
        //获取当前被操作对象的信息
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //获得部门信息，用以选择
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        return "/employee/update";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

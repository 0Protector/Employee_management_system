package com.yk.Dao;

import com.yk.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Tang
 * @Tate 2022/10/5-15:08
 * @Version 1.0
 */
@Repository
//部门Dao
public class DepartmentDao {
    //模拟数据库数据
    private static Map<Integer, Department> departments = null;

    static{
        departments = new HashMap<Integer, Department>();//创建部门表

        departments.put(101, new Department(101,"教学部"));
        departments.put(102, new Department(102,"教研部"));
        departments.put(103, new Department(103,"科研部"));
        departments.put(104, new Department(104,"文艺部"));
        departments.put(105, new Department(105,"后勤部"));
    }

    //获取所有的部门信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //根据id获取部门信息
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}

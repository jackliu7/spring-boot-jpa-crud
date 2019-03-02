package com.edward.springbootcrud.controller;

import com.edward.springbootcrud.bean.BookType;
import com.edward.springbootcrud.bean.Department;
import com.edward.springbootcrud.bean.Employee;
import com.edward.springbootcrud.repository.BookTypeRespository;
import com.edward.springbootcrud.repository.DepartmentRepository;
import com.edward.springbootcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping("/emps")
    public String list(Model model){
        List<Employee> emps = employeeRepository.findAll();
        model.addAttribute("emps",emps);
        return "list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("depts",departments);
        return "add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //来到员工列表页面

        System.out.println("保存的员工信息："+employee);
        //保存员工
        employeeRepository.save(employee);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/emps";
    }

    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){
        Employee employee =  employeeRepository.getOne(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        List<Department> departments = departmentRepository.findAll();
        model.addAttribute("depts",departments);
        //回到修改页面(add是一个修改添加二合一的页面);
        return "add";
    }

    //员工修改；需要提交员工id；
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println("修改的员工数据："+employee);
        employeeRepository.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeRepository.deleteById(id);
        return "redirect:/emps";
    }


}

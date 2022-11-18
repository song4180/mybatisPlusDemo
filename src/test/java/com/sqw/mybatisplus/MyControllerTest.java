package com.sqw.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqw.mybatisplus.entity.Student;
import com.sqw.mybatisplus.entity.vo.StudentScoreVO;
import com.sqw.mybatisplus.service.impl.ScoreServiceImpl;
import com.sqw.mybatisplus.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Song Qingwu
 * @date 2022/11/18 16:12
 * @Description:
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
@WebAppConfiguration
public class MyControllerTest {
    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentServiceImpl studentServiceImpl;

    @Autowired
    @Qualifier("scoreServiceImpl")
    private ScoreServiceImpl scoreServiceImpl;

    @Test
    public void testAdd() {
        int sno = 20160001;
        for (int i = 0; i < 10; i++) {
            Student student = new Student(sno++, "张三", 20, "男", "2016222");
            if (studentServiceImpl.insertStudent(student) == 1) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        }
    }

    @Test
    public void testDeleteBySno() {
        if (studentServiceImpl.deleteBySno(20160009) == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testDeleteBySclass_sex() {
        if (studentServiceImpl.deleteBySclass_sex("2016221", "男") == 1) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    @Test
    public void testGetAll() {
        List<Student> studentList = new ArrayList<Student>();
        studentList = studentServiceImpl.getAll();
        for (Student student : studentList) {
            System.out.println(studentList.toString());
        }
    }

    @Test
    public void testGetStudentsByScope() {
        List<Student> studentList = studentServiceImpl.getStudentsByScope(10);
        for (Student student : studentList) {
            System.out.println(studentList.toString());
        }
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student(20160010, "HHH", 20, "男", "2016222");
        if (studentServiceImpl.updateStudent(student) == 1) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
    }

    @Test
    public void testGetBySno() {
        Student student = studentServiceImpl.getBySno(20160003);
        System.out.println(student.toString());
    }

    @Test
    public void testGetCount() {
        System.out.println(studentServiceImpl.getCount());
    }

    @Test
    public void testGetScore() {
        List<StudentScoreVO> studentScoreVOList = scoreServiceImpl.getScore();
        for (StudentScoreVO studentScoreVO : studentScoreVOList) {
            System.out.println(studentScoreVO.toString());
        }
    }

    @Test
    public void testGetByPage() {
        int curr = 0, size = 3;
        while (curr <= scoreServiceImpl.getCount() / 3 + 1) {
            Page<StudentScoreVO> page = new Page<>(curr, size);
            System.out.println(curr + " " + size);
            scoreServiceImpl.getByPage(page, null).getRecords().forEach(System.out::println);
            curr++;
            System.out.println("------------------------------------------------");
        }
    }
}

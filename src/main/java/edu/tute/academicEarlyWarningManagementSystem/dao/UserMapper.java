package edu.tute.academicEarlyWarningManagementSystem.dao;


import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.StudentService.ModifyInfoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    //登录
    User login(@Param("userName") String userName, @Param("password") String password);

    //根据条件查找学生
    List<User> searchStudent(SearchStudentRequest searchStudentRequest);

    //添加学业预警信息
    Integer insertWarningInfo(WarningInfoRequest warningInfoRequest);

    //删除学业预警信息
    Integer deleteWarningInfo(WarningInfoRequest warningInfoRequest);

    //添加学生信息
    Integer insertStudentInfo(User user);

    //添加教师信息
    Integer insertTeacher(User user);

    //列出预警通知
    List<User> getNotification(String className);

    //根据学号查找学生信息
    User getUser(String userName);

    //根据学号查找学生信息
    Integer changePassword(@Param("userName") String userName, @Param("password") String password);

    //更新预警信息
    Integer updateWarningInfo(@Param("userName") String userName, @Param("description") String description, @Param("handleStatus") String handleStatus);

    Integer modifyInfo(ModifyInfoRequest modifyInfoRequest);
}

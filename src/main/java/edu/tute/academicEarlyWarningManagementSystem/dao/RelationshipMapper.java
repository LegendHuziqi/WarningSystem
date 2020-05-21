package edu.tute.academicEarlyWarningManagementSystem.dao;


import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RelationshipMapper {
    //找出教师/辅导员所管理的班级
    List<String> getAllClass(@Param("userName") String userName);

    //根据班名找出老师工号
    Integer getTeacherbyClassName(@Param("className") String className);

    //根据班名找出辅导员工号
    Integer getAdvisorbyClassName(@Param("className") String className);
}

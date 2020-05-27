package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import org.springframework.stereotype.Service;

@Service
public interface SecretaryService {
    //精确查询学生信息
    ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest);

    //预警信息--添加
    ResponseMsg insertWarningInfo(WarningInfoRequest warningInfoRequest);

    //预警信息--删除
    ResponseMsg deleteWarningInfo(WarningInfoRequest warningInfoRequest);

    //学生信息录入
    ResponseMsg createStudentInfo(User user);

    //辅导员信息录入
    ResponseMsg importAdvisor(User user);

    //班主任信息录入
    ResponseMsg importTeacher(User user);
}

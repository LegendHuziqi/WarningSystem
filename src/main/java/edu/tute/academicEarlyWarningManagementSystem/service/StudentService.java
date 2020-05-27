package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.pojo.CommonService.ChangePasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.StudentService.ModifyInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    //获取自身信息
    ResponseMsg getInfo(UserNameRequest userNameRequest);

    //修改信息
    ResponseMsg modifyInfo(ModifyInfoRequest modifyInfoRequest);
}

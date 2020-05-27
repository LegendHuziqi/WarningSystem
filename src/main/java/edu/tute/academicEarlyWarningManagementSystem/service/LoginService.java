package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.pojo.CommonService.ChangePasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    //登录
    ResponseMsg login(LoginRequest loginRequest);

    //申请重置密码
    void forgetPassword(ForgetPasswordRequest forgetPasswordRequest);

    //根据旧密码改密码
    ResponseMsg changePassword(ChangePasswordRequest changePasswordRequest);

    //获取学生完整信息
    ResponseMsg getUser(UserNameRequest userNameRequest);
}

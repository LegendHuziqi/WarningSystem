package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.ResetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UpdateWarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    //按条件精确查找
    ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest);

    //获取全部学生
    ResponseMsg getAllStudent(UserNameRequest userNameRequest);

    //获取预警信息
    ResponseMsg getNotification(UserNameRequest userNameRequest);

    //获取申请重置密码的学生名单
    ResponseMsg getResetList(UserNameRequest userNameRequest);

    //同意|拒绝重置密码
    ResponseMsg resetPassword(ResetPasswordRequest resetPasswordRequest);

    //进入详情页后完善预警的处理信息
    ResponseMsg updateWarningInfo(UpdateWarningInfoRequest updateWarningInfoRequest);
}

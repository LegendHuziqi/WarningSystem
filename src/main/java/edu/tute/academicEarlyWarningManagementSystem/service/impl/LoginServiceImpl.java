package edu.tute.academicEarlyWarningManagementSystem.service.impl;


import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.dao.RelationshipMapper;
import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.CommonService.ChangePasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    JedisClient jedisClient;

    @Override
    public ResponseMsg login(LoginRequest loginRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.login(loginRequest.getUserName(), loginRequest.getPassword());
        if (result == null) {
            responseMsg.setMsg("登录失败");
            return responseMsg;
        } else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("登录成功");
        }
        return responseMsg;
    }

    @Override
    public void forgetPassword(ForgetPasswordRequest forgetPasswordRequest) {
        User user = userMapper.getUser(forgetPasswordRequest.getUserName());
        int teacher = relationshipMapper.getTeacherbyClassName(user.getClassName());
        jedisClient.hset(String.valueOf(teacher),forgetPasswordRequest.getUserName(),user.getName());
    }

    @Override
    public ResponseMsg changePassword(ChangePasswordRequest changePasswordRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        User user = new User();
        user = userMapper.getUser(changePasswordRequest.getUserName());
        if(changePasswordRequest.getOldPassword().equals(user.getPassword())){
            userMapper.changePassword(changePasswordRequest.getUserName(),changePasswordRequest.getNewPassword());
        }else{
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("密码错误,请重试");
        }
        return responseMsg;
    }


}

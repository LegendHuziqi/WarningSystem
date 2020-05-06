package edu.tute.academicEarlyWarningManagementSystem.service.impl;


import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    JedisClient jedisClient;

    @Override
    public ResponseMsg login(LoginRequest loginRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.login(loginRequest.getUserName(), loginRequest.getPassword());
        if (result == 1) {
            return responseMsg;
        } else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("登录失败");
        }
        return responseMsg;
    }


}

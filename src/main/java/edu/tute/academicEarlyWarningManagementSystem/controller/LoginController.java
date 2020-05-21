package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseMsg login(@RequestBody LoginRequest loginRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        if(loginRequest.getUserName() == null || loginRequest.getPassword() == null){
            responseMsg.setStatusCode(1);
            responseMsg.setData("输入的用户名账号为空,请重试");
            return responseMsg;
        }
        responseMsg = loginService.login(loginRequest);
        return responseMsg;
    }

    @PostMapping("/forgetPassword")
    public ResponseMsg forgetPassword(@RequestBody ForgetPasswordRequest forgetPasswordRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        loginService.forgetPassword(forgetPasswordRequest);
        return responseMsg;
    }
}

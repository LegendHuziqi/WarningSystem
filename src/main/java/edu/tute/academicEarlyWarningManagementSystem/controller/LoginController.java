package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.pojo.CommonService.ChangePasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.Test;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseMsg login(@RequestBody LoginRequest loginRequest){
        System.out.println("1111");
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

    @PostMapping("/changePassword")
    public ResponseMsg changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = loginService.changePassword(changePasswordRequest);
        return responseMsg;
    }

    @PostMapping("/getUser")
    public ResponseMsg changePassword(@RequestBody UserNameRequest userNameRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = loginService.getUser(userNameRequest);
        return responseMsg;
    }

    @PostMapping("/test")
    @CrossOrigin
    public ResponseMsg test(@RequestParam("test") String test){
        ResponseMsg responseMsg = new ResponseMsg();
        System.out.println("test1");
        System.out.println(test);
        responseMsg.setData(test+"aaa");
        return responseMsg;
    }

    @PostMapping("/test2")
    @CrossOrigin
    public ResponseMsg test2(@RequestBody Test test){
        ResponseMsg responseMsg = new ResponseMsg();
        System.out.println("test2");
        System.out.println(test);
        test.setTest("xxx");
        responseMsg.setData(test.getTest());
        return responseMsg;
    }
}

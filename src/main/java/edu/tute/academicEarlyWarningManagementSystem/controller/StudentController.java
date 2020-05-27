package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.StudentService.ModifyInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import edu.tute.academicEarlyWarningManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/getInfo")
    public ResponseMsg getInfo(@RequestBody UserNameRequest userNameRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = studentService.getInfo(userNameRequest);
        return responseMsg;
    }

    @PostMapping("/modifyInfo")
    public ResponseMsg modifyInfo(@RequestBody ModifyInfoRequest modifyInfoRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = studentService.modifyInfo(modifyInfoRequest);
        return responseMsg;
    }


}

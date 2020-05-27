package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.ResetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UpdateWarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @PostMapping("/searchStudent")
    public ResponseMsg searchStudent(@RequestBody SearchStudentRequest searchStudentRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.searchStudent(searchStudentRequest);
        return responseMsg;
    }

    @PostMapping("/getAllStudent")
    public ResponseMsg getAllStudent(@RequestBody UserNameRequest getAllStudentRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.getAllStudent(getAllStudentRequest);
        return responseMsg;
    }

    @PostMapping("/getNotification")
    public ResponseMsg getNotification(@RequestBody UserNameRequest userNameRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.getNotification(userNameRequest);
        return responseMsg;
    }

    @PostMapping("/getResetList")
    public ResponseMsg getResetList(@RequestBody UserNameRequest userNameRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.getResetList(userNameRequest);
        return responseMsg;
    }

    @PostMapping("/resetPassword")
    public ResponseMsg resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.resetPassword(resetPasswordRequest);
        return responseMsg;
    }

    @PostMapping("/updateWarningInfo")
    public ResponseMsg updateWarningInfo(@RequestBody UpdateWarningInfoRequest updateWarningInfoRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = teacherService.updateWarningInfo(updateWarningInfoRequest);
        return responseMsg;
    }
}

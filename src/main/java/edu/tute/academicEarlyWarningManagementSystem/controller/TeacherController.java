package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher")
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
}

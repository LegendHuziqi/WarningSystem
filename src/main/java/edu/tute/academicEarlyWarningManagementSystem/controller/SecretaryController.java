package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import edu.tute.academicEarlyWarningManagementSystem.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secretary")
public class SecretaryController {
    @Autowired
    SecretaryService secretaryService;

    @PostMapping("/searchStudent")
    public ResponseMsg searchStudent(@RequestBody SearchStudentRequest searchStudentRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.searchStudent(searchStudentRequest);
        return responseMsg;
    }

    @PostMapping("/insertWarningInfo")
    public ResponseMsg insertWarningInfo(@RequestBody WarningInfoRequest warningInfoRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.insertWarningInfo(warningInfoRequest);
        return responseMsg;
    }

    @PostMapping("/deleteWarningInfo")
    public ResponseMsg deleteWarningInfo(@RequestBody WarningInfoRequest warningInfoRequest){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.deleteWarningInfo(warningInfoRequest);
        return responseMsg;
    }

    @PostMapping("/insertStudentInfo")
    public ResponseMsg insertStudentInfo(@RequestBody User user){
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.createStudentInfo(user);
        return responseMsg;
    }
}

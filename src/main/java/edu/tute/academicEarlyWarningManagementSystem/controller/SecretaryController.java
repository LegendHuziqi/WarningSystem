package edu.tute.academicEarlyWarningManagementSystem.controller;

import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.ImportTeacherRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.SecretaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/secretary")
@CrossOrigin
public class SecretaryController {
    @Autowired
    SecretaryService secretaryService;

    @PostMapping("/searchStudent")
    public ResponseMsg searchStudent(@RequestBody SearchStudentRequest searchStudentRequest) {
        System.out.println("test");
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.searchStudent(searchStudentRequest);
        return responseMsg;
    }

    @PostMapping("/insertWarningInfo")
    public ResponseMsg insertWarningInfo(@RequestBody WarningInfoRequest warningInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.insertWarningInfo(warningInfoRequest);
        return responseMsg;
    }

    @PostMapping("/deleteWarningInfo")
    public ResponseMsg deleteWarningInfo(@RequestBody WarningInfoRequest warningInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.deleteWarningInfo(warningInfoRequest);
        return responseMsg;
    }

    @PostMapping("/importStudent")
    public ResponseMsg insertStudentInfo(@RequestBody User user) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.createStudentInfo(user);
        return responseMsg;
    }

    @PostMapping("/importAdvisor")
    public ResponseMsg importAdvisor(@RequestBody User user) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.importAdvisor(user);
        return responseMsg;
    }

    @PostMapping("/importTeacher")
    public ResponseMsg importTeacher(@RequestBody User user) {
        ResponseMsg responseMsg = new ResponseMsg();
        responseMsg = secretaryService.importTeacher(user);
        return responseMsg;
    }
}

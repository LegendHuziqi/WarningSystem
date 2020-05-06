package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import org.springframework.stereotype.Service;

@Service
public interface TeacherService {
    ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest);

    ResponseMsg getAllStudent(UserNameRequest userNameRequest);

    ResponseMsg getNotification(UserNameRequest userNameRequest);
}

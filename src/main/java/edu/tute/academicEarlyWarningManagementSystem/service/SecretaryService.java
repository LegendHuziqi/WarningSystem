package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import org.springframework.stereotype.Service;

@Service
public interface SecretaryService {
    ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest);

    ResponseMsg insertWarningInfo(WarningInfoRequest warningInfoRequest);

    ResponseMsg deleteWarningInfo(WarningInfoRequest warningInfoRequest);

    ResponseMsg createStudentInfo(User user);
}

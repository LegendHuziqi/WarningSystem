package edu.tute.academicEarlyWarningManagementSystem.service;

import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {
    ResponseMsg login(LoginRequest loginRequest);

}

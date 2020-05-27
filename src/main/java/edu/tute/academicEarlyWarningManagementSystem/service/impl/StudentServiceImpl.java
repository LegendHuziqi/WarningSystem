package edu.tute.academicEarlyWarningManagementSystem.service.impl;


import com.alibaba.fastjson.JSONObject;
import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.dao.RelationshipMapper;
import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.CommonService.ChangePasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.ForgetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.LoginService.LoginRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.StudentService.ModifyInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.LoginService;
import edu.tute.academicEarlyWarningManagementSystem.service.StudentService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceImpl implements StudentService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    JedisClient jedisClient;


    @Override
    public ResponseMsg getInfo(UserNameRequest userNameRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        User user = userMapper.getUser(userNameRequest.getUserName());
        responseMsg.setData(JSONObject.toJSONString(user));
        return responseMsg;
    }

    @Override
    public ResponseMsg modifyInfo(ModifyInfoRequest modifyInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.modifyInfo(modifyInfoRequest);
        if(result!=0){
            return  responseMsg;
        }else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("更新错误");
            return responseMsg;
        }
    }


}

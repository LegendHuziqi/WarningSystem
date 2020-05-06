package edu.tute.academicEarlyWarningManagementSystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.dao.RelationshipMapper;
import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.TeacherService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    JedisClient jedisClient;

    @Override
    public ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        List<User> searchResult = userMapper.searchStudent(searchStudentRequest);
        if (!searchResult.isEmpty()) {
            ArrayList<JSONObject> result = new ArrayList<>();
            for (User student : searchResult) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userName", student.getUserName());
                jsonObject.put("name", student.getName());
                jsonObject.put("college", student.getCollege());
                jsonObject.put("className", student.getClassName());
                jsonObject.put("room", student.getRoom());
                jsonObject.put("warningStatus", student.getWarningStatus());
                jsonObject.put("handleStatus", student.getHandleStatus());
                result.add(jsonObject);
            }
            responseMsg.setStatusCode(0);
            responseMsg.setData(JSONObject.toJSONString(result));
            return responseMsg;
        } else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("数据库读写错误");
            return responseMsg;
        }
    }

    @Override
    public ResponseMsg getAllStudent(UserNameRequest userNameRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        List<String> allClass = relationshipMapper.getAllClass(userNameRequest.getUserName());
        List<User> result = new ArrayList<User>();
        if (!allClass.isEmpty()) {
            for (String className : allClass) {
                SearchStudentRequest searchStudentRequest = new SearchStudentRequest();
                searchStudentRequest.setClassName(className);
                List<User> students = userMapper.searchStudent(searchStudentRequest);
                for (User student : students) {
                    result.add(student);
                }
            }
            responseMsg.setStatusCode(0);
            responseMsg.setData(JSONObject.toJSONString(result));
            return responseMsg;
        } else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("查询失败");
            return responseMsg;
        }
    }

    @Override
    public ResponseMsg getNotification(UserNameRequest userNameRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        List<String> allClass = relationshipMapper.getAllClass(userNameRequest.getUserName());
        if (!allClass.isEmpty()) {

        }
        return null;
    }


}

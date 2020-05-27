package edu.tute.academicEarlyWarningManagementSystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.dao.RelationshipMapper;
import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.ResetPasswordRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UpdateWarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.TeacherService.UserNameRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.TeacherService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RelationshipMapper relationshipMapper;
    @Autowired
    JedisClient jedisClient;

    public static void main(String[] args) {
        Map test = new HashMap();
        test.put("1", "1");
        test.put("2", "1");
        test.put("3", "0");

        Iterator iterator = test.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

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
        List<JSONObject> result = new ArrayList<JSONObject>();
        if (!allClass.isEmpty()) {
            for (String className : allClass) {
                SearchStudentRequest searchStudentRequest = new SearchStudentRequest();
                searchStudentRequest.setClassName(className);
                searchStudentRequest.setPage(0);
                searchStudentRequest.setPageSize(100);
                List<User> students = userMapper.searchStudent(searchStudentRequest);
                for (User student : students) {
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
        List<JSONObject> result = new ArrayList<JSONObject>();
        List<String> allClass = relationshipMapper.getAllClass(userNameRequest.getUserName());
        if (!allClass.isEmpty()) {
            for (String className : allClass) {
                List<User> temp = userMapper.getNotification(className);
                for (User student : temp) {
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("userName", student.getUserName());
                    jsonObject.put("name", student.getName());
                    jsonObject.put("warningReason", student.getWarningReason());
                    result.add(jsonObject);
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
    public ResponseMsg getResetList(UserNameRequest userNameRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Map temp = jedisClient.hgetAll(userNameRequest.getUserName());
        Iterator<Map.Entry<String, String>> iterator = temp.entrySet().iterator();
        List<JSONObject> result = new ArrayList<>();
        while (iterator.hasNext()) {
            JSONObject jsonObject = new JSONObject();
            Map.Entry<String, String> tmp = iterator.next();
            jsonObject.put("studentId", tmp.getKey());
            jsonObject.put("studentName", tmp.getValue());
            result.add(jsonObject);
        }
        responseMsg.setData(JSONObject.toJSONString(result));
        return responseMsg;
    }

    @Override
    public ResponseMsg resetPassword(ResetPasswordRequest resetPasswordRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        if (resetPasswordRequest.getOption().equals("0")) {
            userMapper.changePassword(resetPasswordRequest.getUserName(), resetPasswordRequest.getUserName());
        }
        jedisClient.hdel(resetPasswordRequest.getTeacherUserName(),resetPasswordRequest.getUserName());
        return responseMsg;
    }

    @Override
    public ResponseMsg updateWarningInfo(UpdateWarningInfoRequest updateWarningInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        userMapper.updateWarningInfo(updateWarningInfoRequest.getUserName(),updateWarningInfoRequest.getDescription(),updateWarningInfoRequest.getHandleStatus());
        return responseMsg;
    }
}

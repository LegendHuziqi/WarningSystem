package edu.tute.academicEarlyWarningManagementSystem.service.impl;

import com.alibaba.fastjson.JSONObject;
import edu.tute.academicEarlyWarningManagementSystem.Bean.User;
import edu.tute.academicEarlyWarningManagementSystem.dao.UserMapper;
import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.SearchStudentRequest;
import edu.tute.academicEarlyWarningManagementSystem.pojo.SecretaryService.WarningInfoRequest;
import edu.tute.academicEarlyWarningManagementSystem.service.SecretaryService;
import edu.tute.academicEarlyWarningManagementSystem.utils.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecretaryServiceImpl implements SecretaryService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    JedisClient jedisClient;

    @Override
    public ResponseMsg searchStudent(SearchStudentRequest searchStudentRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        List<User> searchResult = userMapper.searchStudent(searchStudentRequest);
        if(!searchResult.isEmpty()){
            ArrayList<JSONObject> result= new ArrayList<>();
            for(User student:searchResult){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("userName",student.getUserName());
                jsonObject.put("name",student.getName());
                jsonObject.put("college",student.getCollege());
                jsonObject.put("className",student.getClassName());
                jsonObject.put("warningStatus",student.getWarningStatus());
                jsonObject.put("handleStatus",student.getHandleStatus());
                result.add(jsonObject);
            }
            responseMsg.setStatusCode(0);
            responseMsg.setData(JSONObject.toJSONString(result));
            return responseMsg;
        }else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("数据库读写错误");
            return responseMsg;
        }
    }

    @Override
    public ResponseMsg insertWarningInfo(WarningInfoRequest warningInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.insertWarningInfo(warningInfoRequest);
        if(result == 1){
            responseMsg.setStatusCode(0);
            responseMsg.setMsg("添加学业预警信息成功");
            return responseMsg;
        }else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("添加学业预警信息失败");
            return responseMsg;
        }
    }

    @Override
    public ResponseMsg deleteWarningInfo(WarningInfoRequest warningInfoRequest) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.deleteWarningInfo(warningInfoRequest);
        if(result == 1){
            responseMsg.setStatusCode(0);
            responseMsg.setMsg("删除学业预警信息成功");
            return responseMsg;
        }else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("删除学业预警信息失败");
            return responseMsg;
        }
    }

    @Override
    public ResponseMsg createStudentInfo(User user) {
        ResponseMsg responseMsg = new ResponseMsg();
        Integer result = userMapper.insertStudentInfo(user);
        if(result == 1){
            responseMsg.setStatusCode(0);
            responseMsg.setMsg("添加学生信息成功");
            return responseMsg;
        }else {
            responseMsg.setStatusCode(1);
            responseMsg.setMsg("添加学生信息失败");
            return responseMsg;
        }
    }


}

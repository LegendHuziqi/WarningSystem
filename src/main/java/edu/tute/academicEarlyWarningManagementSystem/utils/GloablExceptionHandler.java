package edu.tute.academicEarlyWarningManagementSystem.utils;


import edu.tute.academicEarlyWarningManagementSystem.pojo.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


//全局的异常处理
@ControllerAdvice
public class GloablExceptionHandler {

    private final static Logger logger= LoggerFactory.getLogger(GloablExceptionHandler.class);

    //jackson序列化错误
    @ResponseBody
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object JsonException(HttpMessageNotReadableException i) {
        logger.error("jackson错误"+i.getMessage());
        ResponseMsg respData = new ResponseMsg();
        respData.setStatus("100");
        respData.setStatusCode(1);
        respData.setMsg("参数错误");
        return respData;
    }

    //自定义异常处理
    @ResponseBody
    @ExceptionHandler(MyErrMsg.class)
    public Object myException(MyErrMsg m) {
        logger.error("自定义错误"+m.getMessage());
        ResponseMsg respData = new ResponseMsg();
        respData.setStatus("100");
        respData.setStatusCode(1);
        respData.setMsg(m.getMessage());
        return respData;
    }

    //全局异常处理
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handleException(Exception e) {
        String msg = e.getMessage();
        if (msg == null || msg.equals("")) {
            msg = "服务器出错";
        }
        ResponseMsg respData = new ResponseMsg();
        respData.setStatus("100");
        respData.setStatusCode(1);
        respData.setMsg(msg);
        return respData;
    }

    /**
     * 校验错误拦截处理
     *
     * @param exception 错误信息集合
     * @return 错误信息
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static Object validationBodyException(MethodArgumentNotValidException exception){
        BindingResult result = exception.getBindingResult();
        ResponseMsg respData = new ResponseMsg();
        respData.setStatus("100");
        respData.setStatusCode(1);
        respData.setMsg("参数校验错误");
        if(result.hasErrors()){
            List<ObjectError> errors = result.getAllErrors();
            for(ObjectError err: errors){
                respData.setMsg(err.getDefaultMessage());
                return respData;
            }
        }
        return null;
    }
}

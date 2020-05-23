package exception;

import entity.ResponseResult;
import enums.CommonEnums;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: luoxian
 * @Date: 2019/5/22 18:12
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult defaultException(HttpServletRequest request, Exception e){
        e.printStackTrace();
        ResponseResult result = new ResponseResult();
        result.setCode( CommonEnums.ERROR.getCode());
        result.setMessage(CommonEnums.ERROR.getMessage());
        result.setData(null);
        return result;
    }

    @ExceptionHandler(value = BusinessException.class)
    @ResponseBody
    public ResponseResult myException(HttpServletRequest request, BusinessException e){
        e.printStackTrace();
        Integer code = e.getCode();
        String msg = e.getMessage();
        if (e.getCode() == null){
            code = CommonEnums.ERROR.getCode();
        }
        if (e.getMessage() == null){
            msg = CommonEnums.ERROR.getMessage();
        }
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(msg);
        result.setData(null);
        return result;
    }
}

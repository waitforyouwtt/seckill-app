package entity;

import enums.CommonEnums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 14:40
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
    }
    public static <T> ResponseResult<T> success(Integer code,String message,T data) {
        ResponseResult<T> response = new ResponseResult();
        response.setCode(code);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
    public static <T> ResponseResult<T> success(T data) {
        ResponseResult<T> response = new ResponseResult();
        response.setCode( CommonEnums.SUCCESS.getCode());
        response.setMessage(CommonEnums.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }
    public static <T> ResponseResult<T> success() {
        ResponseResult<T> response = new ResponseResult();
        response.setCode(CommonEnums.SUCCESS.getCode());
        response.setMessage(CommonEnums.SUCCESS.getMessage());
        response.setData(null);
        return response;
    }
    public static <T> ResponseResult<T> error(T data) {
        ResponseResult<T> response = new ResponseResult();
        response.setCode(CommonEnums.FAIL.getCode());
        response.setMessage(CommonEnums.FAIL.getMessage());
        response.setData(data);
        return response;
    }

    public static <T> ResponseResult<T> error() {
        ResponseResult<T> response = new ResponseResult();
        response.setCode(CommonEnums.ERROR.getCode());
        response.setMessage(CommonEnums.ERROR.getMessage());
        response.setData(null);
        return response;
    }

    public static <T> ResponseResult<T> error(Integer code,String message,T data) {
        ResponseResult<T> response = new ResponseResult();
        response.setCode(code);
        response.setMessage(message);
        response.setData(null);
        return response;
    }



    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }


}

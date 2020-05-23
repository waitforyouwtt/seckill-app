package enums;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/23 14:45
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum CommonEnums {

    SUCCESS(200,"成功"),
    FAIL(300,"失败"),
    ERROR(500,"系统异常")
    ;

    CommonEnums(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;

    private String message;

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
    }}

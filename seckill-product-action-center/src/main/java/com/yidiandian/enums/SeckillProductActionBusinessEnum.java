package com.yidiandian.enums;

import org.assertj.core.util.Lists;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 22:05
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
public enum SeckillProductActionBusinessEnum {

    SALE_COMPLETED(1,"售卖完毕，谢谢惠顾"),
    SECKILL_SUCCESS(2,"恭喜您，秒杀成功"),


    ;

    private Integer code;
    private String message;


    private static final Map<Integer, SeckillProductActionBusinessEnum> valueLookup = new ConcurrentHashMap<>( values().length );

    static {
        for (SeckillProductActionBusinessEnum type : EnumSet.allOf( SeckillProductActionBusinessEnum.class )) {
            valueLookup.put( type.code, type );
        }
    }

    public static SeckillProductActionBusinessEnum resolve(Integer value) {

        return (value != null ? valueLookup.get( value ) : null);
    }

    public static SeckillProductActionBusinessEnum fromValue(Integer value) {
        SeckillProductActionBusinessEnum data = valueLookup.get( value );
        if (data == null) {
            throw new IllegalArgumentException( "参数[" + value + "]不正确，没有找到对应的Enum" );
        }
        return data;
    }

    //将枚举转换成list格式，这样前台遍历的时候比较容易，列如 下拉框 后台调用toList方法，便可以得到code 和name
    public static List<Map> typeEnumList() {
        //javac通过自动推导尖括号里的数据类型.
        List list = Lists.newArrayList();
        for (SeckillProductActionBusinessEnum airlineTypeEnum : SeckillProductActionBusinessEnum.values()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put( "code", airlineTypeEnum.getCode() );
            map.put( "message", airlineTypeEnum.getMessage() );
            list.add( map );
        }
        return list;
    }

    /**
     * 获取枚举的所有code
     *
     * @return
     */
    public static List enumCodeList() {
        List list = Lists.newArrayList();
        for (SeckillProductActionBusinessEnum airlineTypeEnum : SeckillProductActionBusinessEnum.values()) {
            list.add( airlineTypeEnum.getCode() );
        }
        return list;
    }

    SeckillProductActionBusinessEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
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
}

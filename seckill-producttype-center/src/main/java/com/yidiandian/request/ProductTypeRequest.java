package com.yidiandian.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/5/24 18:16
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
public class ProductTypeRequest implements Serializable {
    /**
     * 类型名称
     */
    private String productTypeName;
    /**
     * 类型描述
     */
    private String productTypeDescription;
    /**
     * 父级ID
     */
    private Integer parentId;
    /**
     * 等级
     */
    private Integer grade;
}

package com.yidiandian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: 凤凰[小哥哥]
 * @Date: 2020/7/5 21:52
 * @Version: 1.0
 * @Email: 15290810931@163.com
 */
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class SeckillUnique implements Serializable {

    int useid;
    int id;
}

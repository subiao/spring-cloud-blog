package com.sub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author sub
 * @Date 2021/5/30 16:29
 * @Version 1.0
 */
//@Data 生成getter,setter ,toString等函数
//@NoArgsConstructor 生成无参构造函数
//@AllArgsConstructor //生成全参数构造函数
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}

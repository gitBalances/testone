package com.tansuo365.test1.bean.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 煅后焦
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalcinedCoke implements Serializable,Goods {

    private Long id;

    private String province;

    private String company;

    private String s_company;

    private Double sulfur;

    private Double ash;

    private Double volatile_matter;

    private Double water;

    private Double density;

    private String p_resistivity;

    private Double vanadium;

    private Double granularity;

    private Double today_price;

    private String remarks;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    private Boolean expand_1;

    private Boolean expand_2;

    private Boolean expand_3;

    private String reporter;

    @Override
    public void setGrade(String grade) {
    }
}
package com.tansuo365.test1.bean.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.excel.ExcelCell;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 煅后焦
 */
@ApiModel(value="煅后焦实体",description="货品-煅后焦实体")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalcinedCoke implements Serializable, Goods {

    private Long id;

    @ExcelCell(index = 0)
    private String province;
    @ExcelCell(index = 1)
    private String company;
    @ExcelCell(index = 2)
    private String s_company;
    @ExcelCell(index = 3)
    private Double sulfur;
    @ExcelCell(index = 4)
    private Double ash;
    @ExcelCell(index = 5)
    private Double volatile_matter;
    @ExcelCell(index = 6)
    private Double water;
    @ExcelCell(index = 7)
    private Double density;
    @ExcelCell(index = 8)
    private Double p_resistivity;
    @ExcelCell(index = 9)
    private Double vanadium;
    @ExcelCell(index = 10)
    private String granularity;//粒度改为String VARCHAR
    @ExcelCell(index = 11)
    private Double today_price;
    @ExcelCell(index = 12)
    private String remarks;
    //    private Boolean expand_1;
//
//    private Boolean expand_2;
//
//    private Boolean expand_3;
    @ExcelCell(index = 13)
    private String reporter;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 14)
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 15)
    private Date update_time;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String b_time; //起始时间 搜索用到

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String e_time; //结束时间 搜索用到

    @Transient
    private Integer order; //查询排序 正序0,倒序1


    /*搜索用*/
    @Transient
    private String s_sulfur;
    @Transient
    private String s_ash;
    @Transient
    private String s_volatile_matter;
    @Transient
    private String s_water;
    @Transient
    private String s_density;
    @Transient
    private String s_p_resistivity;
    @Transient
    private String s_vanadium;
    @Transient
    private String s_granularity;
    @Transient
    private String s_today_price;

    public void setSearchParams(String s_sulfur, String s_ash, String s_v_matter,
                                String s_water, String s_density, String s_p_resistivity, String s_vanadium,
                                String s_granularity, String s_price) {
        this.s_sulfur = s_sulfur;
        this.s_ash = s_ash;
        this.s_volatile_matter = s_v_matter;
        this.s_water = s_water;
        this.s_density = s_density;
        this.s_p_resistivity = s_p_resistivity;
        this.s_vanadium = s_vanadium;
        this.s_granularity = s_granularity;
        this.s_today_price = s_price;
    }

}
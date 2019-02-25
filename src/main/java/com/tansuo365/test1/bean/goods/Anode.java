package com.tansuo365.test1.bean.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.excel.ExcelCell;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anode implements Serializable, Goods {

    private Integer id;
    @ExcelCell(index = 0)
    private String province;
    @ExcelCell(index = 1)
    private String company;
    @ExcelCell(index = 2)
    private String s_company;
    @ExcelCell(index = 3)
    private Double e_density;
    @ExcelCell(index = 4)
    private Double true_density;
    @ExcelCell(index = 5)
    private Double compressive;
    @ExcelCell(index = 6)
    private Double carbon;
    @ExcelCell(index = 7)
    private Double flexural;
    @ExcelCell(index = 8)
    private Double room;
    @ExcelCell(index = 9)
    private Double thermal;
    @ExcelCell(index = 10)
    private Double ash;
    @ExcelCell(index = 11)
    private String size;
    @ExcelCell(index = 12)
    private Double bowl_sum;
    @ExcelCell(index = 13)
    private Double bowl_distance;
    @ExcelCell(index = 14)
    private Double in_diameter;
    @ExcelCell(index = 15)
    private Double out_diameter;
    @ExcelCell(index = 16)
    private String slot;
    @ExcelCell(index = 17)
    private Double today_price;
    @ExcelCell(index = 18)
    private String remarks;
    @ExcelCell(index = 19)
    private String reporter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ExcelCell(index = 20)
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ExcelCell(index = 21)
    private Date update_time;

    //    private Boolean expand_1;
//
//    private Boolean expand_2;
//
//    private Boolean expand_3;
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @javax.persistence.Transient
    private String b_time; //起始时间 搜索用到

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @javax.persistence.Transient
    private String e_time; //结束时间 搜索用到

    @javax.persistence.Transient
    private Integer order; //查询排序 正序0,倒序1

}
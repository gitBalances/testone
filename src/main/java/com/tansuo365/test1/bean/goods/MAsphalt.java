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

/**
 * 改质沥青
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MAsphalt implements Serializable, Goods {

    private Long id;

    @ExcelCell(index = 0)
    private String province;
    @ExcelCell(index = 1)
    private String company;
    @ExcelCell(index = 2)
    private String s_company;
    @ExcelCell(index = 3)
    private Double softening_point;
    @ExcelCell(index = 4)
    private Double toluene;
    @ExcelCell(index = 5)
    private Double quinoline;
    @ExcelCell(index = 6)
    private Double beta_resin;
    @ExcelCell(index = 7)
    private Double coking_value;
    @ExcelCell(index = 8)
    private Double ash;
    @ExcelCell(index = 9)
    private Double today_price;
    @ExcelCell(index = 10)
    private String remarks;
    @ExcelCell(index = 11)
    private String reporter;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ExcelCell(index = 12)
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ExcelCell(index = 13)
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
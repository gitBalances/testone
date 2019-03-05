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
 * 改质沥青
 */
@ApiModel(value="沥青实体",description="货品-改质沥青实体")
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
    private String softening_point;
    @ExcelCell(index = 4)
    private String toluene;
    @ExcelCell(index = 5)
    private String quinoline;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 12)
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 13)
    private Date update_time;

    //    private Boolean expand_1;
//
//    private Boolean expand_2;
//
//    private Boolean expand_3;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @javax.persistence.Transient
    private String b_time; //起始时间 搜索用到

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @javax.persistence.Transient
    private String e_time; //结束时间 搜索用到

    @javax.persistence.Transient
    private Integer order; //查询排序 正序0,倒序1


    /*搜索指标用*/
    @Transient
    private String s_softening_point;
    @Transient
    private String s_toluene;
    @Transient
    private String s_quinoline;
    @Transient
    private String s_beta_resin;
    @Transient
    private String s_coking_value;
    @Transient
    private String s_ash;
    @Transient
    private String s_today_price;

    public void setSearchParams(String s_spoint,String s_toluene,
                                String s_quinoline,String s_beta_resin,String s_c_value,
                                String s_ash,String s_price){
        this.s_softening_point = s_spoint;
        this.s_toluene = s_toluene;
        this.s_quinoline = s_quinoline;
        this.s_beta_resin = s_beta_resin;
        this.s_coking_value = s_c_value;
        this.s_ash = s_ash;
        this.s_today_price = s_price;
    }

}
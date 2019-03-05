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

@ApiModel(value="阳极实体",description="货品-阳极实体")
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
    private String size; //TODO 待拆分,查询
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 20)
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ExcelCell(index = 21)
    private Date update_time;

    //    private Boolean expand_1;
//
//    private Boolean expand_2;
//
//    private Boolean expand_3;
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
    private String s_e_density;
    @Transient
    private String s_true_density;
    @Transient
    private String s_compressive;
    @Transient
    private String s_carbon;
    @Transient
    private String s_flexural;
    @Transient
    private String s_room;
    @Transient
    private String s_thermal;
    @Transient
    private String s_ash;
    @Transient
    private String s_size;
    @Transient
    private String s_bowl_sum;
    @Transient
    private String s_bowl_distance;
    @Transient
    private String s_in_diameter;
    @Transient
    private String s_out_diameter;
    @Transient
    private String s_slot;
    @Transient
    private String s_today_price;

    public void setSearchParams(String s_e_density, String s_true_density,
                                String s_compressive, String s_carbon, String s_flexural,
                                String s_room, String s_thermal, String s_ash,
                                String s_size, String s_bowl_sum, String s_bowl_dis,
                                String s_in_dia, String s_out_dia, String s_slot,
                                String s_price) {
        this.s_e_density = s_e_density;
        this.s_true_density = s_true_density;
        this.s_compressive = s_compressive;
        this.s_carbon = s_carbon;
        this.s_flexural = s_flexural;
        this.s_room = s_room;
        this.s_thermal = s_thermal;
        this.s_ash = s_ash;
        this.s_size = s_size;
        this.s_bowl_sum = s_bowl_sum;
        this.s_bowl_distance = s_bowl_dis;
        this.s_in_diameter = s_in_dia;
        this.s_out_diameter = s_out_dia;
        this.s_slot = s_slot;
        this.s_today_price = s_price;
    }
}
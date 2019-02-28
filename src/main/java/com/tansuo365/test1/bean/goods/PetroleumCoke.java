package com.tansuo365.test1.bean.goods;

//import cn.afterturn.easypoi.excel.annotation.Excel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
import com.tansuo365.test1.excel.ExcelCell;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;

/**
 * 货品石油焦
 * 原使用poi的导出(@Excel),改为直接使用js前端进行导出(@ExcelCell)
 * 指定的index如果不指定将按照数据库顺序给出,不影响导出
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetroleumCoke implements Serializable, Goods {

    private static final long serialVersionUID = -6077958594667413658L;
    //    @ExcelCell(index = 0)
    private Long id;
    //    @Excel(name = "品级", orderNum = "0")
//    @ExcelCell(index = 1)
    private String grade;
    //    @Excel(name = "省份", orderNum = "1")
    @ExcelCell(index = 0)
    private String province;
    //    @Excel(name = "企业", orderNum = "2")
    @ExcelCell(index = 1)
    private String company;
    //    @Excel(name = "简称", orderNum = "3")
    @ExcelCell(index = 2)
    private String s_company;
    //    @Excel(name = "硫含量%", orderNum = "4")
    @ExcelCell(index = 3)
    private Double sulfur;
    //    @Excel(name = "灰分%", orderNum = "5")
    @ExcelCell(index = 4)
    private Double ash;
    //    @Excel(name = "挥发分%", orderNum = "6")
    @ExcelCell(index = 5)
    private Double volatile_matter;
    //    @Excel(name = "扣水率%", orderNum = "7")
    @ExcelCell(index = 6)
    private Double wdr;
    //    @Excel(name = "钒含量ppm", orderNum = "8")
    @ExcelCell(index = 7)
    private Double vanadium;
    //    @Excel(name = "真密度g/cm³", orderNum = "9")
    @ExcelCell(index = 8)
    private Double density;
    //    @Excel(name = "粉焦量%", orderNum = "10")
    @ExcelCell(index = 9)
    private Double coke_content;
    //    @Excel(name = "类型", orderNum = "11")
    @ExcelCell(index = 10)
    private String coke_type;
    //    @Excel(name = "今日报价", orderNum = "12")
    @ExcelCell(index = 11)
    private Double today_price;
    //    @Excel(name = "备注", orderNum = "13")
    @ExcelCell(index = 12)
    private String remarks;

//    private Boolean expand_2;
//    private Boolean expand_3;

    @ExcelCell(index = 13)
    private String reporter;
    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "创建时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "14")
    @ExcelCell(index = 14)
    private Date create_time;


    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8") //时区+8
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @Excel(name = "更新时间", exportFormat = "yyyy-MM-dd HH:mm:ss", orderNum = "15")
//    @ExcelCell(index = 14)
    private Date update_time;

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String b_time; //起始时间 搜索用到

    //    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Transient
    private String e_time; //结束时间 搜索用到

    @Transient
    private Integer order; //查询排序 正序0,倒序1



    /*搜索使用*/


    @Transient
    private String s_sulfur;
    @Transient
    private String s_ash;
    @Transient
    private String s_volatile_matter;
    @Transient
    private String s_wdr;
    @Transient
    private String s_vanadium;
    @Transient
    private String s_density;
    @Transient
    private String s_coke_content;
    @Transient
    private String s_today_price;

    public void setSearchParams(String s_sulfur, String s_ash, String s_v_matter, String s_wdr, String s_vanadium
            , String s_density, String s_c_content, String s_price) {
        this.s_sulfur = s_sulfur;
        this.s_ash = s_ash;
        this.s_volatile_matter = s_v_matter;
        this.s_wdr = s_wdr;
        this.s_vanadium = s_vanadium;
        this.s_density = s_density;
        this.s_coke_content = s_c_content;
        this.s_today_price = s_price;
    }

}
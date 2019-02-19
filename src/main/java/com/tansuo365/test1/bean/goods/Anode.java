package com.tansuo365.test1.bean.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
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
public class Anode implements Serializable,Goods {

    private Integer id;

    private String province;

    private String company;

    private String s_company;

    private Double e_density;

    private Double true_density;

    private Double compressive;

    private Double carbon;

    private Double flexural;

    private Double room;

    private Double thermal;

    private Double ash;

    private String size;

    private Integer bowl_sum;

    private Double bowl_distance;

    private Double in_diameter;

    private Double out_diameter;

    private String slot;

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
    public Double getSulfur() {
        return null;
    }

    @Override
    public void setGrade(String grade) {
    }
}
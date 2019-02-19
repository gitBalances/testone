package com.tansuo365.test1.bean.goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalcinedCokeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CalcinedCokeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andS_companyIsNull() {
            addCriterion("s_company is null");
            return (Criteria) this;
        }

        public Criteria andS_companyIsNotNull() {
            addCriterion("s_company is not null");
            return (Criteria) this;
        }

        public Criteria andS_companyEqualTo(String value) {
            addCriterion("s_company =", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotEqualTo(String value) {
            addCriterion("s_company <>", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyGreaterThan(String value) {
            addCriterion("s_company >", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyGreaterThanOrEqualTo(String value) {
            addCriterion("s_company >=", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLessThan(String value) {
            addCriterion("s_company <", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLessThanOrEqualTo(String value) {
            addCriterion("s_company <=", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLike(String value) {
            addCriterion("s_company like", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotLike(String value) {
            addCriterion("s_company not like", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyIn(List<String> values) {
            addCriterion("s_company in", values, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotIn(List<String> values) {
            addCriterion("s_company not in", values, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyBetween(String value1, String value2) {
            addCriterion("s_company between", value1, value2, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotBetween(String value1, String value2) {
            addCriterion("s_company not between", value1, value2, "s_company");
            return (Criteria) this;
        }

        public Criteria andSulfurIsNull() {
            addCriterion("sulfur is null");
            return (Criteria) this;
        }

        public Criteria andSulfurIsNotNull() {
            addCriterion("sulfur is not null");
            return (Criteria) this;
        }

        public Criteria andSulfurEqualTo(Double value) {
            addCriterion("sulfur =", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotEqualTo(Double value) {
            addCriterion("sulfur <>", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurGreaterThan(Double value) {
            addCriterion("sulfur >", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurGreaterThanOrEqualTo(Double value) {
            addCriterion("sulfur >=", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurLessThan(Double value) {
            addCriterion("sulfur <", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurLessThanOrEqualTo(Double value) {
            addCriterion("sulfur <=", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurIn(List<Double> values) {
            addCriterion("sulfur in", values, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotIn(List<Double> values) {
            addCriterion("sulfur not in", values, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurBetween(Double value1, Double value2) {
            addCriterion("sulfur between", value1, value2, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotBetween(Double value1, Double value2) {
            addCriterion("sulfur not between", value1, value2, "sulfur");
            return (Criteria) this;
        }

        public Criteria andAshIsNull() {
            addCriterion("ash is null");
            return (Criteria) this;
        }

        public Criteria andAshIsNotNull() {
            addCriterion("ash is not null");
            return (Criteria) this;
        }

        public Criteria andAshEqualTo(Double value) {
            addCriterion("ash =", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotEqualTo(Double value) {
            addCriterion("ash <>", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThan(Double value) {
            addCriterion("ash >", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThanOrEqualTo(Double value) {
            addCriterion("ash >=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThan(Double value) {
            addCriterion("ash <", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThanOrEqualTo(Double value) {
            addCriterion("ash <=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshIn(List<Double> values) {
            addCriterion("ash in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotIn(List<Double> values) {
            addCriterion("ash not in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshBetween(Double value1, Double value2) {
            addCriterion("ash between", value1, value2, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotBetween(Double value1, Double value2) {
            addCriterion("ash not between", value1, value2, "ash");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterIsNull() {
            addCriterion("volatile_matter is null");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterIsNotNull() {
            addCriterion("volatile_matter is not null");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterEqualTo(Double value) {
            addCriterion("volatile_matter =", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotEqualTo(Double value) {
            addCriterion("volatile_matter <>", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterGreaterThan(Double value) {
            addCriterion("volatile_matter >", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterGreaterThanOrEqualTo(Double value) {
            addCriterion("volatile_matter >=", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterLessThan(Double value) {
            addCriterion("volatile_matter <", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterLessThanOrEqualTo(Double value) {
            addCriterion("volatile_matter <=", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterIn(List<Double> values) {
            addCriterion("volatile_matter in", values, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotIn(List<Double> values) {
            addCriterion("volatile_matter not in", values, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterBetween(Double value1, Double value2) {
            addCriterion("volatile_matter between", value1, value2, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotBetween(Double value1, Double value2) {
            addCriterion("volatile_matter not between", value1, value2, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andWaterIsNull() {
            addCriterion("water is null");
            return (Criteria) this;
        }

        public Criteria andWaterIsNotNull() {
            addCriterion("water is not null");
            return (Criteria) this;
        }

        public Criteria andWaterEqualTo(Double value) {
            addCriterion("water =", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotEqualTo(Double value) {
            addCriterion("water <>", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThan(Double value) {
            addCriterion("water >", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterGreaterThanOrEqualTo(Double value) {
            addCriterion("water >=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThan(Double value) {
            addCriterion("water <", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterLessThanOrEqualTo(Double value) {
            addCriterion("water <=", value, "water");
            return (Criteria) this;
        }

        public Criteria andWaterIn(List<Double> values) {
            addCriterion("water in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotIn(List<Double> values) {
            addCriterion("water not in", values, "water");
            return (Criteria) this;
        }

        public Criteria andWaterBetween(Double value1, Double value2) {
            addCriterion("water between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andWaterNotBetween(Double value1, Double value2) {
            addCriterion("water not between", value1, value2, "water");
            return (Criteria) this;
        }

        public Criteria andDensityIsNull() {
            addCriterion("density is null");
            return (Criteria) this;
        }

        public Criteria andDensityIsNotNull() {
            addCriterion("density is not null");
            return (Criteria) this;
        }

        public Criteria andDensityEqualTo(Double value) {
            addCriterion("density =", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotEqualTo(Double value) {
            addCriterion("density <>", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThan(Double value) {
            addCriterion("density >", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThanOrEqualTo(Double value) {
            addCriterion("density >=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThan(Double value) {
            addCriterion("density <", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThanOrEqualTo(Double value) {
            addCriterion("density <=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityIn(List<Double> values) {
            addCriterion("density in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotIn(List<Double> values) {
            addCriterion("density not in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityBetween(Double value1, Double value2) {
            addCriterion("density between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotBetween(Double value1, Double value2) {
            addCriterion("density not between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andP_resistivityIsNull() {
            addCriterion("p_resistivity is null");
            return (Criteria) this;
        }

        public Criteria andP_resistivityIsNotNull() {
            addCriterion("p_resistivity is not null");
            return (Criteria) this;
        }

        public Criteria andP_resistivityEqualTo(String value) {
            addCriterion("p_resistivity =", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityNotEqualTo(String value) {
            addCriterion("p_resistivity <>", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityGreaterThan(String value) {
            addCriterion("p_resistivity >", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityGreaterThanOrEqualTo(String value) {
            addCriterion("p_resistivity >=", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityLessThan(String value) {
            addCriterion("p_resistivity <", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityLessThanOrEqualTo(String value) {
            addCriterion("p_resistivity <=", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityLike(String value) {
            addCriterion("p_resistivity like", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityNotLike(String value) {
            addCriterion("p_resistivity not like", value, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityIn(List<String> values) {
            addCriterion("p_resistivity in", values, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityNotIn(List<String> values) {
            addCriterion("p_resistivity not in", values, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityBetween(String value1, String value2) {
            addCriterion("p_resistivity between", value1, value2, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andP_resistivityNotBetween(String value1, String value2) {
            addCriterion("p_resistivity not between", value1, value2, "p_resistivity");
            return (Criteria) this;
        }

        public Criteria andVanadiumIsNull() {
            addCriterion("vanadium is null");
            return (Criteria) this;
        }

        public Criteria andVanadiumIsNotNull() {
            addCriterion("vanadium is not null");
            return (Criteria) this;
        }

        public Criteria andVanadiumEqualTo(Double value) {
            addCriterion("vanadium =", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotEqualTo(Double value) {
            addCriterion("vanadium <>", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumGreaterThan(Double value) {
            addCriterion("vanadium >", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumGreaterThanOrEqualTo(Double value) {
            addCriterion("vanadium >=", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumLessThan(Double value) {
            addCriterion("vanadium <", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumLessThanOrEqualTo(Double value) {
            addCriterion("vanadium <=", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumIn(List<Double> values) {
            addCriterion("vanadium in", values, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotIn(List<Double> values) {
            addCriterion("vanadium not in", values, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumBetween(Double value1, Double value2) {
            addCriterion("vanadium between", value1, value2, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotBetween(Double value1, Double value2) {
            addCriterion("vanadium not between", value1, value2, "vanadium");
            return (Criteria) this;
        }

        public Criteria andGranularityIsNull() {
            addCriterion("granularity is null");
            return (Criteria) this;
        }

        public Criteria andGranularityIsNotNull() {
            addCriterion("granularity is not null");
            return (Criteria) this;
        }

        public Criteria andGranularityEqualTo(Double value) {
            addCriterion("granularity =", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityNotEqualTo(Double value) {
            addCriterion("granularity <>", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityGreaterThan(Double value) {
            addCriterion("granularity >", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityGreaterThanOrEqualTo(Double value) {
            addCriterion("granularity >=", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityLessThan(Double value) {
            addCriterion("granularity <", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityLessThanOrEqualTo(Double value) {
            addCriterion("granularity <=", value, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityIn(List<Double> values) {
            addCriterion("granularity in", values, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityNotIn(List<Double> values) {
            addCriterion("granularity not in", values, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityBetween(Double value1, Double value2) {
            addCriterion("granularity between", value1, value2, "granularity");
            return (Criteria) this;
        }

        public Criteria andGranularityNotBetween(Double value1, Double value2) {
            addCriterion("granularity not between", value1, value2, "granularity");
            return (Criteria) this;
        }

        public Criteria andToday_priceIsNull() {
            addCriterion("today_price is null");
            return (Criteria) this;
        }

        public Criteria andToday_priceIsNotNull() {
            addCriterion("today_price is not null");
            return (Criteria) this;
        }

        public Criteria andToday_priceEqualTo(Double value) {
            addCriterion("today_price =", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotEqualTo(Double value) {
            addCriterion("today_price <>", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceGreaterThan(Double value) {
            addCriterion("today_price >", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("today_price >=", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceLessThan(Double value) {
            addCriterion("today_price <", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceLessThanOrEqualTo(Double value) {
            addCriterion("today_price <=", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceIn(List<Double> values) {
            addCriterion("today_price in", values, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotIn(List<Double> values) {
            addCriterion("today_price not in", values, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceBetween(Double value1, Double value2) {
            addCriterion("today_price between", value1, value2, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotBetween(Double value1, Double value2) {
            addCriterion("today_price not between", value1, value2, "today_price");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andExpand_1IsNull() {
            addCriterion("expand_1 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_1IsNotNull() {
            addCriterion("expand_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_1EqualTo(Boolean value) {
            addCriterion("expand_1 =", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotEqualTo(Boolean value) {
            addCriterion("expand_1 <>", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1GreaterThan(Boolean value) {
            addCriterion("expand_1 >", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_1 >=", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1LessThan(Boolean value) {
            addCriterion("expand_1 <", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_1 <=", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1In(List<Boolean> values) {
            addCriterion("expand_1 in", values, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotIn(List<Boolean> values) {
            addCriterion("expand_1 not in", values, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1Between(Boolean value1, Boolean value2) {
            addCriterion("expand_1 between", value1, value2, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_1 not between", value1, value2, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_2IsNull() {
            addCriterion("expand_2 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_2IsNotNull() {
            addCriterion("expand_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_2EqualTo(Boolean value) {
            addCriterion("expand_2 =", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotEqualTo(Boolean value) {
            addCriterion("expand_2 <>", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2GreaterThan(Boolean value) {
            addCriterion("expand_2 >", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_2 >=", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2LessThan(Boolean value) {
            addCriterion("expand_2 <", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_2 <=", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2In(List<Boolean> values) {
            addCriterion("expand_2 in", values, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotIn(List<Boolean> values) {
            addCriterion("expand_2 not in", values, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2Between(Boolean value1, Boolean value2) {
            addCriterion("expand_2 between", value1, value2, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_2 not between", value1, value2, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_3IsNull() {
            addCriterion("expand_3 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_3IsNotNull() {
            addCriterion("expand_3 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_3EqualTo(Boolean value) {
            addCriterion("expand_3 =", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotEqualTo(Boolean value) {
            addCriterion("expand_3 <>", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3GreaterThan(Boolean value) {
            addCriterion("expand_3 >", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_3 >=", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3LessThan(Boolean value) {
            addCriterion("expand_3 <", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_3 <=", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3In(List<Boolean> values) {
            addCriterion("expand_3 in", values, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotIn(List<Boolean> values) {
            addCriterion("expand_3 not in", values, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3Between(Boolean value1, Boolean value2) {
            addCriterion("expand_3 between", value1, value2, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_3 not between", value1, value2, "expand_3");
            return (Criteria) this;
        }

        public Criteria andReporterIsNull() {
            addCriterion("reporter is null");
            return (Criteria) this;
        }

        public Criteria andReporterIsNotNull() {
            addCriterion("reporter is not null");
            return (Criteria) this;
        }

        public Criteria andReporterEqualTo(String value) {
            addCriterion("reporter =", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotEqualTo(String value) {
            addCriterion("reporter <>", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThan(String value) {
            addCriterion("reporter >", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThanOrEqualTo(String value) {
            addCriterion("reporter >=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThan(String value) {
            addCriterion("reporter <", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThanOrEqualTo(String value) {
            addCriterion("reporter <=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLike(String value) {
            addCriterion("reporter like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotLike(String value) {
            addCriterion("reporter not like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterIn(List<String> values) {
            addCriterion("reporter in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotIn(List<String> values) {
            addCriterion("reporter not in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterBetween(String value1, String value2) {
            addCriterion("reporter between", value1, value2, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotBetween(String value1, String value2) {
            addCriterion("reporter not between", value1, value2, "reporter");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
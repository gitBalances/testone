package com.tansuo365.test1.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PetroleumCokeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PetroleumCokeExample() {
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

        public Criteria andSulfurEqualTo(Float value) {
            addCriterion("sulfur =", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotEqualTo(Float value) {
            addCriterion("sulfur <>", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurGreaterThan(Float value) {
            addCriterion("sulfur >", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurGreaterThanOrEqualTo(Float value) {
            addCriterion("sulfur >=", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurLessThan(Float value) {
            addCriterion("sulfur <", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurLessThanOrEqualTo(Float value) {
            addCriterion("sulfur <=", value, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurIn(List<Float> values) {
            addCriterion("sulfur in", values, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotIn(List<Float> values) {
            addCriterion("sulfur not in", values, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurBetween(Float value1, Float value2) {
            addCriterion("sulfur between", value1, value2, "sulfur");
            return (Criteria) this;
        }

        public Criteria andSulfurNotBetween(Float value1, Float value2) {
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

        public Criteria andAshEqualTo(Float value) {
            addCriterion("ash =", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotEqualTo(Float value) {
            addCriterion("ash <>", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThan(Float value) {
            addCriterion("ash >", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThanOrEqualTo(Float value) {
            addCriterion("ash >=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThan(Float value) {
            addCriterion("ash <", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThanOrEqualTo(Float value) {
            addCriterion("ash <=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshIn(List<Float> values) {
            addCriterion("ash in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotIn(List<Float> values) {
            addCriterion("ash not in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshBetween(Float value1, Float value2) {
            addCriterion("ash between", value1, value2, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotBetween(Float value1, Float value2) {
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

        public Criteria andVolatile_matterEqualTo(Float value) {
            addCriterion("volatile_matter =", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotEqualTo(Float value) {
            addCriterion("volatile_matter <>", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterGreaterThan(Float value) {
            addCriterion("volatile_matter >", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterGreaterThanOrEqualTo(Float value) {
            addCriterion("volatile_matter >=", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterLessThan(Float value) {
            addCriterion("volatile_matter <", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterLessThanOrEqualTo(Float value) {
            addCriterion("volatile_matter <=", value, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterIn(List<Float> values) {
            addCriterion("volatile_matter in", values, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotIn(List<Float> values) {
            addCriterion("volatile_matter not in", values, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterBetween(Float value1, Float value2) {
            addCriterion("volatile_matter between", value1, value2, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andVolatile_matterNotBetween(Float value1, Float value2) {
            addCriterion("volatile_matter not between", value1, value2, "volatile_matter");
            return (Criteria) this;
        }

        public Criteria andWdrIsNull() {
            addCriterion("wdr is null");
            return (Criteria) this;
        }

        public Criteria andWdrIsNotNull() {
            addCriterion("wdr is not null");
            return (Criteria) this;
        }

        public Criteria andWdrEqualTo(Float value) {
            addCriterion("wdr =", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrNotEqualTo(Float value) {
            addCriterion("wdr <>", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrGreaterThan(Float value) {
            addCriterion("wdr >", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrGreaterThanOrEqualTo(Float value) {
            addCriterion("wdr >=", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrLessThan(Float value) {
            addCriterion("wdr <", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrLessThanOrEqualTo(Float value) {
            addCriterion("wdr <=", value, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrIn(List<Float> values) {
            addCriterion("wdr in", values, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrNotIn(List<Float> values) {
            addCriterion("wdr not in", values, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrBetween(Float value1, Float value2) {
            addCriterion("wdr between", value1, value2, "wdr");
            return (Criteria) this;
        }

        public Criteria andWdrNotBetween(Float value1, Float value2) {
            addCriterion("wdr not between", value1, value2, "wdr");
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

        public Criteria andVanadiumEqualTo(Float value) {
            addCriterion("vanadium =", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotEqualTo(Float value) {
            addCriterion("vanadium <>", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumGreaterThan(Float value) {
            addCriterion("vanadium >", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumGreaterThanOrEqualTo(Float value) {
            addCriterion("vanadium >=", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumLessThan(Float value) {
            addCriterion("vanadium <", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumLessThanOrEqualTo(Float value) {
            addCriterion("vanadium <=", value, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumIn(List<Float> values) {
            addCriterion("vanadium in", values, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotIn(List<Float> values) {
            addCriterion("vanadium not in", values, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumBetween(Float value1, Float value2) {
            addCriterion("vanadium between", value1, value2, "vanadium");
            return (Criteria) this;
        }

        public Criteria andVanadiumNotBetween(Float value1, Float value2) {
            addCriterion("vanadium not between", value1, value2, "vanadium");
            return (Criteria) this;
        }

        public Criteria andCoke_typeIsNull() {
            addCriterion("coke_type is null");
            return (Criteria) this;
        }

        public Criteria andCoke_typeIsNotNull() {
            addCriterion("coke_type is not null");
            return (Criteria) this;
        }

        public Criteria andCoke_typeEqualTo(String value) {
            addCriterion("coke_type =", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeNotEqualTo(String value) {
            addCriterion("coke_type <>", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeGreaterThan(String value) {
            addCriterion("coke_type >", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeGreaterThanOrEqualTo(String value) {
            addCriterion("coke_type >=", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeLessThan(String value) {
            addCriterion("coke_type <", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeLessThanOrEqualTo(String value) {
            addCriterion("coke_type <=", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeLike(String value) {
            addCriterion("coke_type like", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeNotLike(String value) {
            addCriterion("coke_type not like", value, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeIn(List<String> values) {
            addCriterion("coke_type in", values, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeNotIn(List<String> values) {
            addCriterion("coke_type not in", values, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeBetween(String value1, String value2) {
            addCriterion("coke_type between", value1, value2, "coke_type");
            return (Criteria) this;
        }

        public Criteria andCoke_typeNotBetween(String value1, String value2) {
            addCriterion("coke_type not between", value1, value2, "coke_type");
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

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Short value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Short value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Short value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Short value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Short value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Short> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Short> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Short value1, Short value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Short value1, Short value2) {
            addCriterion("grade not between", value1, value2, "grade");
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

        public Criteria andDensityIsNull() {
            addCriterion("density is null");
            return (Criteria) this;
        }

        public Criteria andDensityIsNotNull() {
            addCriterion("density is not null");
            return (Criteria) this;
        }

        public Criteria andDensityEqualTo(Float value) {
            addCriterion("density =", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotEqualTo(Float value) {
            addCriterion("density <>", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThan(Float value) {
            addCriterion("density >", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThanOrEqualTo(Float value) {
            addCriterion("density >=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThan(Float value) {
            addCriterion("density <", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThanOrEqualTo(Float value) {
            addCriterion("density <=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityIn(List<Float> values) {
            addCriterion("density in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotIn(List<Float> values) {
            addCriterion("density not in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityBetween(Float value1, Float value2) {
            addCriterion("density between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotBetween(Float value1, Float value2) {
            addCriterion("density not between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andCoke_contentIsNull() {
            addCriterion("coke_content is null");
            return (Criteria) this;
        }

        public Criteria andCoke_contentIsNotNull() {
            addCriterion("coke_content is not null");
            return (Criteria) this;
        }

        public Criteria andCoke_contentEqualTo(Float value) {
            addCriterion("coke_content =", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentNotEqualTo(Float value) {
            addCriterion("coke_content <>", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentGreaterThan(Float value) {
            addCriterion("coke_content >", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentGreaterThanOrEqualTo(Float value) {
            addCriterion("coke_content >=", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentLessThan(Float value) {
            addCriterion("coke_content <", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentLessThanOrEqualTo(Float value) {
            addCriterion("coke_content <=", value, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentIn(List<Float> values) {
            addCriterion("coke_content in", values, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentNotIn(List<Float> values) {
            addCriterion("coke_content not in", values, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentBetween(Float value1, Float value2) {
            addCriterion("coke_content between", value1, value2, "coke_content");
            return (Criteria) this;
        }

        public Criteria andCoke_contentNotBetween(Float value1, Float value2) {
            addCriterion("coke_content not between", value1, value2, "coke_content");
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
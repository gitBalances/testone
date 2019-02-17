//package com.tansuo365.test1.unused;
//
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class MemberExample {
//    protected String orderByClause;
//
//    protected boolean distinct;
//
//    protected List<Criteria> oredCriteria;
//
//    public MemberExample() {
//        oredCriteria = new ArrayList<Criteria>();
//    }
//
//    public void setOrderByClause(String orderByClause) {
//        this.orderByClause = orderByClause;
//    }
//
//    public String getOrderByClause() {
//        return orderByClause;
//    }
//
//    public void setDistinct(boolean distinct) {
//        this.distinct = distinct;
//    }
//
//    public boolean isDistinct() {
//        return distinct;
//    }
//
//    public List<Criteria> getOredCriteria() {
//        return oredCriteria;
//    }
//
//    public void or(Criteria criteria) {
//        oredCriteria.add(criteria);
//    }
//
//    public Criteria or() {
//        Criteria criteria = createCriteriaInternal();
//        oredCriteria.add(criteria);
//        return criteria;
//    }
//
//    public Criteria createCriteria() {
//        Criteria criteria = createCriteriaInternal();
//        if (oredCriteria.size() == 0) {
//            oredCriteria.add(criteria);
//        }
//        return criteria;
//    }
//
//    protected Criteria createCriteriaInternal() {
//        Criteria criteria = new Criteria();
//        return criteria;
//    }
//
//    public void clear() {
//        oredCriteria.clear();
//        orderByClause = null;
//        distinct = false;
//    }
//
//    protected abstract static class GeneratedCriteria {
//        protected List<Criterion> criteria;
//
//        protected GeneratedCriteria() {
//            super();
//            criteria = new ArrayList<Criterion>();
//        }
//
//        public boolean isValid() {
//            return criteria.size() > 0;
//        }
//
//        public List<Criterion> getAllCriteria() {
//            return criteria;
//        }
//
//        public List<Criterion> getCriteria() {
//            return criteria;
//        }
//
//        protected void addCriterion(String condition) {
//            if (condition == null) {
//                throw new RuntimeException("Value for condition cannot be null");
//            }
//            criteria.add(new Criterion(condition));
//        }
//
//        protected void addCriterion(String condition, Object value, String property) {
//            if (value == null) {
//                throw new RuntimeException("Value for " + property + " cannot be null");
//            }
//            criteria.add(new Criterion(condition, value));
//        }
//
//        protected void addCriterion(String condition, Object value1, Object value2, String property) {
//            if (value1 == null || value2 == null) {
//                throw new RuntimeException("Between values for " + property + " cannot be null");
//            }
//            criteria.add(new Criterion(condition, value1, value2));
//        }
//
//        public Criteria andIdIsNull() {
//            addCriterion("id is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdIsNotNull() {
//            addCriterion("id is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdEqualTo(Long value) {
//            addCriterion("id =", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdNotEqualTo(Long value) {
//            addCriterion("id <>", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdGreaterThan(Long value) {
//            addCriterion("id >", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdGreaterThanOrEqualTo(Long value) {
//            addCriterion("id >=", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdLessThan(Long value) {
//            addCriterion("id <", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdLessThanOrEqualTo(Long value) {
//            addCriterion("id <=", value, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdIn(List<Long> values) {
//            addCriterion("id in", values, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdNotIn(List<Long> values) {
//            addCriterion("id not in", values, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdBetween(Long value1, Long value2) {
//            addCriterion("id between", value1, value2, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andIdNotBetween(Long value1, Long value2) {
//            addCriterion("id not between", value1, value2, "id");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameIsNull() {
//            addCriterion("username is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameIsNotNull() {
//            addCriterion("username is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameEqualTo(String value) {
//            addCriterion("username =", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameNotEqualTo(String value) {
//            addCriterion("username <>", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameGreaterThan(String value) {
//            addCriterion("username >", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
//            addCriterion("username >=", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameLessThan(String value) {
//            addCriterion("username <", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameLessThanOrEqualTo(String value) {
//            addCriterion("username <=", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameLike(String value) {
//            addCriterion("username like", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameNotLike(String value) {
//            addCriterion("username not like", value, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameIn(List<String> values) {
//            addCriterion("username in", values, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameNotIn(List<String> values) {
//            addCriterion("username not in", values, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameBetween(String value1, String value2) {
//            addCriterion("username between", value1, value2, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andUsernameNotBetween(String value1, String value2) {
//            addCriterion("username not between", value1, value2, "username");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordIsNull() {
//            addCriterion("password is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordIsNotNull() {
//            addCriterion("password is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordEqualTo(String value) {
//            addCriterion("password =", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordNotEqualTo(String value) {
//            addCriterion("password <>", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordGreaterThan(String value) {
//            addCriterion("password >", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
//            addCriterion("password >=", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordLessThan(String value) {
//            addCriterion("password <", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordLessThanOrEqualTo(String value) {
//            addCriterion("password <=", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordLike(String value) {
//            addCriterion("password like", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordNotLike(String value) {
//            addCriterion("password not like", value, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordIn(List<String> values) {
//            addCriterion("password in", values, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordNotIn(List<String> values) {
//            addCriterion("password not in", values, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordBetween(String value1, String value2) {
//            addCriterion("password between", value1, value2, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andPasswordNotBetween(String value1, String value2) {
//            addCriterion("password not between", value1, value2, "password");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyIsNull() {
//            addCriterion("company is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyIsNotNull() {
//            addCriterion("company is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyEqualTo(String value) {
//            addCriterion("company =", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyNotEqualTo(String value) {
//            addCriterion("company <>", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyGreaterThan(String value) {
//            addCriterion("company >", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
//            addCriterion("company >=", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyLessThan(String value) {
//            addCriterion("company <", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyLessThanOrEqualTo(String value) {
//            addCriterion("company <=", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyLike(String value) {
//            addCriterion("company like", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyNotLike(String value) {
//            addCriterion("company not like", value, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyIn(List<String> values) {
//            addCriterion("company in", values, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyNotIn(List<String> values) {
//            addCriterion("company not in", values, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyBetween(String value1, String value2) {
//            addCriterion("company between", value1, value2, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andCompanyNotBetween(String value1, String value2) {
//            addCriterion("company not between", value1, value2, "company");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameIsNull() {
//            addCriterion("truename is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameIsNotNull() {
//            addCriterion("truename is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameEqualTo(String value) {
//            addCriterion("truename =", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameNotEqualTo(String value) {
//            addCriterion("truename <>", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameGreaterThan(String value) {
//            addCriterion("truename >", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameGreaterThanOrEqualTo(String value) {
//            addCriterion("truename >=", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameLessThan(String value) {
//            addCriterion("truename <", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameLessThanOrEqualTo(String value) {
//            addCriterion("truename <=", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameLike(String value) {
//            addCriterion("truename like", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameNotLike(String value) {
//            addCriterion("truename not like", value, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameIn(List<String> values) {
//            addCriterion("truename in", values, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameNotIn(List<String> values) {
//            addCriterion("truename not in", values, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameBetween(String value1, String value2) {
//            addCriterion("truename between", value1, value2, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andTruenameNotBetween(String value1, String value2) {
//            addCriterion("truename not between", value1, value2, "truename");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneIsNull() {
//            addCriterion("phone is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneIsNotNull() {
//            addCriterion("phone is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneEqualTo(Long value) {
//            addCriterion("phone =", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneNotEqualTo(Long value) {
//            addCriterion("phone <>", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneGreaterThan(Long value) {
//            addCriterion("phone >", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneGreaterThanOrEqualTo(Long value) {
//            addCriterion("phone >=", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneLessThan(Long value) {
//            addCriterion("phone <", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneLessThanOrEqualTo(Long value) {
//            addCriterion("phone <=", value, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneIn(List<Long> values) {
//            addCriterion("phone in", values, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneNotIn(List<Long> values) {
//            addCriterion("phone not in", values, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneBetween(Long value1, Long value2) {
//            addCriterion("phone between", value1, value2, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andPhoneNotBetween(Long value1, Long value2) {
//            addCriterion("phone not between", value1, value2, "phone");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexIsNull() {
//            addCriterion("sex is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexIsNotNull() {
//            addCriterion("sex is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexEqualTo(Short value) {
//            addCriterion("sex =", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexNotEqualTo(Short value) {
//            addCriterion("sex <>", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexGreaterThan(Short value) {
//            addCriterion("sex >", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexGreaterThanOrEqualTo(Short value) {
//            addCriterion("sex >=", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexLessThan(Short value) {
//            addCriterion("sex <", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexLessThanOrEqualTo(Short value) {
//            addCriterion("sex <=", value, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexIn(List<Short> values) {
//            addCriterion("sex in", values, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexNotIn(List<Short> values) {
//            addCriterion("sex not in", values, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexBetween(Short value1, Short value2) {
//            addCriterion("sex between", value1, value2, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andSexNotBetween(Short value1, Short value2) {
//            addCriterion("sex not between", value1, value2, "sex");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailIsNull() {
//            addCriterion("email is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailIsNotNull() {
//            addCriterion("email is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailEqualTo(String value) {
//            addCriterion("email =", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailNotEqualTo(String value) {
//            addCriterion("email <>", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailGreaterThan(String value) {
//            addCriterion("email >", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailGreaterThanOrEqualTo(String value) {
//            addCriterion("email >=", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailLessThan(String value) {
//            addCriterion("email <", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailLessThanOrEqualTo(String value) {
//            addCriterion("email <=", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailLike(String value) {
//            addCriterion("email like", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailNotLike(String value) {
//            addCriterion("email not like", value, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailIn(List<String> values) {
//            addCriterion("email in", values, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailNotIn(List<String> values) {
//            addCriterion("email not in", values, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailBetween(String value1, String value2) {
//            addCriterion("email between", value1, value2, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andEmailNotBetween(String value1, String value2) {
//            addCriterion("email not between", value1, value2, "email");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeIsNull() {
//            addCriterion("member_type is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeIsNotNull() {
//            addCriterion("member_type is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeEqualTo(Short value) {
//            addCriterion("member_type =", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeNotEqualTo(Short value) {
//            addCriterion("member_type <>", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeGreaterThan(Short value) {
//            addCriterion("member_type >", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeGreaterThanOrEqualTo(Short value) {
//            addCriterion("member_type >=", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeLessThan(Short value) {
//            addCriterion("member_type <", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeLessThanOrEqualTo(Short value) {
//            addCriterion("member_type <=", value, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeIn(List<Short> values) {
//            addCriterion("member_type in", values, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeNotIn(List<Short> values) {
//            addCriterion("member_type not in", values, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeBetween(Short value1, Short value2) {
//            addCriterion("member_type between", value1, value2, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_typeNotBetween(Short value1, Short value2) {
//            addCriterion("member_type not between", value1, value2, "member_type");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelIsNull() {
//            addCriterion("member_level is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelIsNotNull() {
//            addCriterion("member_level is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelEqualTo(Short value) {
//            addCriterion("member_level =", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelNotEqualTo(Short value) {
//            addCriterion("member_level <>", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelGreaterThan(Short value) {
//            addCriterion("member_level >", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelGreaterThanOrEqualTo(Short value) {
//            addCriterion("member_level >=", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelLessThan(Short value) {
//            addCriterion("member_level <", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelLessThanOrEqualTo(Short value) {
//            addCriterion("member_level <=", value, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelIn(List<Short> values) {
//            addCriterion("member_level in", values, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelNotIn(List<Short> values) {
//            addCriterion("member_level not in", values, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelBetween(Short value1, Short value2) {
//            addCriterion("member_level between", value1, value2, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andMember_levelNotBetween(Short value1, Short value2) {
//            addCriterion("member_level not between", value1, value2, "member_level");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeIsNull() {
//            addCriterion("create_time is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeIsNotNull() {
//            addCriterion("create_time is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeEqualTo(Date value) {
//            addCriterion("create_time =", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeNotEqualTo(Date value) {
//            addCriterion("create_time <>", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeGreaterThan(Date value) {
//            addCriterion("create_time >", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
//            addCriterion("create_time >=", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeLessThan(Date value) {
//            addCriterion("create_time <", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
//            addCriterion("create_time <=", value, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeIn(List<Date> values) {
//            addCriterion("create_time in", values, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeNotIn(List<Date> values) {
//            addCriterion("create_time not in", values, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeBetween(Date value1, Date value2) {
//            addCriterion("create_time between", value1, value2, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
//            addCriterion("create_time not between", value1, value2, "create_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeIsNull() {
//            addCriterion("update_time is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeIsNotNull() {
//            addCriterion("update_time is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeEqualTo(Date value) {
//            addCriterion("update_time =", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeNotEqualTo(Date value) {
//            addCriterion("update_time <>", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeGreaterThan(Date value) {
//            addCriterion("update_time >", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
//            addCriterion("update_time >=", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeLessThan(Date value) {
//            addCriterion("update_time <", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
//            addCriterion("update_time <=", value, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeIn(List<Date> values) {
//            addCriterion("update_time in", values, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeNotIn(List<Date> values) {
//            addCriterion("update_time not in", values, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
//            addCriterion("update_time between", value1, value2, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
//            addCriterion("update_time not between", value1, value2, "update_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeIsNull() {
//            addCriterion("lastlogin_time is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeIsNotNull() {
//            addCriterion("lastlogin_time is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeEqualTo(Date value) {
//            addCriterion("lastlogin_time =", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeNotEqualTo(Date value) {
//            addCriterion("lastlogin_time <>", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeGreaterThan(Date value) {
//            addCriterion("lastlogin_time >", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeGreaterThanOrEqualTo(Date value) {
//            addCriterion("lastlogin_time >=", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeLessThan(Date value) {
//            addCriterion("lastlogin_time <", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeLessThanOrEqualTo(Date value) {
//            addCriterion("lastlogin_time <=", value, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeIn(List<Date> values) {
//            addCriterion("lastlogin_time in", values, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeNotIn(List<Date> values) {
//            addCriterion("lastlogin_time not in", values, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeBetween(Date value1, Date value2) {
//            addCriterion("lastlogin_time between", value1, value2, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andLastlogin_timeNotBetween(Date value1, Date value2) {
//            addCriterion("lastlogin_time not between", value1, value2, "lastlogin_time");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltIsNull() {
//            addCriterion("salt is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltIsNotNull() {
//            addCriterion("salt is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltEqualTo(String value) {
//            addCriterion("salt =", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltNotEqualTo(String value) {
//            addCriterion("salt <>", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltGreaterThan(String value) {
//            addCriterion("salt >", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltGreaterThanOrEqualTo(String value) {
//            addCriterion("salt >=", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltLessThan(String value) {
//            addCriterion("salt <", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltLessThanOrEqualTo(String value) {
//            addCriterion("salt <=", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltLike(String value) {
//            addCriterion("salt like", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltNotLike(String value) {
//            addCriterion("salt not like", value, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltIn(List<String> values) {
//            addCriterion("salt in", values, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltNotIn(List<String> values) {
//            addCriterion("salt not in", values, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltBetween(String value1, String value2) {
//            addCriterion("salt between", value1, value2, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andSaltNotBetween(String value1, String value2) {
//            addCriterion("salt not between", value1, value2, "salt");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2IsNull() {
//            addCriterion("expand_2 is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2IsNotNull() {
//            addCriterion("expand_2 is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2EqualTo(Byte value) {
//            addCriterion("expand_2 =", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2NotEqualTo(Byte value) {
//            addCriterion("expand_2 <>", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2GreaterThan(Byte value) {
//            addCriterion("expand_2 >", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2GreaterThanOrEqualTo(Byte value) {
//            addCriterion("expand_2 >=", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2LessThan(Byte value) {
//            addCriterion("expand_2 <", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2LessThanOrEqualTo(Byte value) {
//            addCriterion("expand_2 <=", value, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2In(List<Byte> values) {
//            addCriterion("expand_2 in", values, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2NotIn(List<Byte> values) {
//            addCriterion("expand_2 not in", values, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2Between(Byte value1, Byte value2) {
//            addCriterion("expand_2 between", value1, value2, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_2NotBetween(Byte value1, Byte value2) {
//            addCriterion("expand_2 not between", value1, value2, "expand_2");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3IsNull() {
//            addCriterion("expand_3 is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3IsNotNull() {
//            addCriterion("expand_3 is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3EqualTo(Byte value) {
//            addCriterion("expand_3 =", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3NotEqualTo(Byte value) {
//            addCriterion("expand_3 <>", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3GreaterThan(Byte value) {
//            addCriterion("expand_3 >", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3GreaterThanOrEqualTo(Byte value) {
//            addCriterion("expand_3 >=", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3LessThan(Byte value) {
//            addCriterion("expand_3 <", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3LessThanOrEqualTo(Byte value) {
//            addCriterion("expand_3 <=", value, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3In(List<Byte> values) {
//            addCriterion("expand_3 in", values, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3NotIn(List<Byte> values) {
//            addCriterion("expand_3 not in", values, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3Between(Byte value1, Byte value2) {
//            addCriterion("expand_3 between", value1, value2, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_3NotBetween(Byte value1, Byte value2) {
//            addCriterion("expand_3 not between", value1, value2, "expand_3");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4IsNull() {
//            addCriterion("expand_4 is null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4IsNotNull() {
//            addCriterion("expand_4 is not null");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4EqualTo(Byte value) {
//            addCriterion("expand_4 =", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4NotEqualTo(Byte value) {
//            addCriterion("expand_4 <>", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4GreaterThan(Byte value) {
//            addCriterion("expand_4 >", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4GreaterThanOrEqualTo(Byte value) {
//            addCriterion("expand_4 >=", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4LessThan(Byte value) {
//            addCriterion("expand_4 <", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4LessThanOrEqualTo(Byte value) {
//            addCriterion("expand_4 <=", value, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4In(List<Byte> values) {
//            addCriterion("expand_4 in", values, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4NotIn(List<Byte> values) {
//            addCriterion("expand_4 not in", values, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4Between(Byte value1, Byte value2) {
//            addCriterion("expand_4 between", value1, value2, "expand_4");
//            return (Criteria) this;
//        }
//
//        public Criteria andExpand_4NotBetween(Byte value1, Byte value2) {
//            addCriterion("expand_4 not between", value1, value2, "expand_4");
//            return (Criteria) this;
//        }
//    }
//
//    public static class Criteria extends GeneratedCriteria {
//
//        protected Criteria() {
//            super();
//        }
//    }
//
//    public static class Criterion {
//        private String condition;
//
//        private Object value;
//
//        private Object secondValue;
//
//        private boolean noValue;
//
//        private boolean singleValue;
//
//        private boolean betweenValue;
//
//        private boolean listValue;
//
//        private String typeHandler;
//
//        public String getCondition() {
//            return condition;
//        }
//
//        public Object getValue() {
//            return value;
//        }
//
//        public Object getSecondValue() {
//            return secondValue;
//        }
//
//        public boolean isNoValue() {
//            return noValue;
//        }
//
//        public boolean isSingleValue() {
//            return singleValue;
//        }
//
//        public boolean isBetweenValue() {
//            return betweenValue;
//        }
//
//        public boolean isListValue() {
//            return listValue;
//        }
//
//        public String getTypeHandler() {
//            return typeHandler;
//        }
//
//        protected Criterion(String condition) {
//            super();
//            this.condition = condition;
//            this.typeHandler = null;
//            this.noValue = true;
//        }
//
//        protected Criterion(String condition, Object value, String typeHandler) {
//            super();
//            this.condition = condition;
//            this.value = value;
//            this.typeHandler = typeHandler;
//            if (value instanceof List<?>) {
//                this.listValue = true;
//            } else {
//                this.singleValue = true;
//            }
//        }
//
//        protected Criterion(String condition, Object value) {
//            this(condition, value, null);
//        }
//
//        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
//            super();
//            this.condition = condition;
//            this.value = value;
//            this.secondValue = secondValue;
//            this.typeHandler = typeHandler;
//            this.betweenValue = true;
//        }
//
//        protected Criterion(String condition, Object value, Object secondValue) {
//            this(condition, value, secondValue, null);
//        }
//    }
//}
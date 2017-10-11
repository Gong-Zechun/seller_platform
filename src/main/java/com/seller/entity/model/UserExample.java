package com.seller.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample implements Serializable {
    /**
     * USER
     */
    protected String orderByClause;

    /**
     * USER
     */
    protected boolean distinct;

    /**
     * USER
     */
    protected List<Criteria> oredCriteria;

    /**
     * USER
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public UserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * USER null
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        private static final long serialVersionUID = 1L;

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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSellerNoIsNull() {
            addCriterion("SELLER_NO is null");
            return (Criteria) this;
        }

        public Criteria andSellerNoIsNotNull() {
            addCriterion("SELLER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSellerNoEqualTo(String value) {
            addCriterion("SELLER_NO =", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoNotEqualTo(String value) {
            addCriterion("SELLER_NO <>", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoGreaterThan(String value) {
            addCriterion("SELLER_NO >", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_NO >=", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoLessThan(String value) {
            addCriterion("SELLER_NO <", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoLessThanOrEqualTo(String value) {
            addCriterion("SELLER_NO <=", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoLike(String value) {
            addCriterion("SELLER_NO like", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoNotLike(String value) {
            addCriterion("SELLER_NO not like", value, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoIn(List<String> values) {
            addCriterion("SELLER_NO in", values, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoNotIn(List<String> values) {
            addCriterion("SELLER_NO not in", values, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoBetween(String value1, String value2) {
            addCriterion("SELLER_NO between", value1, value2, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andSellerNoNotBetween(String value1, String value2) {
            addCriterion("SELLER_NO not between", value1, value2, "sellerNo");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("REAL_NAME <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("REAL_NAME like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("REAL_NAME not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("PHONE is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("PHONE =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("PHONE <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("PHONE >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("PHONE >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("PHONE <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("PHONE <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("PHONE like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("PHONE not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("PHONE in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("PHONE not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("PHONE between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("PHONE not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNull() {
            addCriterion("QQ_NUM is null");
            return (Criteria) this;
        }

        public Criteria andQqNumIsNotNull() {
            addCriterion("QQ_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andQqNumEqualTo(String value) {
            addCriterion("QQ_NUM =", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotEqualTo(String value) {
            addCriterion("QQ_NUM <>", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThan(String value) {
            addCriterion("QQ_NUM >", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumGreaterThanOrEqualTo(String value) {
            addCriterion("QQ_NUM >=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThan(String value) {
            addCriterion("QQ_NUM <", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLessThanOrEqualTo(String value) {
            addCriterion("QQ_NUM <=", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumLike(String value) {
            addCriterion("QQ_NUM like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotLike(String value) {
            addCriterion("QQ_NUM not like", value, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumIn(List<String> values) {
            addCriterion("QQ_NUM in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotIn(List<String> values) {
            addCriterion("QQ_NUM not in", values, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumBetween(String value1, String value2) {
            addCriterion("QQ_NUM between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andQqNumNotBetween(String value1, String value2) {
            addCriterion("QQ_NUM not between", value1, value2, "qqNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumIsNull() {
            addCriterion("WECHAT_NUM is null");
            return (Criteria) this;
        }

        public Criteria andWechatNumIsNotNull() {
            addCriterion("WECHAT_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNumEqualTo(String value) {
            addCriterion("WECHAT_NUM =", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotEqualTo(String value) {
            addCriterion("WECHAT_NUM <>", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumGreaterThan(String value) {
            addCriterion("WECHAT_NUM >", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumGreaterThanOrEqualTo(String value) {
            addCriterion("WECHAT_NUM >=", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLessThan(String value) {
            addCriterion("WECHAT_NUM <", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLessThanOrEqualTo(String value) {
            addCriterion("WECHAT_NUM <=", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLike(String value) {
            addCriterion("WECHAT_NUM like", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotLike(String value) {
            addCriterion("WECHAT_NUM not like", value, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumIn(List<String> values) {
            addCriterion("WECHAT_NUM in", values, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotIn(List<String> values) {
            addCriterion("WECHAT_NUM not in", values, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumBetween(String value1, String value2) {
            addCriterion("WECHAT_NUM between", value1, value2, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumNotBetween(String value1, String value2) {
            addCriterion("WECHAT_NUM not between", value1, value2, "wechatNum");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1IsNull() {
            addCriterion("SELLER_SHOP_ID1 is null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1IsNotNull() {
            addCriterion("SELLER_SHOP_ID1 is not null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1EqualTo(String value) {
            addCriterion("SELLER_SHOP_ID1 =", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1NotEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID1 <>", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1GreaterThan(String value) {
            addCriterion("SELLER_SHOP_ID1 >", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1GreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID1 >=", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1LessThan(String value) {
            addCriterion("SELLER_SHOP_ID1 <", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1LessThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID1 <=", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1Like(String value) {
            addCriterion("SELLER_SHOP_ID1 like", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1NotLike(String value) {
            addCriterion("SELLER_SHOP_ID1 not like", value, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1In(List<String> values) {
            addCriterion("SELLER_SHOP_ID1 in", values, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1NotIn(List<String> values) {
            addCriterion("SELLER_SHOP_ID1 not in", values, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1Between(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID1 between", value1, value2, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1NotBetween(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID1 not between", value1, value2, "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2IsNull() {
            addCriterion("SELLER_SHOP_ID2 is null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2IsNotNull() {
            addCriterion("SELLER_SHOP_ID2 is not null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2EqualTo(String value) {
            addCriterion("SELLER_SHOP_ID2 =", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2NotEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID2 <>", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2GreaterThan(String value) {
            addCriterion("SELLER_SHOP_ID2 >", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2GreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID2 >=", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2LessThan(String value) {
            addCriterion("SELLER_SHOP_ID2 <", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2LessThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID2 <=", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2Like(String value) {
            addCriterion("SELLER_SHOP_ID2 like", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2NotLike(String value) {
            addCriterion("SELLER_SHOP_ID2 not like", value, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2In(List<String> values) {
            addCriterion("SELLER_SHOP_ID2 in", values, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2NotIn(List<String> values) {
            addCriterion("SELLER_SHOP_ID2 not in", values, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2Between(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID2 between", value1, value2, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2NotBetween(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID2 not between", value1, value2, "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3IsNull() {
            addCriterion("SELLER_SHOP_ID3 is null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3IsNotNull() {
            addCriterion("SELLER_SHOP_ID3 is not null");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3EqualTo(String value) {
            addCriterion("SELLER_SHOP_ID3 =", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3NotEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID3 <>", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3GreaterThan(String value) {
            addCriterion("SELLER_SHOP_ID3 >", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3GreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID3 >=", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3LessThan(String value) {
            addCriterion("SELLER_SHOP_ID3 <", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3LessThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID3 <=", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3Like(String value) {
            addCriterion("SELLER_SHOP_ID3 like", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3NotLike(String value) {
            addCriterion("SELLER_SHOP_ID3 not like", value, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3In(List<String> values) {
            addCriterion("SELLER_SHOP_ID3 in", values, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3NotIn(List<String> values) {
            addCriterion("SELLER_SHOP_ID3 not in", values, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3Between(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID3 between", value1, value2, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3NotBetween(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID3 not between", value1, value2, "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("USER_TYPE like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("USER_TYPE not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andVipFlagIsNull() {
            addCriterion("VIP_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andVipFlagIsNotNull() {
            addCriterion("VIP_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andVipFlagEqualTo(String value) {
            addCriterion("VIP_FLAG =", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagNotEqualTo(String value) {
            addCriterion("VIP_FLAG <>", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagGreaterThan(String value) {
            addCriterion("VIP_FLAG >", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagGreaterThanOrEqualTo(String value) {
            addCriterion("VIP_FLAG >=", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagLessThan(String value) {
            addCriterion("VIP_FLAG <", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagLessThanOrEqualTo(String value) {
            addCriterion("VIP_FLAG <=", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagLike(String value) {
            addCriterion("VIP_FLAG like", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagNotLike(String value) {
            addCriterion("VIP_FLAG not like", value, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagIn(List<String> values) {
            addCriterion("VIP_FLAG in", values, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagNotIn(List<String> values) {
            addCriterion("VIP_FLAG not in", values, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagBetween(String value1, String value2) {
            addCriterion("VIP_FLAG between", value1, value2, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipFlagNotBetween(String value1, String value2) {
            addCriterion("VIP_FLAG not between", value1, value2, "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipGradeIsNull() {
            addCriterion("VIP_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andVipGradeIsNotNull() {
            addCriterion("VIP_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andVipGradeEqualTo(String value) {
            addCriterion("VIP_GRADE =", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeNotEqualTo(String value) {
            addCriterion("VIP_GRADE <>", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeGreaterThan(String value) {
            addCriterion("VIP_GRADE >", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeGreaterThanOrEqualTo(String value) {
            addCriterion("VIP_GRADE >=", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeLessThan(String value) {
            addCriterion("VIP_GRADE <", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeLessThanOrEqualTo(String value) {
            addCriterion("VIP_GRADE <=", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeLike(String value) {
            addCriterion("VIP_GRADE like", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeNotLike(String value) {
            addCriterion("VIP_GRADE not like", value, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeIn(List<String> values) {
            addCriterion("VIP_GRADE in", values, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeNotIn(List<String> values) {
            addCriterion("VIP_GRADE not in", values, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeBetween(String value1, String value2) {
            addCriterion("VIP_GRADE between", value1, value2, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andVipGradeNotBetween(String value1, String value2) {
            addCriterion("VIP_GRADE not between", value1, value2, "vipGrade");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("LAST_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("LAST_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("LAST_LOGIN_IP >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("LAST_LOGIN_IP <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("LAST_LOGIN_IP like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("LAST_LOGIN_IP not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addCriterion("LAST_LOGIN_DATE is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addCriterion("LAST_LOGIN_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_DATE >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addCriterion("LAST_LOGIN_DATE <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_DATE <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addCriterion("LAST_LOGIN_DATE in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_DATE not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_DATE between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_DATE not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagIsNull() {
            addCriterion("REGISTER_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagIsNotNull() {
            addCriterion("REGISTER_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagEqualTo(String value) {
            addCriterion("REGISTER_FLAG =", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagNotEqualTo(String value) {
            addCriterion("REGISTER_FLAG <>", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagGreaterThan(String value) {
            addCriterion("REGISTER_FLAG >", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTER_FLAG >=", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagLessThan(String value) {
            addCriterion("REGISTER_FLAG <", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagLessThanOrEqualTo(String value) {
            addCriterion("REGISTER_FLAG <=", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagLike(String value) {
            addCriterion("REGISTER_FLAG like", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagNotLike(String value) {
            addCriterion("REGISTER_FLAG not like", value, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagIn(List<String> values) {
            addCriterion("REGISTER_FLAG in", values, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagNotIn(List<String> values) {
            addCriterion("REGISTER_FLAG not in", values, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagBetween(String value1, String value2) {
            addCriterion("REGISTER_FLAG between", value1, value2, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagNotBetween(String value1, String value2) {
            addCriterion("REGISTER_FLAG not between", value1, value2, "registerFlag");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("DEL_FLAG like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andSellerNoLikeInsensitive(String value) {
            addCriterion("upper(SELLER_NO) like", value.toUpperCase(), "sellerNo");
            return (Criteria) this;
        }

        public Criteria andPasswordLikeInsensitive(String value) {
            addCriterion("upper(PASSWORD) like", value.toUpperCase(), "password");
            return (Criteria) this;
        }

        public Criteria andRealNameLikeInsensitive(String value) {
            addCriterion("upper(REAL_NAME) like", value.toUpperCase(), "realName");
            return (Criteria) this;
        }

        public Criteria andPhoneLikeInsensitive(String value) {
            addCriterion("upper(PHONE) like", value.toUpperCase(), "phone");
            return (Criteria) this;
        }

        public Criteria andQqNumLikeInsensitive(String value) {
            addCriterion("upper(QQ_NUM) like", value.toUpperCase(), "qqNum");
            return (Criteria) this;
        }

        public Criteria andWechatNumLikeInsensitive(String value) {
            addCriterion("upper(WECHAT_NUM) like", value.toUpperCase(), "wechatNum");
            return (Criteria) this;
        }

        public Criteria andSellerShopId1LikeInsensitive(String value) {
            addCriterion("upper(SELLER_SHOP_ID1) like", value.toUpperCase(), "sellerShopId1");
            return (Criteria) this;
        }

        public Criteria andSellerShopId2LikeInsensitive(String value) {
            addCriterion("upper(SELLER_SHOP_ID2) like", value.toUpperCase(), "sellerShopId2");
            return (Criteria) this;
        }

        public Criteria andSellerShopId3LikeInsensitive(String value) {
            addCriterion("upper(SELLER_SHOP_ID3) like", value.toUpperCase(), "sellerShopId3");
            return (Criteria) this;
        }

        public Criteria andUserTypeLikeInsensitive(String value) {
            addCriterion("upper(USER_TYPE) like", value.toUpperCase(), "userType");
            return (Criteria) this;
        }

        public Criteria andVipFlagLikeInsensitive(String value) {
            addCriterion("upper(VIP_FLAG) like", value.toUpperCase(), "vipFlag");
            return (Criteria) this;
        }

        public Criteria andVipGradeLikeInsensitive(String value) {
            addCriterion("upper(VIP_GRADE) like", value.toUpperCase(), "vipGrade");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLikeInsensitive(String value) {
            addCriterion("upper(LAST_LOGIN_IP) like", value.toUpperCase(), "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andRegisterFlagLikeInsensitive(String value) {
            addCriterion("upper(REGISTER_FLAG) like", value.toUpperCase(), "registerFlag");
            return (Criteria) this;
        }

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(REMARKS) like", value.toUpperCase(), "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagLikeInsensitive(String value) {
            addCriterion("upper(DEL_FLAG) like", value.toUpperCase(), "delFlag");
            return (Criteria) this;
        }
    }

    /**
     * USER
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    /**
     * USER null
     */
    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        private static final long serialVersionUID = 1L;

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
package com.seller.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskGroupExample implements Serializable {
    /**
     * TASK_GROUP
     */
    protected String orderByClause;

    /**
     * TASK_GROUP
     */
    protected boolean distinct;

    /**
     * TASK_GROUP
     */
    protected List<Criteria> oredCriteria;

    /**
     * TASK_GROUP
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public TaskGroupExample() {
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
     * TASK_GROUP null
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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("TASK_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("TASK_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("TASK_TYPE =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("TASK_TYPE <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("TASK_TYPE >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("TASK_TYPE <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("TASK_TYPE <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("TASK_TYPE like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("TASK_TYPE not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("TASK_TYPE in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("TASK_TYPE not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("TASK_TYPE between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("TASK_TYPE not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceIsNull() {
            addCriterion("TASK_ENTRANCE is null");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceIsNotNull() {
            addCriterion("TASK_ENTRANCE is not null");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceEqualTo(String value) {
            addCriterion("TASK_ENTRANCE =", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceNotEqualTo(String value) {
            addCriterion("TASK_ENTRANCE <>", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceGreaterThan(String value) {
            addCriterion("TASK_ENTRANCE >", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_ENTRANCE >=", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceLessThan(String value) {
            addCriterion("TASK_ENTRANCE <", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceLessThanOrEqualTo(String value) {
            addCriterion("TASK_ENTRANCE <=", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceLike(String value) {
            addCriterion("TASK_ENTRANCE like", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceNotLike(String value) {
            addCriterion("TASK_ENTRANCE not like", value, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceIn(List<String> values) {
            addCriterion("TASK_ENTRANCE in", values, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceNotIn(List<String> values) {
            addCriterion("TASK_ENTRANCE not in", values, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceBetween(String value1, String value2) {
            addCriterion("TASK_ENTRANCE between", value1, value2, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceNotBetween(String value1, String value2) {
            addCriterion("TASK_ENTRANCE not between", value1, value2, "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIsNull() {
            addCriterion("GOODS_URL is null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIsNotNull() {
            addCriterion("GOODS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlEqualTo(String value) {
            addCriterion("GOODS_URL =", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotEqualTo(String value) {
            addCriterion("GOODS_URL <>", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThan(String value) {
            addCriterion("GOODS_URL >", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_URL >=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThan(String value) {
            addCriterion("GOODS_URL <", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLessThanOrEqualTo(String value) {
            addCriterion("GOODS_URL <=", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLike(String value) {
            addCriterion("GOODS_URL like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotLike(String value) {
            addCriterion("GOODS_URL not like", value, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlIn(List<String> values) {
            addCriterion("GOODS_URL in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotIn(List<String> values) {
            addCriterion("GOODS_URL not in", values, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlBetween(String value1, String value2) {
            addCriterion("GOODS_URL between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlNotBetween(String value1, String value2) {
            addCriterion("GOODS_URL not between", value1, value2, "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNull() {
            addCriterion("GOODS_TITLE is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIsNotNull() {
            addCriterion("GOODS_TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleEqualTo(String value) {
            addCriterion("GOODS_TITLE =", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotEqualTo(String value) {
            addCriterion("GOODS_TITLE <>", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThan(String value) {
            addCriterion("GOODS_TITLE >", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("GOODS_TITLE >=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThan(String value) {
            addCriterion("GOODS_TITLE <", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLessThanOrEqualTo(String value) {
            addCriterion("GOODS_TITLE <=", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLike(String value) {
            addCriterion("GOODS_TITLE like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotLike(String value) {
            addCriterion("GOODS_TITLE not like", value, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleIn(List<String> values) {
            addCriterion("GOODS_TITLE in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotIn(List<String> values) {
            addCriterion("GOODS_TITLE not in", values, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleBetween(String value1, String value2) {
            addCriterion("GOODS_TITLE between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleNotBetween(String value1, String value2) {
            addCriterion("GOODS_TITLE not between", value1, value2, "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdIsNull() {
            addCriterion("SELLER_SHOP_ID is null");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdIsNotNull() {
            addCriterion("SELLER_SHOP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID =", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdNotEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID <>", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdGreaterThan(String value) {
            addCriterion("SELLER_SHOP_ID >", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdGreaterThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID >=", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdLessThan(String value) {
            addCriterion("SELLER_SHOP_ID <", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdLessThanOrEqualTo(String value) {
            addCriterion("SELLER_SHOP_ID <=", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdLike(String value) {
            addCriterion("SELLER_SHOP_ID like", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdNotLike(String value) {
            addCriterion("SELLER_SHOP_ID not like", value, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdIn(List<String> values) {
            addCriterion("SELLER_SHOP_ID in", values, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdNotIn(List<String> values) {
            addCriterion("SELLER_SHOP_ID not in", values, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdBetween(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID between", value1, value2, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdNotBetween(String value1, String value2) {
            addCriterion("SELLER_SHOP_ID not between", value1, value2, "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIsNull() {
            addCriterion("SEARCH_KEYWORD is null");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIsNotNull() {
            addCriterion("SEARCH_KEYWORD is not null");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordEqualTo(String value) {
            addCriterion("SEARCH_KEYWORD =", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotEqualTo(String value) {
            addCriterion("SEARCH_KEYWORD <>", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordGreaterThan(String value) {
            addCriterion("SEARCH_KEYWORD >", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordGreaterThanOrEqualTo(String value) {
            addCriterion("SEARCH_KEYWORD >=", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLessThan(String value) {
            addCriterion("SEARCH_KEYWORD <", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLessThanOrEqualTo(String value) {
            addCriterion("SEARCH_KEYWORD <=", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLike(String value) {
            addCriterion("SEARCH_KEYWORD like", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotLike(String value) {
            addCriterion("SEARCH_KEYWORD not like", value, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordIn(List<String> values) {
            addCriterion("SEARCH_KEYWORD in", values, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotIn(List<String> values) {
            addCriterion("SEARCH_KEYWORD not in", values, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordBetween(String value1, String value2) {
            addCriterion("SEARCH_KEYWORD between", value1, value2, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordNotBetween(String value1, String value2) {
            addCriterion("SEARCH_KEYWORD not between", value1, value2, "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlIsNull() {
            addCriterion("CONDITION_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlIsNotNull() {
            addCriterion("CONDITION_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlEqualTo(String value) {
            addCriterion("CONDITION_IMG_URL =", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlNotEqualTo(String value) {
            addCriterion("CONDITION_IMG_URL <>", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlGreaterThan(String value) {
            addCriterion("CONDITION_IMG_URL >", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("CONDITION_IMG_URL >=", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlLessThan(String value) {
            addCriterion("CONDITION_IMG_URL <", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlLessThanOrEqualTo(String value) {
            addCriterion("CONDITION_IMG_URL <=", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlLike(String value) {
            addCriterion("CONDITION_IMG_URL like", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlNotLike(String value) {
            addCriterion("CONDITION_IMG_URL not like", value, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlIn(List<String> values) {
            addCriterion("CONDITION_IMG_URL in", values, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlNotIn(List<String> values) {
            addCriterion("CONDITION_IMG_URL not in", values, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlBetween(String value1, String value2) {
            addCriterion("CONDITION_IMG_URL between", value1, value2, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlNotBetween(String value1, String value2) {
            addCriterion("CONDITION_IMG_URL not between", value1, value2, "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlIsNull() {
            addCriterion("SEARCH_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlIsNotNull() {
            addCriterion("SEARCH_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlEqualTo(String value) {
            addCriterion("SEARCH_IMG_URL =", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlNotEqualTo(String value) {
            addCriterion("SEARCH_IMG_URL <>", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlGreaterThan(String value) {
            addCriterion("SEARCH_IMG_URL >", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SEARCH_IMG_URL >=", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlLessThan(String value) {
            addCriterion("SEARCH_IMG_URL <", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlLessThanOrEqualTo(String value) {
            addCriterion("SEARCH_IMG_URL <=", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlLike(String value) {
            addCriterion("SEARCH_IMG_URL like", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlNotLike(String value) {
            addCriterion("SEARCH_IMG_URL not like", value, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlIn(List<String> values) {
            addCriterion("SEARCH_IMG_URL in", values, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlNotIn(List<String> values) {
            addCriterion("SEARCH_IMG_URL not in", values, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlBetween(String value1, String value2) {
            addCriterion("SEARCH_IMG_URL between", value1, value2, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlNotBetween(String value1, String value2) {
            addCriterion("SEARCH_IMG_URL not between", value1, value2, "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andStayTimeIsNull() {
            addCriterion("STAY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andStayTimeIsNotNull() {
            addCriterion("STAY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andStayTimeEqualTo(String value) {
            addCriterion("STAY_TIME =", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotEqualTo(String value) {
            addCriterion("STAY_TIME <>", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeGreaterThan(String value) {
            addCriterion("STAY_TIME >", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeGreaterThanOrEqualTo(String value) {
            addCriterion("STAY_TIME >=", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeLessThan(String value) {
            addCriterion("STAY_TIME <", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeLessThanOrEqualTo(String value) {
            addCriterion("STAY_TIME <=", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeLike(String value) {
            addCriterion("STAY_TIME like", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotLike(String value) {
            addCriterion("STAY_TIME not like", value, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeIn(List<String> values) {
            addCriterion("STAY_TIME in", values, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotIn(List<String> values) {
            addCriterion("STAY_TIME not in", values, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeBetween(String value1, String value2) {
            addCriterion("STAY_TIME between", value1, value2, "stayTime");
            return (Criteria) this;
        }

        public Criteria andStayTimeNotBetween(String value1, String value2) {
            addCriterion("STAY_TIME not between", value1, value2, "stayTime");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagIsNull() {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagIsNotNull() {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG =", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagNotEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG <>", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagGreaterThan(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG >", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG >=", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagLessThan(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG <", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG <=", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagLike(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG like", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagNotLike(String value) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG not like", value, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG in", values, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagNotIn(List<String> values) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG not in", values, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG between", value1, value2, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_SERVICE_CHAT_FLAG not between", value1, value2, "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIsNull() {
            addCriterion("SPECIAL_CONDITION is null");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIsNotNull() {
            addCriterion("SPECIAL_CONDITION is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION =", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION <>", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionGreaterThan(String value) {
            addCriterion("SPECIAL_CONDITION >", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionGreaterThanOrEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION >=", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLessThan(String value) {
            addCriterion("SPECIAL_CONDITION <", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLessThanOrEqualTo(String value) {
            addCriterion("SPECIAL_CONDITION <=", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLike(String value) {
            addCriterion("SPECIAL_CONDITION like", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotLike(String value) {
            addCriterion("SPECIAL_CONDITION not like", value, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionIn(List<String> values) {
            addCriterion("SPECIAL_CONDITION in", values, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotIn(List<String> values) {
            addCriterion("SPECIAL_CONDITION not in", values, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionBetween(String value1, String value2) {
            addCriterion("SPECIAL_CONDITION between", value1, value2, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionNotBetween(String value1, String value2) {
            addCriterion("SPECIAL_CONDITION not between", value1, value2, "specialCondition");
            return (Criteria) this;
        }

        public Criteria andConditionSexualIsNull() {
            addCriterion("CONDITION_SEXUAL is null");
            return (Criteria) this;
        }

        public Criteria andConditionSexualIsNotNull() {
            addCriterion("CONDITION_SEXUAL is not null");
            return (Criteria) this;
        }

        public Criteria andConditionSexualEqualTo(String value) {
            addCriterion("CONDITION_SEXUAL =", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualNotEqualTo(String value) {
            addCriterion("CONDITION_SEXUAL <>", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualGreaterThan(String value) {
            addCriterion("CONDITION_SEXUAL >", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualGreaterThanOrEqualTo(String value) {
            addCriterion("CONDITION_SEXUAL >=", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualLessThan(String value) {
            addCriterion("CONDITION_SEXUAL <", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualLessThanOrEqualTo(String value) {
            addCriterion("CONDITION_SEXUAL <=", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualLike(String value) {
            addCriterion("CONDITION_SEXUAL like", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualNotLike(String value) {
            addCriterion("CONDITION_SEXUAL not like", value, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualIn(List<String> values) {
            addCriterion("CONDITION_SEXUAL in", values, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualNotIn(List<String> values) {
            addCriterion("CONDITION_SEXUAL not in", values, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualBetween(String value1, String value2) {
            addCriterion("CONDITION_SEXUAL between", value1, value2, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionSexualNotBetween(String value1, String value2) {
            addCriterion("CONDITION_SEXUAL not between", value1, value2, "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionAgeIsNull() {
            addCriterion("CONDITION_AGE is null");
            return (Criteria) this;
        }

        public Criteria andConditionAgeIsNotNull() {
            addCriterion("CONDITION_AGE is not null");
            return (Criteria) this;
        }

        public Criteria andConditionAgeEqualTo(String value) {
            addCriterion("CONDITION_AGE =", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeNotEqualTo(String value) {
            addCriterion("CONDITION_AGE <>", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeGreaterThan(String value) {
            addCriterion("CONDITION_AGE >", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeGreaterThanOrEqualTo(String value) {
            addCriterion("CONDITION_AGE >=", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeLessThan(String value) {
            addCriterion("CONDITION_AGE <", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeLessThanOrEqualTo(String value) {
            addCriterion("CONDITION_AGE <=", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeLike(String value) {
            addCriterion("CONDITION_AGE like", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeNotLike(String value) {
            addCriterion("CONDITION_AGE not like", value, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeIn(List<String> values) {
            addCriterion("CONDITION_AGE in", values, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeNotIn(List<String> values) {
            addCriterion("CONDITION_AGE not in", values, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeBetween(String value1, String value2) {
            addCriterion("CONDITION_AGE between", value1, value2, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andConditionAgeNotBetween(String value1, String value2) {
            addCriterion("CONDITION_AGE not between", value1, value2, "conditionAge");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseIsNull() {
            addCriterion("ADDITIONAL_CHOOSE is null");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseIsNotNull() {
            addCriterion("ADDITIONAL_CHOOSE is not null");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseEqualTo(String value) {
            addCriterion("ADDITIONAL_CHOOSE =", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseNotEqualTo(String value) {
            addCriterion("ADDITIONAL_CHOOSE <>", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseGreaterThan(String value) {
            addCriterion("ADDITIONAL_CHOOSE >", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseGreaterThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_CHOOSE >=", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseLessThan(String value) {
            addCriterion("ADDITIONAL_CHOOSE <", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseLessThanOrEqualTo(String value) {
            addCriterion("ADDITIONAL_CHOOSE <=", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseLike(String value) {
            addCriterion("ADDITIONAL_CHOOSE like", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseNotLike(String value) {
            addCriterion("ADDITIONAL_CHOOSE not like", value, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseIn(List<String> values) {
            addCriterion("ADDITIONAL_CHOOSE in", values, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseNotIn(List<String> values) {
            addCriterion("ADDITIONAL_CHOOSE not in", values, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_CHOOSE between", value1, value2, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseNotBetween(String value1, String value2) {
            addCriterion("ADDITIONAL_CHOOSE not between", value1, value2, "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("PUBLISH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("PUBLISH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("PUBLISH_DATE =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("PUBLISH_DATE <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("PUBLISH_DATE >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_DATE >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("PUBLISH_DATE <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_DATE <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("PUBLISH_DATE in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("PUBLISH_DATE not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_DATE between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_DATE not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIsNull() {
            addCriterion("PUBLISH_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIsNotNull() {
            addCriterion("PUBLISH_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAmountEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT =", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT <>", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountGreaterThan(Integer value) {
            addCriterion("PUBLISH_AMOUNT >", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT >=", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountLessThan(Integer value) {
            addCriterion("PUBLISH_AMOUNT <", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT <=", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIn(List<Integer> values) {
            addCriterion("PUBLISH_AMOUNT in", values, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotIn(List<Integer> values) {
            addCriterion("PUBLISH_AMOUNT not in", values, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_AMOUNT between", value1, value2, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_AMOUNT not between", value1, value2, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodIsNull() {
            addCriterion("PUBLISH_TIME_PERIOD is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodIsNotNull() {
            addCriterion("PUBLISH_TIME_PERIOD is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodEqualTo(String value) {
            addCriterion("PUBLISH_TIME_PERIOD =", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodNotEqualTo(String value) {
            addCriterion("PUBLISH_TIME_PERIOD <>", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodGreaterThan(String value) {
            addCriterion("PUBLISH_TIME_PERIOD >", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_TIME_PERIOD >=", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodLessThan(String value) {
            addCriterion("PUBLISH_TIME_PERIOD <", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_TIME_PERIOD <=", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodLike(String value) {
            addCriterion("PUBLISH_TIME_PERIOD like", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodNotLike(String value) {
            addCriterion("PUBLISH_TIME_PERIOD not like", value, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodIn(List<String> values) {
            addCriterion("PUBLISH_TIME_PERIOD in", values, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodNotIn(List<String> values) {
            addCriterion("PUBLISH_TIME_PERIOD not in", values, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodBetween(String value1, String value2) {
            addCriterion("PUBLISH_TIME_PERIOD between", value1, value2, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_TIME_PERIOD not between", value1, value2, "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNull() {
            addCriterion("CHECK_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIsNotNull() {
            addCriterion("CHECK_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFlagEqualTo(String value) {
            addCriterion("CHECK_FLAG =", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotEqualTo(String value) {
            addCriterion("CHECK_FLAG <>", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThan(String value) {
            addCriterion("CHECK_FLAG >", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagGreaterThanOrEqualTo(String value) {
            addCriterion("CHECK_FLAG >=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThan(String value) {
            addCriterion("CHECK_FLAG <", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLessThanOrEqualTo(String value) {
            addCriterion("CHECK_FLAG <=", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLike(String value) {
            addCriterion("CHECK_FLAG like", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotLike(String value) {
            addCriterion("CHECK_FLAG not like", value, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagIn(List<String> values) {
            addCriterion("CHECK_FLAG in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotIn(List<String> values) {
            addCriterion("CHECK_FLAG not in", values, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagBetween(String value1, String value2) {
            addCriterion("CHECK_FLAG between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andCheckFlagNotBetween(String value1, String value2) {
            addCriterion("CHECK_FLAG not between", value1, value2, "checkFlag");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusIsNull() {
            addCriterion("TASK_GROUP_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusIsNotNull() {
            addCriterion("TASK_GROUP_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusEqualTo(String value) {
            addCriterion("TASK_GROUP_STATUS =", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusNotEqualTo(String value) {
            addCriterion("TASK_GROUP_STATUS <>", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusGreaterThan(String value) {
            addCriterion("TASK_GROUP_STATUS >", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusGreaterThanOrEqualTo(String value) {
            addCriterion("TASK_GROUP_STATUS >=", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusLessThan(String value) {
            addCriterion("TASK_GROUP_STATUS <", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusLessThanOrEqualTo(String value) {
            addCriterion("TASK_GROUP_STATUS <=", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusLike(String value) {
            addCriterion("TASK_GROUP_STATUS like", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusNotLike(String value) {
            addCriterion("TASK_GROUP_STATUS not like", value, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusIn(List<String> values) {
            addCriterion("TASK_GROUP_STATUS in", values, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusNotIn(List<String> values) {
            addCriterion("TASK_GROUP_STATUS not in", values, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusBetween(String value1, String value2) {
            addCriterion("TASK_GROUP_STATUS between", value1, value2, "taskGroupStatus");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusNotBetween(String value1, String value2) {
            addCriterion("TASK_GROUP_STATUS not between", value1, value2, "taskGroupStatus");
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

        public Criteria andTaskTypeLikeInsensitive(String value) {
            addCriterion("upper(TASK_TYPE) like", value.toUpperCase(), "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskEntranceLikeInsensitive(String value) {
            addCriterion("upper(TASK_ENTRANCE) like", value.toUpperCase(), "taskEntrance");
            return (Criteria) this;
        }

        public Criteria andGoodsUrlLikeInsensitive(String value) {
            addCriterion("upper(GOODS_URL) like", value.toUpperCase(), "goodsUrl");
            return (Criteria) this;
        }

        public Criteria andGoodsTitleLikeInsensitive(String value) {
            addCriterion("upper(GOODS_TITLE) like", value.toUpperCase(), "goodsTitle");
            return (Criteria) this;
        }

        public Criteria andSellerShopIdLikeInsensitive(String value) {
            addCriterion("upper(SELLER_SHOP_ID) like", value.toUpperCase(), "sellerShopId");
            return (Criteria) this;
        }

        public Criteria andSearchKeywordLikeInsensitive(String value) {
            addCriterion("upper(SEARCH_KEYWORD) like", value.toUpperCase(), "searchKeyword");
            return (Criteria) this;
        }

        public Criteria andConditionImgUrlLikeInsensitive(String value) {
            addCriterion("upper(CONDITION_IMG_URL) like", value.toUpperCase(), "conditionImgUrl");
            return (Criteria) this;
        }

        public Criteria andSearchImgUrlLikeInsensitive(String value) {
            addCriterion("upper(SEARCH_IMG_URL) like", value.toUpperCase(), "searchImgUrl");
            return (Criteria) this;
        }

        public Criteria andStayTimeLikeInsensitive(String value) {
            addCriterion("upper(STAY_TIME) like", value.toUpperCase(), "stayTime");
            return (Criteria) this;
        }

        public Criteria andCustomServiceChatFlagLikeInsensitive(String value) {
            addCriterion("upper(CUSTOM_SERVICE_CHAT_FLAG) like", value.toUpperCase(), "customServiceChatFlag");
            return (Criteria) this;
        }

        public Criteria andSpecialConditionLikeInsensitive(String value) {
            addCriterion("upper(SPECIAL_CONDITION) like", value.toUpperCase(), "specialCondition");
            return (Criteria) this;
        }

        public Criteria andConditionSexualLikeInsensitive(String value) {
            addCriterion("upper(CONDITION_SEXUAL) like", value.toUpperCase(), "conditionSexual");
            return (Criteria) this;
        }

        public Criteria andConditionAgeLikeInsensitive(String value) {
            addCriterion("upper(CONDITION_AGE) like", value.toUpperCase(), "conditionAge");
            return (Criteria) this;
        }

        public Criteria andAdditionalChooseLikeInsensitive(String value) {
            addCriterion("upper(ADDITIONAL_CHOOSE) like", value.toUpperCase(), "additionalChoose");
            return (Criteria) this;
        }

        public Criteria andPublishTimePeriodLikeInsensitive(String value) {
            addCriterion("upper(PUBLISH_TIME_PERIOD) like", value.toUpperCase(), "publishTimePeriod");
            return (Criteria) this;
        }

        public Criteria andCheckFlagLikeInsensitive(String value) {
            addCriterion("upper(CHECK_FLAG) like", value.toUpperCase(), "checkFlag");
            return (Criteria) this;
        }

        public Criteria andTaskGroupStatusLikeInsensitive(String value) {
            addCriterion("upper(TASK_GROUP_STATUS) like", value.toUpperCase(), "taskGroupStatus");
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
     * TASK_GROUP
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    /**
     * TASK_GROUP null
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
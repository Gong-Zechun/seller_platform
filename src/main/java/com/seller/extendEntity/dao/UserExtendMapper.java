package com.seller.extendEntity.dao;

import com.seller.entity.model.User;
import com.seller.extendEntity.vo.UserVo;

/**
 * 类功能描述：用户拓展Mapper
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-10-9 Allen Gong 创建
 */
public interface UserExtendMapper {
    /**
     * 获取商家信息概要
     * @param user
     * @return
     */
    UserVo getSellerInfoBrief(User user);
}

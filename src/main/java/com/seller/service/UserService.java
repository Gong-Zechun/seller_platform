package com.seller.service;

import com.seller.constants.Constants;
import com.seller.constants.FieldConst;
import com.seller.entity.dao.UserMapper;
import com.seller.entity.model.User;
import com.seller.entity.model.UserExample;
import com.seller.extendEntity.dao.UserExtendMapper;
import com.seller.extendEntity.vo.UserVo;
import com.util.DateUtils;
import com.util.encrypt.Md5Util;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户service
 * @author: Raygong
 * @date: 2017/8/31 22:41.
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserExtendMapper userExtendMapper;

    /**
     * 注册
     * @param paramUser
     * @return -1:用户编号（sellerNo）不存在; -2:注册失败
     */
    public int register(User paramUser) {
        paramUser.setPassword(Md5Util.getMD5Str(paramUser.getPassword()));
        paramUser.setUserType(FieldConst.SELLER_USER);
        paramUser.setRegisterFlag(FieldConst.REGISTER_FLAG_TRUE);
        paramUser.setCreateTime(DateUtils.getCurrentDateTime());
        paramUser.setUpdateTime(DateUtils.getCurrentDateTime());
        int updateFlag = userMapper.insertSelective(paramUser);
        if(updateFlag > 0) {
            return 1;
        }else {
            return -2;
        }
    }

    /**
     * sellerNo是否已存在
     * @param phone true:已存在; false:不存在
     * @return
     */
    public boolean isPhoneExist(String phone) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone).andDelFlagEqualTo(Constants.FLAG_FALSE);

        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) {
            return false;
        }else {
            return true;
        }
    }

    /**
     * sellerNo是否已被注册
     * @param paramUser
     * @return
     */
    public boolean isSellerNoRegistered(User paramUser) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andSellerNoEqualTo(paramUser.getSellerNo()).andDelFlagEqualTo(Constants.FLAG_FALSE);

        User user = userMapper.selectByExample(example).get(0);
        String registerFlag = user.getRegisterFlag();
        if(registerFlag.equals(FieldConst.REGISTER_FLAG_TRUE)) {
            return true;
        }
        return false;
    }

    /**
     * 用户是否存在
     * @param paramUser
     * @return
     */
    public User getUserByParam(User paramUser) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(paramUser.getPhone())
                .andPasswordEqualTo(Md5Util.getMD5Str(paramUser.getPassword()))
                .andDelFlagEqualTo(Constants.FLAG_FALSE);
        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 根据sellerNo获取用户信息
     * @param sellerNo
     * @return
     */
    public User getUserBySellerNo(String sellerNo) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andSellerNoEqualTo(sellerNo).andDelFlagEqualTo(Constants.FLAG_FALSE);
        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 根据手机号获取用户信息
     * @param phone
     * @return
     */
    public User getUserByPhone(String phone) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone).andDelFlagEqualTo(Constants.FLAG_FALSE);
        List<User> userList = userMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(userList)) {
            return null;
        }
        return userList.get(0);
    }

    /**
     * 获取商家信息概要
     * @param user
     * @return
     */
    public UserVo getSellerInfoBrief(User user) {
        return userExtendMapper.getSellerInfoBrief(user);
    }

    /**
     * 更新店铺
     * @param user
     * @return
     */
    public int updateSellerShopId(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(user.getPhone()).andDelFlagEqualTo(Constants.FLAG_FALSE);
        user.setUpdateTime(DateUtils.getCurrentDateTime());
        return userMapper.updateByExample(user, example);
    }

}

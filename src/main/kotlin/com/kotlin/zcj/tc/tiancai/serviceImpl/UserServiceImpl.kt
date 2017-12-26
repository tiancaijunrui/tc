package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_USER
import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.entity.User
import com.kotlin.zcj.tc.tiancai.service.UserService
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.jooq.DSLContext
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Timestamp
import java.util.*
import javax.annotation.Resource


/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Service("userService")
class UserServiceImpl : UserService {
    private var token_version_key_pre = "token_version_key";

    override fun getTokenVersion(): String {
        if (stringRedis.hasKey(token_version_key_pre)) {
            return stringRedis.opsForValue().get(token_version_key_pre)
        }
        val version = TcUtils.genUUID();
        stringRedis.opsForValue().set(token_version_key_pre, version);
        stringRedis.expireAt(token_version_key_pre, TcUtils.getEndTimeOfDate(Date()))
        return version;
    }

    @Resource
    var dsl: DSLContext? = null

    @Resource
    lateinit private var stringRedis: StringRedisTemplate;


    @Transactional
    override fun getUserByAliUserId(aliUserId: String): TTcUserRecord? {
        val user: TTcUserRecord? = dsl!!.selectFrom(T_TC_USER).where(T_TC_USER.ALI_USER_ID.eq(aliUserId)).limit(1).fetchOne();
        return user;
    }


    @Transactional
    override fun save(user: TTcUserRecord) {
        if (user.createBy == null) {
            user.createBy = user.userId;
            user.createTime = Timestamp(Date().time);
            user.updateBy = user.userId;
            user.updateTime = user.createTime
        }
        dsl!!.insertInto(T_TC_USER, T_TC_USER.USER_ID, T_TC_USER.ALI_USER_ID, T_TC_USER.AVATAR, T_TC_USER.NICK_NAME, T_TC_USER.CREATE_BY,
                T_TC_USER.CREATE_TIME, T_TC_USER.UPDATE_BY, T_TC_USER.UPDATE_TIME).values(user.userId, user.aliUserId, user.avatar, user.nickName, user.createBy,
                user.createTime, user.updateBy, user.updateTime).execute();

    }

    @Transactional
    override fun load(userId: String): TTcUserRecord {
        val user: TTcUserRecord = dsl!!.selectFrom(T_TC_USER).where(T_TC_USER.USER_ID.eq(userId)).fetchAny();
        return user;
    }

}
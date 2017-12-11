package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.data.Tables.T_TC_USER
import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.entity.User
import com.kotlin.zcj.tc.tiancai.service.UserService
import com.kotlin.zcj.tc.tiancai.utils.TcUtils
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource


/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Service("userService")
class UserServiceImpl : UserService {
    @Resource
    var dsl: DSLContext? = null

    @Transactional
    override fun save(user: User) {
        dsl!!.insertInto(T_TC_USER).set(T_TC_USER.USER_ID, TcUtils.genUUID()).execute();
    }

    @Transactional
    override fun load(userId: String): TTcUserRecord {
        val user: TTcUserRecord = dsl!!.selectFrom(T_TC_USER).where(T_TC_USER.USER_ID.eq(userId)).fetchAny();
        return user;
    }

}
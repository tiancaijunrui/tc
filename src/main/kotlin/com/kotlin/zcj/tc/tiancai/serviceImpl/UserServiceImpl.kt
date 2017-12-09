package com.kotlin.zcj.tc.tiancai.serviceImpl

import com.kotlin.zcj.tc.tiancai.entity.User
import com.kotlin.zcj.tc.tiancai.service.UserService
import org.jooq.DSLContext
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import javax.annotation.Resource


/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Service("userService")
class UserServiceImpl : UserService{
    @Resource
    var dsl: DSLContext? = null
    @Transactional
    override fun save(user: User) {
        dsl.insertInto(User)
    }

}
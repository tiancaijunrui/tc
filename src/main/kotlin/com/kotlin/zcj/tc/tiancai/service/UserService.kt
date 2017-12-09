package com.kotlin.zcj.tc.tiancai.service

import com.kotlin.zcj.tc.tiancai.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Service
interface UserService {
    @Transactional
    fun save(user : User);
}
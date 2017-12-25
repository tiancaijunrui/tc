package com.kotlin.zcj.tc.tiancai.service

import com.kotlin.zcj.tc.data.tables.records.TTcUserRecord
import com.kotlin.zcj.tc.tiancai.entity.User
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * @Since2017/12/9 ZhaCongJie@HF
 */
@Service
interface UserService {
    fun save(user: TTcUserRecord);

    fun load(userId: String): TTcUserRecord;

    fun getUserByAliUserId(aliUserId: String): TTcUserRecord?;
}
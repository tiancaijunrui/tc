/*
 * This file is generated by jOOQ.
*/
package com.kotlin.zcj.tc.data.tables.records;


import com.kotlin.zcj.tc.data.tables.TTcUser;

import java.sql.Timestamp;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record11;
import org.jooq.Row11;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TTcUserRecord extends UpdatableRecordImpl<TTcUserRecord> implements Record11<String, String, String, String, String, Integer, Timestamp, String, Timestamp, String, Timestamp> {

    private static final long serialVersionUID = 129993296;

    /**
     * Setter for <code>public.t_tc_user.user_id</code>.
     */
    public void setUserId(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.t_tc_user.user_id</code>.
     */
    public String getUserId() {
        return (String) get(0);
    }

    /**
     * Setter for <code>public.t_tc_user.login_name</code>.
     */
    public void setLoginName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.t_tc_user.login_name</code>.
     */
    public String getLoginName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.t_tc_user.password</code>.
     */
    public void setPassword(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.t_tc_user.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.t_tc_user.email</code>.
     */
    public void setEmail(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.t_tc_user.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.t_tc_user.phone</code>.
     */
    public void setPhone(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.t_tc_user.phone</code>.
     */
    public String getPhone() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.t_tc_user.age</code>.
     */
    public void setAge(Integer value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.t_tc_user.age</code>.
     */
    public Integer getAge() {
        return (Integer) get(5);
    }

    /**
     * Setter for <code>public.t_tc_user.birthday</code>.
     */
    public void setBirthday(Timestamp value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.t_tc_user.birthday</code>.
     */
    public Timestamp getBirthday() {
        return (Timestamp) get(6);
    }

    /**
     * Setter for <code>public.t_tc_user.create_by</code>.
     */
    public void setCreateBy(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.t_tc_user.create_by</code>.
     */
    public String getCreateBy() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.t_tc_user.create_time</code>.
     */
    public void setCreateTime(Timestamp value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.t_tc_user.create_time</code>.
     */
    public Timestamp getCreateTime() {
        return (Timestamp) get(8);
    }

    /**
     * Setter for <code>public.t_tc_user.update_by</code>.
     */
    public void setUpdateBy(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.t_tc_user.update_by</code>.
     */
    public String getUpdateBy() {
        return (String) get(9);
    }

    /**
     * Setter for <code>public.t_tc_user.update_time</code>.
     */
    public void setUpdateTime(Timestamp value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.t_tc_user.update_time</code>.
     */
    public Timestamp getUpdateTime() {
        return (Timestamp) get(10);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<String> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record11 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, Integer, Timestamp, String, Timestamp, String, Timestamp> fieldsRow() {
        return (Row11) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row11<String, String, String, String, String, Integer, Timestamp, String, Timestamp, String, Timestamp> valuesRow() {
        return (Row11) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field1() {
        return TTcUser.T_TC_USER.USER_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field2() {
        return TTcUser.T_TC_USER.LOGIN_NAME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return TTcUser.T_TC_USER.PASSWORD;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return TTcUser.T_TC_USER.EMAIL;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return TTcUser.T_TC_USER.PHONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field6() {
        return TTcUser.T_TC_USER.AGE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field7() {
        return TTcUser.T_TC_USER.BIRTHDAY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field8() {
        return TTcUser.T_TC_USER.CREATE_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field9() {
        return TTcUser.T_TC_USER.CREATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field10() {
        return TTcUser.T_TC_USER.UPDATE_BY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Timestamp> field11() {
        return TTcUser.T_TC_USER.UPDATE_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value1() {
        return getUserId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value2() {
        return getLoginName();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getPassword();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getEmail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getPhone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value6() {
        return getAge();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value7() {
        return getBirthday();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value8() {
        return getCreateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value9() {
        return getCreateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value10() {
        return getUpdateBy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timestamp value11() {
        return getUpdateTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value1(String value) {
        setUserId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value2(String value) {
        setLoginName(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value4(String value) {
        setEmail(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value5(String value) {
        setPhone(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value6(Integer value) {
        setAge(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value7(Timestamp value) {
        setBirthday(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value8(String value) {
        setCreateBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value9(Timestamp value) {
        setCreateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value10(String value) {
        setUpdateBy(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord value11(Timestamp value) {
        setUpdateTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TTcUserRecord values(String value1, String value2, String value3, String value4, String value5, Integer value6, Timestamp value7, String value8, Timestamp value9, String value10, Timestamp value11) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached TTcUserRecord
     */
    public TTcUserRecord() {
        super(TTcUser.T_TC_USER);
    }

    /**
     * Create a detached, initialised TTcUserRecord
     */
    public TTcUserRecord(String userId, String loginName, String password, String email, String phone, Integer age, Timestamp birthday, String createBy, Timestamp createTime, String updateBy, Timestamp updateTime) {
        super(TTcUser.T_TC_USER);

        set(0, userId);
        set(1, loginName);
        set(2, password);
        set(3, email);
        set(4, phone);
        set(5, age);
        set(6, birthday);
        set(7, createBy);
        set(8, createTime);
        set(9, updateBy);
        set(10, updateTime);
    }
}

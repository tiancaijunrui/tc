/*
 * This file is generated by jOOQ.
*/
package com.kotlin.zcj.tc.data;


import com.kotlin.zcj.tc.data.tables.TTcAccount;
import com.kotlin.zcj.tc.data.tables.TTcCorpCode;
import com.kotlin.zcj.tc.data.tables.TTcUser;

import javax.annotation.Generated;


/**
 * Convenience access to all tables in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.9.6"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

    /**
     * The table <code>public.t_tc_account</code>.
     */
    public static final TTcAccount T_TC_ACCOUNT = com.kotlin.zcj.tc.data.tables.TTcAccount.T_TC_ACCOUNT;

    /**
     * The table <code>public.t_tc_corp_code</code>.
     */
    public static final TTcCorpCode T_TC_CORP_CODE = com.kotlin.zcj.tc.data.tables.TTcCorpCode.T_TC_CORP_CODE;

    /**
     * The table <code>public.t_tc_user</code>.
     */
    public static final TTcUser T_TC_USER = com.kotlin.zcj.tc.data.tables.TTcUser.T_TC_USER;
}

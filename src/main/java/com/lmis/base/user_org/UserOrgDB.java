package com.lmis.base.user_org;

import android.content.Context;

import com.lmis.base.org.OrgDB;
import com.lmis.orm.LmisColumn;
import com.lmis.orm.LmisDatabase;
import com.lmis.orm.LmisFields;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengdh on 14-6-15.
 * 记录当前用户可访问的机构信息
 */
public class UserOrgDB extends LmisDatabase {
    Context mContext;

    public UserOrgDB(Context context) {
        super(context);
        mContext = context;
    }

    @Override
    public List<LmisColumn> getModelColumns() {
        List<LmisColumn> cols = new ArrayList<LmisColumn>();

        cols.add(new LmisColumn("user_id", "user_id", LmisFields.integer()));
        cols.add(new LmisColumn("org_id", "Parent Org", LmisFields.manyToOne(new OrgDB(mContext))));
        return cols;
    }

    @Override
    public String getModelName() {
        return "UserOrg";
    }
}

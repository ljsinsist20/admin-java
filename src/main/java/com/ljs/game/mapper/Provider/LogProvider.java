package com.ljs.game.mapper.Provider;

import com.ljs.game.pojo.query.LogQuery;

public class LogProvider {

    public String list(LogQuery logQuery) {
        String sql = " SELECT id, modul, `type`, `desc`, create_time FROM `log`  ";
        StringBuffer str = new StringBuffer(sql);
        if (logQuery.getModul() != null) {
            str.append(" WHERE `modul` like concat('%',#{modul},'%') ");
        }
        if (logQuery.getDesc() != null) {
            str.append(" WHERE `desc` like concat('%',#{desc},'%') ");
        }
        return str.toString();
    }
}

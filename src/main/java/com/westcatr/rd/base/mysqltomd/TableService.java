package com.westcatr.rd.base.mysqltomd;

import com.alibaba.fastjson.JSONObject;
import com.westcatr.rd.base.mysqltomd.dao.mapper.NcDictDto;

import java.util.List;

/**
 * @author xieshuang
 * @date 2020-05-31 18:46
 */
public interface TableService {

    /**
     * 获取表信息
     * @date : 2020/5/31 18:46
     * @author : xieshuang
     * @return java.util.List<com.westcatr.rd.base.mysqltomd.TableInfo>
     */
    List<TableInfo> getTableList();

    /**
     * 获取表字段信息
     * @date : 2020/5/31 18:48
     * @author : xieshuang
     * @param tableName
     * @return java.util.List<com.westcatr.rd.base.mysqltomd.FieldInfo>
     */
    List<FieldInfo> getFieldInfoList(String tableName);

    /**
     * 导出字典表
     * @return 字典表数据
     */
    List<NcDictDto> selectDictList();
}

package com.westcatr.rd.base.mysqltomd;

import cn.hutool.core.date.DateTime;
import com.westcatr.rd.base.mysqltomd.dao.mapper.NcDictDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: Wang Qianfeng
 * @Description: 字典表数据导出
 * @Date: 2022/3/5 20:03
 */
@Configuration
public class DictDataExport {

    @Autowired
    private TableService tableService;

//    @PostConstruct
    public void exportDictData() throws IOException {
        List<NcDictDto> list = tableService.selectDictList();
        // 标题
        StringBuilder sb = new StringBuilder("## VSS系统平台字典表");
        sb.append("\n");
        sb.append("| dictCode | dictName | attrValue | attrName | sortNo | remark |");
        sb.append('\n');
        sb.append("| ----- | ----- | ----- | ----- | ----- | ----- | ");
        sb.append('\n');
        list.stream().sorted(Comparator.comparing(NcDictDto :: getDictCode)).forEach(item -> {
            sb.append("| ");
            sb.append(item.getDictCode());
            sb.append(" | ");
            sb.append(item.getDictName());
            sb.append(" | ");
            sb.append(item.getAttrValue());
            sb.append(" | ");
            sb.append(item.getAttrName());
            sb.append(" | ");
            sb.append(item.getSortNo());
            sb.append(" | ");
            sb.append(item.getRemark());
            sb.append(" |");
            sb.append('\n');
        });
        System.out.println("md文档语句 : " + sb.toString());
        File file = new File("D:\\VSS字典表数据(" + DateTime.now().toString("yyyy年MM月dd日HH时mm") + ").md");
        FileWriter writer = new FileWriter(file, true);  // append 为 true 时可以续写
        BufferedWriter out = new BufferedWriter(writer);
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}

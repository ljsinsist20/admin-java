package com.ljs.game.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ljs.game.mapper.DormMapper;
import com.ljs.game.mapper.TeacherMapper;
import com.ljs.game.pojo.dto.upload.ExcelDormUploadDTO;
import com.ljs.game.pojo.dto.upload.ExcelTeacherUploadDTO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@NoArgsConstructor //无参
public class ExcelTeacherUploadDTOListener extends AnalysisEventListener<ExcelTeacherUploadDTO> {

    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<ExcelTeacherUploadDTO> list = new ArrayList();

    private TeacherMapper teacherMapper;

    /**
    * 传入mapper对象
    */
    public ExcelTeacherUploadDTOListener(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    /**
     *遍历每一行的记录
     * @param data
     * @param context
     */
    @Override
    public void invoke(ExcelTeacherUploadDTO data, AnalysisContext context) {
        log.info("解析到一条记录: {}", data);
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        log.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        log.info("{}条数据，开始存储数据库！", list.size());
        for (ExcelTeacherUploadDTO excelTeacherUploadDTO : list) {
            teacherMapper.addExcel(excelTeacherUploadDTO);
        }
        log.info("存储数据库成功！");
    }
}

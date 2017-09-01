package com.jose.controller.poi;

import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.util.CollectionUtils;

/**
 * Created by Panyuanyuan on 17/8/23.
 *
 * Description:
 */
public class PoiHelper {

    /** 从第一行开始 */
    private Integer rowNumber = 0;

    /**
     * 获取一个带有标题和表头的sheet
     *
     * @param workbook
     * @param headers
     * @param sheetName
     * @return
     */
    public HSSFSheet getHSSFSheet(HSSFWorkbook workbook, List<String> headers, String sheetName) {
        HSSFSheet sheet = workbook.createSheet(sheetName);
        setHSSFSheetHeaderStyle(sheet, headers.size());

        //设置标题
        HSSFRow titleRow = sheet.createRow(rowNumber);
        HSSFCell titleCell = titleRow.createCell(rowNumber);
        HSSFCellStyle titleCellStyle = getCellStyle(workbook, (short) 16, true);
        titleCell.setCellStyle(titleCellStyle);
        titleCell.setCellValue(sheetName);

        //设置表头
        HSSFRow headerRow = sheet.createRow(++rowNumber);
        for (int loop = 0; loop < headers.size(); loop++) {
            HSSFCellStyle headerCellStyle = getCellStyle(workbook, (short) 14, false);
            HSSFCell headerCell = headerRow.createCell(loop);
            headerCell.setCellStyle(headerCellStyle);
            headerCell.setCellValue(headers.get(loop));
        }

        return sheet;
    }

    /**
     * 将数据写入指定的sheet中
     *
     * @param sheet
     * @param list
     * @param <T>
     */
    public <T> void write2HSSFSheet(HSSFSheet sheet, List<T> list) throws Exception{
        if (!CollectionUtils.isEmpty(list)) {
            for (T instance : list) {
                HSSFRow dataRow = sheet.createRow(++rowNumber);
                Class<?> clazz = instance.getClass();
                Field[] fields = clazz.getDeclaredFields();
                List<HSSFCell> cells = getHSSFCell(dataRow, getExcelColumns(clazz).size());

                for (Field field : fields) {
                    if (field.isAnnotationPresent(ExcelColumnAnnotation.class)) {
                        ExcelColumnAnnotation annotation = field.getAnnotation(ExcelColumnAnnotation.class);
                        int index = annotation.index();
                        String name = field.getName();
                        name = name.substring(0, 1).toUpperCase() + name.substring(1);
                        Method method = clazz.getMethod("get" + name);
                        //目前只支持String,后续需要进行扩展
                        Object invoke = method.invoke(instance);
                        if (invoke != null) {
                            String value = invoke.toString();
                            cells.get(index).setCellValue(value);
                        }
                    }
                }

            }
        }

        //写完一个sheet,变量初始化
        this.rowNumber = 0;
    }

    /**
     * 获取一行中的Cell数并返回
     *
     * @param row
     * @param length
     * @return
     */
    private List<HSSFCell> getHSSFCell(HSSFRow row, Integer length) {
        List<HSSFCell> cells = Lists.newArrayList();
        for (int loop = 0; loop < length; loop++) {
            HSSFCell cell = row.createCell(loop);
            cells.add(cell);
        }
        return cells;
    }

    /**
     * 获取输出Excel的Header
     *
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<String> getExcelColumns(Class<T> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        List<String> columns = Lists.newArrayList();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ExcelColumnAnnotation.class)) {
                ExcelColumnAnnotation annotation = field.getAnnotation(ExcelColumnAnnotation.class);
                int index = annotation.index();
                String name = annotation.name();
                columns.add(index, name);
            }
        }

        return columns;
    }

    /**
     * 设置sheet的样式: 合并第一行Title,并进行冻结sheet标题和表头
     *
     * @param sheet
     * @param headerSize
     */
    private void setHSSFSheetHeaderStyle(HSSFSheet sheet, Integer headerSize) {
        for (int loop = 0; loop < headerSize; loop++) {
            sheet.setColumnWidth(loop, 30 * 256);
        }
        CellRangeAddress cra =new CellRangeAddress(0, 0, 0, headerSize - 1);
        sheet.addMergedRegion(cra);
        sheet.createFreezePane(0, 2, 0, 2);
    }

    /**
     * 构造Cell样式:主要针对字体,和是否加粗
     *
     * @param workbook
     * @param fontSize
     * @param isBold
     * @return
     */
    private HSSFCellStyle getCellStyle(HSSFWorkbook workbook, short fontSize, Boolean isBold) {
        Font titleFont = workbook.createFont();
        titleFont.setBold(isBold);
        titleFont.setFontHeightInPoints(fontSize);

        HSSFCellStyle titleStyle = workbook.createCellStyle();
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(CellStyle.ALIGN_CENTER);
        return titleStyle;
    }
}

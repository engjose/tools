package com.jose.controller.poi;

import com.google.common.collect.Lists;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 导出Excel测试类
 */
@RestController
@RequestMapping(value = "/poi")
public class MainTest {

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportExcel(HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        PoiHelper poiHelper = new PoiHelper();
        List<String> headers = poiHelper.getExcelColumns(UserBean.class);
        HSSFSheet sheet = poiHelper.getHSSFSheet(workbook, headers, "用户信息");

        //数据信息
        List<UserBean> users = Lists.newArrayList();
        UserBean user1 = new UserBean("张三", "12", "女");
        UserBean user2 = new UserBean("李四", "28", "男");
        users.add(user1);
        users.add(user2);

        try {
            poiHelper.write2HSSFSheet(sheet, users);

            String filename = DateFormatUtils.format(new Date(), "yyyyMMdd") + "测试.xls";
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            response.setContentType("application/x-download");
            ServletOutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

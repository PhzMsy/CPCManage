package org.msy.boot.controller.Importandexport;

import com.alibaba.excel.EasyExcel;
import org.msy.boot.controller.system.cpc.CpcController;
import org.msy.boot.controller.system.cpc.CpcDetailController;
import org.msy.boot.entity.CpcDetail;
import org.msy.boot.service.system.cpc.CpcService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author 11612
 * @date 2023/3/8
 */
@Controller
@RequestMapping("/IAE")
public class ImportAndExport {
    @RequestMapping
    public void exportExcel(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {


        /*
        String realPath = "D://wsfile/";
        File folder = new File(realPath);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }


        String fileName = realPath + "User" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为用户表 然后文件流会自动关闭
        EasyExcel.write(fileName, CpcDetail.class).sheet("用户表").doWrite();*//*
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class).sheet("模板").doWrite(data());
        */

    }
}


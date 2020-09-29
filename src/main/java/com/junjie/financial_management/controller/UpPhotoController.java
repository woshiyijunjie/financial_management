package com.junjie.financial_management.controller;


import com.junjie.financial_management.entity.Bill;
import com.junjie.financial_management.entity.Goods;
import com.junjie.financial_management.service.BillService;
import com.junjie.financial_management.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@RestController
public class UpPhotoController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BillService billService;

    //后台对 FormData 数据的处理
    @PostMapping(value = "/upLoadPhoto")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   @RequestParam Map<String, Object> map) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(map.get("time").toString());

        //用一个时间来标记图片
        long timestr = new Date().getTime();
        //同时报账信息里面也需要保存
        Bill bill = new Bill();
        bill.setUid(Integer.parseInt(map.get("uid").toString()));
        bill.setBillName(map.get("user_name").toString());
        bill.setBillBankid(map.get("user_bankid").toString());
        bill.setBillNumber(map.get("user_number").toString());
        bill.setBillSmoney((Double.parseDouble(map.get("money").toString())));
        bill.setBillTime(new Date(timestr));
        bill.setBillRmoney((Double.parseDouble(map.get("money").toString())));
        bill.setBillStatus(0);
        bill.setBillMoneyStatus(0);
        billService.addBill(bill);

        this.savePhoto(file, timestr);//保存图片到服务器
        Goods good = new Goods();
        good.setUid(Integer.parseInt(map.get("uid").toString()));
        //这个数据需要上面的代码执行完成
        good.setBid(bill.getId());
        good.setGoodsName(map.get("name").toString());
        good.setGoodsKind(map.get("kind").toString());
        good.setGoodsMoney((Double.parseDouble(map.get("money").toString())));
        good.setGoodsBuyTime(date);
        good.setGoodsUpTime(String.valueOf(timestr));
        good.setGoodsStatus(0);
        //将数据保存到数据库
        goodsService.addGoods(good);

        return "SUCCESS";
    }

    //修改操作(图片没有被修改的情况)
    @PostMapping(value = "/updateFourGoodsById")
    public String updateFourGoodsById(@RequestBody Map<String, Object> map) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(map.get("time").toString());

        Date date = sdf.parse(map.get("time").toString());

        Goods good = new Goods();
        good.setId(Integer.parseInt(map.get("id").toString()));
        good.setGoodsName(map.get("name").toString());
        good.setGoodsKind(map.get("kind").toString());
        good.setGoodsMoney(Double.parseDouble(map.get("money").toString()));
        good.setGoodsBuyTime(date);
        good.setGoodsUpTime(map.get("upTime").toString());
        goodsService.updateGoodsById(good);
        //状态也应该被修改为未审核状态
        goodsService.updateGoodsStatus(Integer.parseInt(map.get("id").toString()), 0);

        //对应的 bill 的信息也应该修改
        Bill bill = new Bill();
        bill.setId(Integer.parseInt(map.get("bid").toString()));
        bill.setBillSmoney(Double.parseDouble(map.get("money").toString()));
        bill.setBillTime(new Date(Long.parseLong(map.get("upTime").toString())));
        bill.setBillRmoney(Double.parseDouble(map.get("money").toString()));
        bill.setBillStatus(0);
        billService.updateBillById(bill);

        return "SUCCESS";
    }

    //修改操作(当图片发生修改的时候)
    @PostMapping(value = "/updateFiveGoodsById")
    public String updateFiveGoodsById(@RequestParam("file") MultipartFile file,
                                      @RequestParam Map<String, Object> map) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        long timestr = new Date().getTime();
        //保存图片到服务器
        this.savePhoto(file, timestr);
        Date date = sdf.parse(map.get("time").toString());
        Goods good = new Goods();
        good.setId(Integer.parseInt(map.get("id").toString()));
        good.setGoodsName(map.get("name").toString());
        good.setGoodsKind(map.get("kind").toString());
        good.setGoodsMoney(Double.parseDouble(map.get("money").toString()));
        good.setGoodsBuyTime(date);
        good.setGoodsUpTime(String.valueOf(timestr));
        goodsService.updateGoodsById(good);
        //状态也应该被修改为未审核状态(这里的状态包括 goods 的状态和 bill 的状态)
        goodsService.updateGoodsStatus(Integer.parseInt(map.get("id").toString()), 0);
        //对应的 bill 的信息也应该修改
        Bill bill = new Bill();
        bill.setId(Integer.parseInt(map.get("bid").toString()));
        bill.setBillSmoney(Double.parseDouble(map.get("money").toString()));
        bill.setBillTime(new Date(timestr));
        bill.setBillRmoney(Double.parseDouble(map.get("money").toString()));
        bill.setBillStatus(0);
        billService.updateBillById(bill);

        return "SUCCESS";
    }


    //用 io 流保存到本地
    private void savePhoto(MultipartFile file, long timestr) {
        try {
            InputStream in = file.getInputStream();
            BufferedInputStream bf = new BufferedInputStream(in);
            FileOutputStream os = new FileOutputStream("E:\\software_install_pathaddadd\\IDEAWorkSpace\\financial_management\\src\\main\\resources\\static\\images\\" + timestr + ".jpg");
            BufferedOutputStream bo = new BufferedOutputStream(os);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = bf.read(bytes)) != -1) {
                bo.write(bytes, 0, len);
            }
            bo.close();
            bf.close();
            bo.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

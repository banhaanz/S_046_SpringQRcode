package com.example.demo.controller;

import com.example.demo.util.QrCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HomeController {

    @Autowired
    private QrCodeUtil qrCodeUtil;

    @GetMapping(value = "/getQrCode")
    public @ResponseBody String getQrCode(){
        qrCodeUtil.genIosQRCode();
        qrCodeUtil.genAndroidQRCode();
        return "GEN QRCODE SUCCESS";
    }
}

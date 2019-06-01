package com.busyqa;

import com.busyqa.config.db.DBBeansConfig;
import com.busyqa.project.pictureupload.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;


@SpringBootApplication
public class MainApplication implements WebMvcConfigurer, CommandLineRunner {


    @Resource
    StorageService storageService;

    public static void main(String[] args) throws Exception {
        System.setProperty("spring.devtools.restart.enabled", "true");

        ConfigurableApplicationContext c = SpringApplication.run(MainApplication.class, args);
        System.out.println("Launch Successfully.");
        showIP(c.getBean(DBBeansConfig.class).SERVER_PORT);
    }

    public static void showIP(String serverPort) throws Exception {
        System.out.println("Local loop address: http://127.0.0.1:" + serverPort);
        System.out.println("Possible host address list for docker:");
        System.out.println("http://" + InetAddress.getLocalHost().getHostAddress() + ":" + serverPort);
        Enumeration<NetworkInterface> n = NetworkInterface.getNetworkInterfaces();
        for (; n.hasMoreElements(); ) {
            NetworkInterface e = n.nextElement();
            Enumeration<InetAddress> a = e.getInetAddresses();
            for (; a.hasMoreElements(); ) {
                InetAddress addr = a.nextElement();
                if (addr instanceof Inet4Address) {
                    System.out.println("http://" + addr.getHostAddress() + ":" + serverPort);
                }
            }
        }
    }


    //Initialize storage
    @Override
    public void run(String... arg) throws Exception {
        storageService.deleteAll();
        storageService.init();
    }

//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

}

//package com.example.demo.temp;
//
//import com.example.demo.DemoApplication;
//import org.apache.hadoop.fs.FileStatus;
//import org.apache.hadoop.fs.FsShell;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.stereotype.Repository;
//
///**
// * @author sxp
// * @create 2019-02-05 21:12
// **/
//@SpringBootApplication
//public class Hdfs implements CommandLineRunner {
//
//    @Autowired
//    FsShell fsShell;
//    @Override
//    public void run(String... args) throws Exception {
//        for (FileStatus fileStatus : fsShell.ls("/")) {
//            System.out.println("> " + fileStatus.getPath());
//        }
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Hdfs.class, args);
//    }
//}

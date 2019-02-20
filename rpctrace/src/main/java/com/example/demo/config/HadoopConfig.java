//package com.example.demo.config;
//
//import org.apache.hadoop.fs.FileSystem;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//
///**
// * @author sxp
// * @create 2019-02-05 11:23
// **/
//
//@Configuration
//@ConditionalOnProperty(name="hadoop.name-node")
////@Slf4j
//public class HadoopConfig {
//
//    @Value("${hadoop.name-node}")
//    private String nameNode;
//
//    @Bean("fileSystem")
//    public FileSystem createFs() throws Exception {
//        //读取配置文件
//        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
//        conf.set("fs.defalutFS", "hdfs://47.101.46.0:9000");
//        conf.set("dfs.replication", "1");
//        //指定访问hdfs的客户端身份
//        FileSystem fs = FileSystem.get(new URI("hdfs://47.101.46.0:9000/"), conf, "root");
//        // 文件系统
////        FileSystem fs = null;
////        // 返回指定的文件系统,如果在本地测试，需要使用此种方法获取文件系统
////        try {
////            URI uri = new URI(nameNode.trim());
////            fs = FileSystem.get(uri,conf);
////        } catch (Exception e) {
////            //log.error("", e);
////        }
//        return  fs;
//    }
//}
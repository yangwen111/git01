package com.example.srv.utils;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: pengyue
 * @Date: 2020/8/24 17:05
 * @DESC: =>
 */
public class MybatisGenUitls {
  private static final Logger logger = LoggerFactory.getLogger(MybatisGenUitls.class);
  public static void main(String[] args){
    // 执行中的异常信息会保存在warnings中
    List<String> warnings = new ArrayList<String>();
    try {
      // true:生成的文件覆盖之前的
      boolean overwrite = true;
      // 读取配置,构造 Configuration 对象.
      // 如果不想使用配置文件的话,也可以直接来 new Configuration(),然后给相应属性赋值.
      File configFile = new File("src/main/resources/myBatisGenerator/generatorConfig.xml");
      ConfigurationParser cp = new ConfigurationParser(warnings);
      Configuration config = cp.parseConfiguration(configFile);
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
      logger.error("=======================");

      myBatisGenerator.generate(null);
      logger.error("=============结束==========");

    } catch (Exception e) {
      logger.error(e.getMessage(),e);

    }
  }

}

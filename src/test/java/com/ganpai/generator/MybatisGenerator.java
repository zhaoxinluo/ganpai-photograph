package com.ganpai.generator;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoxl on 05/07/2017.
 */
public class MybatisGenerator {

    public static void main(String[] args){

        MybatisGenerator obj = new MybatisGenerator();
        try{
            obj.gen();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    private void gen() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = false;
        File currentFile = new File(MybatisGenerator.class.getResource("/").getPath());
        String configPath = currentFile.getParentFile().getParentFile().getPath()+"/src/test/resources/generatorConfig.xml";

        File configFile = new File(configPath);

        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        if(warnings!=null && !warnings.isEmpty()){
            System.out.println("警告信息(如果路径不存在, 请注意Windows是'\\', Mac是'/'):");
            warnings.stream().forEach(e->System.out.println("\t"+e));
        }
    }

}

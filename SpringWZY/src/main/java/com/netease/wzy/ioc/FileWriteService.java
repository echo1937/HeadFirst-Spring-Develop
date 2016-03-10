package com.netease.wzy.ioc;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Eric on 3/10/16.
 */
public class FileWriteService implements InitializingBean, DisposableBean {
    private Properties props;
    private BufferedWriter out;

    public void setProps(Properties props) {
        this.props = props;
    }

    public void write(String content) throws IOException {
        out.write(content);
        out.flush();
    }

    public void afterPropertiesSet() throws Exception {
        String pathname = props.getProperty("filename");
        File filename = new File(pathname);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));
        out = bufferedWriter;
    }

    public void destroy() throws Exception {
        out.close();
    }


}

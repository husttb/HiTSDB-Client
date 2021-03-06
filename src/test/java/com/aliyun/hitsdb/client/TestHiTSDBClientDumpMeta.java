package com.aliyun.hitsdb.client;

import java.io.IOException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aliyun.hitsdb.client.HiTSDB;
import com.aliyun.hitsdb.client.HiTSDBClientFactory;
import com.aliyun.hitsdb.client.exception.http.HttpClientInitException;
import com.aliyun.hitsdb.client.value.response.TagResult;

public class TestHiTSDBClientDumpMeta {
    HiTSDB tsdb;

    @Before
    public void init() throws HttpClientInitException {
        tsdb = HiTSDBClientFactory.connect("127.0.0.1", 8242);
    }

    @After
    public void after() {
        try {
            tsdb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDumpMeta() {
        List<TagResult> dumpMeta = tsdb.dumpMeta("tagk1", "tagv1", 10);
        System.out.println("查询结果：" + dumpMeta);
    }
}

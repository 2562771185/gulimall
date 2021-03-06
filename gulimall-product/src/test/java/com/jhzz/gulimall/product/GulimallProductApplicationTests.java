package com.jhzz.gulimall.product;

import com.aliyun.oss.*;
import com.jhzz.gulimall.product.service.BrandService;
import com.jhzz.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

@Slf4j
@SpringBootTest
class GulimallProductApplicationTests {
    @Autowired
    private BrandService brandService;
    @Resource
    private OSSClient ossClient;
    @Autowired
    private CategoryService categoryService;
    @Test
    void test(){
        Long[] path = categoryService.findCatelogPath(225L);
        log.info("path:{}", Arrays.toString(path));
    }
    @Test
    void contextLoads() {
        String bucketName = "ithz";
//        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "test/2.jpg";

        try {
            InputStream inputStream = new FileInputStream("C:\\Users\\Huanzhi\\Pictures\\OIP-C.jpg");
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException | FileNotFoundException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

}

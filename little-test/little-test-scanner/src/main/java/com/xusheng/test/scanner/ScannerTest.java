package com.xusheng.test.scanner;

import com.xusheng.common.scanner.ClassScanner;
import com.xusheng.common.scanner.reference.RpcReferenceScanner;
import com.xusheng.common.scanner.server.RpcServiceScanner;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

/**
 * @Author xusheng
 * @Date 2022/8/30 15:36
 * @Desc
 */
public class ScannerTest {

    @Test
    public void testScannerClass() throws Exception {
        List<String> classNameList = ClassScanner.getClassNameList("com.xusheng.test.scanner");
        classNameList.forEach(System.out::println);
    }

    @Test
    public void testRpcService() throws Exception {
        RpcServiceScanner.doScannerWithRpcServiceAnnotationFilterAndRegistryService("com.xusheng.test.scanner");
    }

    @Test
    public void testReference() throws Exception {
        RpcReferenceScanner.doScannerWithRpcReferenceAnnotationFilter("com.xusheng.test.scanner");
    }
}

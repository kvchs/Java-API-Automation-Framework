### **本测试框架专注于API的自动化测试，做到和Jenkins持续集成**      
测试报告类型：testNG提供，ReportNg, ExtentReport  
#### ExtentReport配置

`
<!-- https://mvnrepository.com/artifact/com.relevantcodes/extentreports -->
        <dependency>
            <groupId>com.relevantcodes</groupId>
            <artifactId>extentreports</artifactId>
            <version>2.41.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.vimalselvam/testng-extentsreport -->
        <dependency>
            <groupId>com.vimalselvam</groupId>
            <artifactId>testng-extentsreport</artifactId>
            <version>1.3.1</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
        <dependency>
            <groupId>com.aventstack</groupId>
            <artifactId>extentreports</artifactId>
            <version>3.1.5</version>
        </dependency>
`

#### Mock实现  
下载地址：https://repo1.maven.org/maven2/com/github/dreamhead/moco-runner/0.12.0/  
执行命令：java -jar moco-runner-0.12.0-standalone.jar http -p 6677 -c start.json  
访问：http://127.0.0.1:6677/demo
`
<!--Mock依赖-->
        <!-- https://mvnrepository.com/artifact/com.github.dreamhead/moco-runner -->
        <dependency>
            <groupId>com.github.dreamhead</groupId>
            <artifactId>moco-runner</artifactId>
            <version>0.12.0</version>
        </dependency>
`

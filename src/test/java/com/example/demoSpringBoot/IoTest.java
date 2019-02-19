package com.example.demoSpringBoot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * Created by BF100499 on 2019/2/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class IoTest {
    @Test
    public void Byte1()
    {
        OutputStream output = System.out;           //实例化OutputStream对象

        byte[] bytes = "使用OutputStream输出流在控制台输出字符串\n".getBytes();       //创建bytes数组

        try {
            //output.write(bytes);

            bytes = "输出内容：\n".getBytes();
            output.write(bytes);        //向流中写入数据

            bytes = "Java数据交互管道——IO流 \n".getBytes();
            output.write(bytes);

            output.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Test
    public void File1()
    {
        File file = new File("D:/", "word.txt");  //创建文件对象

        try {
            if (!file.exists()) {               //如果文件不存在则新建文件
                file.createNewFile();

            }
            FileOutputStream output = new FileOutputStream(file);

            byte[] bytes = "Java数据交流管道——IO流".getBytes();

            output.write(bytes);                //将数组的信息写入文件中

            output.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            FileInputStream input = new FileInputStream(file);

            byte[] bytes2 = new byte[1024];

            int len = input.read(bytes2);

            System.out.println("文件中的信息是：" + new String(bytes2, 0, len));

            input.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}

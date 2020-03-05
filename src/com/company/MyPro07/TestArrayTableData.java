package com.company.MyPro07;

import java.util.Arrays;

/**
 * 测试数组存储和表格数据
 * @author thinkpad
 */
public class TestArrayTableData {
    public static void main(String[] args) {
        Object[] emp1 = {1001,"高企",18,"讲师","2006.6.6"};
        Object[] emp2 = {1002,"高2器",19,"教师","2007.6.6"};
        Object[] emp3 = {1003,"高3器",20,"小组","2008.6.6"};

        Object[][] tableData = new Object[3][];
        tableData[0] = emp1;
        tableData[1] = emp2;
        tableData[2] = emp3;

        for (Object[] temp : tableData){
            System.out.println(Arrays.toString(temp));
        }
    }
}

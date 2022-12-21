package com.krafttechnologie.tests.day20_DataDrivenFramework;

import com.krafttechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ExcelUtilPractice {

    @Test
    public void readExcelFile(){

        /* ExcelUtil'den object oluşturuyoruz
        ExelUtildeki Contructor gereği --> Object iki argüman alacak. Bunlar: Dosyanın pathi ile
        çalşma yapacağımız sayfanın adı olacak.
        */

        ExcelUtil qaTeam3=new ExcelUtil("src/test/resources/LoginList.xlsx","QaTeam3");
                                        //*resources-loginlist-sağ klik-content root /** takım adı

        // önce satır (row) sayısını bulalım
        System.out.println("qaTeam3.rowCount() = " + qaTeam3.rowCount());

        // sütun (column) sayısını bulma
        System.out.println("qaTeam3.columnCount() = " + qaTeam3.columnCount());

        // sütun adlarını alma
        System.out.println("qaTeam3.getColumnsNames() = " + qaTeam3.getColumnsNames());

        System.out.println("qaTeam3.getCellData(0,1) = " + qaTeam3.getCellData(0, 1));

        //qaTeam3'e atadaığımız dataları liste olarak çağırma
        List<Map<String, String>> dataList = qaTeam3.getDataList();// key value olduğundan Map...
        System.out.println("dataList = " + dataList);

        // satır halinde elementleri getirme
        for(Map<String,String> row:qaTeam3.getDataList()) {
            System.out.println("row = " + row);
        }

        // 2. satırı getirelim
        System.out.println("dataList.get(2) = " + dataList.get(2));

        System.out.println("dataList.get(2).get(\"Your Name\") = " + dataList.get(2).get("Your Name"));

        //(row ve column olduğundan) bütün datayı iki boyutlu array alalım

        String [][] dataArray= qaTeam3.getDataArray();
        System.out.println("Arrays = " + Arrays.deepToString(dataArray)); // Arrays.deepToString ile yazdırıyoruz

    }
}

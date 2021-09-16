package com.latihan1.lat1.services;

import com.latihan1.lat1.entity.Product;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductExcelExporter {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<Product> listProduct;

    public ProductExcelExporter(List<Product> listProduct) {
        this.listProduct = listProduct;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Products");
    }
    private void writeHeaderRow(){
        Row row = sheet.createRow(0);

        Cell cell = row.createCell(0);
        cell.setCellValue("Product Id");

        cell = row.createCell(1);
        cell.setCellValue("Product Name");

        cell = row.createCell(2);
        cell.setCellValue("Product Description");

        cell = row.createCell(3);
        cell.setCellValue("Product Price");
    }
    private void writeDataRows(){
        int rowCount = 1;

        for (Product product : listProduct){
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(product.getId());

            cell = row.createCell(1);
            cell.setCellValue(product.getName());

            cell = row.createCell(2);
            cell.setCellValue(product.getDescription());

            cell = row.createCell(3);
            cell.setCellValue(product.getPrice().toString());
        }
    }
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

package qaguru.qa;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFilesCheck {


    @Test
    void pdfFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/samples.zip"))) {
            ZipEntry entry = zip.getEntry("sample.pdf");

            InputStream inputStream = zip.getInputStream(entry);
            {
                PDF pdf = new PDF(inputStream);
                Assertions.assertEquals("Rave (http://www.nevrona.com/rave)", pdf.creator);
            }
        }
    }

    @Test
    void csvFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/samples.zip"))) {
            ZipEntry entry = zip.getEntry("SampleCSVFile_2kb.csv");

            InputStream inputStream = zip.getInputStream(entry);

            Reader reader = new InputStreamReader(inputStream);
                CSVReader csvReader = new CSVReader(reader);
                List<String[]> values = csvReader.readAll();

            final String[] firstRow = values.get(0);

            Assertions.assertArrayEquals(new String[]{"1", "Eldon Base for stackable storage shelf, platinum",
                    "Muhammed MacIntyre", "3", "-213.25","38.94", "35",
                    "Nunavut", "Storage & Organization", "0.8"}, firstRow);

        }
    }
    @Test
    void XlsFileCheck() throws Exception {
        try (ZipFile zip = new ZipFile(new File("src/test/resources/samples.zip"))) {
            ZipEntry entry = zip.getEntry("fileExampleXLS10.xls");

            InputStream inputStream = zip.getInputStream(entry);

            XLS xls = new XLS(inputStream);
            Assertions.assertEquals("Hashimoto",
                    xls.excel.getSheetAt(0).getRow(2).getCell(2).getStringCellValue());

        }
    }
}









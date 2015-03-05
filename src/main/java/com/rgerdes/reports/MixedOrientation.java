package com.rgerdes.reports;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MixedOrientation {
    public void mixIt() {
        JasperCompileManager.compileReportToFile(pathFirstJrxml, pathFirstJasper);
        JasperCompileManager.compileReportToFile(pathSecondJrxml ,pathSecondJasper );

        File fileFirstReport = new File(pathFirstJasper);
        File fileSecondReport = new File(pathSecondJasper);

        JasperPrint jasperPrint = JasperFillManager.fillReport((JasperReport) JRLoader.loadObject(fileFirstReport), null, dataSourceFirstReport);
        JasperPrint jasperPrintSubReport = JasperFillManager.fillReport((JasperReport)JRLoader.loadObject(fileSecondReport),null,dataSourceSecondReport);

        List list = new ArrayList<>();
        list.add(jasperPrint);
        list.add( jasperPrintSubReport );

         rtfExporter = new JRRtfExporter();
        rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST, list);
        rtfExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,pathOutputFile);
        System.out.println("Exporting report...");
        rtfExporter.exportReport();
        System.out.println("Done!");
    }
}

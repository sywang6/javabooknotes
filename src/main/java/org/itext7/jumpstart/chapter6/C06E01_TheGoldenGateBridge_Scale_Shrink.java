package org.itext7.jumpstart.chapter6;

import com.itextpdf.kernel.geom.AffineTransform;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import org.itext7.jumpstart.AabsolutePath;

import java.io.File;
import java.io.IOException;

/**
 * 缩放
 */
public class C06E01_TheGoldenGateBridge_Scale_Shrink {
    public static final String SRC = AabsolutePath.PROJECT_ROOR_PATH +"src/main/resources/pdf/the_golden_gate_bridge.pdf";
    public static final String DEST = AabsolutePath.PROJECT_ROOR_PATH +"results/chapter06/the_golden_gate_bridge_scale_shrink.pdf";

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C06E01_TheGoldenGateBridge_Scale_Shrink().createPdf(SRC, DEST);
    }

    public void createPdf(String src, String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfDocument origPdf = new PdfDocument(new PdfReader(src));

        //Original page size
        PdfPage origPage = origPdf.getPage(1);
        Rectangle orig = origPage.getPageSizeWithRotation();

        //Add A4 page
        PdfPage page = pdf.addNewPage(PageSize.A4.rotate());
        //Shrink original page content using transformation matrix
        PdfCanvas canvas = new PdfCanvas(page);
        //2D放射变换
        AffineTransform transformationMatrix = AffineTransform
                .getScaleInstance(page.getPageSize().getWidth() / orig.getWidth(),
                page.getPageSize().getHeight() / orig.getHeight());
        //变换矩阵
        canvas.concatMatrix(transformationMatrix);
        PdfFormXObject pageCopy = origPage.copyAsFormXObject(pdf);
        canvas.addXObjectAt(pageCopy, 0, 0);

        //Add page with original size
        pdf.addPage(origPage.copyTo(pdf));

        //Add A2 page
        page = pdf.addNewPage(PageSize.A2.rotate());
        //Scale original page content using transformation matrix
        canvas = new PdfCanvas(page);
        transformationMatrix = AffineTransform.getScaleInstance(page.getPageSize().getWidth() / orig.getWidth(), page.getPageSize().getHeight() / orig.getHeight());
        canvas.concatMatrix(transformationMatrix);
        canvas.addXObjectAt(pageCopy, 0, 0);

        pdf.close();
        origPdf.close();
    }

}

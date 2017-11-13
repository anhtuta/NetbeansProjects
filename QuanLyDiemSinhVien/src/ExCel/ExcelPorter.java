package ExCel;

import java.awt.Label;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelPorter {

    public ExcelPorter() {
    }

    public void exportJtable(JTable jTable, File file) throws IOException {
        TableModel model = jTable.getModel();
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (int i = 0; i < model.getColumnCount(); i++) {
            bw.write(model.getColumnName(i) + "\t");
        }
        bw.write("\n");
        for (int i = 0; i < model.getColumnCount(); i++) {
            for (int j = 0; j < model.getColumnCount(); j++) {
                bw.write(model.getValueAt(i, j).toString() + "\t");
            }
            bw.write("\n");
        }
//        fw.close();
        bw.close();
        System.out.println("da in ra file excel " + file);
    }

    public void writeExcel(JTable jTable, String nameSheet, String tieude) throws IOException, WriteException {
        //Bước 1: Tạo đối tượng WritableWorkbook “trỏ” đến file của bạn. Lưu ý là nếu file của bạn đã tồn tại thì nó sẽ bị xóa đi và tạo lại.
        //WritableWorkbook workbook = Workbook.createWorkbook(file);
        //Bước 2: Tạo WritableSheet – sheet bạn cần ghi dữ liệu:
        //Lưu ý: trong hàm createSheet có 2 đối số, đối số thứ nhất là chuỗi tên sheet.
        //đối số thứ 2 là một số nguyên chỉ vị trí của sheet, vị trí sheet bắt đầu bằng 0.
        //WritableSheet sheet = workbook.createSheet("nameSheet", 0);
        //Bước 3: Tiếp theo chúng ta sẽ thêm các dạng dữ liệu vào các ô bằng phương thức addCell.
        //Để viết dữ liệu vào các ô, chúng ta sẽ có 3 dạng chính: Chuỗi, Số và Công thức lần lượt được tạo bằng Label, Number, Formula
        //Ví dụ:
        //sheet.addCell(new Label(0, 0, "Add a String to cell")); // add a String to cell A1
        //sheet.addCell(new Number(0, 1, 100)); // add number 100 to cell A2
        //sheet.addCell(new Formula(0, 3, "IF(A1=1,"one", "two")")); // add number 100 to cell A3

        // open save file
        JFileChooser choices = new JFileChooser("C:\\Users\\asus tp300l\\Desktop\\QuanLyDiemSinhVien\\FileTest\\Export");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXCEL FILES", "xls", "excel");
        choices.setFileFilter(filter);
        int choice = -1;
        choice = choices.showSaveDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = choices.getSelectedFile();
            int result = JOptionPane.showConfirmDialog(null, "Do you want Save File ?");
            if (result == JOptionPane.YES_OPTION) {

                //
                WritableWorkbook workbook;
                // create workbook
                try {
                    workbook = Workbook.createWorkbook(file);

                    // create sheet
                    WritableSheet sheet1 = workbook.createSheet(nameSheet, 0);

                    // create Label and add to sheet
                    sheet1.addCell(new jxl.write.Label(0, 0, tieude));

                    for (int i = 0; i < jTable.getModel().getColumnCount(); i++) {
                        sheet1.addCell(new jxl.write.Label(i, 1, jTable.getModel().getColumnName(i)));
                    }

                    // row begin write data
                    int rowBegin = 2;
                    int colBegin = 0;

                    for (int row = rowBegin, i = 0; row < jTable.getModel().getRowCount() + rowBegin; row++, i++) {
                        for (int col = colBegin, j = 0; col < jTable.getModel().getColumnCount() + colBegin; col++, j++) {
                            sheet1.addCell(new jxl.write.Label(col, row, jTable.getModel().getValueAt(i, j).toString()));
                        }
                    }
                    // write file
                    workbook.write();
                    JOptionPane.showMessageDialog(null, "Ghi File Thành Công");
                    // close
                    workbook.close();
                } catch (IOException e) {
                    System.out.println("Error create file\n" + e.toString());
                } catch (RowsExceededException e) {
                    System.out.println("Error write file\n" + e.toString());
                } catch (WriteException e) {
                    System.out.println("Error write file\n" + e.toString());
                }
            }
        }
        System.out.println("create and write success");
    }

    public String readExcel(JTable jTable, int indexSheet) {
        String tieude = "";
        JFileChooser choices = new JFileChooser("C:\\Users\\asus tp300l\\Desktop\\QuanLyDiemSinhVien\\FileTest\\Import");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EXCEL FILES", "xls", "excel");
        choices.setFileFilter(filter);
        int choice = -1;
        choice = choices.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File file = choices.getSelectedFile();
            Workbook workbook;
            try {
                // create workbook to open file
                workbook = Workbook.getWorkbook(file);
                // get sheet want read
                Sheet sheet = workbook.getSheet(indexSheet);

                // get number row and col contain data
                int rows = sheet.getRows();
                int cols = sheet.getColumns();
                // get title
                Cell cellTitle = sheet.getCell(0, 0);
                tieude = cellTitle.getContents();
                // get header
                Vector Column = new Vector();
                for (int col = 0; col < cols; col++) {
                    Cell cell = sheet.getCell(col, 1);
                    Column.add(cell.getContents());
                }
                // read data in each cell
                Vector data = new Vector();
                for (int row = 2; row < rows; row++) {
                    Vector rowData = new Vector();
                    for (int col = 0; col < cols; col++) {
                        Cell cell = sheet.getCell(col, row);
                        rowData.add(cell.getContents());
                    }
                    data.add(rowData);
                }
                // close
                workbook.close();
                DefaultTableModel dtm = new DefaultTableModel(data, Column);
                jTable.setModel(dtm);
            } catch (BiffException e) {
                System.out.println("File not found\n" + e.toString());
            } catch (IOException e) {
                System.out.println("File not found\n" + e.toString());
            }
        }
        return tieude;
    }

}

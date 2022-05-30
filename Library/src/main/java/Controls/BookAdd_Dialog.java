package Controls;

import Datas.Book;
import Tools.Judgespchar;
import Tools.Resources;
import Tools.Str2NumCheck;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;
import com.eltima.components.ui.DatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

public class BookAdd_Dialog extends JDialog {
    Font font = new Font("Arial,sans-serif;", Font.BOLD, 18);
    MyButton1 confirm = new MyButton1(60, 30, 5, Color.white, "确认", 18,
            Color.BLACK);
    MyButton1 cancel = new MyButton1(60, 30, 5, Color.white, "取消", 18,
            Color.BLACK);

    MyLabel add_label = new MyLabel("新增图书", new Font("Arial, sans-serif;", Font.BOLD, 25), Color.BLACK);
    MyLabel bookname_label = new MyLabel("书名", font, Color.black);
    MyLabel bookauthor_label = new MyLabel("作者", font, Color.black);
    MyLabel bookpublisher_label = new MyLabel("出版社", font, Color.black);
    MyLabel bookpublishdate_label = new MyLabel("出版日期", font, Color.black);
    MyLabel bookprice_label = new MyLabel("价格", font, Color.black);
    MyLabel bookstock_label = new MyLabel("库存", font, Color.black);

    MyText bookname_text = new MyText(new Dimension(200, 30), 255);
    MyText bookauthor_text = new MyText(new Dimension(200, 30), 255);
    MyText bookpublisher_text = new MyText(new Dimension(200, 30), 255);
    DatePicker bookpublishdate = new DatePicker(this, null);
    MyText bookprice_text = new MyText(new Dimension(200, 30), 10);
    MyText bookstock_text = new MyText(new Dimension(200, 30), 10);

    public BookAdd_Dialog(Window owner) {
        super(owner);
        setSize(400, 500);
        setLayout(new FreeLayout());

        setForeground(new Color(240, 243, 249));


        confirm.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (bookname_text.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "书名不能为空!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookname_text.getText().trim())) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "书名包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (bookauthor_text.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "作者不能为空!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookauthor_text.getText().trim())) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "作者包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (bookpublisher_text.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "出版社不能为空!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (Judgespchar.check(bookpublisher_text.getText().trim())) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "出版社包含特殊字符!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (bookpublishdate.getValue() == null) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "出版日期不能为空!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!Str2NumCheck.isUnsignedDoubleValue(bookprice_text.getText().trim())) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "请输入正确的价格!", "提示", JOptionPane.WARNING_MESSAGE);
                } else if (!Str2NumCheck.isUnsignedIntValue(bookstock_text.getText().trim())) {
                    JOptionPane.showMessageDialog(BookAdd_Dialog.this, "请输入正确的库存!", "提示", JOptionPane.WARNING_MESSAGE);
                } else {
                    Book book_filter = new Book();
                    book_filter.setName(bookname_text.getText().trim());
                    book_filter.setAuthor(bookauthor_text.getText().trim());
                    book_filter.setPublisher(bookpublisher_text.getText().trim());
                    book_filter.setPublishDate((Date) bookpublishdate.getValue());
                    try {
                        if(Book.getBooks(book_filter).size()>0){
                            JOptionPane.showMessageDialog(BookAdd_Dialog.this, "该书已存在!", "提示", JOptionPane.WARNING_MESSAGE);
                        }else {
                            book_filter.setPrice(Double.parseDouble(bookprice_text.getText().trim()));
                            book_filter.setStock(Integer.parseInt(bookstock_text.getText().trim()));
                            Book.addBook(book_filter);
                            JOptionPane.showMessageDialog(BookAdd_Dialog.this, "添加成功!", "提示", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(BookAdd_Dialog.this, "添加失败!", "提示", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }
        });
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }
        });

        bookpublishdate.setPattern("yyyy-MM-dd");
        bookpublishdate.setEnabled(true);
        bookpublishdate.setEditorable(false);
        bookpublishdate.setPreferredSize(new Dimension(200, 30));
        bookpublishdate.getField().setBackground(Color.WHITE);
        bookpublishdate.getField().setFont(new Font("Arial, sans-serif;",
                Font.PLAIN, 18));

        int left1 = 50;
        int left2 = 150;
        add(add_label,
                new Margin(10,
                        (int) ((getSize().getWidth() - add_label.getPreferredSize().getWidth()) / 2), -1, -1));
        add(bookname_label, new Margin(70, left1, -1, -1));
        add(bookname_text, new Margin(70, left2, -1, -1));
        add(bookauthor_label, new Margin(120, left1, -1, -1));
        add(bookauthor_text, new Margin(120, left2, -1, -1));
        add(bookpublisher_label, new Margin(170, left1, -1, -1));
        add(bookpublisher_text, new Margin(170, left2, -1, -1));
        add(bookpublishdate_label, new Margin(220, left1, -1, -1));
        add(bookpublishdate, new Margin(220, left2, -1, -1));
        add(bookprice_label, new Margin(270, left1, -1, -1));
        add(bookprice_text, new Margin(270, left2, -1, -1));
        add(bookstock_label, new Margin(320, left1, -1, -1));
        add(bookstock_text, new Margin(320, left2, -1, -1));
        add(confirm, new Margin(-1, 100, 20, -1));
        add(cancel, new Margin(-1, -1, 20, 100));
        setTitle("新增图书");
        setIconImage(Resources.BOOKICON);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setVisible(true);
    }
}

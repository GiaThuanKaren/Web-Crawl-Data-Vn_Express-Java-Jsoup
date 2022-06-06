
//import javax.swing.text.Document;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ASUS
 */
public class JSOUP {

    public static void main(String[] args) {
        try {
            Document document = (Document) Jsoup.connect("https://tiki.vn/phu-kien-thoi-trang/c27498?page=2").get();
            System.out.println(document.outerHtml());
        } catch (Exception e) {
            System.out.println("Error"+e);
        }
    }

}

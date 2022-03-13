/*
 * 書籍データ登録
 */
package beans;

import enterprise.RegBookWorker;
import entity.BookDataEntity;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import utility.BinaryDataUtility;

/**
 * 2021/7/11 書籍データを登録するバッキングBean
 * @author daidou
 */
//バッキングBeanを「rbb」で参照できるようにする
@Named(value = "rbb")
@RequestScoped
public class RegBookBean {
    // 書籍タイトルを格納する配列
    String[] title = {
        "Androidアプリ開発　パーフェクトマスター",
        "JavaScript　Web開発パーフェクトマスター",
        "Excelビジネス設計　パーフェクトマスター",
        "ホームページビルダー19　パーフェクトマスター",
        "Visual C# 2013　パーフェクトマスター",
        "Visual Basic 2013　パーフェクトマスター",
        "Visual C++ 2013　パーフェクトマスター",
        "はじめての男の婚活マニュアル",
        "海自オタがうっかり「中の人」と結婚した件",
        "服を変えると、人生が変わる。一流の男の身だしなみ",
        "チューブ生姜適量ではなくて1㎝がいい人の理系の理科",
    };
    //本体価格を格納する配列
    Integer[] price = {
        3200,3400,3200,2980,3400,3200,2800,1800,925,1300,1300
    };
    //列挙型のジャンルを格納する配列
    Genre[] genre = {
        Genre.JENRE1,Genre.JENRE1,Genre.JENRE1,Genre.JENRE1,Genre.JENRE1,
        Genre.JENRE1,Genre.JENRE1,Genre.JENRE2,Genre.JENRE2,Genre.JENRE3,
        Genre.JENRE3,
    };
    //書籍の紹介文を格納する配列
    String[] exp = {
        "AndroidStudioの使い方、JavaやXMLの仕組み、アプリ開発の実際を解説。",
        "JavaScriptを使用したアプリ開発に必要なノウハウの基礎から応用まで。",
        "統計学の基礎とExcelを使った統計解析のテクニックをわかりやすく解説。",
        "ホームページビルダーで思い通りのページを作るためのノウハウを解説。",
        "Visual C# 2013のアプリケーション開発とプログラムのポイントが身につく。",
        "Visual Basicプログラミングとアプリケーション開発の解説書です。",
        "標準C++、C++/CX、さらにwindowsストアアプリの開発へとステップアップ。",
        "結婚を意識しつつ女性と上手くコミュニケーションをとるための超基本。",
        "海上自衛官と漫画家カップルのなれ初めから結婚生活・子育てまでを描く。",
        "オシャレになって生涯所得を上げたい、大切な人をオシャレにしたい人の本。",
        "「ひとつまみって、何グラム？」本書は、理系のためのクッキングガイドです。",
    };
    //サムネイル用の画像をを格納する配列
    String [] thumbnail = {
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/android1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/js1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/excel1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/hpb1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/vc1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/vb1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/pluplu1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/kon1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/ota1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/fuku1.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/ryo1.jpg",
    //拡大表示用の画像をを格納する配列
    };
    String [] image = {
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/android2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/js2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/excel2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/hpb2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/vc2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/vb2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/pluplu2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/kon2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/ota2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/fuku2.jpg",
        "C:/Users/terad.MIYU/Documents/NetBeansProjects/RegisterBook/web/resources/images/ryo2.jpg",
    };
    
    @EJB
    // EJBをインジェクト
    RegBookWorker worker;
    
    /**************************************************
     * 2021/7/11 書籍データを登録するバッキングBean
     * データの登録を実行する
     * @return result.xhtmlページに遷移
     **************************************************/
    public String doRegister() {
        for (int i = 0; i < title.length; i++) {
            // イメージファイルのデータをバイナリ形式でフィールドに格納
            byte[] img1 = BinaryDataUtility.readBinaryData(thumbnail[i]);
            byte[] img2 = BinaryDataUtility.readBinaryData(image[i]);
            // エンティティクラスをインスタンス化して1件分の
            // レコードに相当するデータを登録
            BookDataEntity bde =
                    new BookDataEntity(title[i],price[i],
                                        genre[i],exp[i],img1,img2);
            //EJBのメソッドを実行してデータベースに登録
            worker.register(bde);
        }
        return "result.xhtml";
    }

}

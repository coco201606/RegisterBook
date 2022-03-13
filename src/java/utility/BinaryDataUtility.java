/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**　　　
 * 2021.7.18 ロガーオブジェクト
 * 　　　　　 およびファイルの絶対パスを取得してPATHオブジェクトを生成
 * @author daidou
 */



public class BinaryDataUtility {

/**　　　
 * ロガーオブジェクトの作成
 */
    public static final Logger log =
            Logger.getLogger(BinaryDataUtility.class.getName());

/**　　　
 * バイナリデータを読み込む
 * @param relative      読み込むファイルの相対パス
 * @return              バイナリ形式のデータ（配列）
 */
    public static byte[] readBinaryData(String relative) {
//        String filePath = getRealPath(relative);
        //絶対パス取得（対象ファイルのパスはアプリケーションルートからのパスとして取得）    
//        Path path = Paths.get(filePath);
        Path path = Paths.get(relative);
        byte[] binaryData = null;
        try {
            binaryData = Files.readAllBytes(path);
        } catch(IOException ex) {
            log.severe(ex.toString());
        }
        return binaryData;  //読み込んだバイナリデータを返す
    }

/**　　　
 * 絶対パスを取得する
 * @param path          絶対パスに変換するパス情報
 * @return              絶対パスを表す文字列
 */

//    public static String getRealPath(String path) {
//        ExternalContext ctx = FacesContext.getCurrentInstance()
//                                          .getExternalContext();
//        return ctx.getRealPath(path);
//    }


}


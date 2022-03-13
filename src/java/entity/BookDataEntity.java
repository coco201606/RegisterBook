/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import beans.Genre;
import java.io.Serializable;
import javax.persistence.*;

/**
 * 2021.7.18 エンティティ・クラス
 * @author daidou
 */
@Entity
@Table(name = "BOOK") //登録先のテーブル名をBOOKにする
public class BookDataEntity implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;        //自動的に割り振られる連番をフィールドに格納
    private String title;   //タイトル用のフィールド
    private Integer price;  //価格用のフィールド
    @Enumerated(EnumType.STRING)
    private Genre genre;    //列挙型のフィールド
    //@Lob @Basic(fetch = FetchType.LAZY)
    private String exp;     //説明文用のフィールド
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] img1;    //サムネイル用のフィールド
    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] img2;    //拡大画像用のフィールド
    
/**
 * パラメータ無しのコンストラクタ
 */
    public BookDataEntity(){
    }
/**
 * コンストラクタ
 * @param title　書籍タイトル 
 * @param price　本体価格
 * @param genre　書籍のジャンル
 * @param exp 　 紹介文
 * @param img1 　サムネイル用のイメージ（バイナル）
 * @param img2 　拡大表示用のイメージ（バイナリ）
 */
    public BookDataEntity(
        String title,
        Integer price,
        Genre genre,
        String exp,
        byte[] img1,
        byte[] img2
    ){
        this.title = title;
        this.price = price;
        this.genre = genre;
        this.exp = exp;
        this.img1 = img1;
        this.img2 = img2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public byte[] getImg1() {
        return img1;
    }

    public void setImg1(byte[] img1) {
        this.img1 = img1;
    }

    public byte[] getImg2() {
        return img2;
    }

    public void setImg2(byte[] img2) {
        this.img2 = img2;
    }
    
}

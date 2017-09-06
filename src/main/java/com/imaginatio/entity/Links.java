package com.imaginatio.entity;
import javax.persistence.*;
/**
 * Created by HardWorker on 17.04.2017.
 */
@Entity
@Table(name = "LINKS")
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long linkId;

    @Column(name = "CURRENT_PAGE")
    private int carrentPage;

    @Column(name = "LINK_DESCRIPTION")
    private String linkDescription;

    @Column(name = "LINK_TO_PAGE")
    private int page;

    @Column(name = "BOOK_NAME")
    private String bookName;

    public Links() {
    }

    public Links(int carrentPage, String linkDescription, int page) {
        this.carrentPage = carrentPage;
        this.linkDescription = linkDescription;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCarrentPage() {
        return carrentPage;
    }

    public void setCarrentPage(int carrentPage) {
        this.carrentPage = carrentPage;
    }

    public long getLinkId() {
        return linkId;
    }

    public void setLinkId(long linkId) {
        this.linkId = linkId;
    }

    public String getLinkDescription() {
        return linkDescription;
    }

    public void setLinkDescription(String linkDescription) {
        this.linkDescription = linkDescription;
    }

}

